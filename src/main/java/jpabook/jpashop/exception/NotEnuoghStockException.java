package jpabook.jpashop.exception;

public class NotEnuoghStockException extends RuntimeException {

    public NotEnuoghStockException() {
        super();
    }

    public NotEnuoghStockException(String message) {
        super(message);
    }

    public NotEnuoghStockException(String message, Throwable cause) {
        super(message, cause);
    }


}
