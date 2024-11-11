package org.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private boolean isModified = false;

    public TextEditor() {
        setTitle("Editor de Texto");
        setSize(600, 400);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                isModified = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                isModified = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                isModified = true;
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Configurar el JFileChooser con un filtro para archivos txt y md
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                // Permitir solo directorios y archivos con extensión txt o md
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt") || f.getName().toLowerCase().endsWith(".md");
            }

            @Override
            public String getDescription() {
                return "Archivos de texto (*.txt, *.md)";
            }
        });

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu fileMenu = new JMenu("Archivo");

        JMenuItem openItem = new JMenuItem("Abrir");
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openItem.addActionListener(e -> openFile());

        JMenuItem saveItem = new JMenuItem("Guardar");
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveItem.addActionListener(e -> saveFile());

        JMenuItem exitItem = new JMenuItem("Salir");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        exitItem.addActionListener(e -> exitApp());

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Menú Ayuda
        JMenu helpMenu = new JMenu("Ayuda");

        JMenuItem aboutItem = new JMenuItem("Acerca de");
        aboutItem.addActionListener(e -> showHelpDialog());

        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // Confirmación antes de cerrar si hay cambios sin guardar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApp();
            }
        });
    }

    // Método para abrir un archivo y cargar su contenido
    private void openFile() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Verificar la extensión del archivo
            String fileName = file.getName().toLowerCase();
            if (!fileName.endsWith(".txt") && !fileName.endsWith(".md")) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione un archivo con extensión .txt o .md.",
                        "Extensión no válida", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                isModified = false;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al abrir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para guardar el contenido en un archivo
    private void saveFile() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
                isModified = false;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para salir de la aplicación
    private void exitApp() {
        if (isModified) {
            int option = JOptionPane.showConfirmDialog(this, "Hay cambios sin guardar. ¿Desea salir?", "Salir",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    // Mostrar ayuda
    private void showHelpDialog() {
        JOptionPane.showMessageDialog(this,
                "Editor de Texto Básico\n\n"
                        + "Este es un editor de texto simple que permite:\n"
                        + " - Abrir archivos de texto y ver su contenido.\n"
                        + " - Guardar el contenido editado en un archivo.\n\n"
                        + "Atajos:\n"
                        + " - Ctrl+O: Abrir archivo\n"
                        + " - Ctrl+S: Guardar archivo\n"
                        + " - Ctrl+Q: Salir del programa\n\n"
                        + "Contacto:\n"
                        + " - email: A22DavidCR@iessanclemente.net\n"
                        + " - linkedin: https://www.linkedin.com/in/chaves19/",
                "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TextEditor().setVisible(true));
    }
}
