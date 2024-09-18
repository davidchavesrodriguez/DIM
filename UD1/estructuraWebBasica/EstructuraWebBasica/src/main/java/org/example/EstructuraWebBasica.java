package org.example;

import javax.swing.*;
import java.awt.*;

public class EstructuraWebBasica {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        jframe.setTitle("Estructura Web Basica");
        jframe.setSize(500, 500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jframe.setBackground(Color.white);
        jframe.setLayout(new BorderLayout());

        JPanel mainHeader = new JPanel();
        mainHeader.setBackground(Color.decode("#cd5c5c"));
        JLabel headerLabel = new JLabel("<header>");
        headerLabel.setForeground(Color.WHITE);
        mainHeader.add(headerLabel);
        mainHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, Color.white));
        jframe.add(mainHeader, BorderLayout.NORTH);

        JPanel mainFooter = new JPanel();
        mainFooter.setBackground(Color.decode("#cd5c5c"));
        JLabel footerLabel = new JLabel("<footer>");
        footerLabel.setForeground(Color.WHITE);
        mainFooter.add(footerLabel);
        mainFooter.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, Color.white));
        jframe.add(mainFooter, BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3));
        jframe.add(mainPanel, BorderLayout.CENTER);

        JPanel navPanel = new JPanel();
        navPanel.setBackground(Color.decode("#cd5c5c"));
        JLabel navLabel = new JLabel("<nav>", JLabel.CENTER);
        navLabel.setForeground(Color.WHITE);
        navPanel.setLayout(new BorderLayout());
        navPanel.add(navLabel, BorderLayout.CENTER);
        mainPanel.add(navPanel);

        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new GridLayout(4, 1));
        sectionPanel.setBackground(Color.decode("#cd5c5c"));
        JLabel sectionLabel = new JLabel("<section>", JLabel.CENTER);
        sectionLabel.setForeground(Color.WHITE);
        sectionPanel.add(sectionLabel);
        sectionPanel.setBorder(BorderFactory.createMatteBorder(0, 10, 0, 10, Color.white));

        JPanel sectionHeader = new JPanel();
        sectionHeader.setSize(1, 1);
        sectionHeader.setBackground(Color.decode("#bdb76b"));
        JLabel sectionHeaderLabel = new JLabel("<header>", JLabel.CENTER);
        sectionHeaderLabel.setForeground(Color.WHITE);
        sectionHeader.setLayout(new BorderLayout());
        sectionHeader.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#cd5c5c")));
        sectionHeader.add(sectionHeaderLabel, BorderLayout.CENTER);
        sectionPanel.add(sectionHeader);

        JPanel sectionArticle = new JPanel();
        sectionArticle.setBackground(Color.decode("#bdb76b"));
        JLabel sectionArticleLabel = new JLabel("<article>", JLabel.CENTER);
        sectionArticleLabel.setForeground(Color.WHITE);
        sectionArticle.setLayout(new BorderLayout());
        sectionArticle.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#cd5c5c")));
        sectionArticle.add(sectionArticleLabel, BorderLayout.CENTER);
        sectionPanel.add(sectionArticle);

        JPanel sectionFooter = new JPanel();
        sectionFooter.setBackground(Color.decode("#bdb76b"));
        JLabel sectionFooterLabel = new JLabel("<footer>", JLabel.CENTER);
        sectionFooterLabel.setForeground(Color.WHITE);
        sectionFooter.setLayout(new BorderLayout());
        sectionFooter.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.decode("#cd5c5c")));
        sectionFooter.add(sectionFooterLabel, BorderLayout.CENTER);
        sectionPanel.add(sectionFooter);

        mainPanel.add(sectionPanel);

        JPanel asidePanel = new JPanel();
        asidePanel.setBackground(Color.decode("#cd5c5c"));
        JLabel asideLabel = new JLabel("<aside>", JLabel.CENTER);
        asideLabel.setForeground(Color.WHITE);
        asidePanel.setLayout(new BorderLayout());
        asidePanel.add(asideLabel, BorderLayout.CENTER);
        mainPanel.add(asidePanel);

        jframe.setVisible(true);
    }
}
