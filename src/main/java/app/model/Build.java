package app.model;

import java.util.ArrayList;
import java.util.List;

public class Build {
    private String buildName;
    private CharacterModel selectedChar;
    private List<Skill> skillList;
    private int spentPoints;

    public Build() {
        this.buildName = null;
        this.selectedChar = null;
        this.skillList = new ArrayList<>();
        this.spentPoints = 0;
    }

    public void addSpentPoint() {
        ++this.spentPoints;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public CharacterModel getSelectedChar() {
        return selectedChar;
    }

    public void setSelectedChar(CharacterModel selectedChar) {
        this.selectedChar = selectedChar;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public int getSpentPoints() {
        return spentPoints;
    }

    public void setSpentPoints(int spentPoints) {
        this.spentPoints = spentPoints;
    }

}