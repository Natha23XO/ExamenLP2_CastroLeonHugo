CREATE DATABASE EXAMEN_LP2_C1_CastroLeon;
USE EXAMEN_LP2_C1_CastroLeon;

CREATE TABLE EMPLEADO(
id int primary key auto_increment,
nombre varchar(50),
apellido varchar(50),
edad INT CHECK (Edad >= 18),
sexo ENUM('M', 'F') NOT NULL,
salario DECIMAL(10, 2) CHECK (Salario BETWEEN 1500 AND 2500)
);
SELECT*FROM EMPLEADO;

INSERT INTO Empleado (nombre, apellido, edad, sexo, salario)
VALUES ('Hugo', 'Castro', 25, 'M', 2000.00);