package kr.wooriga.ejm_task.code.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.wooriga.ejm_task.common.util.PredicateBuilder;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static kr.wooriga.ejm_task.domain.QCommonCode.commonCode;
import static kr.wooriga.ejm_task.domain.QCommonCodeGroup.commonCodeGroup;

@RequiredArgsConstructor
public class CommonCodeRepositoryCustomImpl implements CommonCodeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<CommonCodePayloads.ListResponse> list(CommonCodePayloads.ListRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize(), Sort.by(Sort.Direction.ASC, "name"));

        Predicate predicate = PredicateBuilder.builder()
                .containsString(commonCode.value, request.getValue())
                .containsString(commonCode.name, request.getName())
                .eqString(commonCodeGroup.uuid, request.getGroupUuid())
                .containsString(commonCodeGroup.name, request.getGroupNm())
                .build();

        List<CommonCodePayloads.ListResponse> fetch = queryFactory.select(
                        Projections.fields(CommonCodePayloads.ListResponse.class,
                                commonCode.uuid,
                                commonCode.value,
                                commonCode.name,
                                commonCodeGroup.name.as("groupName"),
                                commonCode.createdAt,
                                commonCode.updatedAt
                        )
                )
                .from(commonCode)
                .join(commonCode.group, commonCodeGroup)
                .where(predicate, commonCode.enabled.eq(true), commonCodeGroup.enabled.eq(true))
                .limit(pageRequest.getPageSize())
                .offset(pageRequest.getOffset())
                .orderBy(commonCode.name.asc())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(commonCode.id.count()).
                from(commonCode)
                .join(commonCode.group, commonCodeGroup)
                .where(predicate, commonCode.enabled.eq(true), commonCodeGroup.enabled.eq(true));

        return PageableExecutionUtils.getPage(fetch, pageRequest, countQuery::fetchOne);
    }
}
