package mygroup.appointments.exception;

public class CityNotValidException extends RuntimeException{
    private String message;
    public CityNotValidException(String message){
        super(message);
        this.message = message;
    }

    public CityNotValidException(){}
}
