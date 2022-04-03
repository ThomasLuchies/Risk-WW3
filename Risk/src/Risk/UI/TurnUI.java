package Risk.UI;

import javax.swing.*;
import java.awt.*;

public class TurnUI {
    private JFrame frame;
    private JLabel label;
    private JPanel panel;

    public TurnUI() {
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.label = new JLabel("Hello");
        label.setBounds(0,0,100,50);
        label.setFont(new Font(null, Font.PLAIN, 25));;

        this.frame.add(this.panel);
        this.panel.add(this.label);
    }
}
