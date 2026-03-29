# Actividad Semana 4 - Aplicación de Registro en Android

Esta aplicación de Android, desarrollada con **Kotlin** y **Jetpack Compose**, demuestra la implementación de formularios de captura de datos y el manejo de navegación entre pantallas transmitiendo múltiples argumentos.

## Propiedades

* **Interfaz moderna:** Desarrollada completamente con Material Design 3.
* **Gestión del estado:** Aplicación de `remember` y `mutableStateOf` para gestionar formularios reactivos.
* **Navegación dinámica:** Se utiliza `NavHost` para transferir parámetros entre las funciones composables.
* **De borde a borde:** Ajuste que utiliza toda la superficie de la pantalla, incluidas las barras del sistema.

## Estructura del Proyecto

El código se divide en tres componentes principales dentro del `MainActivity.kt`:

### 1. Navegación (NavHost)
Establece las rutas de la aplicación:
* `principal`: Pantalla de inicio que contiene el formulario.
* `detalle`: Pantalla receptora que obtiene seis variables (`cedula`, `nombre`, `apellido`, `telefono`, `direccion` y `email`) del `backStackEntry`.

### 2. Pantalla principal (`PrincipalScreen`)
Contiene un formulario formado por seis campos de tipo `OutlinedTextField`. 
* **Lógica:** Recoge en tiempo real la información que el usuario introduce.
* **Acción:** Al hacer clic en "Enviar", se genera una ruta dinámica que lleva a la pantalla siguiente, incluyendo todos los datos introducidos.

### 3. Pantalla de Detalle (llamada "Detalle")
Es una pantalla elemental de visualización que acepta los datos en forma de parámetros.
* **Diseño:** Emplea un componente `Column` centrado para presentar la información, utilizando varios estilos de tipografía.

## Requisitos para Ejecución

* **Android Studio** Jellyfish | 2023.3.1 o más reciente.
* **Kotlin** 1.9.0 o posterior
* **Compose Compiler** compatible con la versión de Kotlin utilizada.
* **Dependencia de navegación:** `androidx.navigation:navigation-compose`.

## Indicaciones de uso

1.  Llene todos los espacios requeridos en el formulario al abrir la aplicación.
2.  Haga clic en el botón **"Enviar."**
3.  La aplicación lo llevará a una nueva visualización en la que podrá verificar que los datos fueron enviados y se mostraron correctamente.
