package net.tecno360.gamecc.exceptionhandler;

import net.tecno360.gamecc.exception.ClassificationNotFoundException;
import net.tecno360.gamecc.exception.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleGameNotFoundException(GameNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(ClassificationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleClassificationNotFoundException(ClassificationNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception e){

        return "Message: " + e.getMessage() +
                "\n" + "Cause: " + e.getCause();
    }

}
