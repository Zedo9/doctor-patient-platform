package mygroup.appointments.exception;

public class AppointmentDateNotValidException extends RuntimeException {
    private String message;
    public AppointmentDateNotValidException(String message){
        super(message);
        this.message = message;
    }

    public AppointmentDateNotValidException(){}
}
