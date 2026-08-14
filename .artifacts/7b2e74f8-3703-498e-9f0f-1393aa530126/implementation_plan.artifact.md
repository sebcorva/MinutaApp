# Plan de Reestructuración Profesional (MVVM + Organización de Carpetas)

Este plan detalla la reorganización del proyecto siguiendo las mejores prácticas de arquitectura Android (MVVM) y una estructura de carpetas escalable.

## User Review Required

> [!IMPORTANT]
> Moveremos `LoginScreen.kt` a una nueva ubicación. Si tienes otros archivos que dependan de él (además de `MainActivity.kt`), es posible que necesiten actualizaciones de imports manuales, aunque yo me encargaré de los archivos principales detectados.

## Proposed Changes

### Dependencias

Añadiremos la librería necesaria para usar ViewModels de forma sencilla en Compose.

#### [MODIFY] [libs.versions.toml](file:///Users/sebastiancorvalan/Documents/PROGRAMACION/MyApp/gradle/libs.versions.toml)
#### [MODIFY] [build.gradle.kts](file:///Users/sebastiancorvalan/Documents/PROGRAMACION/MyApp/app/build.gradle.kts)

---

### Nueva Estructura de UI

Organizaremos las pantallas por carpetas de funcionalidades dentro de `ui/screens`.

#### [NEW] Carpeta `ui/screens/login`
#### [NEW] Carpeta `ui/screens/register`

#### [NEW] [LoginViewModel.kt](file:///Users/sebastiancorvalan/Documents/PROGRAMACION/MyApp/app/src/main/java/com/example/myapp/ui/screens/login/LoginViewModel.kt)
Manejaremos el estado (`email`, `password`, `errorMessage`) y la lógica de validación aquí.

#### [MODIFY/MOVE] [LoginScreen.kt](file:///Users/sebastiancorvalan/Documents/PROGRAMACION/MyApp/app/src/main/java/com/example/myapp/ui/screens/login/LoginScreen.kt)
Actualizaremos la pantalla para que use el `LoginViewModel` en lugar de estados internos.

#### [NEW] [RegisterScreen.kt](file:///Users/sebastiancorvalan/Documents/PROGRAMACION/MyApp/app/src/main/java/com/example/myapp/ui/screens/register/RegisterScreen.kt)
Crearemos una pantalla de registro básica como punto de partida.

---

### Punto de Entrada

#### [MODIFY] [MainActivity.kt](file:///Users/sebastiancorvalan/Documents/PROGRAMACION/MyApp/app/src/main/java/com/example/myapp/MainActivity.kt)
Actualizaremos los imports para que apunten a la nueva ubicación de la pantalla de Login.

## Verification Plan

### Automated Tests
- Ejecutar `gradlew assembleDebug` para verificar que la compilación sea exitosa tras el refactor.

### Manual Verification
- Abrir la app en el emulador/dispositivo.
- Verificar que la pantalla de Login se muestra correctamente.
- Probar que la validación de campos vacíos sigue funcionando (ahora a través del ViewModel).
