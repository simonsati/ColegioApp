package com.colegio.modelo;

import java.time.LocalDate;

/**
 * Subclase de Persona. Los profesores son mayores de edad, tienen cédula,
 * un área de trabajo y reciben un pago mensual.
 *
 * Es la ÚNICA subclase que solicita constructor (requisito del parcial).
 */
public class Profesor extends Persona {

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
}
