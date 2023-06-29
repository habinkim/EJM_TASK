package kr.wooriga.ejm_task.code.repository;

import kr.wooriga.ejm_task.domain.CommonCode;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonCodeRepository extends JpaRepository<CommonCode, Long>, CommonCodeRepositoryCustom {

    Optional<CommonCode> findByIdAndEnabledTrue(Long id);

    @EntityGraph(attributePaths = {"group"})
    Optional<CommonCode> findByUuidAndEnabledTrue(String uuid);

    Optional<CommonCode> findByValueAndEnabledTrue(String value);
}
