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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton boton = new JButton("Click");

        // Event
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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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


    // Actividad 6: Menú desplegable (JComboBox).
    // Crea una interfaz que tenga un menú desplegable con opciones para elegir un color (por ejemplo: "Rojo", "Verde", "Azul").
    // Al seleccionar un color, muestra el color seleccionado en la consola.

    // Actividad 7: Campo de contraseña (JPasswordField).
    // Crea una interfaz con un campo de texto para el nombre de usuario y un campo de contraseña.
    // Al hacer clic en el botón "Iniciar sesión", muestra en la consola el nombre de usuario y la contraseña ingresada
    // (la contraseña puede ser simplemente leída como texto).

    // Actividad 8: Radio Buttons (JRadioButton).
    // Crea una interfaz con un grupo de tres botones de opción (radio buttons) que representen opciones de pago:
    // "Tarjeta de Crédito", "PayPal", y "Transferencia Bancaria".
    // Al seleccionar una opción y hacer clic en un botón de "Confirmar", muestra en la consola la opción seleccionada.

    // Actividad 9: Checkbox (JCheckBox).
    // Crea una interfaz con tres casillas de verificación (checkboxes) que representen opciones de toppings para una pizza:
    // "Queso Extra", "Pepperoni", y "Aceitunas".
    // Al hacer clic en el botón "Ordenar", muestra en la consola los toppings seleccionados.

    // Actividad 10: Menú de barra (JMenuBar y JMenu).
    // Crea una interfaz que tenga un menú en la barra superior con dos opciones: "Archivo" y "Edición".
    // En "Archivo", agrega un submenú "Abrir" y "Guardar".
    // Al seleccionar una de estas opciones, muestra el texto correspondiente en la consola.

    public static void main(String[] args) {
        basicWindow1();
        buttonsWindow2();
        textFieldWindow3();
        fullNameWindow4();
    }
}


