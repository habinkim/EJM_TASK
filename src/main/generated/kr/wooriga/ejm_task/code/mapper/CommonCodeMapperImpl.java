package kr.wooriga.ejm_task.code.mapper;

import javax.annotation.processing.Generated;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T01:33:17+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (Azul Systems, Inc.)"
)
@Component
public class CommonCodeMapperImpl implements CommonCodeMapper {

    @Override
    public CommonCodePayloads.DetailResponse detailResponse(CommonCode commonCode) {
        if ( commonCode == null ) {
            return null;
        }

        CommonCodePayloads.DetailResponse.DetailResponseBuilder<?, ?> detailResponse = CommonCodePayloads.DetailResponse.builder();

        String uuid = commonCodeGroupUuid( commonCode );
        if ( uuid != null ) {
            detailResponse.groupUuid( uuid );
        }
        String name = commonCodeGroupName( commonCode );
        if ( name != null ) {
            detailResponse.groupName( name );
        }
        String description = commonCodeGroupDescription( commonCode );
        if ( description != null ) {
            detailResponse.groupDescription( description );
        }
        if ( commonCode.getUuid() != null ) {
            detailResponse.uuid( commonCode.getUuid() );
        }
        if ( commonCode.getValue() != null ) {
            detailResponse.value( commonCode.getValue() );
        }
        if ( commonCode.getName() != null ) {
            detailResponse.name( commonCode.getName() );
        }
        if ( commonCode.getDescription() != null ) {
            detailResponse.description( commonCode.getDescription() );
        }

        return detailResponse.build();
    }

    private String commonCodeGroupUuid(CommonCode commonCode) {
        if ( commonCode == null ) {
            return null;
        }
        CommonCodeGroup group = commonCode.getGroup();
        if ( group == null ) {
            return null;
        }
        String uuid = group.getUuid();
        if ( uuid == null ) {
            return null;
        }
        return uuid;
    }

    private String commonCodeGroupName(CommonCode commonCode) {
        if ( commonCode == null ) {
            return null;
        }
        CommonCodeGroup group = commonCode.getGroup();
        if ( group == null ) {
            return null;
        }
        String name = group.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String commonCodeGroupDescription(CommonCode commonCode) {
        if ( commonCode == null ) {
            return null;
        }
        CommonCodeGroup group = commonCode.getGroup();
        if ( group == null ) {
            return null;
        }
        String description = group.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }
}
