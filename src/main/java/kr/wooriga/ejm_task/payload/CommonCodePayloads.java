package kr.wooriga.ejm_task.payload;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CommonCodePayloads {

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListRequest {

        @Builder.Default
        @Positive(message = "페이지 번호는 0 이상이어야 합니다.")
        private Integer pageNo = 0;

        @Builder.Default
        @Positive(message = "페이지당 크기는 0 이상이어야 합니다.")
        private Integer pageSize = 10;

        private String value;

        private String name;

        private String groupUuid;
        private String groupNm;

    }

    @SuperBuilder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListResponse {

        private String uuid;
        private String value;
        private String name;

        private String groupName;

    }

    @SuperBuilder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetailResponse extends ListResponse {
        private String description;

        private String groupUuid;
        private String groupDescription;
    }

    @SuperBuilder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {

        @NotBlank(message = "코드 값을 입력하지 않으셨습니다.")
        private String value;

        @NotBlank(message = "코드명을 입력하지 않으셨습니다.")
        private String name;

        @NotBlank(message = "설명을 입력하지 않으셨습니다.")
        private String description;

        @NotBlank(message = "부모 식별자를 입력하지 않으셨습니다.")
        private String groupUuid;

    }
}
