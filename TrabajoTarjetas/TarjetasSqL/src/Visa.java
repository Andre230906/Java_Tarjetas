public class Visa extends Tarjeta {

    public Visa(String numeroCuenta, double montoApertura) {
        super(numeroCuenta, montoApertura);
    }

    @Override
    public double cuotaDeManejo() {
        return 50000 - Descuento.DIAMANTE.getValorDescontado(getMontoApertura());
    }
}
