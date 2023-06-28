package kr.wooriga.ejm_task.code.controller;

import kr.wooriga.ejm_task.base.ControllerBaseTest;
import kr.wooriga.ejm_task.common.config.Uris;
import kr.wooriga.ejm_task.common.response.MessageCode;
import kr.wooriga.ejm_task.domain.CommonCode;
import kr.wooriga.ejm_task.domain.CommonCodeGroup;
import kr.wooriga.ejm_task.dummy.DummyService;
import kr.wooriga.ejm_task.payload.CommonCodePayloads;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CommonCodeControllerTest extends ControllerBaseTest {

    @Autowired
    private DummyService dummyService;

    private CommonCode defaultCommonCode;

    private CommonCodeGroup defaultCommonCodeGroup;

    @BeforeEach
    public void init() {
        dummyService.initCommonCodeGroups();
        dummyService.initCommonCodes();
        defaultCommonCode = dummyService.getDefaultCommonCodes().get(0);
        defaultCommonCodeGroup = dummyService.getDefaultCommonCodeGroups().get(0);
    }

    @Transactional
    @Test
    @Order(1)
    @DisplayName("공통코드 리스트 조회, 성공")
    void codeListSuccess() throws Exception {
        String uri = Uris.CODE_LIST;

        CommonCodePayloads.ListRequest request =
                new CommonCodePayloads.ListRequest(0, 10, "", "", "", "");

        mockMvc.perform(
                        post(uri)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(stringUtils.toJson(request))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].uuid", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].value", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].name", notNullValue()))
                .andExpect(jsonPath("$.result.content[0].groupName", notNullValue()))

                .andExpect(jsonPath("$.result.pageable.offset", is(0)))
                .andExpect(jsonPath("$.result.pageable.pageNumber", is(0)))
                .andExpect(jsonPath("$.result.pageable.pageSize", is(10)))
                .andExpect(jsonPath("$.result.pageable.paged", is(true)))
                .andExpect(jsonPath("$.result.pageable.unpaged", is(false)))

                .andExpect(jsonPath("$.result.pageable.sort.empty", is(false)))
                .andExpect(jsonPath("$.result.pageable.sort.unsorted", is(false)))
                .andExpect(jsonPath("$.result.pageable.sort.sorted", is(true)))

                .andExpect(jsonPath("$.result.last", is(false)))
                .andExpect(jsonPath("$.result.totalPages", is(10)))
                .andExpect(jsonPath("$.result.totalElements", is(100)))
                .andExpect(jsonPath("$.result.first", is(true)))
                .andExpect(jsonPath("$.result.size", is(10)))
                .andExpect(jsonPath("$.result.number", is(0)))
                .andExpect(jsonPath("$.result.sort.empty", is(false)))
                .andExpect(jsonPath("$.result.sort.unsorted", is(false)))
                .andExpect(jsonPath("$.result.sort.sorted", is(true)))
                .andExpect(jsonPath("$.result.numberOfElements", is(10)))
                .andExpect(jsonPath("$.result.empty", is(false)))

                .andDo(restDocs.document(
                                requestFields(
                                        fieldWithPath("pageNo").type(JsonFieldType.NUMBER).description("페이지 번호").optional(),
                                        fieldWithPath("pageSize").type(JsonFieldType.NUMBER).description("페이지 당 크기").optional(),
                                        fieldWithPath("value").type(JsonFieldType.STRING).description("코드 값"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("코드명"),
                                        fieldWithPath("groupUuid").type(JsonFieldType.STRING).description("코드 그룹 식별자"),
                                        fieldWithPath("groupNm").type(JsonFieldType.STRING).description("코드 그룹 이름")
                                ),
                                responseFields(
                                        fieldWithPath("message").description("시스템 메시지"),
                                        fieldWithPath("result.content[]").description("오브젝트"),
                                        fieldWithPath("result.content[].uuid").description("고유번호"),
                                        fieldWithPath("result.content[].value").description("코드 값"),
                                        fieldWithPath("result.content[].name").description("코드명"),
                                        fieldWithPath("result.content[].groupName").description("코드 그룹 이름"),

                                        fieldWithPath("result.pageable").description("페이징 오브젝트"),
                                        fieldWithPath("result.pageable.offset").description("offset"),
                                        fieldWithPath("result.pageable.pageNumber").description("페이지 번호 (0부터 시작)"),
                                        fieldWithPath("result.pageable.pageSize").description("요청한 페이지 당 크기"),
                                        fieldWithPath("result.pageable.paged").description("페이징 여부"),
                                        fieldWithPath("result.pageable.unpaged").description("미 페이징 여부"),
                                        fieldWithPath("result.pageable.sort").description("정렬 정보"),
                                        fieldWithPath("result.pageable.sort.empty").description("정렬 정보 미존재 여부"),
                                        fieldWithPath("result.pageable.sort.unsorted").description("미정렬 여부"),
                                        fieldWithPath("result.pageable.sort.sorted").description("정렬 여부"),

                                        fieldWithPath("result.last").description("마지막 페이지 여부"),
                                        fieldWithPath("result.totalPages").description("페이지 갯수"),
                                        fieldWithPath("result.totalElements").description("총 요소 갯수"),
                                        fieldWithPath("result.first").description("첫 페이지 여부"),
                                        fieldWithPath("result.size").description("페이지 당 크기"),
                                        fieldWithPath("result.number").description("페이지 번호 (0부터 시작)"),
                                        fieldWithPath("result.sort.empty").description("정렬 정보 미존재 여부"),
                                        fieldWithPath("result.sort.unsorted").description("미정렬 여부"),
                                        fieldWithPath("result.sort.sorted").description("정렬 여부"),
                                        fieldWithPath("result.numberOfElements").description("현재 페이지 요소 갯수"),
                                        fieldWithPath("result.empty").description("현재 페이지 요소 미존재 여부")
                                )
                        )
                );

    }

    @Transactional
    @Test
    @Order(2)
    @DisplayName("공통코드 상세 조회, 성공")
    void codeDetailSuccess() throws Exception {
        String uri = Uris.CODE_ROOT + Uris.REST_NAME_UUID;

        mockMvc.perform(
                        get(uri, defaultCommonCode.getUuid())
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", notNullValue()))
                .andExpect(jsonPath("$.result", notNullValue()))
                .andExpect(jsonPath("$.result.uuid", notNullValue()))
                .andExpect(jsonPath("$.result.value", notNullValue()))
                .andExpect(jsonPath("$.result.name", notNullValue()))
                .andExpect(jsonPath("$.result.groupName", notNullValue()))
                .andExpect(jsonPath("$.result.description", notNullValue()))
                .andExpect(jsonPath("$.result.groupUuid", notNullValue()))
                .andExpect(jsonPath("$.result.createAt", notNullValue()))
                .andExpect(jsonPath("$.result.updatedAt", notNullValue()))

                .andExpect(jsonPath("$.message", is(MessageCode.SUCCESS.name())))
                .andExpect(jsonPath("$.result.uuid", is(defaultCommonCode.getUuid())))
                .andExpect(jsonPath("$.result.value", is(defaultCommonCode.getValue())))
                .andExpect(jsonPath("$.result.name", is(defaultCommonCode.getName())))
                .andExpect(jsonPath("$.result.groupName", is(defaultCommonCode.getGroup().getName())))
                .andExpect(jsonPath("$.result.description", is(defaultCommonCode.getDescription())))
                .andExpect(jsonPath("$.result.groupUuid", is(defaultCommonCode.getGroup().getUuid())))
                .andExpect(jsonPath("$.result.createAt",
                        is(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                .format(defaultCommonCode.getCreatedAt())))
                )
                .andExpect(jsonPath("$.result.updatedAt",
                        is(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                .format(defaultCommonCode.getUpdatedAt())))
                )

                .andDo(restDocs.document(
                                pathParameters(
                                        parameterWithName("uuid").description("공통코드 식별자")
                                ),
                                responseFields(
                                        fieldWithPath("message").description("시스템 메시지"),
                                        fieldWithPath("result").description("오브젝트"),
                                        fieldWithPath("result.uuid").description("공통코드 식별자"),
                                        fieldWithPath("result.value").description("공통코드 값"),
                                        fieldWithPath("result.name").description("공통코드 이름"),
                                        fieldWithPath("result.groupName").description("공통코드 그룹 이름"),
                                        fieldWithPath("result.description").description("공통코드 설명"),
                                        fieldWithPath("result.groupUuid").description("공통코드 그룹 식별자"),
                                        fieldWithPath("result.createAt").description("생성일"),
                                        fieldWithPath("result.updatedAt").description("수정일")

                                )
                        )
                );

    }

    @Transactional
    @Test
    @Order(3)
    @DisplayName("공통코드 상세 생성, 성공")
    void createCodeSuccess() {
    }

    @Transactional
    @Test
    @Order(4)
    @DisplayName("공통코드 상세 수정, 성공")
    void updateCodeSuccess() {
    }

    @Transactional
    @Test
    @Order(5)
    @DisplayName("공통코드 상세 삭제, 성공")
    void deleteCodeSuccess() {
    }

    @Transactional
    @Test
    @Order(6)
    @DisplayName("공통코드 그룹 리스트 조회, 성공")
    void codeGroupListSuccess() {
    }

    @Transactional
    @Test
    @Order(7)
    @DisplayName("공통코드 그룹 상세 조회, 성공")
    void codeGroupDetailSuccess() {
    }

    @Transactional
    @Test
    @Order(8)
    @DisplayName("공통코드 그룹 생성, 성공")
    void createCodeGroupSuccess() {
    }

    @Transactional
    @Test
    @Order(9)
    @DisplayName("공통코드 그룹 수정, 성공")
    void updateCodeGroupSuccess() {
    }

    @Transactional
    @Test
    @Order(10)
    @DisplayName("공통코드 그룹 삭제, 성공")
    void deleteCodeGroupSuccess() {
    }
}
