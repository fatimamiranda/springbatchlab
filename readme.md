## ejemplo 1

## ejemplo 2

## ejemplo 3

## ejemplo 4

Objetivo: Pasar datos de la tabla PRODUCTS al fichero materiales/salidas/ejemplo04_productos.csv

Se inicluye un ItemProcessor<Product,Product> que no realiza ninguna tarea!

El reader recibe un parámetro String para que la query filtre el producto por familia.

El endpoint para disparar el job4:

- http://localhost:8080/trigger/job4?familia=hardware

## ejemplo 5

Objetivo: Pasar datos de la tabla PRODUCTS al fichero materiales/salidas/ejemplo05_productos.csv

Se inicluye un ItemProcessor<Product,Product> que no realiza ninguna tarea!

El reader recibe dos parámetros (min y max) para filtrar productos entre un rango de precios.

El endpoint para disparar el job5:

- http://localhost:8080/trigger/job5?min=100.0&max=150.76

## ejemplo 7

Objetivo: Utilizar implementaciones sencillas (dummy) de ItemReader e ItemWriter

ItemReader lee la clase ProductDTO
ItemProcessor mapea de ProductDTO a Product
ItemWriter escribe Product

El endpoint para disparar el job7:

- http://localhost:8080/trigger/job7

## ejemplo 8

Objetivo: Leer datos de un fichero XML y escribir en fichero CSV

El endpoint para disparar el job8:

- http://localhost:8080/trigger/job8


## ejemplo 10

Objetivo: Pasar datos de un fichero csv a una tabla, utilizando repositorios de Spring Data (JPA)

El endpoint para disparar el job10:

- http://localhost:8080/trigger/job10

## ejemplo 11

El endpoint para disparar el job11:

- http://localhost:8080/trigger/job11

## ejemplo 12

El endpoint para disparar el job12:

- http://localhost:8080/trigger/job12

## ejemplo 13

El endpoint para disparar el job13:

- http://localhost:8080/trigger/job13

## ejemplo 14

Objetivo: Ejecutar steps en paralelo

El endpoint para disparar el job14:

- http://localhost:8080/trigger/job14

## ejemplo 15

Objetivo: Ejecutar steps con condicionales.



El endpoint para disparar el job15:

- http://localhost:8080/trigger/job15

