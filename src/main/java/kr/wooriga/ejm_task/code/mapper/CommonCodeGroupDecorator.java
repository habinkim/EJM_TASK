package kr.wooriga.ejm_task.code.mapper;

import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import kr.wooriga.ejm_task.payload.CommonCodeGroupPayloads;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.stream.Collectors;

@Primary
public abstract class CommonCodeGroupDecorator implements CommonCodeGroupMapper {

    @Qualifier("delegate")
    @Autowired
    private CommonCodeGroupMapper delegate;

    @Override
    public CommonCodeGroupPayloads.DetailResponse detailResponse(CommonCodeGroup commonCodeGroup) {
        CommonCodeGroupPayloads.DetailResponse detailResponse = delegate.detailResponse(commonCodeGroup);

        List<CommonCodePayloads.ListResponse> codes = commonCodeGroup.getCodes().stream()
                .map(c -> new CommonCodePayloads.ListResponse(c.getUuid(), c.getValue(), c.getName(), commonCodeGroup.getName()))
                .collect(Collectors.toList());

        return detailResponse.toBuilder().codes(codes).build();
    }
}
