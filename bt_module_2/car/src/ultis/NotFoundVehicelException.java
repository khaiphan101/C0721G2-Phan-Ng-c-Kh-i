package ultis;

public class NotFoundVehicelException extends Exception{
    public void getMessage(String message) {
        System.err.println(message);
    }
}
