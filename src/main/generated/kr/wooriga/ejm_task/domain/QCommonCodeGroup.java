package kr.wooriga.ejm_task.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommonCodeGroup is a Querydsl query type for CommonCodeGroup
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCommonCodeGroup extends EntityPathBase<CommonCodeGroup> {

    private static final long serialVersionUID = -833885246L;

    public static final QCommonCodeGroup commonCodeGroup = new QCommonCodeGroup("commonCodeGroup");

    public final kr.wooriga.ejm_task.domain.base.QBaseEntity _super = new kr.wooriga.ejm_task.domain.base.QBaseEntity(this);

    public final ListPath<CommonCode, QCommonCode> codes = this.<CommonCode, QCommonCode>createList("codes", CommonCode.class, QCommonCode.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    //inherited
    public final BooleanPath enabled = _super.enabled;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final StringPath uuid = _super.uuid;

    public QCommonCodeGroup(String variable) {
        super(CommonCodeGroup.class, forVariable(variable));
    }

    public QCommonCodeGroup(Path<? extends CommonCodeGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommonCodeGroup(PathMetadata metadata) {
        super(CommonCodeGroup.class, metadata);
    }

}

