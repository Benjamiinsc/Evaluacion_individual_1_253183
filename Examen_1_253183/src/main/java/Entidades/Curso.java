/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;

/**
 * Representa una entidad de dominio para un Curso.
 *
 * @author benja
 */
public final class Curso {

    private final String nombre;
    private final double costo;
    private final List<Horario> horarios;

    /**
     * Construye una nueva instancia de un Curso.
     *
     * @param nombre El nombre del curso.
     * @param costo El precio del curso.
     * @param horarios Una lista de objetos Horario asociados al curso.
     */
    public Curso(String nombre, double costo, List<Horario> horarios) {
        this.nombre = nombre;
        this.costo = costo;
        this.horarios = horarios;
    }

    /**
     * Devuelve el nombre del curso.
     *
     * @return El nombre del curso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el costo del curso.
     *
     * @return El costo del curso.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Devuelve la lista de horarios del curso.
     *
     * @return Una lista de objetos Horario.
     */
    public List<Horario> getHorarios() {
        return horarios;
    }

    /**
     * Devuelve una representación en formato de texto del curso, mostrando
     * su nombre y costo.
     *
     * @return Una cadena con el formato "Nombre del Curso - $Costo.00".
     */
    @Override
    public String toString() {
        return String.format("%s - $%.2f", nombre, costo);
    }


}
