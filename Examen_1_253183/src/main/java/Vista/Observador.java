/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vista;

import Modelo.IModelo;

/**
 * Define un Observador en el patrón de diseño Observer.
 *
 * @author benja
 */
public interface Observador {

    /**
     * Método de actualizacion que es invocado por el sujeto observable cuando su estado cambia.
     *
     * @param modelo Una referencia al modelo que ha sido actualizado, permitiendo al observador obtener los nuevos datos.
     */
    public void actualiza(IModelo modelo);
}