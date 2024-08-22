use blabyzpzzkbi294szmyn;

Drop table if exists Clientes;
create table Clientes (
id int auto_increment primary key,
nombre varchar(55)
);
Drop table if exists Productos;
create table Productos(
id int auto_increment primary key,
nombre varchar (255),
precio double
);
Drop table if exists Facturas;
create table Facturas(
id int auto_increment primary key,
cliente_id int,
fecha date,
foreign key (cliente_id) references Clientes(id)
);
Drop table if exists Factura_Productos;
create table Factura_Productos(
Factura_id int,
Producto_id int,
foreign key (Factura_id) references Facturas(id),
foreign key (Producto_id) references Productos(id)
);