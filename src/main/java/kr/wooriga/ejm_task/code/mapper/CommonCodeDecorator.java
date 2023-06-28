package kr.wooriga.ejm_task.code.mapper;

import kr.wooriga.ejm_task.code.service.CommonCodeGateway;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

@Primary
public abstract class CommonCodeDecorator implements CommonCodeMapper {

    @Qualifier("delegate")
    @Autowired
    private CommonCodeMapper delegate;

    @Autowired
    private CommonCodeGateway gateway;

    @Override
    public CommonCode fromCreateRequest(CommonCodePayloads.CreateRequest request) {
        CommonCode commonCode = delegate.fromCreateRequest(request);
        CommonCodeGroup commonCodeGroup = gateway.findCommonCodeGroupByUuid(request.getGroupUuid());
        return commonCode.toBuilder().group(commonCodeGroup).build();
    }

    @Override
    public CommonCode.CommonCodeBuilder<?, ?> fromUpdateRequest(CommonCodePayloads.UpdateRequest request, CommonCode.CommonCodeBuilder<?, ?> commonCode) {
        CommonCode.CommonCodeBuilder<?, ?> commonCodeBuilder = delegate.fromUpdateRequest(request, commonCode);

        if(request.getGroupUuid() != null) {
            CommonCodeGroup commonCodeGroup = gateway.findCommonCodeGroupByUuid(request.getGroupUuid());
            commonCodeBuilder = commonCodeBuilder.group(commonCodeGroup);
        }

        return commonCodeBuilder;
    }
}
