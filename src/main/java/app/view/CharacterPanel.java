package app.view;

import app.model.CharacterModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;

public class CharacterPanel extends JPanel {
    private Dimension screenSize;
    private CharacterModel character;
    private GridBagLayout mainLayout;
    private GridBagConstraints constraints;
    private MainTreePanel mainTreePanel;
    private JLabel charLabel;
    private JLabel buildNameLabel;
    private JTextField buildNameField;
    private JButton saveButton;
    private JButton backButton;
    private Font charLabelFont;

    public CharacterPanel(CharacterModel character) {
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        this.character = character;
        initComponents();
    }

    private void initComponents() {
        this.mainLayout = new GridBagLayout();
        this.constraints = new GridBagConstraints();
        this.mainTreePanel = new MainTreePanel(character);
        this.charLabel = new JLabel(character.getCharName());
        this.saveButton = new JButton("Save Build");
        this.backButton = new JButton("Back");
        this.charLabelFont = new Font("Serif", Font.BOLD, 50);
        this.charLabel.setFont(charLabelFont);
        this.buildNameLabel = new JLabel("Enter Build Name to Save:");
        this.buildNameField = new JTextField(20);
        this.setLayout(mainLayout);

        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.gridy = 0;
        constraints.weightx = 1;
        this.add(backButton, constraints);

        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.ipady = 40;
        constraints.gridy = 1;
        constraints.weightx = 0;
        this.add(charLabel, constraints);

        constraints.ipady = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridy = 2;
        this.add(mainTreePanel, constraints);

        constraints.gridy = 3;
        this.add(buildNameLabel, constraints);

        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(0, 750, 0, 750);
        this.add(buildNameField, constraints);

        constraints.gridy = 5;
        constraints.fill = 0;
        this.add(saveButton, constraints);
        this.setVisible(true);
    }

    public MainTreePanel getMainTreePanel() {
        return this.mainTreePanel;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

    public JLabel getBuildNameLabel() {
        return buildNameLabel;
    }

    public void setBuildNameLabel(JLabel buildNameLabel) {
        this.buildNameLabel = buildNameLabel;
    }

    public JTextField getBuildNameField() {
        return buildNameField;
    }

    public void setBuildNameField(JTextField buildNameField) {
        this.buildNameField = buildNameField;
    }
}