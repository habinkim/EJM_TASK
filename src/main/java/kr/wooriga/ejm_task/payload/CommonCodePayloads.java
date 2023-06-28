package kr.wooriga.ejm_task.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

public class CommonCodePayloads {

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

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdAt;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime updatedAt;

    }

    @Builder
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

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequest {

        @NotBlank(message = "코드 식별자를 입력하지 않으셨습니다.")
        private String uuid;

        private String value;
        private String name;
        private String description;
        private String groupUuid;

    }
}
