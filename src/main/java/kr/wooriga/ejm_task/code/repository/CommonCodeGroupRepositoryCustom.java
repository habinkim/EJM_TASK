package kr.wooriga.ejm_task.code.repository;

import kr.wooriga.ejm_task.payload.CommonCodeGroupPayloads;
import org.springframework.data.domain.Page;

public interface CommonCodeGroupRepositoryCustom {
    Page<CommonCodeGroupPayloads.ListResponse> list(CommonCodeGroupPayloads.ListRequest request);
}
