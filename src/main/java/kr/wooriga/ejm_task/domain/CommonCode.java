package kr.wooriga.ejm_task.domain;

import kr.wooriga.ejm_task.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@SuperBuilder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "NAME_UK", columnNames = "name"),
        @UniqueConstraint(name = "VALUE_UK", columnNames = "value")
    }
)
public class CommonCode extends BaseEntity {

    @Column(nullable = false)
    @Comment("코드값")
    private String value;

    @Column(nullable = false)
    @Comment("코드명")
    private String name;

    @Column(columnDefinition = "TEXT NOT NULL")
    @Comment("설명")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @Comment("코드 그룹 ID")
    private CommonCodeGroup group;

}
