

¡Bienvenido al primer desafío del Challenge Java!

En esta oportunidad, a los Devs se nos solicitó crear un conversor de divisas utilizando el lenguaje Java. Las características solicitadas por nuestro cliente son las siguientes:

** Requisitos: **
- El convertidor de moneda debe:

           - Convertir de la moneda de tu país a Dólar
           - Convertir de la moneda de tu país  a Euros
           - Convertir de la moneda de tu país  a Libras Esterlinas
           - Convertir de la moneda de tu país  a Yen Japonés
           - Convertir de la moneda de tu país  a Won sul-coreano

Recordando que también debe ser posible convertir inversamente, es decir:

           - Convertir de Dólar a la moneda de tu país
           - Convertir de Euros a la moneda de tu país
           - Convertir de Libras Esterlinas a la moneda de tu país
           - Convertir de Yen Japonés a la moneda de tu país
           - Convertir de Won sul-coreano a la moneda de tu país

**Extras:**
Como desafío extra te animamos a que dejes fluir tu creatividad, si puedo convertir divisas, ¿tal vez pueda añadir a mi programa otros tipos de conversiones como temperatura por ejemplo?

**_**Data Base Connector MySQL**_**
------
create database conversor_alura;
use conversor_alura;
create table TIPOCONVERSION(
id int auto_increment,
nombre varchar(50) not null,
descripcion varchar(250) not null,
primary key(id)
)engine = InnoDB;

insert into TIPOCONVERSION(
nombre,
descripcion
)values('MONEDAS','Conversor de tipo monedas internacionales'),('TEMPERATURAS','Conversor de tipo temperaturas'),('MEDIDAS','Conversor de tipo medidas');

create table CONVERSION(
id int auto_increment,
cambio1 varchar(50),
cambio2 varchar(50),
valor1 double not null default 0,
valor2 double not null default 0,
primary key(id)
)engine = InnoDB;

alTER table CONVERSION ADD column TIPOCONVERSION_ID INT ;

ALTER table CONVERSION ADD foreign key (TIPOCONVERSION_ID) REFERENCES TIPOCONVERSION(ID);


insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'PESO','DOLAR', 950,1,1
);

insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'PESO','EURO', 870,1,1
);
select * FROM CONVERSION;
select * FROM TIPOCONVERSION;
