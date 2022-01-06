# TreeApiRest

Proyecto Gradle

Aplicación desarrollada en el framwwork Spring Boot implementando el patrón de diseño de repositorio, dándole al proyecto la siguiente estructura:

ApiRest/

..Models/

....Tree.java

....Node.java

..Controllers/

....TreeController

....NodeController

..Services/

....TreeService

....NodeService

....TreeServiceImp

....NodeServiceImp

..Repository/

....TreeRepository

....NodeRepository

Para implementar un servicio que permitiera la creación de un árbol se implmentaron los modelos Tree y Node, los cuáles contienen la siguiente estructura:

Tree/

..Integer Id

..List<Nodes>
  
Node/

..Integer Id

..Integer key

..String content

....Node parent

....Node left

....Node rigth

.... Tree tree

.... Boolean isRoot

  
Se construyeron dos controladores para crear los servicios REST correspondientes a los modelos Tree y Node, y sus services dónde se implementó toda la lógica de construcción del árbol a nivel de base de datos a través de los repositorios.

## Bases
Este proyecto fue generado con Spring Boot y Gradle
  
## Instalación para prueba local
  
Dirigirse a la carpeta del proyecto y ejecutar el siguiente comando:

### Windows
```gradlew clean build```
  
### Linux and Mac
> cd apirest
>  
> ```foo@bar:~$ gradlew clean build```
  
