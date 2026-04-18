# Trazabilidad: HU01 y HU02 (MusicApp)

## Resumen por HU

| HU | Nombre | Estado en código (auditoría) |
|----|--------|------------------------------|
| **HU01** | Consultar catálogo de álbumes | Listado **mock** en `LazyVerticalGrid`, título y artista en tile, carátula como **placeholder por gradiente** (no URL). Scroll vertical vía grid. **Pendiente** respecto a CA: API, fecha de lanzamiento en modelo/UI (ver commits en rama), estados vacío/error/reintento/carga, carátula por defecto ante URL ausente en API. |
| **HU02** | Consultar información detallada de un álbum | Pantalla de detalle con **mock** (`AlbumDetailUiModel`), `LazyColumn` con metadatos, tracklist y tarjetas informativas. Ruta de navegación `album_detail/{albumId}` y parámetro `albumId` en `AlbumDetailScreen` (gancho `LaunchedEffect` para futura API). **Pendiente**: API, estados carga/error/reintento, sustituir mock por datos reales. |
| **Infra** | Tema, navegación global, otras pestañas | Compose, `AppTheme`, `MusicAppRoot` (varias rutas), plantillas compartidas, componentes de diseño reutilizados. |

## Archivos que pertenecen principalmente a HU01

- `app/src/main/java/com/example/musicapp/ui/screens/AlbumCatalogScreen.kt` — Punto de entrada de la pestaña de catálogo.
- `app/src/main/java/com/example/musicapp/ui/screens/catalog/CatalogAlbum.kt` — Modelo de ítem de catálogo y lista mock.
- `app/src/main/java/com/example/musicapp/ui/components/organisms/CatalogContentOrganism.kt` — Grid y secciones de cabecera del catálogo.
- `app/src/main/java/com/example/musicapp/ui/components/molecules/AlbumTileMolecule.kt` — Tile clickeable del álbum.
- `app/src/main/java/com/example/musicapp/ui/components/molecules/AlbumMetaFooterMolecule.kt` — Título, artista y metadatos inferiores del tile.
- `app/src/main/java/com/example/musicapp/ui/components/molecules/CatalogBrandRowMolecule.kt`
- `app/src/main/java/com/example/musicapp/ui/components/molecules/CatalogCollectionHeaderMolecule.kt`
- `app/src/main/java/com/example/musicapp/ui/components/organisms/CatalogHeroSectionOrganism.kt`
- `app/src/main/java/com/example/musicapp/ui/components/molecules/FeaturedSpunCardMolecule.kt`

## Archivos que pertenecen principalmente a HU02

- `app/src/main/java/com/example/musicapp/ui/screens/AlbumDetailScreen.kt`
- `app/src/main/java/com/example/musicapp/ui/components/templates/AlbumDetailTemplate.kt`
- `app/src/main/java/com/example/musicapp/ui/components/organisms/AlbumDetailContentOrganism.kt`
- `app/src/main/java/com/example/musicapp/ui/screens/album/AlbumDetailMock.kt` — `AlbumDetailUiModel`, `AlbumDetailTrack`, datos mock.
- `app/src/main/java/com/example/musicapp/ui/components/organisms/AlbumHeroSectionOrganism.kt`
- `app/src/main/java/com/example/musicapp/ui/components/molecules/AlbumMetaHeaderMolecule.kt`
- `app/src/main/java/com/example/musicapp/ui/components/organisms/TracklistCardOrganism.kt`
- `app/src/main/java/com/example/musicapp/ui/components/molecules/TrackListItemMolecule.kt`
- `app/src/main/java/com/example/musicapp/ui/components/molecules/DetailTopBarMolecule.kt`

## Archivos compartidos

- `app/src/main/java/com/example/musicapp/MainActivity.kt` — Entrada `setContent` + `AppTheme`.
- `app/src/main/java/com/example/musicapp/ui/navigation/MusicAppRoot.kt` — **Mixto**: catálogo (tab 0), detalle de álbum, artistas, coleccionistas, FAB.
- `app/src/main/java/com/example/musicapp/ui/components/templates/CatalogScreenTemplate.kt` — Scaffold común; usado por catálogo y por `AlbumDetailTemplate`.
- `app/src/main/java/com/example/musicapp/ui/components/atoms/AppAlbumCoverPlaceholder.kt` + `app/src/main/java/com/example/musicapp/ui/util/PlaceholderGradients.kt` — Placeholder visual en catálogo y detalle.
- `app/src/main/java/com/example/musicapp/ui/components/organisms/CatalogBottomNavBarOrganism.kt` — Barra inferior en flujo catálogo y detalle.
- `app/src/main/java/com/example/musicapp/ui/theme/**` — Tokens y `AppTheme.kt`.
- Resto de pantallas y organismos (artistas, coleccionistas, nuevo lanzamiento, showcase) — **Fuera del alcance** de HU01/HU02 pero presentes en el mismo módulo.

## Supuestos funcionales detectados (HU02 detallado en doc aparte)

