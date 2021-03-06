DROP TABLE IF EXISTS PRUEBA;
DROP TABLE IF EXISTS PEOPLE;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS PROVEEDORES;

CREATE TABLE PROVEEDORES(
	CODIGO			BIGINT			NOT NULL,
	NOMBRE			VARCHAR(100)	NOT NULL,
	PAIS			VARCHAR(100)	NOT NULL
);

CREATE TABLE PRODUCTS(
	CODIGO			BIGINT			NOT NULL,
	NOMBRE			VARCHAR(100)	NOT NULL,
	PRECIO			DECIMAL(8,2)	NOT NULL,
	FECHA_ALTA		DATE			NOT NULL,
	DESCATALOGADO	BIT(1)			NOT NULL,
	FAMILIA			VARCHAR(100)	NOT NULL
);

CREATE TABLE PRUEBA(
	CODIGO			BIGINT			NOT NULL,
	COL1			VARCHAR(100)	NOT NULL,
	COL2			VARCHAR(100)    NOT NULL,
	PRIMARY 		KEY (CODIGO)
);

CREATE TABLE PEOPLE (
	first_name		VARCHAR(100)	NOT NULL,
	last_name		VARCHAR(100)	NOT NULL
);

