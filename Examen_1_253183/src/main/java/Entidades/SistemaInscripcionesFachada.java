/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz ISistemaInscripciones.
 *
 * @author benja
 */
public class SistemaInscripcionesFachada implements ISistemaInscripciones {

    private List<Curso> cursosInscritos;
    private List<Curso> cursosNoInscritos;

    /**
     * Construye una nueva instancia de la fachada del sistema de inscripciones.
     * Inicializa las listas de cursos.
     */
    public SistemaInscripcionesFachada() {
        this.cursosInscritos = new ArrayList<>();
        this.cursosNoInscritos = new ArrayList<>();
        cargarCursosIniciales();
    }

    /**
     * Método privado para poblar la lista de cursos disponibles mockeados.
     */
    private void cargarCursosIniciales() {
        this.cursosNoInscritos.clear();
        this.cursosNoInscritos.add(new Curso("Ingenieria de requisitos", 900.00, List.of(new Horario("Martes", "13:30 - 15:00", "Presencial"), new Horario("Viernes", "15:00 - 16:30", "Remota"))));
        this.cursosNoInscritos.add(new Curso("Arquitectura de software", 666.00, List.of(new Horario("Lunes", "15:00 - 16:30", "Presencial"), new Horario("Miercoles", "15:00 - 16:30", "Presencial"))));
        this.cursosNoInscritos.add(new Curso("Diseño de sistemas interactivos",700.00,List.of(new Horario("Martes", "19:30 - 21:00", "En Línea"), new Horario("Jueves","19:30 - 21:00","Remota"))));
        this.cursosNoInscritos.add(new Curso("Aplicaciones web", 777.00, List.of(new Horario("Martes", "13:30 - 15:00", "Presencial"), new Horario("Viernes", "15:00 - 16:30", "Remota"))));
        this.cursosNoInscritos.add(new Curso("Sustentabilidad", 1000.00, List.of(new Horario("Lunes", "15:00 - 16:30", "Presencial"), new Horario("Miercoles", "15:00 - 16:30", "Presencial"))));
        this.cursosNoInscritos.add(new Curso("Administracion de proyectos de software",626.00,List.of(new Horario("Martes", "19:30 - 21:00", "En Línea"), new Horario("Jueves","19:30 - 21:00","Remota"))));
    }

    /**
     * Obtiene la lista de cursos en los que el usuario se ha inscrito.
     *
     * @return Una lista de objetos Curso que representan los cursos inscritos.
     */
    @Override
    public List<Curso> getCursosInscritos() {
        return this.cursosInscritos;
    }

    /**
     * Obtiene la lista de cursos que están disponibles para la inscripción.
     *
     * @return Una lista de objetos Curso que representan los cursos no inscritos.
     */
    @Override
    public List<Curso> getCursosNoInscritos() {
        return this.cursosNoInscritos;
    }

    /**
     * Procesa la inscripción de un curso.
     * Mueve el curso de la lista de "no inscritos" a la lista de "inscritos"
     * @param curso El curso que se va a inscribir.
     */
    @Override
    public void inscribirCurso(Curso curso) {
        if (curso != null && this.cursosNoInscritos.contains(curso)) {
            this.cursosNoInscritos.remove(curso);
            this.cursosInscritos.add(curso);
        }
    }

    /**
     * Procesa la desinscripción de un curso.
     * Mueve el curso de la lista de "inscritos" de vuelta a la lista de "no inscritos"
     *
     * @param curso El curso que se va a desinscribir.
     */
    @Override
    public void desinscribirCurso(Curso curso) {
        if (curso != null && this.cursosInscritos.contains(curso)) {
            this.cursosInscritos.remove(curso);
            this.cursosNoInscritos.add(curso);
        }
    }

    /**
     * Genera una ficha de pago basada en los cursos actualmente inscritos.
     * @return Un objeto  FichaPago que resume la inscripción y el costo total.
     */
    @Override
    public FichaPago generarFichaDePago() {
        return FichaPago.crearDesde(this.cursosInscritos);
    }

    /**
     * Reinicia el estado del sistema de inscripciones a su estado inicial.
     * Limpia la lista de cursos inscritos y restaura la lista completa de cursos disponibles.
     */
    @Override
    public void reiniciarInscripcion() {
        this.cursosInscritos.clear();
        cargarCursosIniciales();
    }
}