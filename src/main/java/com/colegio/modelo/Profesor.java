package com.colegio.modelo;

import java.time.LocalDate;

/**
 * Subclase de Persona. Los profesores son mayores de edad, tienen cédula,
 * un área de trabajo y reciben un pago mensual.
 *
 * Es la ÚNICA subclase que solicita constructor (requisito del parcial).
 */
public class Profesor extends Persona {

    /** 30 % adicional que se reconoce por preparación de clase. */
    public static final double PORCENTAJE_PREPARACION = 0.30;
    /** 19 % del pago total que el colegio cubre como prestaciones sociales. */
    public static final double PORCENTAJE_PRESTACIONES = 0.19;

    private String cedula;
    private String area;
    private double salarioHora;
    private int horasDictadas;

    /** Único constructor de la jerarquía. */
    public Profesor(String nombre, String direccion, String telefono, LocalDate fechaNacimiento,
            String cedula, String area, double salarioHora, int horasDictadas) {
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setFechaNacimiento(fechaNacimiento);
        if (!esMayorDeEdad()) {
            throw new IllegalArgumentException("El profesor debe ser mayor de edad (18 años o más).");
        }
        setCedula(cedula);
        setArea(area);
        setSalarioHora(salarioHora);
        setHorasDictadas(horasDictadas);
    }

    // ---------------------------------------------------------------- get / set
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(double salarioHora) {
        if (salarioHora < 0) {
            throw new IllegalArgumentException("El salario por hora no puede ser negativo.");
        }
        this.salarioHora = salarioHora;
    }

    public int getHorasDictadas() {
        return horasDictadas;
    }

    public void setHorasDictadas(int horasDictadas) {
        if (horasDictadas < 0) {
            throw new IllegalArgumentException("Las horas dictadas no pueden ser negativas.");
        }
        this.horasDictadas = horasDictadas;
    }

    // ---------------------------------------------------------------- lógica
    /**
     * Pago mensual = salarioHora × horasDictadas + 30 % por preparación.
     */
    public double calcularPagoMensual() {
        return calcularPagoMensual(horasDictadas);
    }

    /**
     * SOBRECARGA: calcula el pago para una cantidad de horas dada
     * (útil para simular cuánto ganaría con otras horas).
     */
    public double calcularPagoMensual(int horas) {
        double pagoHoras = salarioHora * horas;
        return pagoHoras + pagoHoras * PORCENTAJE_PREPARACION;
    }

    /** Prestaciones sociales = 19 % del pago total del mes. */
    public double calcularPrestaciones() {
        return calcularPagoMensual() * PORCENTAJE_PRESTACIONES;
    }

    /** Costo total para el colegio: pago + prestaciones. */
    public double calcularCostoTotal() {
        return calcularPagoMensual() + calcularPrestaciones();
    }

    /** SOBREESCRITURA del método de Persona. */
    @Override
    public String mostrarInformacion() {
        return "Profesor " + super.mostrarInformacion() + " - C.C. " + cedula + " - Área: " + area;
    }
}
