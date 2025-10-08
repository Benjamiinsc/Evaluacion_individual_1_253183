/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Representa una entidad de dominio para un Horario específico de un curso.
 *
 * @author benja
 */
public final class Horario {

    private final String dia;
    private final String hora;
    private final String modalidad;

    /**
     * Construye una nueva instancia de Horario.
     *
     * @param dia El día de la semana.
     * @param hora La hora de la clase.
     * @param modalidad La modalidad en que se imparte.
     */
    public Horario(String dia, String hora, String modalidad) {
        this.dia = dia;
        this.hora = hora;
        this.modalidad = modalidad;
    }

    /**
     * Devuelve el día del horario.
     *
     * @return El día de la semana.
     */
    public String getDia() {
        return dia;
    }

    /**
     * Devuelve la hora del horario.
     *
     * @return El rango de horas de la clase.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Devuelve la modalidad del horario.
     *
     * @return La modalidad de la clase.
     */
    public String getModalidad() {
        return modalidad;
    }

    /**
     * Devuelve una representación en formato de texto del horario.
     *
     * @return Una cadena con el formato "Día Hora (Modalidad)".
     */
    @Override
    public String toString() {
        return String.format("%s %s (%s)", dia, hora, modalidad);
    }
}