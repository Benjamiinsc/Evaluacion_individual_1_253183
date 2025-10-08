/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.List;

/**
 * Representa un Objeto de Transferencia de Datos (DTO) para una Ficha de Pago.
 * @author benja
 */
public final class FichaPagoDTO {

    private final List<CursoDTO> cursosInscritos;
    private final double costoTotal;

    /**
     * Construye una nueva instancia de FichaPagoDTO.
     *
     * @param cursosInscritos La lista de objetos {@link CursoDTO} inscritos.
     * @param costoTotal El costo total a pagar por los cursos.
     */
    public FichaPagoDTO(List<CursoDTO> cursosInscritos, double costoTotal) {
        this.cursosInscritos = cursosInscritos;
        this.costoTotal = costoTotal;
    }

    /**
     * Devuelve la lista de cursos inscritos en la ficha de pago.
     *
     * @return Una lista de CursoDTO que representa los cursos inscritos.
     */
    public List<CursoDTO> getCursosInscritos() {
        return cursosInscritos;
    }

    /**
     * Devuelve el costo total a pagar.
     *
     * @return El costo total calculado.
     */
    public double getCostoTotal() {
        return costoTotal;
    }
}