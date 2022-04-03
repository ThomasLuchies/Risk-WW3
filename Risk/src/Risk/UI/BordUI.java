package Risk.UI;

import Risk.Core.Coords;
import Risk.Core.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BordUI implements ActionListener {
    private JFrame frame;
    private JLabel label;
    private JPanel panel;
    private int y;
    private int x;
    private FieldUI fieldUI;

    BordUI()
    {
        this.panel = new JPanel();
        this.frame = new JFrame();
        this.label = new JLabel("Hello");
        label.setBounds(0,0,100,50);
        label.setFont(new Font(null, Font.PLAIN, 25));

//        this.panel.add(this.label);

        this.panel.setLayout(new GridLayout(0,3));
        this.frame.add(this.panel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(666, 420);
        this.frame.setTitle("Risk WO III");
        this.frame.pack();
        this.frame.setVisible(true);

        for(y = 0; y < 3; y++)
        {
            for(x = 0; x < 3; x++)
            {
                this.fieldUI = new FieldUI(new Field(null, new Coords(x, y)));
                this.fieldUI.getButton().addActionListener(this);
                this.panel.add(this.fieldUI.getButton());
            }

        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.fieldUI)
        {
            frame.dispose();
            TurnUI turnUI = new TurnUI();
        }
    }
}
