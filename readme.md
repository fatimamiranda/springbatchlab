##ejemplo1

##ejemplo2

##ejemplo3

##ejemplo4

Objetivo: Pasar datos de la tabla PRODUCTS al fichero materiales/salidas/ejemplo04_productos.csv

Se inicluye un ItemProcessor<Product,Product> que no realiza ninguna tarea!

El reader recibe un parámetro String para que la query filtre el producto por familia.

Hay dos endpoints para disparar el job4:

- http://localhost:8080/job4/hardware
- http://localhost:8080/job4?familia=hardware

##ejemplo7

