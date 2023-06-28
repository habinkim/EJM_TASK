package kr.wooriga.ejm_task.code.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import kr.wooriga.ejm_task.payload.CommonCodeGroupPayloads;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T04:35:19+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 11.0.11 (Azul Systems, Inc.)"
)
@Component
@Qualifier("delegate")
public class CommonCodeGroupMapperImpl_ implements CommonCodeGroupMapper {

    @Override
    public CommonCodeGroupPayloads.DetailResponse detailResponse(CommonCodeGroup commonCodeGroup) {
        if ( commonCodeGroup == null ) {
            return null;
        }

        CommonCodeGroupPayloads.DetailResponse.DetailResponseBuilder<?, ?> detailResponse = CommonCodeGroupPayloads.DetailResponse.builder();

        if ( commonCodeGroup.getUuid() != null ) {
            detailResponse.uuid( commonCodeGroup.getUuid() );
        }
        if ( commonCodeGroup.getName() != null ) {
            detailResponse.name( commonCodeGroup.getName() );
        }
        if ( commonCodeGroup.getDescription() != null ) {
            detailResponse.description( commonCodeGroup.getDescription() );
        }
        List<CommonCodePayloads.ListResponse> list = commonCodeListToListResponseList( commonCodeGroup.getCodes() );
        if ( list != null ) {
            detailResponse.codes( list );
        }
        if ( commonCodeGroup.getCreatedAt() != null ) {
            detailResponse.createdAt( commonCodeGroup.getCreatedAt() );
        }
        if ( commonCodeGroup.getUpdatedAt() != null ) {
            detailResponse.updatedAt( commonCodeGroup.getUpdatedAt() );
        }

        return detailResponse.build();
    }

    @Override
    public CommonCodeGroup fromCreateRequest(CommonCodeGroupPayloads.CreateRequest request) {
        if ( request == null ) {
            return null;
        }

        CommonCodeGroup.CommonCodeGroupBuilder<?, ?> commonCodeGroup = CommonCodeGroup.builder();

        if ( request.getName() != null ) {
            commonCodeGroup.name( request.getName() );
        }
        if ( request.getDescription() != null ) {
            commonCodeGroup.description( request.getDescription() );
        }

        return commonCodeGroup.build();
    }

    @Override
    public CommonCodeGroup.CommonCodeGroupBuilder<?, ?> fromUpdateRequest(CommonCodeGroupPayloads.UpdateRequest request, CommonCodeGroup.CommonCodeGroupBuilder<?, ?> commonCodeGroup) {
        if ( request == null ) {
            return commonCodeGroup;
        }

        if ( request.getName() != null ) {
            commonCodeGroup.name( request.getName() );
        }
        if ( request.getDescription() != null ) {
            commonCodeGroup.description( request.getDescription() );
        }

        return commonCodeGroup;
    }

    protected CommonCodePayloads.ListResponse commonCodeToListResponse(CommonCode commonCode) {
        if ( commonCode == null ) {
            return null;
        }

        CommonCodePayloads.ListResponse.ListResponseBuilder<?, ?> listResponse = CommonCodePayloads.ListResponse.builder();

        if ( commonCode.getUuid() != null ) {
            listResponse.uuid( commonCode.getUuid() );
        }
        if ( commonCode.getValue() != null ) {
            listResponse.value( commonCode.getValue() );
        }
        if ( commonCode.getName() != null ) {
            listResponse.name( commonCode.getName() );
        }

        return listResponse.build();
    }

    protected List<CommonCodePayloads.ListResponse> commonCodeListToListResponseList(List<CommonCode> list) {
        if ( list == null ) {
            return null;
        }

        List<CommonCodePayloads.ListResponse> list1 = new ArrayList<CommonCodePayloads.ListResponse>( list.size() );
        for ( CommonCode commonCode : list ) {
            list1.add( commonCodeToListResponse( commonCode ) );
        }

        return list1;
    }
}
