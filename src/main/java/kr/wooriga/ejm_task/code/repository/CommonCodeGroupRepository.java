package kr.wooriga.ejm_task.code.repository;

import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonCodeGroupRepository extends JpaRepository<CommonCodeGroup, Long>, CommonCodeGroupRepositoryCustom {
    Optional<CommonCodeGroup> findByUuidAndEnabledTrue(String uuid);

    Optional<CommonCodeGroup> findByNameAndEnabledTrue(String name);
}
