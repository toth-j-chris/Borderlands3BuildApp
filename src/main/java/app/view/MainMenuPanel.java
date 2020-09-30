package app.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;

public class MainMenuPanel extends JPanel {
    private GridLayout mainLayout;
    private JLabel menuLabel;
    private Font labelFont;
    private JButton newBuild;
    private JButton resumeBuild;
    private JButton loadBuild;

    public MainMenuPanel() {
        initComponents();
    }

    private void initComponents() {
        this.mainLayout = new GridLayout(5, 3);
        setLayout(mainLayout);

        this.menuLabel = new JLabel();
        this.labelFont = new Font("Serif", Font.BOLD, 50);
        menuLabel.setFont(labelFont);
        menuLabel.setText("<html><div style='text-align: center;'>Main Menu</div></html>");
        this.newBuild = new JButton("New Build");
        this.resumeBuild = new JButton("Resume Build");
        this.loadBuild = new JButton("Load Build");
        
        add(new JPanel());
        add(menuLabel);
        add(new JPanel());

        add(new JPanel());
        add(newBuild);
        add(new JPanel());

        add(new JPanel());
        add(resumeBuild);
        add(new JPanel());

        add(new JPanel());
        add(loadBuild);
        add(new JPanel());
    }

    public JButton getNewBuild() {
        return newBuild;
    }

    public void setNewBuild(JButton newBuild) {
        this.newBuild = newBuild;
    }

    public JButton getLoadBuild() {
        return loadBuild;
    }

    public void setLoadBuild(JButton loadBuild) {
        this.loadBuild = loadBuild;
    }

    public JButton getResumeBuild() {
        return resumeBuild;
    }

    public void setResumeBuild(JButton resumeBuild) {
        this.resumeBuild = resumeBuild;
    }
}