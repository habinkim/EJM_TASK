package kr.wooriga.ejm_task.payload;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public class CommonCodeGroupPayloads {

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListRequest {

        @Builder.Default
        @PositiveOrZero(message = "페이지 번호는 0 이상이어야 합니다.")
        private Integer pageNo = 0;

        @Builder.Default
        @Positive(message = "페이지당 크기는 1 이상이어야 합니다.")
        private Integer pageSize = 10;

        private String name;

    }

    @SuperBuilder(toBuilder = true)
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListResponse {

        private String uuid;
        private String name;

    }

    @SuperBuilder(toBuilder = true)
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetailResponse extends ListResponse {

        private String description;
        private List<CommonCodePayloads.ListResponse> codes;

    }

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {

        @NotBlank(message = "그룹명을 입력하지 않으셨습니다.")
        private String name;

        @NotBlank(message = "설명을 입력하지 않으셨습니다.")
        private String description;

    }

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequest {

        @NotBlank(message = "그룹 식별자를 입력하지 않으셨습니다.")
        private String uuid;

        private String name;
        private String description;

    }

}
