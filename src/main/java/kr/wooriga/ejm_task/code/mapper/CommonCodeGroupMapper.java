package kr.wooriga.ejm_task.code.mapper;

import kr.wooriga.ejm_task.common.config.BaseMapperConfig;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import kr.wooriga.ejm_task.payload.CommonCodeGroupPayloads;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = BaseMapperConfig.class)
@DecoratedWith(CommonCodeGroupDecorator.class)
public interface CommonCodeGroupMapper {

    CommonCodeGroupPayloads.DetailResponse detailResponse(CommonCodeGroup commonCodeGroup);

    CommonCodeGroup fromCreateRequest(CommonCodeGroupPayloads.CreateRequest request);

    @Mapping(target = "uuid", ignore = true)
    CommonCodeGroup.CommonCodeGroupBuilder<?, ?> fromUpdateRequest(CommonCodeGroupPayloads.UpdateRequest request,
                                                                   @MappingTarget CommonCodeGroup.CommonCodeGroupBuilder<?, ?> commonCodeGroup);
}
