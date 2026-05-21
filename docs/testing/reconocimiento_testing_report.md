# Reporte de pruebas de reconocimiento - Vinilos

## Objetivo

- Validar la estabilidad de la aplicación Vinilos mediante pruebas de reconocimiento aleatorias y sistemáticas, con el fin de identificar posibles crashes, ANRs, excepciones críticas, errores de navegación o fallos durante la exploración automática de la aplicación.

## Importancia de las pruebas

- Estas pruebas complementan la estrategia de calidad del proyecto y permiten evidenciar el comportamiento de la aplicación frente a eventos generados automáticamente.

## APK probado

- APK utilizado: `AppVinilos.apk`
- Paquete Android: `com.example.musicapp`
- Dispositivo: dispositivo físico Android conectado mediante ADB

---

## 1. Prueba de reconocimiento aleatoria con Monkey

### Descripción

Se ejecutó una prueba de reconocimiento aleatoria utilizando Android Monkey. Esta herramienta genera eventos pseudoaleatorios sobre la aplicación, como toques, movimientos, navegación y cambios de interacción, con el objetivo de detectar comportamientos inesperados, bloqueos o errores críticos.

### Instalación del APK

Primero se instaló el APK de la aplicación:

```bash
adb install ~/Descargas/AppVinilos.apk
```

En caso de existir una versión anterior instalada, se puede usar:

```bash
adb install -r ~/Descargas/AppVinilos.apk
```

### Ejecución de la prueba

Para ejecutar la prueba, se ejecutó el siguiente comando:

```bash
adb shell monkey -p com.example.musicapp -v --throttle 500 10000 > ~/Descargas/monkey_report.txt 2>&1
```

### Parámetros utilizados

| Parámetro | Descripción |
| --- | --- |
| `-p com.example.musicapp` | Limita la ejecución al paquete de la aplicación Vinilos |
| `-v` | Activa el modo verbose para registrar mayor detalle de los eventos |
| `--throttle 500` | Agrega una espera de 500 ms entre eventos |
| `10000` | Cantidad total de eventos generados |
| `> monkey_report.txt 2>&1` | Redirige la salida estándar y errores al archivo de reporte |

### Validación de errores

Para revisar si durante la ejecución se presentaron crashes, ANRs o excepciones, se utilizó el siguiente comando:

```bash
cat ~/Descargas/monkey_report.txt | grep -E "CRASH|ANR|Exception"
```

También se revisó el final del reporte con:

```bash
tail -20 ~/Descargas/monkey_report.txt
```

El reporte evidenció que la ejecución terminó correctamente:

```
Events injected: 10000
:Dropped: keys=0 pointers=0 trackballs=0 flips=31 rotations=0
// Monkey finished
```

### Análisis de resultados

La prueba Monkey finalizó exitosamente, ya que se inyectaron los 10000 eventos configurados y se obtuvo el mensaje // Monkey finished.

Durante la ejecución aparecieron mensajes de tipo Rejecting start of Intent. Estos mensajes corresponden a intentos del Monkey por iniciar actividades externas del dispositivo, como aplicaciones de Motorola, WhatsApp u otras aplicaciones instaladas. Sin embargo, estos intentos fueron rechazados porque la prueba fue limitada al paquete objetivo com.example.musicapp.

Por tanto, dichos mensajes no representan errores de la aplicación Vinilos, sino el comportamiento esperado al restringir la prueba al paquete de la aplicación.

### Evidencia generada

La evidencia de esta prueba se encuentra en:

```
docs/testing/monkey/monkey_report.txt
```

## 2. Prueba de reconocimiento sistemática tipo Ripper/Reaper con DroidBot

### Descripción

Se ejecutó una prueba de reconocimiento sistemático utilizando DroidBot sobre el APK de Vinilos. A diferencia de Monkey, que genera eventos pseudoaleatorios, DroidBot explora la interfaz de usuario identificando estados de pantalla y ejecutando acciones sobre los elementos disponibles.

Esta prueba permite realizar una exploración más estructurada de la aplicación, por lo que fue utilizada como prueba tipo Ripper/Reaper dentro de la estrategia de reconocimiento.

```python
python -m droidbot.start \
  -d ZY22LHWZSM \
  -a ~/Descargas/AppVinilos.apk \
  -o ~/Descargas/droidbot_vinilos \
  -policy dfs_greedy \
  -timeout 600 \
  -interval 1 \
  -keep_app \
  -grant_perm \
  -accessibility_auto
```

### Parámetros utilizados

