# Calculadora

En el proyecto actual se crea la funcionalidad de una Calculadora, la cual cuenta con dos operaciones `Sumar y Restar`.

## Configuración Inical

**NOTA** se debe tener instalado `Maven 3.6.3` o superior.

Se debe instalar la Librería de `Tracer-1.0.0` con el comando a continuación, el cual nos crea una nueva dependencia en nuestro Maven local.

```
mvn install:install-file -Dfile="~\calculadora\src\main\resources\lib\tracer-1.0.0.jar" -DgroupId=com.sanitas -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
```

El símbolo `~` se debe reemplazar por la ruta en donde se haya descargado el proyecto.

## Ejecutar el Proyecto

1. En la raíz del proyecto ejecutar el comando `mvn install`, con este comando se ejecutarán las pruebas y se crea el jar de la aplicación.

2. Al finalizar el punto 1, ejecutar el comando `mvn spring-boot:run` el cual inicializa el proyecto al cual se puede acceder mediante los siguientes links

    [Sumar - **GET**] http://localhost:8080/calculadora/sumar?numero1=2&numero2=3

    [Restar- **GET**]  http://localhost:8080/calculadora/restar/3/2
    
	[Operacion - **POST**] http://localhost:8080/calculadora/operacion
	```JSON
	{
		"operador":"suma",
		"num1": 2,
		"num2": 3
	}
	
	{
		"operador":"resta",
		"num1": 3,
		"num2": 2
	}
	```
	
3. Se implementa la documentación mediante **Swagger 2** y se puede visualizar en la ruta anexa.

	[Swagger] http://localhost:8080/swagger-ui.html
