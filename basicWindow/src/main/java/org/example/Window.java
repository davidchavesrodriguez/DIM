package org.example;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Window {

    public static void main(String[] args) {
        // create a new frame
        JFrame f = new JFrame("My first JavaSwing Window");

        // create a panel
        JPanel p = new JPanel();

        // create a button with the action command "Click"
        JButton b = new JButton("Basic action");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                URI uri;
                try {
                    uri = new URI("https://static.wikia.nocookie.net/esstarwars/images/5/50/Darth_Maul_profile.png/revision/latest?cb=20150902165521");
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // load image from URL
        ImageIcon image1;
        try {
            image1 = new ImageIcon(ImageIO.read(new URI("https://img.freepik.com/foto-gratis/paisaje-forestal_71767-127.jpg").toURL()));
        } catch (Exception ex) {
            ex.printStackTrace();
            image1 = new ImageIcon(); // fallback if image loading fails
        }

        // add image to frame
        f.add(new JLabel(image1), BorderLayout.CENTER);

        // add button to panel
        p.add(b);

        // add panel to frame
        f.add(p, BorderLayout.SOUTH);

        // set the size and default close operation of the frame
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set frame visibility
        f.setVisible(true);
    }
}
