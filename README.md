# TreeApiRest

Proyecto Gradle

Aplicación desarrollada con el framework Spring Boot implementando el patrón de diseño de repositorio, dándole al proyecto la siguiente estructura:

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

Para implementar un servicio que permitiera la creación de un árbol se implementaron los modelos Tree y Node, los cuáles contienen la siguiente estructura:

```bash
├── Tree
    ├── id (Integer)
    ├── nodes (List<Node>)
├── Node
    ├── id (Integer)
    ├── key (Integer)
    ├── content (Integer)
    ├── parent (Integer)
    ├── left (Integer)
    ├── rigth (Integer)
    ├── tree (Tree)
    ├── isRoot (Boolean)
```
  
Se construyeron dos controladores para crear los servicios REST correspondientes a los modelos Tree y Node, y sus services dónde se implementó toda la lógica de construcción del árbol a nivel de base de datos a través de los repositorios.

## Bases
Este proyecto fue generado con Spring Boot y Gradle, como motor de persistencia de datos se usó H2.
  
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

##### Servicio para creación de árbol

Desde Postman podemos enviar al endpoint http://localhost:8080/tree/ el siguiente request en formato JSON:

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

Prueba desde postman

![image](https://user-images.githubusercontent.com/23733231/148381381-03f1ff45-18e7-442e-8bec-9a74d6bdb516.png)

El resultado de la prueba es el siguiente:

![image](https://user-images.githubusercontent.com/23733231/148381729-1637f1b5-382b-4342-861f-17b703eef15b.png)

#### Revisión en la consola de H2

Inicio de sesión en H2

  user: sa
  pass: 

![image](https://user-images.githubusercontent.com/23733231/148383881-7b110c60-c888-4bdc-bf00-54ae3c3f9fc7.png)

Verificación de datos en H2

![image](https://user-images.githubusercontent.com/23733231/148384257-c32e2d39-fb54-4b1c-bb0b-0991785d3b7e.png)

![image](https://user-images.githubusercontent.com/23733231/148384189-61d73124-54cd-4722-a7bd-49cab4840007.png)

### Problemas y conclusiones

Se puede apreciar que el objeto correspondiente al Arbol y sus Nodos son mapeados correctamente y así se verifican en la BD.

Se presenta problemas con Spring Boot al momento de hacer relaciones recursivas, los atributos de la clase Node, left y rigth son columnas que se relaciones con la misma tabla (Node) con un tipo de relación 1 a 1, por lo tanto, en Spring se hace uso de la anotación OneToOne, la cuál no permite eliminar la recursividad en los objetos al ser serializados, por lo tanto, la respuesta del servicio para creación de un árbol es null y el árbol se pinta por consola para verificar su creación.

El tipo de relación 1 a 1 con la misma tabla no permite crear las columnas a nivel de base de datos.
