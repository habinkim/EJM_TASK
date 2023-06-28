package kr.wooriga.ejm_task.exception;

import kr.wooriga.ejm_task.common.response.MessageCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class CommonApplicationException extends RuntimeException {

    private MessageCode messageCode;

}
