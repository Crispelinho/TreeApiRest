# TreeApiRest

Proyecto Gradle

Aplicación desarrollada en el framwwork Spring Boot implementando el patrón de diseño de repositorio, dándole al proyecto la siguiente estructura:

```bash
├── ApiRest/
│   ├── Models/
│   │   ├── Tree.java
|   |   ├── Node.java
│   ├── Controllers/
│   │   ├── TreeController.java
|   |   ├── NodeController.java
│   ├── Services/
│   │   ├── TreeService.java
|   |   ├── NodeService.java
│   │   ├── TreeServiceImp.java
|   |   ├── NodeServiceImp.java
│   ├── Repositorys/
│   │   ├── TreeRepository.java
|   |   ├── NodeRepository.java
└── ApirestApplication.java
```

Para implementar un servicio que permitiera la creación de un árbol se implmentaron los modelos Tree y Node, los cuáles contienen la siguiente estructura:

```bash
├── Tree
│   ├── id (Integer)
│   ├── nodes (List<Node>)
├── Node
│   ├── id (Integer)
│   ├── key (Integer)
│   ├── content (Integer)
│   ├── parent (Integer)
│   ├── left (Integer)
│   ├── rigth (Integer)
│   ├── tree (Tree)
│   ├── isRoot (Boolean)
└── ApirestApplication.java
```
  
Se construyeron dos controladores para crear los servicios REST correspondientes a los modelos Tree y Node, y sus services dónde se implementó toda la lógica de construcción del árbol a nivel de base de datos a través de los repositorios.

## Bases
Este proyecto fue generado con Spring Boot y Gradle
  
## Instalación para prueba local
  
Dirigirse a la carpeta del proyecto y ejecutar el siguiente comando:

### Compilación del proyecto
#### Windows
> ```gradlew clean build```
  
#### Linux and Mac
> ```cd apirest```
>  
> ```foo@bar:~$ gradlew clean build```

#### Ejecución de la aplicación con Gradle
Desde Visual Studio Code dirigirse a la clase ApirestApplication y darle run al proyecto.

![image](https://user-images.githubusercontent.com/23733231/148381022-4305c745-d3ad-4d97-9639-11cbe4b55118.png)

```json
{ "some": "json" }
```




