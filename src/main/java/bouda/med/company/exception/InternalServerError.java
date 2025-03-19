package bouda.med.company.exception;

public class InternalServerError extends RuntimeException{

    public InternalServerError(){

    }
    public InternalServerError(String message){
        super(message);
    }
    
}
