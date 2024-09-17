package org.example;

import javax.swing.*;
import java.awt.*;

public class EstructuraWebBasica {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setTitle("Estructura Web Basica");
        jframe.setSize(500, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.setLayout(new BorderLayout());

        JPanel mainHeader = new JPanel();
        mainHeader.setBackground(Color.decode("#cd5c5c"));
        mainHeader.add(new JLabel("<header>"));
        jframe.add(mainHeader, BorderLayout.NORTH);

        JPanel mainFooter = new JPanel();
        mainFooter.setBackground(Color.decode("#cd5c5c"));
        mainFooter.add(new JLabel("<footer>"));
        jframe.add(mainFooter, BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3));
        jframe.add(mainPanel, BorderLayout.CENTER);

        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.decode("#cd5c5c"));
        navPanel.add(new JLabel("<nav>"));
        mainPanel.add(navPanel);

        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new GridLayout(4, 1));
        sectionPanel.setBackground(Color.decode("#cd5c5c"));

        JPanel sectionHeader = new JPanel();
        sectionHeader.setBackground(Color.decode("#bdb76b"));
        sectionHeader.add(new JLabel("<header>"));
        sectionPanel.add(sectionHeader);

        JPanel sectionArticle = new JPanel();
        sectionArticle.setBackground(Color.decode("#bdb76b"));
        sectionArticle.add(new JLabel("<article>"));
        sectionPanel.add(sectionArticle);

        JPanel sectionFooter = new JPanel();
        sectionFooter.setBackground(Color.decode("#bdb76b"));
        sectionFooter.add(new JLabel("<footer>"));
        sectionPanel.add(sectionFooter);

        mainPanel.add(sectionPanel);

        JPanel asidePanel = new JPanel();
        asidePanel.setBackground(Color.decode("#cd5c5c"));
        asidePanel.add(new JLabel("<aside>"));
        mainPanel.add(asidePanel);

        jframe.setVisible(true);
    }
}
