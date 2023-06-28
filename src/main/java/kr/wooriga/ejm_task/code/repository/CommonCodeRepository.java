package kr.wooriga.ejm_task.code.repository;

import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonCodeRepository extends JpaRepository<CommonCode, Long>, CommonCodeRepositoryCustom {

    @EntityGraph(attributePaths = {"group"})
    Optional<CommonCode> findByUuid(String uuid);
}
