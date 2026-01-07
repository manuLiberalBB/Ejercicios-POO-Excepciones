package Excepciones;

public class LimiteExcedidoException extends Exception{
    public LimiteExcedidoException(String mensaje) {
        super(mensaje);
    }
}
