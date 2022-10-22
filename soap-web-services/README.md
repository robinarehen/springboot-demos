# Web Services Soap
En este proyecto se muestra paso a paso como conectar con un **Servicio Web Soap**

# Generar Clases
Lo primero que debemos hacer es generar las clases desde el **WSDL** puede ser un archivo **xml** o directamente desde una **url**

### Configuración desde una URL
1. `<generatePackage>` Etiqueta que indica el paquete donde se deben generar las clases.
2. `<generateDirectory>` Etiqueta que indica la carpeta en donde se encuentran los paquetes, si no se especifica esta etiqueta lo genera en una carpeta por defecto.

```xml
<plugin>
  <groupId>org.jvnet.jaxb2.maven2</groupId>
  <artifactId>maven-jaxb2-plugin</artifactId>
  <version>0.13.2</version>
  <executions>
    <execution>
      <goals>
        <goal>generate</goal>
      </goals>
    </execution>
  </executions>
  <configuration>
    <schemaLanguage>WSDL</schemaLanguage>
    <generatePackage>com.demo.client.webservice.wsdl</generatePackage>
    <generateDirectory>${project.basedir}/src/main/java</generateDirectory>
    <schemas>
      <schema>
        <url>http://www.dneonline.com/calculator.asmx?wsdl</url>
      </schema>
    </schemas>
  </configuration>
</plugin>
```

### Configuración desde un XML
1. `<schemaDirectory>` Etiqueta que indica la ubicación de la **WSDL**.
2. `<includes>*.wsdl</includes>` Etiqueta en la cual indicamos que tomé todos los archivos **.wsdl** por si tenemos más de uno.
```xml
<plugin>
  <groupId>org.jvnet.jaxb2.maven2</groupId>
  <artifactId>maven-jaxb2-plugin</artifactId>
  <version>0.13.2</version>
  <executions>
    <execution>
      <goals>
        <goal>generate</goal>
      </goals>
    </execution>
  </executions>
  <configuration>
    <schemaLanguage>WSDL</schemaLanguage>
    <generatePackage>com.demo.client.webservice.wsdl</generatePackage>
    <generateDirectory>${project.basedir}/src/main/java</generateDirectory>
    <schemaDirectory>${project.basedir}/src/main/resources/wsdl</schemaDirectory>
    <schemaIncludes>
      <includes>*.wsdl</includes>
    </schemaIncludes>
  </configuration>
</plugin>
```
