package app.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;

public class CharacterSelectPanel extends JPanel {
    private GridLayout mainLayout;
    private JLabel characterSelectLabel;
    private Font labelFont;
    private JButton amaraButton;
    private JButton fl4kButton;
    private JButton mozeButton;
    private JButton zaneButton;
    private JButton backButton;

    public CharacterSelectPanel() {
        initComponents();
    }

    private void initComponents() {
        this.mainLayout = new GridLayout(6, 3);
        this.setLayout(mainLayout);

        this.characterSelectLabel = new JLabel("Select a Character");
        this.labelFont = new Font("Serif", Font.BOLD, 30);
        this.characterSelectLabel.setFont(labelFont);
        this.amaraButton = new JButton("Amara");
        this.fl4kButton = new JButton("Fl4k");
        this.mozeButton = new JButton("Moze");
        this.zaneButton = new JButton("Zane");
        this.backButton = new JButton("Return to Main Menu");

        this.add(new JPanel());
        this.add(characterSelectLabel);
        this.add(new JPanel());

        this.add(new JPanel());
        this.add(amaraButton);
        this.add(new JPanel());

        this.add(new JPanel());
        this.add(fl4kButton);
        this.add(new JPanel());

        this.add(new JPanel());
        this.add(mozeButton);
        this.add(new JPanel());

        this.add(new JPanel());
        this.add(zaneButton);
        this.add(new JPanel());

        this.add(new JPanel());
        this.add(backButton);
        this.add(new JPanel());
    }

    public JButton getAmaraButton() {
        return amaraButton;
    }

    public void setAmaraButton(JButton amaraButton) {
        this.amaraButton = amaraButton;
    }

    public JButton getFl4kButton() {
        return fl4kButton;
    }

    public void setFl4kButton(JButton fl4kButton) {
        this.fl4kButton = fl4kButton;
    }

    public JButton getMozeButton() {
        return mozeButton;
    }

    public void setMozeButton(JButton mozeButton) {
        this.mozeButton = mozeButton;
    }

    public JButton getZaneButton() {
        return zaneButton;
    }

    public void setZaneButton(JButton zaneButton) {
        this.zaneButton = zaneButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }
}