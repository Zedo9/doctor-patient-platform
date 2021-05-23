package mygroup.appointments.responses;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private String errorMessage;
    private String errorCode;

    public ErrorResponse(LocalDateTime timestamp, String message, String error_code) {
        this.timestamp = timestamp;
        this.errorMessage = message;
        this.errorCode = error_code;
    }

    public ErrorResponse(){}

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
