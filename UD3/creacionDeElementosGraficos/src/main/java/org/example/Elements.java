package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.concurrent.Flow;

public class Elements {

    // Actividad 1: Crear una ventana básica.
    // Crea una ventana con un botón que, al ser presionado, muestre un mensaje en la consola.
    public static void basicWindow1() {
        JFrame frame = new JFrame("Ejercicio 1");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton boton = new JButton("Click");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Esto es el primer ejercicio");
            }
        });

        frame.add(boton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Actividad 2: Ventana con múltiples botones.
    // Crea una ventana que tenga dos botones: uno que diga "Aceptar" y otro que diga "Cancelar".
    // Al hacer clic en el botón "Aceptar", se debe mostrar el mensaje "Aceptado",
    // y al hacer clic en "Cancelar", se debe mostrar "Cancelado".
    public static void buttonsWindow2() {
        JFrame frame = new JFrame("Ejercicio 2");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        acceptButton.addActionListener(e -> System.out.println("Aceptado ✅"));
        cancelButton.addActionListener(e -> System.out.println("Cancelado ❌"));

        frame.add(acceptButton);
        frame.add(cancelButton);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Actividad 3: Interfaz con campos de texto.
    // Crea una ventana con un campo de texto donde el usuario pueda escribir su nombre y un botón.
    // Al hacer clic en el botón, debe mostrar en la consola el nombre que el usuario ha introducido.
    public static void textFieldWindow3() {
        JFrame frame = new JFrame("Ejercicio 3");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel textLabel = new JLabel("Nombre: ");
        JTextField textField = new JTextField(30);
        JButton textButton = new JButton("Mostrar");

        textButton.addActionListener(e -> {
            String input = textField.getText().trim();
            if (input.isEmpty()) {
                System.out.println("Escribe algo!!");
            } else {
                System.out.println(input);
            }
        });

        frame.add(textLabel);
        frame.add(textField);
        frame.add(textButton);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Actividad 4: Uso de etiquetas y campos de texto.
    // Crea una interfaz que tenga dos campos de texto: uno para el nombre y otro para el apellido.
    // Al hacer clic en un botón "Enviar", debe mostrar un saludo personalizado en la consola con el nombre completo.
    public static void fullNameWindow4() {
        JFrame frame = new JFrame("Ejercicio 4");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Nombre: ");
        JTextField nameField = new JTextField(20);
        JLabel lastnameLabel = new JLabel("Apellido/s: ");
        JTextField lastnameField = new JTextField(40);
        JButton textButton = new JButton("Mostrar");

        textButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String lastname = lastnameField.getText().trim();

            if (name.isEmpty()) {
                System.out.println("Escribe un nombre");
            } else if (lastname.isEmpty()) {
                System.out.println("Felicidades, " + name + "!");
            } else {
                System.out.println("Felicidades, " + name + " " + lastname + "!");
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(lastnameLabel);
        frame.add(lastnameField);
        frame.add(textButton);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Actividad 5: Uso de cuadros de diálogo (JOptionPane).
    // Crea una ventana con un botón que, al ser presionado, muestre un cuadro de diálogo pidiendo al usuario
    // que ingrese su edad. Luego, debe mostrar otro cuadro de diálogo con la edad ingresada.
    public static void dialogWindow5() {
        JFrame frame = new JFrame("Ejercicio 5");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        JButton ageButton = new JButton("Pedir Edad");

        ageButton.addActionListener(e -> {
            String ageInput = JOptionPane.showInputDialog(frame, "Introduce tu edad:");
            if (ageInput != null) {
                JOptionPane.showMessageDialog(frame, "Tu edad es: " + ageInput);
            }
        });

        frame.add(ageButton);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Actividad 6: Menú desplegable (JComboBox).
    // Crea una interfaz que tenga un menú desplegable con opciones para elegir un color (por ejemplo: "Rojo", "Verde", "Azul").
    // Al seleccionar un color, muestra el color seleccionado en la consola.
    public static void comboBoxWindow6() {
        JFrame frame = new JFrame("Ejercicio 6");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        JComboBox<String> colorComboBox = new JComboBox<>(new String[]{"Rojo", "Verde", "Azul"});
        colorComboBox.addActionListener(e -> {
            String selectedColor = Objects.requireNonNull(colorComboBox.getSelectedItem()).toString();
            System.out.println("Color seleccionado: " + selectedColor);
        });

        frame.add(colorComboBox);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Actividad 7: Campo de contraseña (JPasswordField).
    // Crea una interfaz con un campo de texto para el nombre de usuario y un campo de contraseña.
    // Al hacer clic en el botón "Iniciar sesión", muestra en la consola el nombre de usuario y la contraseña ingresada
    // (la contraseña puede ser simplemente leída como texto).
    public static void passwordField7() {
        JFrame frame = new JFrame("Ejercicio 7");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel userLabel = new JLabel("Usuario: ");
        JTextField userField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Contraseña: ");
        JPasswordField passwordField = new JPasswordField(20);
        JButton textButton = new JButton("Iniciar Sesion");

        textButton.addActionListener(e -> {
            String user = userField.getText().trim();
            String password = passwordField.getText().trim();

            if (user.isEmpty() || password.isEmpty()) {
                System.out.println("Cubre todos los campos");
            } else {
                System.out.println("Usuario: " + user + ", Contraseña: " + password);
            }
        });


        frame.add(userLabel);
        frame.add(userField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(textButton);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Actividad 8: Radio Buttons (JRadioButton).
    // Crea una interfaz con un grupo de tres botones de opción (radio buttons) que representen opciones de pago:
    // "Tarjeta de Crédito", "PayPal", y "Transferencia Bancaria".
    // Al seleccionar una opción y hacer clic en un botón de "Confirmar", muestra en la consola la opción seleccionada.
    public static void radioWindow8() {
        JFrame frame = new JFrame("Ejercicio 8");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioTarjeta = new JRadioButton("Tarjeta de Crédito");
        JRadioButton radioPaypal = new JRadioButton("Paypal");
        JRadioButton radioTransferencia = new JRadioButton("Transferencia  Bancaria");

        buttonGroup.add(radioTarjeta);
        buttonGroup.add(radioPaypal);
        buttonGroup.add(radioTransferencia);

        JButton confirmButton = new JButton("Confirmar");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioTarjeta.isSelected()) {
                    System.out.println("Opción seleccionada: Tarjeta de Crédito");
                } else if (radioPaypal.isSelected()) {
                    System.out.println("Opción seleccionada: PayPal");
                } else if (radioTransferencia.isSelected()) {
                    System.out.println("Opción seleccionada: Transferencia Bancaria");
                } else {
                    System.out.println("No se ha seleccionado ninguna opción.");
                }
            }
        });

        frame.add(radioTarjeta);
        frame.add(radioPaypal);
        frame.add(radioTransferencia);
        frame.add(confirmButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Actividad 9: Checkbox (JCheckBox).
    // Crea una interfaz con tres casillas de verificación (checkboxes) que representen opciones de toppings para una pizza:
    // "Queso Extra", "Pepperoni", y "Aceitunas".
    // Al hacer clic en el botón "Ordenar", muestra en la consola los toppings seleccionados.
    public static void checkboxWindow9() {
        JFrame frame = new JFrame("Ejercicio 9");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JCheckBox quesoExtra = new JCheckBox("Queso Extra");
        JCheckBox pepperoni = new JCheckBox("Pepperoni");
        JCheckBox aceitunas = new JCheckBox("Aceitunas");
        JButton orderButton = new JButton("Ordenar");

        orderButton.addActionListener(e -> {
            StringBuilder toppings = new StringBuilder("Toppings seleccionados:");
            if (quesoExtra.isSelected()) toppings.append(" Queso Extra,");
            if (pepperoni.isSelected()) toppings.append(" Pepperoni,");
            if (aceitunas.isSelected()) toppings.append(" Aceitunas,");

            if (toppings.length() > 25) {
                toppings.setLength(toppings.length() - 1);
            } else {
                toppings.append(" Ninguno");
            }

            System.out.println(toppings);
        });

        frame.add(quesoExtra);
        frame.add(pepperoni);
        frame.add(aceitunas);
        frame.add(orderButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    // Actividad 10: Menú de barra (JMenuBar y JMenu).
    // Crea una interfaz que tenga un menú en la barra superior con dos opciones: "Archivo" y "Edición".
    // En "Archivo", agrega un submenú "Abrir" y "Guardar".
    // Al seleccionar una de estas opciones, muestra el texto correspondiente en la consola.
    public static void menuBarWindow10() {
        JFrame frame = new JFrame("Ejercicio 10");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 200);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenu editMenu = new JMenu("Edición");

        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Guardar");


        openItem.addActionListener(e -> System.out.println("Opción seleccionada: Abrir"));
        saveItem.addActionListener(e -> System.out.println("Opción seleccionada: Guardar"));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Selector de Actividades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JComboBox<String> activityComboBox = getStringJComboBox();
        JButton executeButton = new JButton("Ejecutar Actividad");

        executeButton.addActionListener(e -> {
            int selectedIndex = activityComboBox.getSelectedIndex();
            switch (selectedIndex) {
                case 0 -> basicWindow1();
                case 1 -> buttonsWindow2();
                case 2 -> textFieldWindow3();
                case 3 -> fullNameWindow4();
                case 4 -> dialogWindow5();
                case 5 -> comboBoxWindow6();
                case 6 -> passwordField7();
                case 7 -> radioWindow8();
                case 8 -> checkboxWindow9();
                case 9 -> menuBarWindow10();
                default -> System.out.println("Selecciona una actividad válida.");
            }
        });


        frame.add(activityComboBox);
        frame.add(executeButton);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JComboBox<String> getStringJComboBox() {
        return new JComboBox<>(new String[]{
                "Ejercicio 1: Ventana básica",
                "Ejercicio 2: Múltiples botones",
                "Ejercicio 3: Campos de texto",
                "Ejercicio 4: Nombre completo",
                "Ejercicio 5: Cuadro de diálogo",
                "Ejercicio 6: Menú desplegable",
                "Ejercicio 7: Campo de contraseña",
                "Ejercicio 8: Radio buttons",
                "Ejercicio 9: Checkbox",
                "Ejercicio 10: Menú de barra"
        });
    }
}


