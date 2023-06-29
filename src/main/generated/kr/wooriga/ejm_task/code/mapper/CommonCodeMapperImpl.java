package kr.wooriga.ejm_task.code.mapper;

import javax.annotation.processing.Generated;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-29T19:43:41+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
@Primary
public class CommonCodeMapperImpl extends CommonCodeDecorator {

    @Autowired
    @Qualifier("delegate")
    private CommonCodeMapper delegate;

    @Override
    public CommonCodePayloads.DetailResponse detailResponse(CommonCode commonCode)  {
        return delegate.detailResponse( commonCode );
    }
}
