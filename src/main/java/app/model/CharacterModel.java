package app.model;

public class CharacterModel {
    private String charName;
    private SkillTree skillTree1;
    private SkillTree skillTree2;
    private SkillTree skillTree3;

    public SkillTree findSkillTreeByNum(int selected) {
        switch (selected) {
            case 1:
            return skillTree1;
            case 2:
            return skillTree2;
            case 3:
            return skillTree3;
        }
        return null;
    } 

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public SkillTree getSkillTree1() {
        return skillTree1;
    }

    public void setSkillTree1(SkillTree skillTree1) {
        this.skillTree1 = skillTree1;
    }

    public SkillTree getSkillTree2() {
        return skillTree2;
    }

    public void setSkillTree2(SkillTree skillTree2) {
        this.skillTree2 = skillTree2;
    }

    public SkillTree getSkillTree3() {
        return skillTree3;
    }

    public void setSkillTree3(SkillTree skillTree3) {
        this.skillTree3 = skillTree3;
    }

}