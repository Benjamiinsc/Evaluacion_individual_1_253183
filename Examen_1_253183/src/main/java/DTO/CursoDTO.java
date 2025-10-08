/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;

/**
 * Representa un Objeto de Transferencia de Datos (DTO) para un Curso.
 *
 * @author benja
 */
public final class CursoDTO {

    private final String nombre;
    private final double costo;
    private final List<HorarioDTO> horarios;

    /**
     * Construye una nueva instancia de CursoDTO.
     *
     * @param nombre El nombre que tendrá el curso.
     * @param costo El costo del curso.
     * @param horarios Una lista de objetos HorarioDTO asociados al curso.
     */
    public CursoDTO(String nombre, double costo, List<HorarioDTO> horarios) {
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
     * @return Una lista inmutable de HorarioDTO.
     */
    public List<HorarioDTO> getHorarios() {
        return horarios;
    }

    /**
     * Devuelve una representación en formato de texto del curso.
     *
     * @return Una cadena con el formato "Nombre del Curso - $Costo.00".
     */
    @Override
    public String toString() {
        return String.format("%s - $%.2f", nombre, costo);
    }
}