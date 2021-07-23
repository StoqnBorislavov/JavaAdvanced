package JavaOOP.ExceptionsAndErrorHandling;

public class InvalidPersonNameException extends RuntimeException{
    public InvalidPersonNameException(String message){
        super(message);
    }
}
