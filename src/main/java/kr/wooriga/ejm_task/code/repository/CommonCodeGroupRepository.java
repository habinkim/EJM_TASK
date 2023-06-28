package kr.wooriga.ejm_task.code.repository;

import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import kr.wooriga.ejm_task.payload.CommonCodeGroupPayloads;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonCodeGroupRepository extends JpaRepository<CommonCodeGroup, Long>, CommonCodeGroupRepositoryCustom {
    Optional<CommonCodeGroup> findByUuid(String uuid);
}
