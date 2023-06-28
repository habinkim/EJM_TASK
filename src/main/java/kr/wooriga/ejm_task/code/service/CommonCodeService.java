package kr.wooriga.ejm_task.code.service;

import kr.wooriga.ejm_task.code.mapper.CommonCodeMapper;
import kr.wooriga.ejm_task.code.repository.CommonCodeGroupRepository;
import kr.wooriga.ejm_task.code.repository.CommonCodeRepository;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommonCodeService {

    private final CommonCodeRepository commonCodeRepository;
    private final CommonCodeGroupRepository commonCodeGroupRepository;

    private final CommonCodeGateway gateway;

    private final CommonCodeMapper mapper;

    @Transactional(readOnly = true)
    public Page<CommonCodePayloads.ListResponse> codeList(final CommonCodePayloads.ListRequest request) {
        return commonCodeRepository.list(request);
    }

    @Transactional(readOnly = true)
    public CommonCodePayloads.DetailResponse codeDetail(final String uuid) {
        CommonCode commonCode = gateway.findCommonCodeByUuid(uuid);
        return mapper.detailResponse(commonCode);
    }

    @Transactional
    public void createCode(final CommonCodePayloads.CreateRequest request) {
        CommonCode commonCode = mapper.fromCreateRequest(request);
        commonCodeRepository.save(commonCode);
    }

    @Transactional
    public void updateCode(CommonCodePayloads.UpdateRequest request) {
        CommonCode commonCode = gateway.findCommonCodeByUuid(request.getUuid());
        CommonCode updatedCommonCode = mapper.fromUpdateRequest(request, commonCode.toBuilder()).build();
        commonCodeRepository.save(updatedCommonCode);
    }

    @Transactional
    public void deleteCode(String uuid) {
        CommonCode commonCode = gateway.findCommonCodeByUuid(uuid);
        commonCode.disable();
        commonCodeRepository.save(commonCode);
    }
}
