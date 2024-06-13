/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yubra
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

public class Yubrajproject extends JFrame implements ActionListener {

      private JLabel titleLabel;
    private JLabel inputLabel;
    private JTextArea inputArea;
    private JButton encodeButton;
    private JButton decodeButton;
    private JButton clearButton;
    private JButton exitButton;
    private JTextArea outputArea;


    public Yubrajproject() {
        setTitle("Base64 Encoder/Decoder");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
         // Set background color
        getContentPane().setBackground(new Color(240, 240, 240)); // Light gray color
        
        titleLabel = new JLabel("Base64 Encoder/Decoder");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(120, 20, 300, 30);
        add(titleLabel);

        inputLabel = new JLabel("Enter message:");
        inputLabel.setBounds(20, 70, 120, 20);
        add(inputLabel);

        JScrollPane inputScrollPane = new JScrollPane();
        inputScrollPane.setBounds(150, 70, 250, 100);
        inputScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        inputScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS); // Enable horizontal scroll bar
        inputArea = new JTextArea();
        inputScrollPane.setViewportView(inputArea);
        add(inputScrollPane);


        encodeButton = new JButton("Encode");
        encodeButton.setBounds(50, 190, 100, 30);
        encodeButton.addActionListener(this);
        add(encodeButton);

        decodeButton = new JButton("Decode");
        decodeButton.setBounds(180, 190, 100, 30);
        decodeButton.addActionListener(this);
        add(decodeButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(310, 190, 100, 30);
        clearButton.addActionListener(this);
        add(clearButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(180, 240, 100, 30);
        exitButton.addActionListener(this);
        add(exitButton);

        outputArea = new JTextArea();
        JScrollPane outputScrollPane = new JScrollPane(outputArea);
        outputScrollPane.setBounds(20, 280, 450, 100);
        outputScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        outputScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(outputScrollPane);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encodeButton) {
            String plainText = inputArea.getText();
            if (plainText.isEmpty()) {
                outputArea.setText("Error: Please enter a message to encode.");
                return;
            }
            try {
                String encodedText = Base64.getEncoder().encodeToString(plainText.getBytes());
                outputArea.setText("Encoded message:\n" + encodedText);
            } catch (Exception ex) {
                outputArea.setText("Error occurred while encoding the message: " + ex.getMessage());
            }
        } else if (e.getSource() == decodeButton) {
            String encodedText = inputArea.getText();
            if (encodedText.isEmpty()) {
                outputArea.setText("Error: Please enter a message to decode.");
                return;
            }
            try {
                byte[] decodedBytes = Base64.getDecoder().decode(encodedText);
                String decodedText = new String(decodedBytes);
                outputArea.setText("Decoded message:\n" + decodedText);
            } catch (IllegalArgumentException ex) {
                  outputArea.setText("Invalid Base64 encoded message: invalid decode message");
            } catch (Exception ex) {
                outputArea.setText("Error occurred while decoding the message: " + ex.getMessage());
            }
        } else if (e.getSource() == clearButton) {
            inputArea.setText("");
            outputArea.setText("");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Yubrajproject().setVisible(true);
            }
        });
    }
}




