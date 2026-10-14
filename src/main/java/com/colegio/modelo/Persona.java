package com.colegio.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Superclase que agrupa los datos personales comunes a Profesores y
 * Estudiantes. No es abstracta (requisito del parcial): puede instanciarse,
 * aunque en la aplicación siempre se usan sus subclases.
 *
 * No declara constructor explícito: Java le asigna el constructor por
 * defecto y los datos se asignan con los setters.
 */
public class Persona {

    public static final int MAYORIA_DE_EDAD = 18;
    public static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected LocalDate fechaNacimiento;

    // ---------------------------------------------------------------- get / set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // ---------------------------------------------------------------- lógica
    /** Edad en años cumplidos a la fecha de hoy. */
    public int calcularEdad() {
        if (fechaNacimiento == null) {
            return 0;
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public boolean esMayorDeEdad() {
        return calcularEdad() >= MAYORIA_DE_EDAD;
    }

    /**
     * Descripción de la persona. Las subclases SOBRESCRIBEN este método
     * para agregar sus datos particulares (polimorfismo por sobreescritura).
     */
    public String mostrarInformacion() {
        return nombre + " (" + calcularEdad() + " años)";
    }

    /**
     * SOBRECARGA de mostrarInformacion(): misma firma de nombre, distinta
     * lista de parámetros. Permite pedir también los datos de contacto.
     */
    public String mostrarInformacion(boolean incluirContacto) {
        String info = mostrarInformacion();
        if (incluirContacto) {
            info += " | Dir: " + direccion + " | Tel: " + telefono
                    + " | Nac: " + fechaNacimiento.format(FORMATO_FECHA);
        }
        return info;
    }

    @Override
    public String toString() {
        return mostrarInformacion();
    }
}
