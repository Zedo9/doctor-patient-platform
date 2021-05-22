package mygroup.appointments.exception;

public class EntityNotFoundException extends RuntimeException{
    private String message;
    public EntityNotFoundException(String message){
        super(message);
        this.message = message;
    }

    public EntityNotFoundException(){}
}
