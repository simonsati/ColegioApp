package com.colegio.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Almacena los Profesores y Estudiantes registrados.
 * Relación de ASOCIACIÓN (1 colegio -> * profesores / * estudiantes).
 *
 * Las listas se inicializan en su declaración, por lo que la clase no
 * necesita constructor explícito.
 */
public class Colegio {

    private String nombre = "Colegio";
    private List<Profesor> profesores = new ArrayList<>();
    private List<Estudiante> estudiantes = new ArrayList<>();

    // ---------------------------------------------------------------- get / set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    // ---------------------------------------------------------------- registro
    /** SOBRECARGA de registrar: versión para Profesor. */
    public void registrar(Profesor profesor) {
        profesores.add(profesor);
    }

    /** SOBRECARGA de registrar: versión para Estudiante. */
    public void registrar(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    /**
     * Lista polimórfica con todas las personas del colegio. Cada elemento
     * responde a mostrarInformacion() según su clase real.
     */
    public List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>(profesores);
        personas.addAll(estudiantes);
        return personas;
    }
}
