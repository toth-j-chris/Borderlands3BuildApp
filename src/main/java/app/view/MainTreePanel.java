package app.view;

import app.model.CharacterModel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class MainTreePanel extends JPanel {
    private GridLayout mainLayout;
    private CharacterModel character;
    private List<SkillTreePanel> skillTreePanels;

    public MainTreePanel(CharacterModel character) {
        this.character = character;
        initComponents();
    }

    private void initComponents() {
        this.mainLayout = new GridLayout(0, 3);
        this.setLayout(mainLayout);
        this.skillTreePanels = new ArrayList<>();
        for (int i = 1; i <= 3; ++i) {
            SkillTreePanel skillTreePanel = new SkillTreePanel(character, i);
            skillTreePanels.add(skillTreePanel);
            switch(i) {
                case 1:
                skillTreePanel.setBackground(Color.GREEN);
                break;
                case 2:
                skillTreePanel.setBackground(Color.BLUE);
                break;
                case 3:
                skillTreePanel.setBackground(Color.RED);
                break;
            }
            add(skillTreePanel);
        }

        setVisible(true);
    }

    public List<SkillTreePanel> getSkillTreePanels() {
        return this.skillTreePanels;
    }
}