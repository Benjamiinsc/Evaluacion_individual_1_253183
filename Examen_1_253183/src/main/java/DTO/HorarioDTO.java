/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 * Representa un Objeto de Transferencia de Datos (DTO) para un Horario.
 *
 * @author benja
 */
public final class HorarioDTO {

    private final String dia;
    private final String hora;
    private final String modalidad;

    /**
     * Construye una nueva instancia de HorarioDTO.
     *
     * @param dia El día de la semana.
     * @param hora La hora de la clase.
     * @param modalidad La modalidad en que se imparte.
     */
    public HorarioDTO(String dia, String hora, String modalidad) {
        this.dia = dia;
        this.hora = hora;
        this.modalidad = modalidad;
    }

    /**
     * Devuelve el día de la semana.
     *
     * @return El día del horario.
     */
    public String getDia() {
        return dia;
    }

    /**
     * Devuelve la hora de la clase.
     *
     * @return La hora del horario.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Devuelve la modalidad de la clase.
     *
     * @return La modalidad del horario.
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
