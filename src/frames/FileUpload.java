package frames;

import java.io.BufferedReader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileUpload extends JFrame {

    public FileUpload() throws IOException {
        super();
        // Initial setu[
        setTitle("Rules Of Santorini Board Game");

        // Create the basic UI content
        JTextArea textArea = new JTextArea(40, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("resources/New Text Document.txt")))) {
            textArea.read(reader, "File");
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        getContentPane().setBackground(Color.ORANGE);

        JButton ok = new JButton("Got It");
        add(textArea, BorderLayout.SOUTH);
        add(ok, BorderLayout.SOUTH);

        ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}