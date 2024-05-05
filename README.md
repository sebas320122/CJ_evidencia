# Sistema de consultorio v1.0

Sistema creado para adminsitrar doctores, pacientes y citas del consultorio.

## Instalación y configuracion

- Instalar Java JDK: https://www.oracle.com/java/technologies/downloads/
- En el repositorio, seleccionar "v1.0" en el apartado Releases
- Descargar Ejecutable.rar
- Extraer ejecutable en ruta de preferencia
- Tras la extracción, seleccionar carpeta "SistemaConsultorio"
- Seleccionar campo de ruta, borrar contenido, y escribir "powershell"
- En powershell escribir el comando: java -jar .\SistemaConsultorio.jar
- Se indicara al usuario que se ha completado la instalacion y pedira nombre y contraseña para poder generar el primer administrador y de ese modo acceder al sistema

## Uso del programa

Al ingresar al sistema por medio de un administrador, se tendra la posibilidad de realizar las siguientes operaciones, pudiendo elegir ingresando el numero correspondiente a la operacion en consola:
- 1 Dar de alta a doctor
  - Ingresar nombre
  - Ingresarsar especialidad
  - Nota: No pertmitira dar de alta a un doctor con nombre y especialidad igual a la de otro registro
- 2 Dar de alta a paciente
  - Ingresar nombre
  - Nota: No permitira dar de alta a un paciente con nombre igual a la de otro registro
- 3 Crear cita
  - Ingresar ID de doctor
  - Ingresar ID de paciente
  - Ingresar fecha
  - Ingresar hora
  - Ingresar motivo
  - Nota: Solo permitira crear cita si el ID del doctor y paciente se encuentran en los registros
- 4 Ver lista de doctores
  - (Solo requiere seleccionar la opcion)
- 5 Ver lista de pacientes
  - (Solo requiere seleccionar la opcion)
- 6 Ver lista de citas
  - (Solo requiere seleccionar la opcion) 
- 7 Dar de alta administrador
  - Ingresar nombre
  - Ingresar contraseña
  - Nota: No permitira der de alta a un administrador con un nombre previamente registrado
- 8 Ver lista de administradores
  - (Solo requiere seleccionar la opcion) 
- 9 Salir
  - (Solo require seleccionar la opcion)  

## Créditos

El presente sistema ha sido creado por el equipo de desarrollo integrado por los siguientes miembros:
- Sebastián García Lizárraga
- Carlos Eladio Lopez Cisneros
- Jesús Alberto Avendano Heiras

## Licencia

- [GNU General Public License v3.0 (GPL-3.0)](https://choosealicense.com/licenses/gpl-3.0/)
