package kr.wooriga.ejm_task.code.service;

import kr.wooriga.ejm_task.code.repository.CommonCodeGroupRepository;
import kr.wooriga.ejm_task.code.repository.CommonCodeRepository;
import kr.wooriga.ejm_task.common.response.MessageCode;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import kr.wooriga.ejm_task.exception.CommonApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommonCodeGateway {

    private final CommonCodeRepository commonCodeRepository;
    private final CommonCodeGroupRepository commonCodeGroupRepository;

    @Transactional(readOnly = true, propagation = Propagation.MANDATORY)
    public CommonCode findCommonCodeByUuid(String uuid) {
        return commonCodeRepository.findByUuid(uuid)
                .orElseThrow(() -> new CommonApplicationException(MessageCode.NOT_FOUND_COMMON_CODE));
    }

    @Transactional(readOnly = true, propagation = Propagation.MANDATORY)
    public CommonCodeGroup findCommonCodeGroupByUuid(String uuid) {
        return commonCodeGroupRepository.findByUuid(uuid)
                .orElseThrow(() -> new CommonApplicationException(MessageCode.NOT_FOUND_COMMON_CODE_GROUP));
    }

}
