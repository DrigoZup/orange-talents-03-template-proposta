package br.com.zup.creditcard.errorhandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.zup.creditcard.general.ResponseDto;

@RestControllerAdvice
public class ErrorValidatorHandler {
	@Autowired
    MessageSource messageSource;
	
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDto> handleValidationErrors(MethodArgumentNotValidException exception) {
        List<ErrorDto> dto = new ArrayList<>();
        
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorDto error = new ErrorDto(e.getField(), message);
            dto.add(error);
        });
        
        return dto;
    }
    
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler({GenericException.class})
    public @ResponseBody ResponseDto handleBusinessErrors(Exception e) {
        return new ResponseDto(e.getMessage());
    }
    
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler({BadCredentialsException.class, DisabledException.class,
//        IllegalArgumentException.class, ExpiredJwtException.class})
//    public @ResponseBody ResponseDto handleSecurityErrors(Exception e) {
//        return new ResponseDto(e.getMessage());
//    }
}
