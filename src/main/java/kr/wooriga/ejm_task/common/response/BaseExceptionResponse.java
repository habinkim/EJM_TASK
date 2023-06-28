package kr.wooriga.ejm_task.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseExceptionResponse {

    private String message;
    private String code;

}
