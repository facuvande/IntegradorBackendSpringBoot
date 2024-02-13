# API Rest para proyecto Final TodoCode

* Realice esta API Rest como proyecto final aplicando todo lo aprendido en el curso de Apis En Java Con SpringBoot de Todocode
* Este proyecto fue realizado por Facundo Vandecaveye.


## Stack de Tecnologias

* Java
* Spring Framework
* Spring Boot
* Lombok
* Spring Data JPA
* Hibernate
* MySQL

## Modulos

* Modulo de Cliente
* Modulo de Producto
* Modulo de Venta


## Instalacion y Ejecucion

* Antes de ejecutar el servidor de la API, debes actualizar la configuracion de la base de datos dentro del archivo application.properties. 
* Actualiza el numero de puerto, nombre de usuario y contraseña según la configuración de tu base de datos local.

```
    server.port=8009

    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/integrador_springboot?seSSL=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=

```

## Puntos de acceso de la API

`https://localhost:8009/`

* Acceso a Documentacion por Swagger
`http://localhost:8009/doc/documentation.html`


## API Endpoints

### Cliente

* `POST /clientes/crear` : Crear un nuevo cliente
* `GET /clientes` : Trae lista completa de clientes
* `GET /clientes/{code}` : Trae cliente en particular recibiendo como parametro el codigo de cliente
* `DELETE /clientes/eliminar/{code}` : Eliminar un cliente en particular recibiendo como parametro el codigo de cliente
* `PUT /clientes/editar/{code}` : Edita un cliente recibiendo como parametro el codigo de cliente y como Body el nuevo cliente

### Producto

* `POST /productos/crear` : Crear un nuevo Producto
* `GET /productos` : Trae lista completa de productos
* `GET /productos/{code}` : Trae producto en particular recibiendo como parametro el codigo de producto
* `DELETE /productos/eliminar/{code}` : Eliminar un producto en particular recibiendo como parametro el codigo de producto
* `PUT /productos/editar/{code}` : Edita un producto recibiendo como parametro el codigo de producto y como Body el nuevo producto
* `GET /productos/falta_stock` : Trae todos los productos cuya cantidad_disponible es menor a 5


### Venta

* `POST /ventas/crear` : Crear una nueva Venta
* `GET /ventas` : Trae lista completa de ventas
* `GET /ventas/{code}` : Trae venta en particular recibiendo como parametro el codigo de venta
* `DELETE /ventas/eliminar/{code}` : Eliminar una venta en particular recibiendo como parametro el codigo de venta
* `PUT /ventas/editar/{code}` : Edita una venta recibiendo como parametro el codigo de venta y como Body la nueva venta
* `GET /ventas/productos/{code}` : Trae todos los productos de una venta recibiendo como parametro el codigo de la venta
* `GET /ventas/fecha/{fecha_venta}` : Trae sumatoria total del monto y cantidad total de ventas en determinada fecha en formato `YYYY-MM-DD`
* `GET /ventas/mayor_venta` : Trae datos de la mayor venta realizada (monto mas grande)
  


### Recomendaciones

* Recomiendo realizar las consultas mediante la funcionalidad agregada de documentacion de Swagger, ingresando mediante la url `http://localhost:8009/doc/documentation.html` reemplazando el puerto por el elegido en application.properties
