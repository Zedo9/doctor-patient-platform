package mygroup.appointments.exception;

public class AppointmentTimeNotValidException extends RuntimeException{
    private String message;
    public AppointmentTimeNotValidException(String message){
        super(message);
        this.message = message;
    }

    public AppointmentTimeNotValidException(){}
}
