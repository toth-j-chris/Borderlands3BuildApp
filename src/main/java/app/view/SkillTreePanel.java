package app.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

import app.model.CharacterModel;
import app.model.Skill;

public class SkillTreePanel extends JPanel {
    private CharacterModel character;
    private int treeNum;
    private JLabel treeLabel;
    private Font treeLabelFont;
    private GridBagLayout mainLayout;
    private ToolTipManager tipMan;
    private GridBagConstraints constraints;
    private Map<JButton, Skill> treeMap;
    private List<JButton> buttonList;

    public SkillTreePanel(CharacterModel character, int treeNum) {
        this.character = character;
        this.treeNum = treeNum;
        this.treeLabel = new JLabel(character.findSkillTreeByNum(treeNum).getSkillTreeName());
        this.treeLabelFont = new Font("Serif", Font.BOLD, 30);
        this.treeLabel.setForeground(Color.WHITE);
        initTree();
        setVisible(true);
    }

    private void initTree() {
        this.mainLayout = new GridBagLayout();
        this.tipMan = ToolTipManager.sharedInstance();
        this.constraints = new GridBagConstraints();
        setLayout(mainLayout);

        tipMan.setInitialDelay(0);
        tipMan.setDismissDelay(1000 * 1000);

        List<Skill> skillList = character.findSkillTreeByNum(treeNum).getSkillList();
        this.treeMap = new HashMap<>();
        this.buttonList = new ArrayList<>();

        constraints.gridx = 3;
        constraints.gridy = 0;
        add(treeLabel, constraints);
        for (Skill skill : skillList) {
            JButton skillButton = new JButton();
            String buttonString = "<html><div style='text-align: center;'>" + skill.getSkillName() + "<br>"
                    + skill.getCurrPoints() + "/" + skill.getMaxPoints() + "</div></html>";
            skillButton.setSize(50, 50);
            if (skill.getMaxPoints() != -1) {
                skillButton.setText(buttonString);
                if (skill.getCurrPoints() == skill.getMaxPoints()) {
                    skillButton.setToolTipText("<html>" + skill.getSkillDesc() + "<br><br>" + "Current Rank:<br>"
                            + skill.findTierByNum(skill.getCurrPoints()).getTierDesc() + "</html>");
                } else if (skill.getCurrPoints() > 0) {
                    skillButton.setToolTipText("<html>" + skill.getSkillDesc() + "<br><br>" + "Current Rank:<br>"
                            + skill.findTierByNum(skill.getCurrPoints()).getTierDesc() + "<br><br>Next Rank:<br>"
                            + skill.findTierByNum(skill.getCurrPoints() + 1).getTierDesc() + "</html>");
                } else {
                    skillButton.setToolTipText("<html>" + skill.getSkillDesc() + "<br><br>" + "Next Rank:<br>"
                            + skill.findTierByNum(1).getTierDesc() + "</html>");
                }
            } else {
                skillButton.setText(skill.getSkillName());
                skillButton.setToolTipText("<html>" + skill.getSkillDesc() + "<br><br>"
                        + skill.findTierByNum(skill.getCurrPoints()).getTierDesc() + "</html>");
            }
            constraints.fill = GridBagConstraints.BOTH;
            constraints.gridx = skill.getColNum();
            constraints.gridy = skill.getRowNum();
            add(skillButton, constraints);
            treeMap.put(skillButton, skill);
            buttonList.add(skillButton);
        }
    }

    public Map<JButton, Skill> getTreeMap() {
        return this.treeMap;
    }

    public List<JButton> getButtonList() {
        return this.buttonList;
    }
}