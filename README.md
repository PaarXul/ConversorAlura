# **_**Challenge Java // Convertidor**_**
## ¡Bienvenido al primer desafío del Challenge Java!

En esta oportunidad, a los Devs se nos solicitó crear un conversor de divisas utilizando el lenguaje Java. Las características solicitadas por nuestro cliente son las siguientes:

** Requisitos: **
- El convertidor de moneda debe:

           - Convertir de la moneda de tu país a Dólar
           - Convertir de la moneda de tu país  a Euros

- Recordando que también debe ser posible convertir inversamente, es decir:

           - Convertir de Dólar a la moneda de tu país
           - Convertir de Euros a la moneda de tu país

**Extras:**
Como desafío extra te animamos a que dejes fluir tu creatividad, si puedo convertir divisas, ¿tal vez pueda añadir a mi programa otros tipos de conversiones como temperatura por ejemplo?

Conocimientos Aplicados
------------------------------------
* Java 11
* Programación Orientada Objetos
* Clases
* Herencia, Polimorfismo.
* Data Factory
* Lambda 
* DAO (Data Access Object)
* MVC (Model - View - Controller)
* Librerías Maven
* BasicDataSource (Pool de conexiones)
* Java Swing
* Sobrescritura de métodos
* Creación de base de datos
* Consultas SQL

##### ***Data Base Connector MySQL***

> **Creacion de base de datos**
> 
>create database conversor_alura;
>
>use conversor_alura;
>
>create table TIPOCONVERSION(
<img src="">id int auto_increment,
nombre varchar(50) not null,
descripcion varchar(250) not null,
primary key(id)
)engine = InnoDB;
>
>insert into TIPOCONVERSION(
nombre,
descripcion
)values('MONEDAS','Conversor de tipo monedas internacionales'),('TEMPERATURAS','Conversor de tipo temperaturas'),('MEDIDAS','Conversor de tipo medidas');
>
>create table CONVERSION(
id int auto_increment,
cambio1 varchar(50),
cambio2 varchar(50),
valor1 double not null default 0,
valor2 double not null default 0,
primary key(id)
)engine = InnoDB;
> 
>**Modificar base de datos**
> 
>AlTER table CONVERSION ADD column TIPOCONVERSION_ID INT ;
>
>ALTER table CONVERSION ADD foreign key (TIPOCONVERSION_ID) REFERENCES TIPOCONVERSION(ID);

> **Inserción de datos**
> 
>insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'PESO','DOLAR', 950,1,1
);
>
>insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'PESO','EURO', 870,1,1
);
insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'Celsius','Fahrenheit', 0,32,2
);
insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'Celsius','Kelvin', 0,273.15,2
);
insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'Fahrenheit','Kelvin', 32,273.15,2
);
>
>insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'Kilómetro','Metro', 1,1000,3
);
insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'Kilómetro','Milla', 1,0.621371,3
);
insert into CONVERSION(
cambio1,
cambio2,
valor1,
valor2,
TIPOCONVERSION_ID
)values(
'Metro','Milla', 1,0.000621371,3
);

> **Consultas Básicas**
> 
>select * FROM CONVERSION;   
>select * FROM TIPOCONVERSION;

![Screenshot_3.png](src%2Fmain%2Fjava%2Forg%2Falura%2Fimg%2FScreenshot_3.png)
![Screenshot_2.png](src%2Fmain%2Fjava%2Forg%2Falura%2Fimg%2FScreenshot_2.png)
![Screenshot_4.png](src%2Fmain%2Fjava%2Forg%2Falura%2Fimg%2FScreenshot_4.png)
![Screenshot_5.png](src%2Fmain%2Fjava%2Forg%2Falura%2Fimg%2FScreenshot_5.png)
