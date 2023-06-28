package kr.wooriga.ejm_task.code.service;

import kr.wooriga.ejm_task.code.mapper.CommonCodeMapper;
import kr.wooriga.ejm_task.code.repository.CommonCodeGroupRepository;
import kr.wooriga.ejm_task.code.repository.CommonCodeRepository;
import kr.wooriga.ejm_task.common.response.MessageCode;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.exception.CommonApplicationException;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommonCodeService {

    private final CommonCodeRepository commonCodeRepository;
    private final CommonCodeGroupRepository commonCodeGroupRepository;
    private final CommonCodeMapper mapper;

    @Transactional(readOnly = true)
    public Page<CommonCodePayloads.ListResponse> codeList(CommonCodePayloads.ListRequest request) {
        return commonCodeRepository.list(request);
    }

    @Transactional(readOnly = true)
    public CommonCodePayloads.DetailResponse codeDetail(String uuid) {
        CommonCode commonCode = findByUuid(uuid);
        return mapper.detailResponse(commonCode);
    }

    @Transactional(readOnly = true, propagation = Propagation.MANDATORY)
    public CommonCode findByUuid(String uuid) {
        return commonCodeRepository.findByUuid(uuid)
                .orElseThrow(() -> new CommonApplicationException(MessageCode.NOT_FOUND_COMMON_CODE));
    }
}
