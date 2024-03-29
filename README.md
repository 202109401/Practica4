# Practica4.- Creación API REST
En esta práctica se ha creado una API REST con los conceptos aprendidos en clase. La temática de esta práctica es de películas, temática que se empleó en la práctica anterior de la asignatura.
Para comprobar el funcionamiento del código, se ha empleado el puerto 8080, cuyo link es: http://localhost:8080/api/peliculas

Además se ha creado un archivo HTTP en VisualStudioCode llamado apiPeliculas.http para comprobar el correcto funcionamiento de la práctica.
# Ejemplo test de funcionamiento:
## CREACIÓN DE UNA PELÍCULA:
Para crear una película, se emplea el método HTTP, POST. 
```ruby
POST http://localhost:8080/api/peliculas HTTP/1.1
Content-Type: application/json

{
    "titulo":"Titanic",
    "año" : 1997
}
```

Al mandar esta petición, se obtiene una respuesta de éxito 201 (HTTP.CREATE), creándose el título de la película deseado. 
```ruby
HTTP/1.1 201 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Fri, 29 Mar 2024 12:35:30 GMT
Connection: close

{
  "titulo": "Titanic",
  "año": 1997
}
```

Si se desea ver el resultado obtenido al ir a la URL: http://localhost:8080/api/peliculas tras ejecutar la petición POST, se obtendrá el siguiente resultado:

![image](https://github.com/202109401/Practica4/assets/147172532/e7e7bfbb-f575-4c0d-ae1e-50ac583ee90c)

## OBTENCIÓN DE UNA PELÍCULA DETERMINADA
Para obtener una película concreta, se realiza una petición haciendo uso de GET. 

```ruby
GET http://localhost:8080/api/peliculas/Titanic
```
Al mandar esta petición, se obtiene una respuesta de éxito 200, obteniéndose la información de la película deseada. 
```ruby
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Fri, 29 Mar 2024 12:45:58 GMT
Connection: close

{
  "titulo": "Titanic",
  "año": 1997
}
```

Si se desea ver el resultado obtenido al ir a la URL: http://localhost:8080/api/peliculas/Titanic tras ejecutar la petición GET, se obtendrá el siguiente resultado:

![image](https://github.com/202109401/Practica4/assets/147172532/406faa20-80e8-410b-ba5e-745894f73da6)

## ACTUALIZACIÓN DE UNA PELÍCULA
Para actualizar la información de una película concreta, se realiza una petición haciendo uso de PUT. 
```ruby
PUT http://localhost:8080/api/peliculas/Titanic
Content-Type: application/json

{
    "titulo": "Titanic: Edición Especial",
    "año": 2022
}
```
Al mandar esta petición, se obtiene una respuesta de éxito 200, reemplazándose la información que se quiere modificar por la nueva actualizada de la película deseada. 
```ruby
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Fri, 29 Mar 2024 12:49:30 GMT
Connection: close

{
  "titulo": "Titanic: Edición Especial",
  "año": 2022
}
```
Si se desea ver el resultado obtenido al ir a la URL: http://localhost:8080/api/peliculas tras ejecutar la petición GET, se obtendrá el siguiente resultado:

![image](https://github.com/202109401/Practica4/assets/147172532/ee961586-eeb4-407e-8d4c-4f6b3c886c79)
## ELIMINACIÓN DE UNA PELÍCULA
Para eliminar una película concreta, se realiza una petición haciendo uso de DELETE. 
```ruby
DELETE http://localhost:8080/api/peliculas/Titanic
```
Al mandar esta petición, se obtiene el siguiente resultado:
```ruby
HTTP/1.1 204 
Date: Fri, 29 Mar 2024 12:56:10 GMT
Connection: close
```
Si se desea ver el resultado obtenido al ir a la URL: http://localhost:8080/api/peliculas tras ejecutar la petición DELETE, se puede ver que se ha borrado la película de la lista:

![image](https://github.com/202109401/Practica4/assets/147172532/734a4d4d-59bc-4999-a1ed-f36d7244d215)
