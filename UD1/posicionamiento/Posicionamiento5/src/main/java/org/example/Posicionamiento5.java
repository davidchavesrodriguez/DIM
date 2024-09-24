package org.example;

import javax.swing.*;
import java.awt.*;

public class Posicionamiento5 {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("Grid Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar el layout
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configurar el relleno
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre paneles

        // Panel Jade (3x3) - ocupa 3 columnas y 3 filas
        JPanel jadePanel = new JPanel();
        jadePanel.setBackground(new Color(76, 235, 169)); // Jade
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3; gbc.gridheight = 2;
        frame.add(jadePanel, gbc);

        // Panel Green (1x2) - ocupa 1 columna y 2 filas
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(new Color(56, 120, 0)); // Verde
        gbc.gridx = 3; gbc.gridy = 0; gbc.gridwidth = 1; gbc.gridheight = 2;
        frame.add(greenPanel, gbc);

        // Panel Red (1x1) - ocupa 1 columna y 1 fila
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; gbc.gridheight = 1;
        frame.add(redPanel, gbc);

        // Panel Pink (3x3) - ocupa 2 columnas y 3 filas
        JPanel pinkPanel = new JPanel();
        pinkPanel.setBackground(new Color(240, 0, 255)); // Rosa
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 2; gbc.gridheight = 4; // Cambiado a 4 para que ocupe las filas adecuadas
        frame.add(pinkPanel, gbc);

        // Panel Orange (3x1) - ocupa 3 columnas y 1 fila
        JPanel orangePanel = new JPanel();
        orangePanel.setBackground(new Color(255, 109, 0)); // Naranja
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 3; gbc.gridheight = 1; // Ocupa 3 columnas
        frame.add(orangePanel, gbc);

        // Panel Blue (1x4) - ocupa 1 columna y 4 filas
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(new Color(1, 80, 159)); // Azul
        gbc.gridx = 3; gbc.gridy = 2; gbc.gridwidth = 1; gbc.gridheight = 4; // Cambiado a 4 para que ocupe las filas adecuadas
        frame.add(bluePanel, gbc);

        // Panel Brown (1x1) - ocupa 1 columna y 1 fila
        JPanel brownPanel = new JPanel();
        brownPanel.setBackground(new Color(202, 158, 97)); // Marrón
        gbc.gridx = 3; gbc.gridy = 6; gbc.gridwidth = 1; gbc.gridheight = 1;
        frame.add(brownPanel, gbc);

        // Ajustar el tamaño a pantalla completa
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true); // Opcional: Para ocultar la barra de título

        // Hacer visible el marco
        frame.setVisible(true);
    }
}
