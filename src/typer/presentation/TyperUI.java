package typer.presentation;

/**
 * Created with IntelliJ IDEA.
 * User: Piet Jetse
 * Date: 25-12-2014
 * Time: 20:10
 */
import typer.AutoTyper;
import typer.strategies.Typer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TyperUI extends JFrame {

    private JPanel contentPane;
    private JTextField minSleepTextField;
    private JTextField maxSleepTextfield;
    private JTextField sentenceTextfield;

    /**
     * Launch the application.
     */
    public static void initialize() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TyperUI frame = new TyperUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TyperUI() {

        //Panel

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 296, 121);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Labels

        JLabel sentenceLabel = new JLabel("Sentence : ");
        sentenceLabel.setBounds(10, 11, 55, 14);
        contentPane.add(sentenceLabel);

        JLabel sleepBetweenLabel = new JLabel("Sleep Between : ");
        sleepBetweenLabel.setBounds(10, 36, 81, 14);
        contentPane.add(sleepBetweenLabel);

        JLabel andLabel = new JLabel("And ");
        andLabel.setHorizontalAlignment(SwingConstants.CENTER);
        andLabel.setBounds(174, 36, 30, 14);
        contentPane.add(andLabel);

        //TextFields

        minSleepTextField = new JTextField();
        minSleepTextField.setText("1000");
        minSleepTextField.setToolTipText("Min Sleep");
        minSleepTextField.setBounds(101, 33, 63, 20);
        contentPane.add(minSleepTextField);
        minSleepTextField.setColumns(10);

        maxSleepTextfield = new JTextField();
        maxSleepTextfield.setText("3000");
        maxSleepTextfield.setToolTipText("Max Sleep");
        maxSleepTextfield.setColumns(10);
        maxSleepTextfield.setBounds(214, 33, 63, 20);
        contentPane.add(maxSleepTextfield);

        sentenceTextfield = new JTextField();
        sentenceTextfield.setText("My Sentence to Type");
        sentenceTextfield.setBounds(101, 8, 176, 20);
        contentPane.add(sentenceTextfield);
        sentenceTextfield.setColumns(10);

        //Buttons

        JButton startButton = new JButton("Start Script");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AutoTyper.strategies.add(new Typer(
                        sentenceTextfield.getText(),
                        Integer.parseInt(minSleepTextField.getText()),
                        Integer.parseInt(maxSleepTextfield.getText())));
                AutoTyper.initialized = true;
                dispose();
            }
        });
        startButton.setBounds(10, 61, 270, 23);
        contentPane.add(startButton);
    }
}

