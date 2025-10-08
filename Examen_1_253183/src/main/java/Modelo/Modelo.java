/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import DTO.CursoDTO;
import DTO.FichaPagoDTO;
import Entidades.Curso;
import Entidades.FichaPago;
import Entidades.SistemaInscripcionesFachada;
import Entidades.ISistemaInscripciones;
import Vista.Observador;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * El Modelo gestiona el estado de la aplicación
 * y notifica a los observadores sobre cualquier cambio.
 *
 * @author benja
 */
public class Modelo implements IModelo {

    private final List<Observador> observadores;
    private final ISistemaInscripciones sistemaInscripcion;
    private FichaPagoDTO ultimaFichaGenerada;

    /**
     * Constructor que inicializa el estado del Modelo.
     */
    public Modelo() {
        this.observadores = new ArrayList<>();
        this.sistemaInscripcion = new SistemaInscripcionesFachada();
    }

    /**
     * Procesa la solicitud para inscribir un curso.
     * @param cursoDto El curso a inscribir.
     */
    public void inscribirCurso(CursoDTO cursoDto) {
        if (cursoDto == null) {
            // Ya no se genera un mensaje de error. Simplemente no hace nada.
            return;
        }
        Curso cursoEntidad = encontrarCursoPorNombre(cursoDto.getNombre());
        if (cursoEntidad != null) {
            sistemaInscripcion.inscribirCurso(cursoEntidad);
            notificarObservadores();
        }
    }

    /**
     * Procesa la solicitud para desinscribir un curso.
     * @param cursoDto El curso a desinscribir.
     */
    public void desinscribirCurso(CursoDTO cursoDto) {
        if (cursoDto == null) {
            return;
        }
        Curso cursoEntidad = encontrarCursoPorNombre(cursoDto.getNombre());
        if (cursoEntidad != null) {
            sistemaInscripcion.desinscribirCurso(cursoEntidad);
            notificarObservadores(); // La notificación se hace aquí
        }
    }

    /**
     * Genera la ficha de pago, reinicia el sistema y notifica a los observadores.
     */
    // Este método es llamado por el Controlador, no devuelve nada.
    public void generarFicha() {
        FichaPago fichaEntidad = sistemaInscripcion.generarFichaDePago();

        if (fichaEntidad.getCursosInscritos().isEmpty()) {
            // Ya no se genera un mensaje de error.
            // La vista deberá validar el DTO de la ficha para mostrar un aviso.
        }

        this.ultimaFichaGenerada = convertirFichaEntidadADTO(fichaEntidad);
        sistemaInscripcion.reiniciarInscripcion();
        notificarObservadores();
    }

    /**
     * Devuelve la última ficha generada y la elimina del estado.
     * @return El DTO de la última ficha de pago.
     */
    // --- MÉTODOS GETTER (Implementando IModelo y para el "Pizarrón") ---
    @Override
    public FichaPagoDTO getUltimaFichaYLimpiar() {
        FichaPagoDTO ficha = this.ultimaFichaGenerada;
        this.ultimaFichaGenerada = null;
        return ficha;
    }

    /**
     * Devuelve la lista de cursos inscritos en formato DTO.
     * @return Lista de DTOs de cursos inscritos.
     */
    @Override
    public List<CursoDTO> getCursosInscritos() { // Nombre coincide con la interfaz
        List<Curso> entidades = sistemaInscripcion.getCursosInscritos();
        return entidades.stream().map(this::convertirCursoEntidadADTO).collect(Collectors.toList());
    }

    /**
     * Devuelve la lista de cursos no inscritos en formato DTO.
     * @return Lista de DTOs de cursos no inscritos.
     */
    @Override
    public List<CursoDTO> getCursosNoInscritos() { // Nombre coincide con la interfaz
        List<Curso> entidades = sistemaInscripcion.getCursosNoInscritos();
        return entidades.stream().map(this::convertirCursoEntidadADTO).collect(Collectors.toList());
    }

    /**
     * Agrega una Vista a la lista de observadores.
     * @param obs El observador (Vista) a agregar.
     */
    // --- MÉTODOS OBSERVER ---
    public void agregarObservador(Observador obs) {
        if (obs != null && !this.observadores.contains(obs)) {
            this.observadores.add(obs);
        }
    }

    /**
     * Notifica a todos los observadores sobre un cambio en el modelo.
     */
    public void notificarObservadores() {
        for (Observador obs : this.observadores) {
            obs.actualiza(this);
        }
    }

    /**
     * Busca la entidad Curso original basándose en el nombre del DTO. Es
     * necesario porque la fachada solo entiende de entidades.
     * @param nombre El nombre del curso a buscar.
     * @return La entidad Curso encontrada o null.
     */
    // --- MÉTODOS DE AYUDA PARA TRADUCCIÓN ---
    private Curso encontrarCursoPorNombre(String nombre) {
        // Busca tanto en la lista de inscritos como en la de no inscritos
        return sistemaInscripcion.getCursosNoInscritos().stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst()
                .orElse(sistemaInscripcion.getCursosInscritos().stream()
                        .filter(c -> c.getNombre().equals(nombre))
                        .findFirst()
                        .orElse(null));
    }

    /**
     * Convierte una entidad Curso a su DTO correspondiente.
     * @param curso La entidad a convertir.
     * @return El DTO del curso.
     */
    private CursoDTO convertirCursoEntidadADTO(Curso curso) {
        // 1. Toma la lista de entidades Horario del curso
        List<Entidades.Horario> horariosEntidad = curso.getHorarios();

        // 2. Convierte esa lista a una lista de HorarioDTO
        List<DTO.HorarioDTO> horariosDto = horariosEntidad.stream()
                .map(horario -> new DTO.HorarioDTO(
                horario.getDia(),
                horario.getHora(),
                horario.getModalidad()))
                .collect(Collectors.toList());

        // 3. Crea y devuelve el CursoDTO usando el constructor completo
        return new DTO.CursoDTO(curso.getNombre(), curso.getCosto(), horariosDto);
    }

    /**
     * Devuelve el costo total de los cursos actualmente inscritos.
     * @return El costo total.
     */
    @Override
    public double getCostoTotalInscritos() {
        return this.sistemaInscripcion.getCursosInscritos().stream()
                .mapToDouble(Curso::getCosto)
                .sum();
    }

    /**
     * Reinicia el estado de las inscripciones.
     */
    @Override
    public void reiniciar() {
        sistemaInscripcion.reiniciarInscripcion();
        notificarObservadores();
    }

    /**
     * Convierte una entidad FichaPago a su DTO correspondiente.
     * @param ficha La entidad a convertir.
     * @return El DTO de la ficha de pago.
     */
    private FichaPagoDTO convertirFichaEntidadADTO(FichaPago ficha) {
        List<CursoDTO> cursoDtos = ficha.getCursosInscritos().stream()
                .map(this::convertirCursoEntidadADTO)
                .collect(Collectors.toList());
        return new FichaPagoDTO(cursoDtos, ficha.getCostoTotal());
    }
}
