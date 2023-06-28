package kr.wooriga.ejm_task.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {

    private String message;
    private @JsonInclude(JsonInclude.Include.NON_NULL) T result;

}
