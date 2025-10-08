/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;

/**
 * Representa una entidad de dominio para una Ficha de Pago.
 *
 * @author benja
 */
public final class FichaPago {
    
    private final List<Curso> cursosInscritos;
    private final double costoTotal;

    /**
     * Constructor privado para crear una instancia de FichaPago.
     * Solo es accesible a través del método de fábrica crearDesde.
     *
     * @param cursosInscritos La lista de cursos inscritos.
     * @param costoTotal El costo total ya calculado.
     */
    private FichaPago(List<Curso> cursosInscritos, double costoTotal) {
        this.cursosInscritos = cursosInscritos;
        this.costoTotal = costoTotal;
    }

    /**
     * Calcula automáticamente el costo total sumando los costos de los cursos
     * proporcionados y devuelve una nueva ficha de pago.
     *
     * @param cursosInscritos La lista de cursos a partir de la cual se generará la ficha.
     * @return Una nueva instancia inmutable de FichaPago.
     */
    public static FichaPago crearDesde(List<Curso> cursosInscritos) {
        double costoTotalCalculado = cursosInscritos.stream()
                .mapToDouble(Curso::getCosto)
                .sum();

        return new FichaPago(cursosInscritos, costoTotalCalculado);
    }

    /**
     * Devuelve la lista de cursos inscritos en esta ficha.
     *
     * @return Una lista de objetos {@link Curso}.
     */
    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    /**
     * Devuelve el costo total calculado para esta ficha.
     *
     * @return El costo total a pagar.
     */
    public double getCostoTotal() {
        return costoTotal;
    }
}