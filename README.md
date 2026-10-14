# ColegioApp

Aplicación de escritorio en Java Swing (NetBeans) para llevar el registro de
**Profesores** y **Estudiantes** de un colegio.

Segundo examen parcial — Programación Orientada a Objetos.
Autor: Simón Satizábal — Código 1137060514.

## Cómo ejecutar

1. Abrir la carpeta `ColegioApp` en NetBeans (*File → Open Project*). Es un proyecto Maven.
2. *Run Project* (F6). La clase principal es `com.colegio.Main`.
3. Requiere JDK 17 o superior.

## Estructura

| Paquete | Clase | Rol |
|---|---|---|
| `com.colegio` | `Main` | Punto de entrada: crea el `Colegio` y abre la ventana principal |
| `com.colegio.modelo` | `Persona` | Superclase (no abstracta) con nombre, dirección, teléfono y fecha de nacimiento |
| | `Profesor` | Subclase: cédula, área, salario por hora y horas dictadas. **Único constructor** de la jerarquía |
| | `Estudiante` | Subclase: código, grado y acudiente. Sin constructor propio (usa setters) |
| | `Colegio` | Asociación 1→* con profesores y estudiantes |
| `com.colegio.reportes` | `GeneradorReportes` | Dependencia con `Colegio`: genera los dos reportes |
| `com.colegio.vista` | `VentanaPrincipal`, `FrmProfesores`, `FrmEstudiantes`, `FrmReportes` | JFrame diseñados con el editor gráfico de NetBeans (`.form`) |

## Reglas de negocio

- Pago mensual = salario por hora × horas dictadas + 30 % por preparación de clase.
- Prestaciones sociales = 19 % del pago mensual.
- Los profesores deben ser mayores de edad (18 años o más).

## Polimorfismo

- **Sobreescritura:** `mostrarInformacion()` en `Profesor` y `Estudiante`; `toString()` en `Persona`.
- **Sobrecarga:** `mostrarInformacion()` / `mostrarInformacion(boolean)`,
  `calcularPagoMensual()` / `calcularPagoMensual(int)`,
  `Colegio.registrar(Profesor)` / `Colegio.registrar(Estudiante)`.

## Reportes

1. Lista de estudiantes.
2. Profesores ordenados por salario total (mayor a menor) con el total de prestaciones sociales.

Ambos se pueden imprimir (o guardar como PDF) con el botón **Imprimir**.
