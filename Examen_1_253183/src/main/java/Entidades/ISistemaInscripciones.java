/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Entidades;

import java.util.List;

/**
 * Interfaz que define la logica para el sistema de inscripciones
 * @author benja
 */
public interface ISistemaInscripciones {

    /**
     * Obtiene la lista de cursos en los que el usuario se ha inscrito.
     *
     * @return Una lista de objetos Curso que representan los cursos inscritos.
     */
    List<Curso> getCursosInscritos();

    /**
     * Obtiene la lista de cursos que están disponibles para la inscripción.
     *
     * @return Una lista de objetos Curso que representan los cursos no inscritos.
     */
    List<Curso> getCursosNoInscritos();

    /**
     * Genera una ficha de pago basada en los cursos actualmente inscritos.
     *
     * @return Un objeto FichaPago que resume la inscripción y el costo total.
     */
    FichaPago generarFichaDePago();

    /**
     * Procesa la inscripción de un curso.
     *
     * @param curso El curso que se va a inscribir.
     */
    void inscribirCurso(Curso curso);

    /**
     * Procesa la desinscripción de un curso.
     *
     * @param curso El curso que se va a desinscribir.
     */
    void desinscribirCurso(Curso curso);

    /**
     * Reinicia el estado del sistema de inscripciones a su estado inicial.
     */
    void reiniciarInscripcion();
}
