package kr.wooriga.ejm_task.code.mapper;

import kr.wooriga.ejm_task.common.config.BaseMapperConfig;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = BaseMapperConfig.class)
@DecoratedWith(CommonCodeDecorator.class)
public interface CommonCodeMapper {

    @Mapping(target = "groupUuid", source = "group.uuid")
    @Mapping(target = "groupName", source = "group.name")
    @Mapping(target = "groupDescription", source = "group.description")
    CommonCodePayloads.DetailResponse detailResponse(CommonCode commonCode);


    CommonCode fromCreateRequest(CommonCodePayloads.CreateRequest request);

    CommonCode.CommonCodeBuilder<?, ?> fromUpdateRequest(CommonCodePayloads.UpdateRequest request, @MappingTarget CommonCode.CommonCodeBuilder<?, ?> commonCode);
}
