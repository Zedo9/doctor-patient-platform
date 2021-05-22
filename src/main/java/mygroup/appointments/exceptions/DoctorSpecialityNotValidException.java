package mygroup.appointments.exceptions;

public class DoctorSpecialityNotValidException extends RuntimeException{
    private String message;
    public DoctorSpecialityNotValidException(String message){
        super(message);
        this.message = message;
    }

    public DoctorSpecialityNotValidException(){}
}
