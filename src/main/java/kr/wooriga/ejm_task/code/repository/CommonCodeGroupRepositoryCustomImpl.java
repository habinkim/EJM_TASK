package kr.wooriga.ejm_task.code.repository;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.wooriga.ejm_task.common.util.PredicateBuilder;
import kr.wooriga.ejm_task.payload.CommonCodeGroupPayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static kr.wooriga.ejm_task.domain.QCommonCodeGroup.commonCodeGroup;

@RequiredArgsConstructor
public class CommonCodeGroupRepositoryCustomImpl implements CommonCodeGroupRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<CommonCodeGroupPayloads.ListResponse> list(CommonCodeGroupPayloads.ListRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getPageNo(), request.getPageSize(), Sort.by(Sort.Direction.ASC, "name"));

        Predicate predicate = PredicateBuilder.builder()
                .containsString(commonCodeGroup.name, request.getName())
                .build();

        List<CommonCodeGroupPayloads.ListResponse> fetch = queryFactory.select(
                        Projections.fields(CommonCodeGroupPayloads.ListResponse.class,
                                commonCodeGroup.uuid,
                                commonCodeGroup.name,
                                commonCodeGroup.createdAt,
                                commonCodeGroup.updatedAt
                        )
                )
                .from(commonCodeGroup)
                .where(predicate, commonCodeGroup.enabled.eq(true))
                .limit(pageRequest.getPageSize())
                .offset(pageRequest.getOffset())
                .orderBy(commonCodeGroup.name.asc())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(commonCodeGroup.id.count())
                .from(commonCodeGroup)
                .where(predicate, commonCodeGroup.enabled.eq(true));

        return PageableExecutionUtils.getPage(fetch, pageRequest, countQuery::fetchOne);
    }
}
