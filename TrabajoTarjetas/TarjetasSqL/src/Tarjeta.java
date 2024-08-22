public abstract class Tarjeta {
    private String numeroCuenta;
    private double montoApertura;

    public Tarjeta(String numeroCuenta, double montoApertura) {
        this.numeroCuenta = numeroCuenta;
        this.montoApertura = montoApertura;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getMontoApertura() {
        return montoApertura;
    }

    public abstract double cuotaDeManejo();
}
