package com.colegio.modelo;

/**
 * Subclase de Persona con los datos particulares de un estudiante.
 *
 * No declara constructor (el parcial pide constructor solo en una de las
 * subclases): se crea con new Estudiante() y se llena con los setters.
 */
public class Estudiante extends Persona {

    private String codigo;
    private String grado;
    private String acudiente;

    // ---------------------------------------------------------------- get / set
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    // ---------------------------------------------------------------- lógica
    /** SOBREESCRITURA del método de Persona. */
    @Override
    public String mostrarInformacion() {
        return "Estudiante " + super.mostrarInformacion() + " - Cód. " + codigo + " - Grado: " + grado;
    }
}
