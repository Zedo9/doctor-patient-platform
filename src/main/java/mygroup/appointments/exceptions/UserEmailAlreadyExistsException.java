package mygroup.appointments.exceptions;

public class UserEmailAlreadyExistsException extends RuntimeException{
    private String message;
    public UserEmailAlreadyExistsException(String message){
        super(message);
        this.message = message;
    }
    public UserEmailAlreadyExistsException(){}
}
