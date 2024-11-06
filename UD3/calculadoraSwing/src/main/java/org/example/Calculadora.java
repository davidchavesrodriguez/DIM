package org.example;

import javax.swing.*;
import java.awt.*;

public class Calculadora {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Calculadora");
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextField operationField = new JTextField(20);
        operationField.setPreferredSize(new Dimension(500, 60));
        operationField.setEditable(false);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4, 1, 1));

        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button0 = new JButton("0");
        JButton buttonAdd = new JButton("+");
        buttonAdd.setFont(new Font("Arial", Font.BOLD, 30));
        JButton buttonSubtract = new JButton("-");
        buttonSubtract.setFont(new Font("Arial", Font.BOLD, 30));
        JButton buttonMultiply = new JButton("*");
        buttonMultiply.setFont(new Font("Arial", Font.BOLD, 30));
        JButton buttonDivide = new JButton("/");
        buttonDivide.setFont(new Font("Arial", Font.BOLD, 30));
        JButton buttonEquals = new JButton("=");
        buttonEquals.setFont(new Font("Arial", Font.BOLD, 30));
        JButton buttonClear = new JButton("C");
        buttonClear.setFont(new Font("Arial", Font.BOLD, 30));


        buttonsPanel.add(button7);
        buttonsPanel.add(button8);
        buttonsPanel.add(button9);
        buttonsPanel.add(buttonAdd);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        buttonsPanel.add(buttonSubtract);
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(buttonMultiply);
        buttonsPanel.add(button0);
        buttonsPanel.add(buttonClear);
        buttonsPanel.add(buttonEquals);
        buttonsPanel.add(buttonDivide);


        mainFrame.add(operationField, BorderLayout.NORTH);
        mainFrame.add(buttonsPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }
}
