package napih_server.exception;

public class ApiEndpointNotFoundException extends RuntimeException{

    public ApiEndpointNotFoundException(String message){
        super(message);
    }

}
