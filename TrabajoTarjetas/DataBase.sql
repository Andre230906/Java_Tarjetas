use by28wsxlyfggqfqk88in;
CREATE TABLE Tarjetas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(20) NOT NULL,
    monto_apertura DOUBLE NOT NULL,
    tipo_tarjeta ENUM('Joven', 'Nomina', 'Visa') NOT NULL,
    anho VARCHAR(4) NOT NULL
);
