package com.colegio.modelo;

import java.time.LocalDate;

/**
 * Superclase que agrupa los datos personales comunes a Profesores y
 * Estudiantes. No es abstracta (requisito del parcial): puede instanciarse,
 * aunque en la aplicación siempre se usan sus subclases.
 *
 * No declara constructor explícito: Java le asigna el constructor por
 * defecto y los datos se asignan con los setters.
 */
public class Persona {

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
}