| Parámetro | Descripción |
| --- | --- |
| `-d ZY22LHWZSM` | Identificador del dispositivo físico usado en la prueba |
| `-a ~/Descargas/AppVinilos.apk` | Ruta del APK probado |
| `-o ~/Descargas/droidbot_vinilos` | Carpeta de salida generada por DroidBot |
| `-policy dfs_greedy` | Política de exploración sistemática basada en profundidad codiciosa |
| `-timeout 600` | Duración máxima de la prueba: 600 segundos, equivalente a 10 minutos |
| `-interval 1` | Intervalo de 1 segundo entre eventos |
| `-keep_app` | Mantiene la aplicación instalada después de la prueba |
| `-grant_perm` | Otorga permisos requeridos por la aplicación durante la instalación |
| `-accessibility_auto` | Intenta habilitar automáticamente el servicio de accesibilidad requerido por DroidBot |

### Resultados de la ejecución

DroidBot realizó una exploración sistemática de la aplicación usando la política dfs_greedy. Durante la ejecución, la herramienta generó archivos de evidencia correspondientes a estados, eventos y vistas exploradas.

Uno de los resultados más relevantes fue la generación automática de capturas de vistas de navegación, almacenadas en la carpeta views. Estas imágenes permiten evidenciar visualmente que la herramienta recorrió diferentes pantallas de la aplicación y no se limitó únicamente a abrir o cerrar la app.

En total, DroidBot generó 191 archivos de evidencia durante la ejecución.

### Evidencia

La evidencia generada por DroidBot se encuentra en:

```
docs/testing/droidbot/droidbot_vinilos/
```

Dentro de esta carpeta se encuentran archivos relacionados con la exploración automática, incluyendo capturas de las vistas navegadas por la herramienta.

### Revisión de hallazgos críticos
Durante la ejecución de DroidBot también se capturó el logcat del dispositivo para revisar posibles errores críticos.

Se filtraron patrones asociados a errores relevantes mediante comandos como:

```bash
grep -i "FATAL EXCEPTION\|ANR\|AndroidRuntime\|OutOfMemoryError\|crash" ~/Descargas/logcat_droidbot.txt > ~/Descargas/droidbot_findings.txt
```

Adicionalmente, se generó un archivo más específico para errores críticos asociados a la aplicación:

```bash
grep -i "FATAL EXCEPTION\|ANR in com.example.musicapp\|OutOfMemoryError" ~/Descargas/logcat_droidbot.txt > ~/Descargas/droidbot_critical_findings.txt
```

Los archivos .txt obtenidos durante esta revisión fueron almacenados en: 

```
docs/testing/droidbot/critical-findings/
```

### Análisis de hallazgos

El filtro general encontró algunas coincidencias relacionadas con palabras como crash o AndroidRuntime. Sin embargo, al revisar los resultados, estas coincidencias correspondían a procesos externos del dispositivo, tales como servicios de Google, Motorola, WhatsApp, YouTube u otros componentes del sistema.

No se encontraron errores críticos asociados al paquete de la aplicación Vinilos:

```
com.example.musicapp
```

Por tanto, durante la ejecución de la prueba sistemática con DroidBot no se identificaron crashes, ANRs, excepciones fatales ni errores de memoria asociados a la aplicación.

## Comparación entre Monkey y DroidBot

| Prueba | Tipo de Reconocimiento | Herramienta | Objetivo |
| --- | --- | --- | --- |
| Monkey | Aleatorio | Android Monkey | Generar eventos pseudoaleatorios para detectar crashes, ANRs o excepciones |
| Ripper/Reaper | Sistemático | DroidBot | Explorar estados de la interfaz y navegar automáticamente por la aplicación |

Monkey permitió validar el comportamiento de la aplicación frente a eventos aleatorios, mientras que DroidBot permitió realizar una exploración sistemática de la interfaz, generando evidencia visual de las pantallas recorridas.

## Conclusión
- Se ejecutaron pruebas de reconocimiento aleatorias y sistemáticas sobre el APK de release de la aplicación Vinilos.
- La prueba Monkey ejecutó correctamente 10000 eventos sobre el paquete com.example.musicapp y finalizó con el mensaje // Monkey finished.
- La prueba sistemática con DroidBot exploró la interfaz durante 10 minutos utilizando la política dfs_greedy, generando 191 archivos de evidencia, incluyendo capturas de vistas navegadas.
- Luego de revisar los reportes y los hallazgos críticos, no se identificaron crashes, ANRs, excepciones fatales ni errores de memoria asociados a la aplicación Vinilos.
