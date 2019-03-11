package com.cg.pizzaordering.aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PizzaOrderExceptionAspect {
	/*
	 * @ExceptionHandler(MovieDetailsNotFoundException.class) public
	 * ResponseEntity<CustomResponse> handelMovieDetailsNotFoundException(Exception
	 * e) { CustomResponse response = new CustomResponse(e.getMessage(),
	 * HttpStatus.EXPECTATION_FAILED.value()); return new
	 * ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED); }
	 */
}

