package fa.trainning.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.trainning.dto.DataResponse;
import fa.trainning.exception.AccountException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public DataResponse handleRuntimeException(RuntimeException e) {
		return new DataResponse("400", e.getMessage(), 200);
	}

	@ExceptionHandler(AccountException.class)
	@ResponseBody
	public DataResponse handleAccountException(AccountException e) {
		return new DataResponse("400", e.getMessage(), 200);
	}

}
