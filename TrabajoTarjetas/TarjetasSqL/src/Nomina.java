public class Nomina extends Tarjeta {

    public Nomina(String numeroCuenta, double montoApertura) {
        super(numeroCuenta, montoApertura);
    }

    @Override
    public double cuotaDeManejo() {
        return 50000 - Descuento.PLATINO.getValorDescontado(getMontoApertura());
    }
}
