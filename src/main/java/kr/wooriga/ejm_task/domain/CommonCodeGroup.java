package kr.wooriga.ejm_task.domain;

import kr.wooriga.ejm_task.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SuperBuilder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(name = "NAME_UK", columnNames = "name")})
public class CommonCodeGroup extends BaseEntity {

    @Column(nullable = false)
    @Comment("그룹명")
    private String name;

    @Column(columnDefinition = "TEXT NOT NULL")
    @Comment("설명")
    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Comment("소속 공통코드")
    private List<CommonCode> codes = new ArrayList<>();

}
