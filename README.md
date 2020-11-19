# Api de clientes
Api desarrollada para el reto tech de Intercorp Retail.

## Para cumplir con el reto se usaron las siguientes herramientas:
- Framework: Spring boot
- Lenguaje: Java8
- Cloud: AWS
- Base de datos: Mysql
- IDE: IntelliJ IDEA 
- Control de versiones: Git/github

## Enlaces:
- Proyecto en github: https://github.com/gustavo-aguirre/client-data-service.git
- Documentación del api: http://appclientdataservice-env.eba-rgdg6i7j.us-east-2.elasticbeanstalk.com/clientes/swagger-ui.html


## Operaciones disponibles:
- Endpoint de entrada POST /creacliente
  - Nombre
  - Apellido
  - Edad
  - Fecha de nacimiento
- Endpoint de salida GET /kpideclientes
  - Promedio edad entre todos los clientes
  - Desviación estándar entre las edades de todos los clientes
- Endpoint de salida GET /listclientes
  - Lista de personas con todos los datos + fecha probable de muerte de cada una

