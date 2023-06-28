package kr.wooriga.ejm_task.code.service;

import kr.wooriga.ejm_task.code.mapper.CommonCodeGroupMapper;
import kr.wooriga.ejm_task.code.mapper.CommonCodeMapper;
import kr.wooriga.ejm_task.code.repository.CommonCodeGroupRepository;
import kr.wooriga.ejm_task.code.repository.CommonCodeRepository;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import kr.wooriga.ejm_task.payload.CommonCodeGroupPayloads;
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

    private final CommonCodeMapper commonCodeMapper;
    private final CommonCodeGroupMapper commonCodeGroupMapper;

    @Transactional(readOnly = true)
    public Page<CommonCodePayloads.ListResponse> codeList(final CommonCodePayloads.ListRequest request) {
        return commonCodeRepository.list(request);
    }

    @Transactional(readOnly = true)
    public CommonCodePayloads.DetailResponse codeDetail(final String uuid) {
        CommonCode commonCode = gateway.findCommonCodeByUuid(uuid);
        return commonCodeMapper.detailResponse(commonCode);
    }

    @Transactional
    public void createCode(final CommonCodePayloads.CreateRequest request) {
        CommonCode commonCode = commonCodeMapper.fromCreateRequest(request);
        commonCodeRepository.save(commonCode);
    }

    @Transactional
    public void updateCode(CommonCodePayloads.UpdateRequest request) {
        CommonCode commonCode = gateway.findCommonCodeByUuid(request.getUuid());
        CommonCode updatedCommonCode = commonCodeMapper.fromUpdateRequest(request, commonCode.toBuilder()).build();
        commonCodeRepository.save(updatedCommonCode);
    }

    @Transactional
    public void deleteCode(String uuid) {
        CommonCode commonCode = gateway.findCommonCodeByUuid(uuid);
        commonCode.disable();
        commonCodeRepository.save(commonCode);
    }


    @Transactional(readOnly = true)
    public Page<CommonCodeGroupPayloads.ListResponse> codeGroupList(CommonCodeGroupPayloads.ListRequest request) {
        return commonCodeGroupRepository.list(request);
    }

    @Transactional(readOnly = true)
    public CommonCodeGroupPayloads.DetailResponse codeGroupDetail(String uuid) {
        CommonCodeGroup commonCodeGroup = gateway.findCommonCodeGroupByUuid(uuid);
        return commonCodeGroupMapper.detailResponse(commonCodeGroup);
    }

    @Transactional
    public void createCodeGroup(CommonCodeGroupPayloads.CreateRequest request) {
        CommonCodeGroup commonCodeGroup = commonCodeGroupMapper.fromCreateRequest(request);
        commonCodeGroupRepository.save(commonCodeGroup);
    }

    @Transactional
    public void updateCodeGroup(CommonCodeGroupPayloads.UpdateRequest request) {
        CommonCodeGroup commonCodeGroup = gateway.findCommonCodeGroupByUuid(request.getUuid());
        commonCodeGroup = commonCodeGroupMapper.fromUpdateRequest(request, commonCodeGroup.toBuilder()).build();
        commonCodeGroupRepository.save(commonCodeGroup);
    }

    @Transactional
    public void deleteCodeGroup(String uuid) {
        CommonCodeGroup commonCodeGroup = gateway.findCommonCodeGroupByUuid(uuid);
        commonCodeGroup.disable();
        commonCodeGroupRepository.save(commonCodeGroup);
    }
}
