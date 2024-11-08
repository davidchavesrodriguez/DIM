package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Calculadora {
    public static Long firstNumber = null;
    public static Long secondNumber = null;
    public static String operation;

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Calculadora");
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Campo de texto alineado a la derecha
        JTextField operationField = new JTextField(20);
        operationField.setPreferredSize(new Dimension(500, 60));
        operationField.setEditable(false);
        operationField.setHorizontalAlignment(SwingConstants.RIGHT);
        operationField.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Método para verificar si el campo muestra "ERROR"
        ActionListener addNumberToField = e -> {
            if (operationField.getText().equals("ERROR")) {
                operationField.setText("");
            }
            if (operationField.getText().equals("0") || operationField.getText().isEmpty()) {
                operationField.setText(((JButton) e.getSource()).getText());
            } else {
                operationField.setText(operationField.getText() + ((JButton) e.getSource()).getText());
            }
        };

        // Botones numéricos
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 30));
            numberButtons[i].setBackground(Color.decode("#BDD5E7"));
            numberButtons[i].setFocusPainted(false);
            numberButtons[i].addActionListener(addNumberToField);
        }

        // Botones operadores
        String[] operators = {"+", "-", "×", "/"};
        JButton[] operatorButtons = new JButton[4];
        for (int i = 0; i < operators.length; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].setFont(new Font("Arial", Font.BOLD, 30));
            operatorButtons[i].setBackground(Color.decode("#4474C4"));
            operatorButtons[i].setForeground(Color.WHITE);
            operatorButtons[i].setFocusPainted(false);
            final String op = operators[i];
            operatorButtons[i].addActionListener(_ -> {
                if (!operationField.getText().equals("ERROR")) {
                    try {
                        if (firstNumber == null && !operationField.getText().isEmpty()) {
                            firstNumber = Long.parseLong(operationField.getText());
                            operation = op;
                            operationField.setText(operationField.getText() + op);
                        }
                    } catch (NumberFormatException ex) {
                        operationField.setText("ERROR");
                    }
                }
            });
        }

        // Botón igual
        JButton buttonEquals = new JButton("=");
        buttonEquals.setFont(new Font("Arial", Font.BOLD, 30));
        buttonEquals.setBackground(Color.decode("#52A447"));
        buttonEquals.setFocusPainted(false);
        buttonEquals.addActionListener(_ -> {
            if (!operationField.getText().equals("ERROR")) {
                try {
                    String[] parts = operationField.getText().split("\\" + operation);

                    if (parts.length == 2) {
                        secondNumber = Long.parseLong(parts[1].trim());
                        if (firstNumber != null && !operation.isEmpty()) {
                            switch (operation) {
                                case "+" -> {
                                    long addValue = firstNumber + secondNumber;
                                    operationField.setText(Long.toString(addValue));
                                }
                                case "-" -> {
                                    long subtractValue = firstNumber - secondNumber;
                                    operationField.setText(Long.toString(subtractValue));
                                }
                                case "×" -> {
                                    long multiplyValue = firstNumber * secondNumber;
                                    operationField.setText(Long.toString(multiplyValue));
                                }
                                case "/" -> {
                                    if (secondNumber == 0) {
                                        operationField.setText("ERROR");
                                    } else {
                                        long divideValue = firstNumber / secondNumber;
                                        operationField.setText(Long.toString(divideValue));
                                    }
                                }
                            }
                            // Restablecer para iniciar una nueva operación
                            firstNumber = null;
                            secondNumber = null;
                            operation = "";
                        }
                    }
                } catch (Exception _) {

                }
            }
        });

        // Botón de borrar
        JButton buttonClear = new JButton("C");
        buttonClear.setFont(new Font("Arial", Font.BOLD, 30));
        buttonClear.setBackground(Color.decode("#FF9D22"));
        buttonClear.setFocusPainted(false);
        buttonClear.addActionListener(_ -> {
            operationField.setText("");
            firstNumber = null;
            secondNumber = null;
            operation = "";
        });

        // Agregar los botones al panel
        buttonsPanel.add(numberButtons[7]);
        buttonsPanel.add(numberButtons[8]);
        buttonsPanel.add(numberButtons[9]);
        buttonsPanel.add(operatorButtons[0]);
        buttonsPanel.add(numberButtons[4]);
        buttonsPanel.add(numberButtons[5]);
        buttonsPanel.add(numberButtons[6]);
        buttonsPanel.add(operatorButtons[1]);
        buttonsPanel.add(numberButtons[1]);
        buttonsPanel.add(numberButtons[2]);
        buttonsPanel.add(numberButtons[3]);
        buttonsPanel.add(operatorButtons[2]);
        buttonsPanel.add(buttonClear);
        buttonsPanel.add(numberButtons[0]);
        buttonsPanel.add(buttonEquals);
        buttonsPanel.add(operatorButtons[3]);

        // Agregar panel de botones y campo de texto al marco
        mainFrame.add(operationField, BorderLayout.NORTH);
        mainFrame.add(buttonsPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }
}
