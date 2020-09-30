package app.model;

import java.util.List;

public class SkillTree {
    private int treeNum;
    private String skillTreeName;
    private List<Skill> skillList;
    
    public void add(Skill skill) {
        skillList.add(skill);
    }
    
    public int getTreeNum() {
        return treeNum;
    }

    public void setTreeNum(int treeNum) {
        this.treeNum = treeNum;
    }

    public String getSkillTreeName() {
        return skillTreeName;
    }

    public void setSkillTreeName(String skillTreeName) {
        this.skillTreeName = skillTreeName;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

}