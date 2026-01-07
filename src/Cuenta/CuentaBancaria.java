package Cuenta;

import Excepciones.SaldoInsuficienteException;

public class CuentaBancaria {

    // Atributos
    private String titular;
    private double saldo;

    // Constructor
    public CuentaBancaria(String nombreDelTitular, double dineroInicial) {
        this.titular = nombreDelTitular;
        this.saldo = dineroInicial;
    }

    public double getSaldo() {
        return saldo;
    }
    public void restarSaldo(double monto) throws SaldoInsuficienteException {
        if (this.saldo >= monto) {
        this.saldo = this.saldo - monto;
        } else {
            throw new SaldoInsuficienteException("No hay fondos suficientes. Saldo actual: " + this.saldo);
        }
    }
    public void mostrarDatos() {
        System.out.println("Titular: " + titular + " | Saldo: $" + saldo);
    }
}
