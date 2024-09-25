package org.example;

import javax.swing.*;
import java.awt.*;

public class Posicionamiento5 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        JPanel mainDiv = new JPanel();
        mainDiv.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        JPanel jadePanel = new JPanel();
        jadePanel.setBackground(Color.decode("#4ceba9"));
        mainDiv.add(jadePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        mainDiv.add(redPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        JPanel orangePanel = new JPanel();
        orangePanel.setBackground(Color.decode("#ff6d00"));
        mainDiv.add(orangePanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 4;
        JPanel pinkPanel = new JPanel();
        pinkPanel.setBackground(Color.decode("#f000ff"));
        mainDiv.add(pinkPanel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.decode("#387800"));
        mainDiv.add(greenPanel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 4;
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.decode("#01509f"));
        mainDiv.add(bluePanel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        JPanel brownPanel = new JPanel();
        brownPanel.setBackground(Color.decode("#ca9e61"));
        mainDiv.add(brownPanel, gbc);

        frame.add(mainDiv);
        frame.setVisible(true);
    }
}
