package Tarjeta;

import Cliente.Cliente;
import Excepciones.LimiteExcedidoException;

public class TarjetaCredito extends Tarjeta {
    // Atributos exclusivos de la tarjeta de credito
    private double limiteCrediticio;
    private double saldoConsumido;

    // ------ CONSTRUCTOR --------
    public TarjetaCredito(String numero, String codSeguridad, String fechaEmision, String fechaVencimiento, String marca, Cliente cliente, double limiteCrediticio) {
        super(numero, codSeguridad, fechaEmision, fechaVencimiento, marca, cliente);
        this.limiteCrediticio = limiteCrediticio;
        this.saldoConsumido = 0;
    }
    // ---- METODO ABSTRACTO -------

    @Override
    public void procesarPago(double monto) {
        try {
            if (saldoConsumido + monto > limiteCrediticio) {
                throw new LimiteExcedidoException("Límite insuficiente. Te querés gastar " + (saldoConsumido + monto) + " y tu límite es " + limiteCrediticio);
            }
                this.saldoConsumido += monto;
                System.out.println("Pago exitoso con CRÉDITO. Deuda acumulada: $" + this.saldoConsumido);
        } catch(LimiteExcedidoException e) {
            System.out.println("OPERACIÓN DENEGADA");
            System.out.println("MOTIVO: " + e.getMessage());
        }
    }

    // ----- GETTERS & SETTERS

    public double getLimiteCrediticio() {
        return limiteCrediticio;
    }

    public void setLimiteCrediticio(double limiteCrediticio) {
        this.limiteCrediticio = limiteCrediticio;
    }

    public double getSaldoConsumido() {
        return saldoConsumido;
    }

    public void setSaldoConsumido(double saldoConsumido) {
        this.saldoConsumido = saldoConsumido;
    }
}
