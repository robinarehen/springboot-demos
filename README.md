# springboot-demos

## Sprin Security Userdetails v1
En esta rama, se crea la versión inicial la cual funciona, pero el modelo de base de datos tiene errores en las relaciones, creando ciclos infinitos, que internamente spring corrige en el entorno de desarrollo, desconociendo que pueda pasar en un entorno productivo más controlado.

## Sprin Security Userdetails v2
En esta rama, se arreglan los error en el modelo de la version 1.
Se cambia el manejo de los acceso, donde se elimina el uso de
```
@PreAuthorize("hasAuthority('/usuarios')")
```

Para implementar los cambios en las clases
```
SecurityCheckUrlAccessConfig
WebSecurityConfig
```