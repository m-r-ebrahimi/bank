package dao;

public class OutOfMoneyException extends Exception{
    public OutOfMoneyException(String message) {
        super(message);
    }
}
