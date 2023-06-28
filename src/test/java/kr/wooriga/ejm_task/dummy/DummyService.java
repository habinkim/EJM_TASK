package kr.wooriga.ejm_task.dummy;

import kr.wooriga.ejm_task.base.AbstractIntegrationTest;
import kr.wooriga.ejm_task.code.repository.CommonCodeGroupRepository;
import kr.wooriga.ejm_task.code.repository.CommonCodeRepository;
import kr.wooriga.ejm_task.code.service.CommonCodeGateway;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class DummyService extends AbstractIntegrationTest {

    @Autowired
    private CommonCodeGateway commonCodeGateway;

    @Autowired
    private CommonCodeRepository commonCodeRepository;

    @Autowired
    private CommonCodeGroupRepository commonCodeGroupRepository;

    private List<CommonCode> defaultCommonCodes;

    private List<CommonCodeGroup> defaultCommonCodeGroups;

    @Transactional(propagation = Propagation.MANDATORY)
    public void initCommonCodes() {
        IntStream.range(0, 100)
                .forEach(i -> {
                    Collections.shuffle(defaultCommonCodeGroups);
                    CommonCode commonCode = initCommonCode(i, stringUtils.uuidGenerator(), defaultCommonCodeGroups.get(0));
                    defaultCommonCodes.add(commonCode);
                });
        commonCodeRepository.saveAll(defaultCommonCodes);
    }

    public CommonCode initCommonCode(Integer index, String uuid, CommonCodeGroup commonCodeGroup) {
        return new CommonCode(uuid, uuid + "_" + index, uuid, commonCodeGroup);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void initCommonCodeGroups() {
        IntStream.range(0, 25)
                .forEach(i -> {
                    CommonCodeGroup commonCodeGroup = initCommonCodeGroup(i, stringUtils.uuidGenerator());
                    defaultCommonCodeGroups.add(commonCodeGroup);
                });
        commonCodeGroupRepository.saveAll(defaultCommonCodeGroups);
    }

    public CommonCodeGroup initCommonCodeGroup(Integer index, String uuid) {
        return new CommonCodeGroup(uuid + "_" + index, uuid, null);
    }

    public List<CommonCode> getDefaultCommonCodes() {
        return defaultCommonCodes;
    }

    public List<CommonCodeGroup> getDefaultCommonCodeGroups() {
        return defaultCommonCodeGroups;
    }
}
