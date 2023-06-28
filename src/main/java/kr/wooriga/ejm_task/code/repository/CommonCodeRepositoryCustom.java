package kr.wooriga.ejm_task.code.repository;

import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import org.springframework.data.domain.Page;

public interface CommonCodeRepositoryCustom {
    Page<CommonCodePayloads.ListResponse> list(CommonCodePayloads.ListRequest request);
}
