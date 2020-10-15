package com.bcnit12.controller;

import java.security.AccessControlException;
import java.util.NoSuchElementException;
import javax.servlet.ServletException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorController extends DefaultResponseErrorHandler {
	/*
	 * @ResponseStatus(value = HttpStatus.OK)
	 * 
	 * @ResponseBody public String requestOk() { return "All right"; }
	 */
	@ExceptionHandler(AccessControlException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	@ResponseBody
	public String requestForbidden() {
		return "You shall not pass!";

	}

	@ExceptionHandler(ServletException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public String requestNotFound() {
		return "Please check the path,maybe you forgot a param.";
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String invalidRequest() {
		return "Invalid request.More(or less) info needed.If the word 'body' is included "
				+ "in the path,you have to enter the info manually in the body section.";
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class, NoSuchElementException.class,  })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String cantFoundEmployee() {
		return "Employee not found.Try with '/show' to find the id you are looking for.";
	}
//	@ExceptionHandler(NoHandlerFoundException.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	@ResponseBody
//	public String requestPathNotFound() {
//		return "Invalid path.";
//	}
	

}
