/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import DTO.CursoDTO;
import DTO.FichaPagoDTO;
import java.util.List;

/**
 * Define una interfaz del Modelo que sirve como una fachada de solo 
 * lectura para que la Vista acceda al estado actual de la aplicación mediante DTOs.
 */
public interface IModelo {

    /**
     * Obtiene la lista de cursos actualmente inscritos.
     *
     * @return Una lista de CursoDTO que representa los cursos inscritos.
     */
    List<CursoDTO> getCursosInscritos();

    /**
     * Obtiene la lista de cursos disponibles para la inscripción.
     *
     * @return Una lista de CursoDTO que representa los cursos no inscritos.
     */
    List<CursoDTO> getCursosNoInscritos();

    /**
     * Obtiene la última ficha de pago que fue generada y la elimina del estado del modelo.
     * @return El último FichaPagoDTO generado, o null si no hay uno pendiente.
     */
    FichaPagoDTO getUltimaFichaYLimpiar();

    /**
     * Indica al modelo que debe reiniciar su estado interno.
     */
    void reiniciar();

    /**
     * Calcula y devuelve el costo total actual de todos los cursos inscritos.
     *
     * @return Un double con la suma de los costos de los cursos en la lista de inscritos.
     */
    double getCostoTotalInscritos();
}
