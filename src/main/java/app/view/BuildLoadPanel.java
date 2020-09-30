package app.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import app.model.Build;

public class BuildLoadPanel extends JPanel {
    private List<Build> savedBuilds;
    private GridBagLayout mainLayout;
    private GridBagConstraints constraints;
    private GridLayout panelLayout;
    private JPanel scrollPanePanel;
    private JScrollPane scrollPane;
    private Map<JButton, Build> loadMap;
    private List<JButton> buttonList;
    private JButton backButton;

    public BuildLoadPanel(List<Build> savedBuilds) {
        this.savedBuilds = savedBuilds;
        initComponents();
    }

    private void initComponents() {
        this.mainLayout = new GridBagLayout();
        this.constraints = new GridBagConstraints();
        this.panelLayout = new GridLayout(0, 2);
        this.setLayout(mainLayout);

        this.backButton = new JButton("Back");

        this.scrollPanePanel = new JPanel();
        this.scrollPanePanel.setLayout(panelLayout);
        this.loadMap = new HashMap<>();
        this.buttonList = new ArrayList<>();
        for (Build build : savedBuilds) {
            JLabel label = new JLabel(build.getBuildName());
            JButton button = new JButton("Load");
            this.loadMap.put(button, build);
            this.buttonList.add(button);
            this.scrollPanePanel.add(label);
            this.scrollPanePanel.add(button);
        }
        this.scrollPane = new JScrollPane(scrollPanePanel);

        this.scrollPane.setPreferredSize(new Dimension(400, 600));

        constraints.anchor = GridBagConstraints.NORTHWEST;
        this.add(backButton, constraints);
        constraints.anchor = GridBagConstraints.CENTER;
        this.add(scrollPane, constraints);
    }

    public Map<JButton, Build> getLoadMap() {
        return loadMap;
    }

    public void setLoadMap(Map<JButton, Build> loadMap) {
        this.loadMap = loadMap;
    }

    public List<JButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<JButton> buttonList) {
        this.buttonList = buttonList;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }
}