package Risk.UI;

import Risk.Core.Field;

import javax.swing.*;

public class FieldUI
{
    private JButton button;
    private Field field;

    public FieldUI(Field field)
    {
        this.button = new JButton();
        this.field = field;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
