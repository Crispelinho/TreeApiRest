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

#### Pruebas

Desde Postman podemos al endpoint http://localhost:8080/tree/ el siguiente request en formato JSON:

```json
{   
    "nodes": [
        {
            "key": 9,
            "content": "Prueba9"
        },
        {
            "key": 1,
            "content": "Prueba1"
        },
        {
            "key": 5,
            "content": "Prueba5"
        },
                {
            "key": 6,
            "content": "Prueba6"
        }
        ,
                {
            "key": 11,
            "content": "Prueba11"
        }
        ,
                {
            "key": 2,
            "content": "Prueba2"
        }
        ,
                {
            "key": 8,
            "content": "Prueba8"
        }
    ]
}
```

Representación del árbol

![image](https://user-images.githubusercontent.com/23733231/148383048-367649ba-2a26-4710-8603-ab8461001710.png)


![image](https://user-images.githubusercontent.com/23733231/148381381-03f1ff45-18e7-442e-8bec-9a74d6bdb516.png)

El resultado de la prueba es el siguiente:

![image](https://user-images.githubusercontent.com/23733231/148381729-1637f1b5-382b-4342-861f-17b703eef15b.png)





