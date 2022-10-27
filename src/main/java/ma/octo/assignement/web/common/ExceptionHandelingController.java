package ma.octo.assignement.exceptions.common;


import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.UsernameDejaUtilise;
import ma.octo.assignement.exceptions.UtilisateurNonExistant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandelingController {

    @ExceptionHandler(UtilisateurNonExistant.class)
    public ResponseEntity<String> handleUtilisateurNonExistant(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Utilisateur introuvable", null,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CompteNonExistantException.class)
    public ResponseEntity<String> handleCompteNonExistantException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Compte introuvable", null,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsernameDejaUtilise.class)
    public ResponseEntity<String> handleUsernameDejaUtilise(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), null,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> errors =  new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error->{
            errors.put(error.getField(),error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

}
