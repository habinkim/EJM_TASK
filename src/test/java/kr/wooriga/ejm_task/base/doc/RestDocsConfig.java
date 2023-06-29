package kr.wooriga.ejm_task.base.doc;

import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

@TestConfiguration
@Profile("test")
public class RestDocsConfig {

    @Bean
    public RestDocumentationResultHandler writeRESTDocs() {
        return document(
                "{method-name}",
                DocumentUtils.getDocumentRequest(),
                DocumentUtils.getDocumentResponse()
        );
    }

}
