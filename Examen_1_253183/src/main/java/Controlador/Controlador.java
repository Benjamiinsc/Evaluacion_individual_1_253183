/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DTO.CursoDTO;
import Modelo.Modelo;

/**
 * El controlador del modelo mvc.
 *
 * @author benja
 */
public class Controlador {

    /**
     * Referencia a la instancia del Modelo para comunicarse con la lógica de
     * negocio.
     */
    private final Modelo modelo;

    /**
     * Construye una nueva instancia del Controlador.
     *
     * @param modelo La instancia del Modelo que este controlador manipulará.
     */
    public Controlador(Modelo modelo) {
        this.modelo = modelo;
    }

    /**
     * Solicita al Modelo que inscriba un curso.
     *
     * @param cursoDto El DTO del curso a inscribir.
     */
    public void inscribirCurso(CursoDTO cursoDto) {
        modelo.inscribirCurso(cursoDto);
    }

    /**
     * Solicita al Modelo que desinscriba un curso.
     *
     * @param cursoDto El DTO del curso a desinscribir.
     */
    public void desinscribirCurso(CursoDTO cursoDto) {
        modelo.desinscribirCurso(cursoDto);
    }

    /**
     * Solicita al Modelo que genere la ficha de pago con los cursos inscritos.
     */
    public void generarFicha() {
        modelo.generarFicha();
    }

    /**
     * Solicita al Modelo que reinicie el proceso de inscripción a su estado
     * inicial.
     */
    public void reiniciar() {
        modelo.reiniciar();
    }
}
