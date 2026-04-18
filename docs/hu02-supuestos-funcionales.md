# HU02 — Supuestos funcionales del detalle de álbum

Los criterios de aceptación funcionales entregados para HU02 están incompletos. Este documento recoge **solo** inferencias mínimas a partir del mock y del código Compose existente, sin inventar producto nuevo.

## Qué se infirió del mock (`AlbumDetailMock.kt`)

- Existe un modelo `AlbumDetailUiModel` con: título de pantalla (`screenTitle`), título del álbum, artista, año (`year` como texto), formato (p. ej. tipo de soporte), lista de pistas (`AlbumDetailTrack`: número, título, subtítulo, duración), etiquetas agregadas de total de pistas y duración total, códigos/matrix y condición física, e índice de variante visual de portada (`coverVariantIndex`).
- Las pistas se muestran como una lista ordenada con información auxiliar (p. ej. “Side A”, “Instrumental”) en el campo subtítulo.

## Qué se infirió del código existente (`AlbumDetailScreen.kt`, `AlbumDetailContentOrganism.kt`)

- La pantalla usa el mismo shell visual que el catálogo (`AlbumDetailTemplate` → `CatalogScreenTemplate`): fondo, `Scaffold` con barra inferior (`CatalogBottomNavBarOrganism`) alineada a la pestaña de álbumes (`ALBUMS_TAB_INDEX = 0`).
- Contenido en **scroll vertical** (`LazyColumn`): barra superior con título y acciones (atrás, menú “more”), sección hero de portada con botón play, bloque de metadatos principales, tarjeta de tracklist, dos tarjetas de estadística/info (“Matrix”, “Condition”).
- Los callbacks `onMenuClick` y `onPlayClick` están cableados como **no-op** (`{}`) en `AlbumDetailScreen`: no hay comportamiento de negocio definido en código.
- Los datos mostrados provienen de **`albumDetailUiMock`**: no hay lectura de API ni de argumentos de navegación en la versión base documentada antes de los commits de la rama HU02.

## Qué NO se puede asegurar por falta de criterios

- Si todos los campos del mock son obligatorios cuando existan datos reales (p. ej. si `matrixCode` o `condition` pueden omitirse).
- Comportamiento esperado del botón **Play** (reproducción, preview, deshabilitado).
- Comportamiento del menú **More** (compartir, favoritos, etc.).
- Formato exacto de fechas (solo hay `year` como `String` en el mock).
- Paginación o carga parcial de tracks si el álbum es muy grande.
- Comportamiento offline o caché.

## Alcance mínimo recomendado para HU02 (conservador)

1. **Mostrar** en pantalla el conjunto de información que la API de detalle exponga y que sea razonablemente mapeable al layout actual (título, artista, año/fecha acordada con backend, formato, lista de canciones con duraciones, y cualquier campo extra acordado explícitamente).
2. **Navegación**: entrar al detalle con un **identificador de álbum** estable; botón atrás vuelve al flujo previo.
3. **Estados**: indicación de carga mientras se obtiene el detalle; mensaje de error con **reintentar** si falla la llamada a la API (alineado con la intención de las subtareas de verificación, sin duplicar lógica innecesaria en HU01).
4. **No** implementar reproductor completo, edición de álbum, ni acciones de menú sin requerimiento explícito futuro.

## Relación con HU01

- HU01 debe poder **navegar** a esta pantalla pasando el identificador coherente con el backend. El contenido mostrado en HU02 depende de ese id y de la API de detalle, no del mock a largo plazo.

---

*Revisar este documento cuando el negocio entregue criterios de aceptación formales de HU02; sustituir supuestos por requisitos confirmados.*
