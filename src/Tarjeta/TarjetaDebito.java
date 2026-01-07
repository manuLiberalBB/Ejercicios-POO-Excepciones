package Tarjeta;

import Cliente.Cliente;
import Cuenta.CuentaBancaria;
import Excepciones.SaldoInsuficienteException;

public class TarjetaDebito extends Tarjeta {
    // Atributos exclusivos de la tarjeta de débito
    private CuentaBancaria cuentaAsociada;

    // ----- CONSTRUCTOR --------

    public TarjetaDebito(String numero, String codSeguridad, String fechaEmision, String fechaVencimiento, String marca, Cliente cliente, CuentaBancaria cuentaAsociada) {
        super(numero, codSeguridad, fechaEmision, fechaVencimiento, marca, cliente);
        this.cuentaAsociada = cuentaAsociada;
    }

    // ---- METODO ABSTRACTO -----

    @Override
    public void procesarPago(double monto) {

            try {
            cuentaAsociada.restarSaldo(monto);
            System.out.println("Pago realizado con DÉBITO directo de la cuenta.");
            } catch (SaldoInsuficienteException e) {
            System.out.println("ERROR: La cuenta no tiene fondos suficientes para realizar el pago");
            System.out.println("ERROR: " + e.getMessage());
            }
    }
}
