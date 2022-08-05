package fa.trainning.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.trainning.dto.DataResponse;

@ControllerAdvice
public class MyExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public DataResponse handleRuntimeException(RuntimeException e) {
		return new DataResponse("400", e.getMessage(), 200);
	}

	/*
	 * @ExceptionHandler(StoreException.
	 * class)
	 * 
	 * @ResponseBody public DataResponse handleStoreException(StoreException e) {
	 * return new DataResponse("400", e.getMessage(), 200); }
	 */
}
