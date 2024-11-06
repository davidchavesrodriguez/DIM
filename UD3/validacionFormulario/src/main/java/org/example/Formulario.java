package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.regex.Pattern;

public class Formulario {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Formulario");
        mainFrame.setSize(400, 275);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Márgenes

        // Etiquetas y textField
        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField(20);
        JLabel nameErrorLabel = new JLabel();
        nameErrorLabel.setForeground(Color.RED);

        JLabel mailLabel = new JLabel("Correo:");
        JTextField mailField = new JTextField(20);
        JLabel mailErrorLabel = new JLabel();
        mailErrorLabel.setForeground(Color.RED);

        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField(20);
        JLabel passwordErrorLabel = new JLabel();
        passwordErrorLabel.setForeground(Color.RED);

        JLabel successLabel = new JLabel();
        successLabel.setForeground(Color.GREEN);

        // Botón de enviar
        JButton submitButton = new JButton("Enviar");
        submitButton.addActionListener(e -> {
            boolean hasError = false;

            // Validar nombre
            String name = nameField.getText();
            if (Objects.equals(name, "")) {
                nameErrorLabel.setText("Escribe tu nombre");
                hasError = true;
                // System.out.println("Escribe tu nombre");
            } else {
                nameErrorLabel.setText("");
            }

            // Validar correo
            String mail = mailField.getText();
            Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            if (mail.length() < 8) {
                mailErrorLabel.setText("El correo debe tener al menos 8 caracteres");
                hasError = true;
                // System.out.println("El correo debe tener al menos 8 caracteres");
            } else if (!emailPattern.matcher(mail).matches()) {
                mailErrorLabel.setText("<html>Formato de correo inválido<br>(debe ser nombre@ejemplo.com)</html>");
                hasError = true;
                // System.out.println("Formato de correo inválido(debe ser nombre@ejemplo.com)");
            } else {
                mailErrorLabel.setText("");
            }

            // Validar contraseña
            String password = new String(passwordField.getPassword());
            if (password.length() < 8) {
                passwordErrorLabel.setText("La contraseña debe tener al menos 8 caracteres");
                hasError = true;
                // System.out.println("La contraseña debe tener al menos 8 caracteres");
            } else {
                passwordErrorLabel.setText("");
            }

            // Eliminar la label de acceso si se accede erroneamente
            if (hasError) {
                successLabel.setText("");
            }

            // Mostrar datos solo si no hay errores
            if (!hasError) {
                successLabel.setText("Formulario enviado con exito");
                System.out.println("Has accedido al sistema como: Nombre: " + name + ", Correo: " + mail + ", Contraseña: " + password);
                nameField.setText("");
                mailField.setText("");
                passwordField.setText("");
            }
        });

        // Agregar componentes al panel principal
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(nameErrorLabel);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(mailLabel);
        mainPanel.add(mailField);
        mainPanel.add(mailErrorLabel);
        mainPanel.add(Box.createVerticalStrut(10));

        // En caso de que haya errores
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(passwordErrorLabel);
        mainPanel.add(Box.createVerticalStrut(10));

        // En caso de acceder
        mainPanel.add(successLabel);

        mainPanel.add(submitButton);

        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);
    }
}
