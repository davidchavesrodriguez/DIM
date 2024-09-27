package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EstructuraWebBasicaV2 {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setTitle("Estructura Web Basica V2");
        jframe.setSize(500, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new BorderLayout());

        JPanel mainHeader = new JPanel();
        mainHeader.setLayout(new BorderLayout());
        mainHeader.setPreferredSize(new Dimension(200, 60));
        mainHeader.setBackground(Color.decode("#cd5c5c"));
        JLabel headerLabel = new JLabel("cabeceira", JLabel.CENTER);
        headerLabel.setForeground(Color.WHITE);
        mainHeader.add(headerLabel, BorderLayout.CENTER);
        mainHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, Color.white));
        jframe.add(mainHeader, BorderLayout.NORTH);


        JPanel mainFooter = new JPanel();
        mainFooter.setBackground(Color.decode("#cd5c5c"));
        JLabel footerLabel = new JLabel("pé");
        footerLabel.setForeground(Color.WHITE);
        mainFooter.add(footerLabel);
        mainFooter.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, Color.white));
        jframe.add(mainFooter, BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));
        jframe.add(mainPanel, BorderLayout.CENTER);

        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.decode("#cd5c5c"));
        JLabel navLabel = new JLabel("menu de navegacion", JLabel.CENTER);
        navLabel.setForeground(Color.WHITE);
        navPanel.setLayout(new BorderLayout());
        navPanel.add(navLabel, BorderLayout.CENTER);
        jframe.add(navPanel, BorderLayout.WEST);

        // Sección central
        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new GridBagLayout());
        sectionPanel.setBackground(Color.decode("#cd5c5c"));
        sectionPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, Color.white));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.weightx = 1.0;


        JPanel sectionHeader = new JPanel();
        sectionHeader.setBackground(Color.decode("#7abcde"));
        JLabel sectionHeaderLabel = new JLabel("artigo", JLabel.CENTER);
        sectionHeaderLabel.setForeground(Color.WHITE);
        sectionHeader.setLayout(new BorderLayout());
        sectionHeader.setBorder(BorderFactory.createMatteBorder(10, 5, 5, 5, Color.decode("#cd5c5c")));
        sectionHeader.add(sectionHeaderLabel, BorderLayout.CENTER);

        gbc.gridy = 0;
        gbc.weighty = 0.1;
        sectionPanel.add(sectionHeader, gbc);


        JPanel sectionArticle = new JPanel();
        sectionArticle.setBackground(Color.decode("#7abcde"));
        JLabel sectionArticleLabel = new JLabel("artigo", JLabel.CENTER);
        sectionArticleLabel.setForeground(Color.WHITE);
        sectionArticle.setLayout(new BorderLayout());
        sectionArticle.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#cd5c5c")));
        sectionArticle.add(sectionArticleLabel, BorderLayout.CENTER);

        gbc.gridy = 1;
        gbc.weighty = 0.8;
        sectionPanel.add(sectionArticle, gbc);


        JPanel sectionFooter = new JPanel();
        sectionFooter.setBackground(Color.decode("#7abcde"));
        JLabel sectionFooterLabel = new JLabel("artigo", JLabel.CENTER);
        sectionFooterLabel.setForeground(Color.WHITE);
        sectionFooter.setLayout(new BorderLayout());
        sectionFooter.setBorder(BorderFactory.createMatteBorder(5, 5, 20, 5, Color.decode("#cd5c5c")));
        sectionFooter.add(sectionFooterLabel, BorderLayout.CENTER);

        gbc.gridy = 2;
        gbc.weighty = 0.2;
        sectionPanel.add(sectionFooter, gbc);

        mainPanel.add(sectionPanel);

        jframe.setVisible(true);
    }
}
