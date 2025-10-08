/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Vista;

import DTO.CursoDTO;
import DTO.FichaPagoDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Un panel de Swing personalizado diseñado para mostrar una Ficha de Pago.
 *
 * @author benja
 */
public class PanelFichaPago extends JPanel {

    /**
     * Construye y configura el panel con su layout y apariencia inicial.
     */
    public PanelFichaPago() {
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(Color.WHITE);
        limpiar();
    }

    /**
     * Rellena el panel con los datos de una ficha de pago.
     * Limpia cualquier contenido anterior y dibuja el nuevo desglose de cursos
     * y el total a pagar.
     *
     * @param ficha El DTO con la información de la ficha a mostrar.
     */
    public void mostrarFicha(FichaPagoDTO ficha) {
        this.removeAll();

        if (ficha == null || ficha.getCursosInscritos().isEmpty()) {
            limpiar();
            return;
        }

        JLabel titulo = new JLabel("Ficha de Pago", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setBorder(new EmptyBorder(5, 0, 15, 0));
        this.add(titulo, BorderLayout.NORTH);

        JPanel cursosPanel = new JPanel(new GridBagLayout());
        cursosPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTH;

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 0.35;
        cursosPanel.add(new JLabel("Curso Inscrito"), gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.55;
        cursosPanel.add(new JLabel("Horario(s)"), gbc);
        gbc.gridx = 2;
        gbc.weightx = 0.10;
        cursosPanel.add(new JLabel("Costo"), gbc);

        int fila = 1;
        for (CursoDTO curso : ficha.getCursosInscritos()) {
            gbc.gridy = fila++;
            String horariosStr = curso.getHorarios().stream().map(Object::toString).collect(Collectors.joining(" , "));
            gbc.gridx = 0;
            cursosPanel.add(new JLabel(curso.getNombre()), gbc);
            gbc.gridx = 1;
            cursosPanel.add(new JLabel(horariosStr), gbc);
            gbc.gridx = 2;
            cursosPanel.add(new JLabel(String.format("$%.2f", curso.getCosto())), gbc);
        }

        this.add(cursosPanel, BorderLayout.CENTER);

        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.setBackground(Color.WHITE);
        totalPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
        totalPanel.add(new JLabel(" "), BorderLayout.NORTH);

        JLabel totalLabel = new JLabel("COSTO TOTAL:");
        totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        JLabel totalValor = new JLabel(String.format("$%.2f", ficha.getCostoTotal()));
        totalValor.setFont(new Font("Segoe UI", Font.BOLD, 16));

        totalPanel.add(totalLabel, BorderLayout.WEST);
        totalPanel.add(totalValor, BorderLayout.EAST);
        this.add(totalPanel, BorderLayout.SOUTH);

        this.revalidate();
        this.repaint();
    }

    /**
     * Limpia todo el contenido del panel, dejándolo en blanco.
     */
    public final void limpiar() {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
}