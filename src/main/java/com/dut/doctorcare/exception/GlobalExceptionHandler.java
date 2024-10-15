package com.dut.doctorcare.exception;

import com.dut.doctorcare.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<Object>> handlingRuntimeException(Exception e) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ApiResponse<Object>> handlingRuntimeException(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse<Object> apiResponse = new ApiResponse<>();

        apiResponse.setStatus(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity<ApiResponse<Object>> handlingAccessDeniedException(AccessDeniedException e) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setStatus(ErrorCode.UNAUTHORIZED.getCode());
        apiResponse.setMessage(ErrorCode.UNAUTHORIZED.getMessage());
        return ResponseEntity.status(ErrorCode.UNAUTHORIZED.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(value =MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handlingMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ApiResponse<Object> apiResponse = new ApiResponse<>();

        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try{
        String enumKey = e.getFieldError().getDefaultMessage();
             errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException ex) {

        }
        apiResponse.setStatus(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
