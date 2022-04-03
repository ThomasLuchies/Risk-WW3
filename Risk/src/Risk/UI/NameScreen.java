package Risk.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameScreen implements ActionListener {

    private JFrame frame;
    private JFrame frame1;
    private JPanel panel;;
    private JPanel panel1;
    private JLabel title;
    private JLabel title2;
    private JLabel error;
    private JTextField player1Name;
    private JTextField player2Name;
    private JButton submit;
    private String enter;

    public NameScreen()
    {
        this.frame = new JFrame();

        this.title = new JLabel("Player 1");
        this.title2 = new JLabel("Player 2");
        this.error = new JLabel();
        this.player1Name = new JTextField("Player 1", 10);
        this.player2Name = new JTextField("Player 2", 10);
        this.submit = new JButton("Submit");
        this.submit.setBounds(100,160,200,40);
        this.submit.setFocusable(false);
        this.submit.addActionListener(this);

        this.panel = new JPanel();
//        this.panel.setBackground(Color.black);
        this.panel.setLayout(new GridLayout(0,2));
        this.panel.setSize(1000,1000);
        this.panel.setBounds(0,0 ,1000,1000);
        this.panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        this.panel.add(this.title);
        this.panel.add(this.player1Name);
        this.panel.add(this.title2);
        this.panel.add(this.player2Name);
        this.panel.add(this.error);
        this.panel.add(this.submit);

        this.frame.add(this.panel, BorderLayout.CENTER);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(666, 420);
        this.frame.setTitle("Risk WO III");
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.submit)
        {
            if(this.player1Name.getText().length() == 0 || this.player2Name.getText().length() == 0)
            {
                this.error.setText("Fill in both players names");
            }
            else
            {
                frame.dispose();
                BordUI bordUI = new BordUI();
            }
        }
    }
}
