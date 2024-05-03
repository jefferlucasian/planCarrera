CREATE DATABASE plancarrera;
use plancarrera;

CREATE TABLE clientes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    correo VARCHAR(255) UNIQUE,
    fecha_registro TIMESTAMP,
    activo BOOLEAN
);