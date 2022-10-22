insert into usuarios (id_usuario, usuario, contrasenia, enabled) values (1, 'rarellano', '$2a$10$iPwRfYkeETRb8vYqtZd/1uxndPdoFlrvVjicZe3sFXlr7e4FBB5vC', true);
insert into usuarios (id_usuario, usuario, contrasenia, enabled) values (2, 'rhenriquez', '$2a$10$iPwRfYkeETRb8vYqtZd/1uxndPdoFlrvVjicZe3sFXlr7e4FBB5vC', true);

insert into datos_personales (id_usuario, nombres, apellidos) values (1, 'Robin', 'Arellano');
insert into datos_personales (id_usuario, nombres, apellidos) values (2, 'Robin', 'Henriquez');

insert into roles (id_rol, nombre, descripcion) values (1, 'Admin', 'Administrador');
insert into roles (id_rol, nombre, descripcion) values (2, 'Dev', 'Desarrollador');

insert into roles_usuarios (id_rol_usuario, id_usuario, id_rol, descripcion) values (1, 1, 1, 'user: rarellano - rol: Admin');
insert into roles_usuarios (id_rol_usuario, id_usuario, id_rol, descripcion) values (2, 2, 2, 'user: rhenriquez - rol: dev');

insert into modulos (id_modulo, nombre, label, icono) values (1, 'Servicio Modulos', 'Modulos', 'folder');
insert into modulos (id_modulo, nombre, label, icono) values (2, 'Servicio Roles', 'Roles', 'folder');
insert into modulos (id_modulo, nombre, label, icono) values (3, 'Servicio Usuarios', 'Usuarios','folder');
insert into modulos (id_modulo, nombre, label, icono) values (4, 'Servicio Paginas', 'Paginas','folder');

insert into paginas_modulo (id_modulo, label, url, icono) values (1, 'Listar Modulos', '/modulos', 'list');
insert into paginas_modulo (id_modulo, label, url, icono) values (1, 'Crear Modulos', '/modulos/crear', 'save');
insert into paginas_modulo (id_modulo, label, url, icono) values (2, 'Listar Roles', '/roles', 'list');
insert into paginas_modulo (id_modulo, label, url, icono) values (2, 'Crear Roles', '/roles/crear', 'save');
insert into paginas_modulo (id_modulo, label, url, icono) values (3, 'Listar Usuarios', '/usuarios', 'list');
insert into paginas_modulo (id_modulo, label, url, icono) values (3, 'Crear Usuarios', '/usuarios/crear', 'save');
insert into paginas_modulo (id_modulo, label, url, icono) values (4, 'Listar Paginas', '/paginas', 'list');
/*insert into paginas_modulo (id_modulo, label, url, icono) values (4, 'Crear Paginas', '/paginas/crear', 'save');*/

/*Rol Admin*/
insert into paginas_rol (id_pagina_modulo, id_rol) values (1, 1);
insert into paginas_rol (id_pagina_modulo, id_rol) values (2, 1);
insert into paginas_rol (id_pagina_modulo, id_rol) values (3, 1);
insert into paginas_rol (id_pagina_modulo, id_rol) values (4, 1);
insert into paginas_rol (id_pagina_modulo, id_rol) values (5, 1);
insert into paginas_rol (id_pagina_modulo, id_rol) values (6, 1);
insert into paginas_rol (id_pagina_modulo, id_rol) values (7, 1);

/*Rol Dev*/
insert into paginas_rol (id_pagina_modulo, id_rol) values (1, 2);
insert into paginas_rol (id_pagina_modulo, id_rol) values (2, 2);

/*
The passwords is: abc123abc
*/

/* Eliminar tablas
DROP TABLE roles_usuarios;
DROP TABLE paginas_rol;
DROP TABLE paginas_modulo;
DROP TABLE modulos;
DROP TABLE datos_personales;
DROP TABLE roles;
DROP TABLE usuarios;
*/

