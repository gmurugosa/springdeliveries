package tech.escalab.springdeliveries.handler;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.escalab.springdeliveries.dto.error.ErrorResponse;

import java.util.List;
import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class HandlerController {
    private final MessageSource messageSource;
    private Logger LOG = LoggerFactory.getLogger(HandlerController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> generalError(Exception exception) {

        LOG.error("Error found: ", exception);

        return buildResponse(100, HttpStatus.INTERNAL_SERVER_ERROR, "general_error", exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception) {

        LOG.error("Error found: ", exception);

        List<String> errors = exception.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .toList();

        return buildResponse(101, HttpStatus.BAD_REQUEST, "validation_error", errors);
    }

    private ResponseEntity<ErrorResponse> buildResponse(Integer codeAppError, HttpStatus httpStatus, String messageKey, Object detail) {

        var errorResponse = ErrorResponse.builder()
                .codeAppError(codeAppError)
                .httpStatus(httpStatus.value())
                .message(getMessage(messageKey))
                .detailMessage(detail)
                .build();

        return new ResponseEntity(errorResponse, httpStatus);
    }

    private String getMessage(String messageKey) {

        return messageSource.getMessage(messageKey, null, Locale.getDefault());
    }

}
