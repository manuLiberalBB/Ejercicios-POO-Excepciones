package Principal;

import Cliente.Cliente;
import Cuenta.CuentaBancaria;
import Tarjeta.*;

public class Principal {

    public static void main(String[] args) {

        System.out.println("--- 1. CREANDO EL ENTORNO ---");

        // A. Creamos al cliente
        Cliente messi = new Cliente("Lionel Messi", "10.101.010");
        System.out.println("Cliente creado: " + messi.toString());

        // B. Creamos la Cuenta Bancaria (La caja fuerte)
        CuentaBancaria cuentaLeo = new CuentaBancaria("Lionel Messi", 65000);
        System.out.println("Cuenta creada con saldo inicial: $650000");

        System.out.println("\n--- 2. EMITIENDO TARJETAS ---");

        // C. Tarjeta de DÉBITO (La vinculamos a la cuentaLeo)
        TarjetaDebito tarjetaDebito = new TarjetaDebito(
                "4500-1111", "123", "01/24", "01/29", "VISA",
                messi,
                cuentaLeo
        );

        // D. Tarjeta de CRÉDITO
        TarjetaCredito tarjetaCredito = new TarjetaCredito(
                "5400-2222-1111-3333", "999", "01/24", "01/29", "MASTERCARD",
                messi,
                50000
        );

        System.out.println("\n--- 3. PROBANDO PAGOS ---");

        // CASO A: Pago con DÉBITO ($20.000)
        // Debería restar de la cuenta bancaria inmediatamente.
        System.out.println("\n>> Comprando súper con DÉBITO ($20.000)...");
        tarjetaDebito.procesarPago(20000);

        // Verificamos la cuenta bancaria
        System.out.print("Estado de la Cuenta Bancaria: ");
        // Esperamos ver $80.000
        System.out.println("Saldo actual: $" + cuentaLeo.getSaldo());


        // CASO B: Pago con CRÉDITO ($10.000)
        // No toca la cuenta, aumenta la deuda de la tarjeta.
        System.out.println("\n>> Comprando nafta con CRÉDITO ($10.000)...");
        tarjetaCredito.procesarPago(10000);

        // Verificamos de nuevo la cuenta (NO debería haber cambiado)
        System.out.print("Estado de la Cuenta Bancaria: ");
        System.out.println("Saldo actual: $" + cuentaLeo.getSaldo()); // Sigue en 80k

        System.out.println("Saldo consumido tarjeta crédito: $" + tarjetaCredito.getSaldoConsumido());


        // CASO C: Intentar reventar la tarjeta de DÉBITO (Saldo insuficiente)
        System.out.println("\n>> Intentando comprar un auto ($5.000.000) con DÉBITO...");
        tarjetaDebito.procesarPago(5000000); // Debería dar error
    }
}