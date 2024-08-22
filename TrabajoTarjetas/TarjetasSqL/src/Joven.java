public class Joven extends Tarjeta {

    public Joven(String numeroCuenta, double montoApertura) {
        super(numeroCuenta, montoApertura);
    }

    @Override
    public double cuotaDeManejo() {
        return 50000 - Descuento.BASICO.getValorDescontado(getMontoApertura());
    }
}
