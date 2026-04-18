# Plan de ramas y commits (HU01 / HU02)

## Historial Git aplicado en este repositorio (referencia)

En `main`, después de la reorganización, el orden quedó aproximadamente: documentación compartida → baseline del proyecto → merge de `feature/HU01-catalogo-albumes` (fecha de lanzamiento en catálogo) → commit en `feature/HU02-detalle-album` y fast-forward a `main` (navegación con `albumId`). Ver `git log --oneline` para hashes exactos en tu clon.

## Nombres de ramas y objetivo

| Rama | Objetivo |
|------|----------|
| `main` | Línea integrada estable: documentación de trazabilidad + baseline de la app; incorpora merges de HU01 y HU02 en el orden acordado. |
| `feature/HU01-catalogo-albumes` | Catálogo de álbumes: modelo de lista, UI de listado, integración API del catálogo, estados vacío/carga/error/reintento, carátula por defecto sin URL, fecha de lanzamiento, navegación emitiendo `albumId`. |
| `feature/HU02-detalle-album` | Detalle de álbum: ruta con argumento, consumo API de detalle, estados carga/error/reintento, sustitución progresiva del mock, pruebas. |
| `chore/preparacion-separacion-hus` | *(Opcional)* Solo si hace falta extraer navegación o rutas a archivos dedicados **sin** cambiar comportamiento, para facilitar `git add -p` en equipos grandes. |

## Dependencias entre HU01 y HU02

- HU02 depende de un **contrato de navegación** desde el catálogo: el listado debe poder navegar con un **identificador de álbum** establecido en HU01 (o en un commit `chore(shared)` explícito acordado).
- Recomendación de merge: **HU01 → `main` → HU02** (rama HU02 partida de `main` con HU01 ya fusionada, salvo acuerdo explícito de paralelizar con mock de id fijo temporal).

## Commits sugeridos en `feature/HU01-catalogo-albumes`

Lista ordenada; los que ya tienen implementación parcial en el repositorio se marcan con el estado actual.

1. **`feat(hu01): estructurar pantalla de catálogo de álbumes`**  
   - Archivos: `AlbumCatalogScreen.kt`, `CatalogScreenTemplate.kt` (uso desde scaffold), `CatalogContentOrganism.kt`, moléculas de cabecera del catálogo (`CatalogBrandRowMolecule`, `CatalogCollectionHeaderMolecule`, `CatalogHeroSectionOrganism`, `FeaturedSpunCardMolecule`).  
   - *Estado:* implementado en baseline.

2. **`feat(hu01): modelo y listado mock de álbumes en catálogo`**  
   - Archivos: `catalog/CatalogAlbum.kt`, cableado en `CatalogContentOrganism` / `AlbumCatalogScreen`.  
   - *Estado:* implementado en baseline.

3. **`feat(hu01): tile de álbum con carátula placeholder y metadatos`**  
   - Archivos: `AlbumTileMolecule.kt`, `AlbumMetaFooterMolecule.kt`, `AppAlbumCoverPlaceholder.kt`, `PlaceholderGradients.kt` (si se atribuye placeholder compartido aquí, duplicar mención en shared).  
   - *Estado:* implementado en baseline (placeholder por gradiente, no por URL).

4. **`feat(hu01): agregar fecha de lanzamiento al listado`**  
   - Archivos: `CatalogAlbum.kt`, mocks, `AlbumMetaFooterMolecule.kt` / `AlbumTileMolecule.kt`.  
   - *Estado:* puede aplicarse en rama HU01 como primer commit incremental tras baseline (ver historial Git).

5. **`chore(shared): permiso INTERNET y dependencias de red`** *(si aplica)*  
   - Archivos: `AndroidManifest.xml`, `app/build.gradle.kts`, `gradle/libs.versions.toml` si se introduce version catalog.

6. **`feat(hu01): consumir API del catálogo y mapear a modelo de lista`**  
   - Archivos: nuevo paquete `data/` o `network/`, DTOs, mapeo a modelo de UI.  
   - *Estado:* pendiente (no hay cliente HTTP en el proyecto base).

7. **`feat(hu01): estado de carga del catálogo`** — ViewModel o estado en pantalla + UI.  
   - *Estado:* pendiente.

8. **`feat(hu01): estado vacío del catálogo`** — Mensaje “no se encuentran álbumes”.  
   - *Estado:* pendiente.

9. **`feat(hu01): error de consulta del catálogo con reintento`**  
   - *Estado:* pendiente.

10. **`feat(hu01): carátula por defecto cuando no hay URL en API`**  
    - *Estado:* pendiente (hoy solo gradiente por índice).

11. **`feat(hu01): navegación al detalle con identificador de álbum`**  
    - Archivos: `AlbumCatalogScreen.kt` (callback con id), `MusicAppRoot.kt` (solo la parte `navigate("album_detail/{id}")` si se acuerda reparto con HU02).  
    - *Riesgo:* mismo archivo que HU02; coordinar o un único commit `chore(shared)` de contrato de rutas.

12. **`test(hu01): pruebas de catálogo`**  
    - Archivos: `app/src/test/...` o `androidTest/...`.  
    - *Estado:* pendiente (configurar dependencias de test).

## Commits sugeridos en `feature/HU02-detalle-album`

1. **`docs(hu02): documentar supuestos funcionales del detalle del álbum`**  
   - Archivos: `docs/hu02-supuestos-funcionales.md`.  
   - *Estado:* entregado en baseline de documentación.

2. **`feat(hu02): estructura base de pantalla de detalle del álbum`**  
   - Archivos: `AlbumDetailTemplate.kt`, `AlbumDetailScreen.kt`, `AlbumDetailContentOrganism.kt`, `AlbumDetailMock.kt`, organismos/moléculas de detalle.  
   - *Estado:* implementado en baseline.

3. **`feat(hu02): leer albumId desde NavBackStackEntry y ruta album_detail/{albumId}`** *(nombre ejemplo)*  
   - Archivos: `MusicAppRoot.kt`, `AlbumDetailScreen.kt`.  
   - *Estado:* aplicable como commit incremental en rama HU02 tras HU01 en main.

4. **`feat(hu02): cargar información detallada del álbum desde API`** — pendiente.

5. **`feat(hu02): estado de carga del detalle`** — pendiente.

6. **`feat(hu02): error de consulta del detalle con reintento`** — pendiente.

7. **`test(hu02): pruebas del detalle del álbum`** — pendiente.

## Baseline en `main` (arranque del repositorio app)

1. **`docs(shared): trazabilidad HU01 HU02 y plan de ramas`** — Solo `docs/*.md`.
2. **`chore(shared): baseline proyecto Android Compose MusicApp`** — Gradle, `app/`, `.gitignore` (excluir `.vscode/` del control de versiones salvo decisión contraria del equipo).

## Riesgos o dependencias (resumen)

| Riesgo | Mitigación |
|--------|------------|
| `MusicAppRoot.kt` mezcla rutas | Commits pequeños; `git add -p`; opcional rama `chore/preparacion-separacion-hus`. |
| Criterios HU01 vs subtareas de “API detalle” | Responsabilidad de error/carga de **detalle** en HU02; documentado en `trazabilidad-hus.md`. |
| Sin tests | Primer commit de test añade dependencias; etiquetar claramente. |

---

*Actualizar este documento cuando se cierren contratos de API y nombres de rutas reales.*
