package app.model;

import java.util.List;

public class Skill {
    private String skillName;
    private String skillType;
    private String skillDesc;
    private int treeNum;
    private int rowNum;
    private int colNum;
    private int maxPoints;
    private int currPoints;
    private List<SkillTier> skillTiers;

    public void addPoint() {
        this.currPoints = this.currPoints + 1;
    }

    public SkillTier findTierByNum(int tierNum) {
        for (SkillTier tier : skillTiers) {
            if (tier.getTierNum() == tierNum) {
                return tier;
            }
        }
        return null;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }

    public int getTreeNum() {
        return treeNum;
    }

    public void setTreeNum(int treeNum) {
        this.treeNum = treeNum;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public int getCurrPoints() {
        return currPoints;
    }

    public void setCurrPoints(int currPoints) {
        this.currPoints = currPoints;
    }

    public List<SkillTier> getSkillTiers() {
        return skillTiers;
    }

    public void setSkillTiers(List<SkillTier> skillTiers) {
        this.skillTiers = skillTiers;
    }
}