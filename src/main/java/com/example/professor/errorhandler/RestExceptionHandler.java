package com.example.professor.errorhandler;

//import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

//   @Override
//   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//       String error = "Malformed JSON request";
//       return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
//   }

   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
       return new ResponseEntity<>(apiError, apiError.getStatus());
   }


   //other exception handlers below
   @ExceptionHandler(EntityNotFoundException.class)
   protected ResponseEntity<Object> handleEntityNotFound(
           EntityNotFoundException ex) {
       ApiError apiError = new ApiError(NOT_FOUND);
       apiError.setMessage(ex.getMessage());
       return buildResponseEntity(apiError);
   }

    /**
     * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid validation.
     *
     * @param ex      the MethodArgumentNotValidException that is thrown when @Valid validation fails
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ApiError apiError = new ApiError(BAD_REQUEST);
        apiError.setMessage("Validation error");
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
        return buildResponseEntity(apiError);
    }

    /**
     * Handle HttpMessageNotReadableException. Happens when request JSON is malformed.
     *
     * @param ex      HttpMessageNotReadableException
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable
    (HttpMessageNotReadableException ex,
     HttpHeaders headers,
     HttpStatus status,
     WebRequest request) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage("Validation error");
//        apiError.addValidationErrors(ex.getHttpInputMessage().getFieldErrors());
//        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
//        return buildResponseEntity(apiError);

        //ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        //Log.info("{} to {}", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());
        String error = "Malformed JSON request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
   }
}
