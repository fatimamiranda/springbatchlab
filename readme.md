## ejemplo 1

## ejemplo 2

## ejemplo 3

## ejemplo 4

Objetivo: Pasar datos de la tabla PRODUCTS al fichero materiales/salidas/ejemplo04_productos.csv

Se inicluye un ItemProcessor<Product,Product> que no realiza ninguna tarea!

El reader recibe un parámetro String para que la query filtre el producto por familia.

Hay dos endpoints para disparar el job4:

- http://localhost:8080/job4/hardware
- http://localhost:8080/job4?familia=hardware

## ejemplo 5

Objetivo: Pasar datos de la tabla PRODUCTS al fichero materiales/salidas/ejemplo05_productos.csv

Se inicluye un ItemProcessor<Product,Product> que no realiza ninguna tarea!

El reader recibe dos parámetros (min y max) para filtrar productos entre un rango de precios.

El endpoint para disparar el job5:

- http://localhost:8080/job5?min=100.0&max=150.76

## ejemplo 7

## ejemplo 8

## ejemplo 10

## ejemplo 11

# ejemplo 12

