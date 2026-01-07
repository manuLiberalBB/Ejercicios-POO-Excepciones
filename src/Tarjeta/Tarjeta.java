package Tarjeta;

import Cliente.Cliente;

public abstract class Tarjeta {

    // ----- Atributos -------
    private String numero;
    private String codSeguridad;
    private String fechaEmision;
    private String fechaVencimiento;
    private String marca;
    private Cliente cliente;

    // ----- Constructor ----->

    public Tarjeta(String numero, String codSeguridad, String fechaEmision, String fechaVencimiento, String marca, Cliente cliente) {
        this.numero = numero;
        this.codSeguridad = codSeguridad;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.marca = marca;
        this.cliente = cliente;
    }

    // ----- Metodo Abstracto | Se define el que se hace pero no el como -----

    public abstract void procesarPago(double monto);

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodSeguridad() {
        return codSeguridad;
    }

    public void setCodSeguridad(String codSeguridad) {
        this.codSeguridad = codSeguridad;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
