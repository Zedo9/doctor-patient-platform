package mygroup.appointments.aspects;

import mygroup.appointments.exceptions.*;
import mygroup.appointments.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDoctorNotFoundException(DoctorNotFoundException e) {
        ErrorResponse response= new ErrorResponse();
        response.setErrorCode("NOT_FOUND");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PatientNotFoundExcep.class)
    public ResponseEntity<ErrorResponse> handlePatientNotFoundException(PatientNotFoundExcep e) {
        ErrorResponse response= new ErrorResponse();
        response.setErrorCode("NOT_FOUND");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAppointmentNotFoundException(AppointmentNotFoundException e) {
        ErrorResponse response= new ErrorResponse();
        response.setErrorCode("NOT_FOUND");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CityNotValidException.class)
    public ResponseEntity<ErrorResponse> handleCityNotValidException(CityNotValidException e) {
        ErrorResponse response= new ErrorResponse();
        response.setErrorCode("BAD_REQUEST");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DoctorSpecialityNotValidException.class)
    public ResponseEntity<ErrorResponse> handleDoctorSpecialityNotValidException(DoctorSpecialityNotValidException e) {
        ErrorResponse response= new ErrorResponse();
        response.setErrorCode("BAD_REQUEST");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppointmentTimeNotValidException.class)
    public ResponseEntity<ErrorResponse> handleAppointmentTimeNotValidException(AppointmentTimeNotValidException e) {
        ErrorResponse response= new ErrorResponse();
        response.setErrorCode("BAD_REQUEST");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AppointmentDateNotValidException.class)
    public ResponseEntity<ErrorResponse> handleAppointmentTimeNotValidException(AppointmentDateNotValidException e) {
        ErrorResponse response= new ErrorResponse();
        response.setErrorCode("BAD_REQUEST");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserEmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserEmailAlreadyExistsException(UserEmailAlreadyExistsException e) {
        ErrorResponse response= new ErrorResponse();
        response.setErrorCode("CONFLICT");
        response.setErrorMessage(e.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.CONFLICT);
    }
}