- El detalle actual es **presentacional**: datos fijos en `albumDetailUiMock`; no hay contrato de API en código.
- La navegación al detalle debe evolucionar a ruta con **identificador de álbum** (ver `docs/plan-ramas-y-commits.md` y rama HU02).
- Las subtareas de HU01 que hablan de error en API del **detalle** del álbum corresponden en responsabilidad a **HU02**.

## Riesgos de separación

1. **`MusicAppRoot.kt`**: concentra rutas y callbacks; cualquier cambio de firma catálogo ↔ detalle afecta ambas HU. Mitigación: commits con `git add -p` o extracción futura opcional a un grafo dedicado (`chore/preparacion-separacion-hus` solo si el equipo lo necesita).
2. **`CatalogScreenTemplate` / `AlbumDetailTemplate`**: acoplamiento de shell; no conviene duplicar sin motivo.
3. **Ausencia de capa de red**: los commits futuros de API y tests introducirán dependencias compartidas (`INTERNET`, Retrofit u otro cliente); deben ir etiquetados `chore(shared)` o el primer commit de red explícito.
4. **Pruebas automatizadas**: no hay `test/` ni `androidTest/` para estas HU; el primer `test(hu*)` implica configurar dependencias de test en Gradle.

## Recomendación de orden de commits (resumen)

1. Baseline compartido (`chore(shared): …`) en `main`.
2. Trabajo **HU01** en `feature/HU01-catalogo-albumes`: catálogo, API lista, estados, placeholder URL, fecha de lanzamiento; merge a `main`.
3. Trabajo **HU02** en `feature/HU02-detalle-album` desde `main` actualizado: ruta con `albumId`, API detalle, estados, tests.

Detalle commit por commit: ver [plan-ramas-y-commits.md](plan-ramas-y-commits.md).

## Archivos que tocan ambas HU y cómo partir el trabajo

| Situación | Recomendación |
|-----------|----------------|
| `MusicAppRoot.kt`: callback `onOpenAlbumDetail` y `composable` de detalle | Un commit HU01 puede limitarse a pasar **id** desde el catálogo y llamar `navigate("album_detail/{id}")`. El `composable` con `navArguments` y lectura del id en **HU02** en commit separado; si el mismo archivo cambia dos veces, usar **hunks** o dos commits consecutivos en la misma rama antes de merge. |
| `AppAlbumCoverPlaceholder` / gradientes | Mantener en **compartido**; HU01 solo añade la política “si URL null/vacía → usar placeholder” en el tile. |
| `CatalogBottomNavBarOrganism` | **Compartido**; cambios de íconos o tabs no mezclar con lógica de API de una sola HU sin necesidad. |

## Tabla de trazabilidad (archivos clave)

| Archivo | HU | Motivo | Tipo de cambio |
|---------|-----|--------|----------------|
| `app/.../AlbumCatalogScreen.kt` | HU01 | Pantalla pestaña catálogo | UI |
| `app/.../catalog/CatalogAlbum.kt` | HU01 | Modelo ítem + mocks / futuro mapeo API | Modelo / datos |
| `app/.../CatalogContentOrganism.kt` | HU01 | Lista principal scrolleable | UI |
| `app/.../AlbumTileMolecule.kt` | HU01 | Representación de cada álbum | UI |
| `app/.../AlbumMetaFooterMolecule.kt` | HU01 | Título, artista, fecha en tile | UI |
| `app/.../AlbumDetailScreen.kt` | HU02 | Contenedor pantalla detalle | UI |
| `app/.../AlbumDetailContentOrganism.kt` | HU02 | Layout detalle | UI |
| `app/.../album/AlbumDetailMock.kt` | HU02 | Mock detalle / futuro reemplazo por API | Datos |
| `app/.../TracklistCardOrganism.kt` | HU02 | Tracklist | UI |
| `app/.../MusicAppRoot.kt` | Compartido / mixto | NavHost y rutas | Navegación |
| `app/.../CatalogScreenTemplate.kt` | Compartido | Scaffold | Infra UI |
| `app/.../AppAlbumCoverPlaceholder.kt` | Compartido | Carátula placeholder | UI base |
| `app/.../PlaceholderGradients.kt` | Compartido | Gradientes placeholder | Util |
| `app/.../MainActivity.kt` | Compartido | Entrada app | Infra |
| `app/build.gradle.kts` | Compartido | Dependencias | Build |
| `app/.../ArtistDetailScreen.kt` | Fuera HU01; acopla HU02 | Navegación a detalle álbum | Navegación |
| `docs/trazabilidad-hus.md` | Documentación | Trazabilidad | Docs |
| `docs/plan-ramas-y-commits.md` | Documentación | Plan Git | Docs |
| `docs/hu02-supuestos-funcionales.md` | HU02 | Supuestos funcionales | Docs |
| *(pendiente)* cliente HTTP, DTOs, ViewModels | HU01 / HU02 / shared | API y estado | Infra / lógica |
| *(pendiente)* `src/test` o `androidTest` | HU01 / HU02 | Pruebas | Test |

---

*Documento generado como entregable del plan de trazabilidad HU01/HU02. Actualizar la tabla cuando se añadan APIs, tests o nuevos archivos.*
