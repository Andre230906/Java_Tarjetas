/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public enum TipoCliente {
    CLIENTE_BASICO(1.0),    // Sin descuento
    CLIENTE_PREMIUM(0.9),   // 10% de descuento
    CLIENTE_PEDRO(0.8);     // 20% de descuento

    private double descuento;

    private TipoCliente(double descuento) {
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }
}
