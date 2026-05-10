# Ingeniería de software para aplicaciones móviles — Grupo 3

Este repositorio es el espacio de trabajo del **Grupo 3** para el proyecto del curso **Ingeniería de software para aplicaciones móviles**.

## Integrantes

| Nombre | Correo |
|--------|--------|
| Carlos Ortiz | cd.ortiz@uniandes.edu.co |
| Camilo Roa | ca.roac@uniandes.edu.co |
| Joseph Mauricio Gutierrez Valero | jm.gutierrez23@uniandes.edu.co |
| Steven Garzon | sr.garzon@uniandes.edu.co |

# Configuración del proyecto de manera local
Recomendaciones para montar el proyecto de manera local:
- Contar con la última versión estable de Android Studio
- Hacer pull o descargar el código fuente del release o de la rama release
- Contar con un dispositivo Android para ejecutar la app en ADB, o un computador con prestaciones suficientes para correr el emulador

Para montar el proyecto se debe:
1. Colocar la carpeta del código fuente en la carpeta que tenga designada para proyectos en Android Studio
2. Abrir Android Studio, seleccionar abrir proyecto y seleccionar la carpeta del código fuente
3. Sincronizar los archivos Gradle desde la interfaz o con Ctrl+Shift+O desde Windows
4. Al finalizar la sincronización se podrá ver la estructura del proyecto, ejecutarlo y ejecutar las pruebas

Las pruebas se realizaron con la API JUnit para testCompose, ya que compose no permite realizar pruebas con Espresso y Mario dijo que Kraken no estaba del todo probado con Jetpack Compose