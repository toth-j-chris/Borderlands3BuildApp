package app.model;

import javax.json.bind.JsonbBuilder;
import javax.json.bind.Jsonb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private Jsonb jsonb;
    private Build currBuild;
    private CharacterModel amara;
    private CharacterModel fl4k;
    private CharacterModel moze;
    private CharacterModel zane;
    private List<CharacterModel> charList;
    private List<Build> savedBuilds;

    public Model() {
        this.jsonb = JsonbBuilder.create();
        loadCurrBuild();
        loadSavedBuilds();
        loadAmara();
        loadFl4k();
        loadMoze();
        loadZane();
        addCharsToList();
    }

    public void saveCurrBuild(Build build) {
        String fileString = "CurrentBuild.json";
        try {
            jsonb.toJson(build, new FileWriter(fileString));
        } catch (IOException err) {
            System.out.println(err.getMessage());
            err.printStackTrace();
        }
    }

    public void loadCurrBuild() {
        String fileName = "CurrentBuild.json";
        File currBuildFile = new File(fileName);
        if (currBuildFile.exists()) {
            try (InputStream inputStream = new FileInputStream(fileName)) {
                Build build = JsonbBuilder.create().fromJson(inputStream, Build.class);
                this.currBuild = build;
                String selectedCharName = build.getSelectedChar().getCharName();
                if (selectedCharName.equals("Amara")) {
                    this.amara = build.getSelectedChar();
                } else if (selectedCharName.equals("Fl4k")) {
                    this.fl4k = build.getSelectedChar();
                } else if (selectedCharName.equals("Moze")) {
                    this.moze = build.getSelectedChar();
                } else if (selectedCharName.equals("Zane")) {
                    this.zane = build.getSelectedChar();
                } else {
                    this.currBuild = new Build();
                    currBuild.setBuildName("CurrentBuild");
                }
            } catch (IOException err) {
                err.printStackTrace();
                System.out.println(err.getMessage());
            }
        } else {
            this.currBuild = new Build();
            currBuild.setBuildName("CurrentBuild");
        }
    }

    public void newCurrBuild() {
        this.currBuild = new Build();
        this.currBuild.setBuildName("CurrentBuild");
    }

    public void loadSavedBuilds() {
        String fileName = "SavedBuilds.json";
        File savedBuildsFile = new File(fileName);
        if (savedBuildsFile.exists()) {
            try (InputStream inputStream = new FileInputStream(fileName)) {
                this.savedBuilds = new ArrayList<>();
                this.savedBuilds = JsonbBuilder.create().fromJson(inputStream, new ArrayList<Build>() {
                }.getClass().getGenericSuperclass());
            } catch (IOException err) {
                err.printStackTrace();
                System.out.println(err.getMessage());
            }
        } else {
            this.savedBuilds = new ArrayList<>();
        }
    }

    public boolean addSavedBuild(String buildName) {
        if (checkSaved(buildName)) {
            return false;
        } else {
            Build savedBuild = new Build();
            savedBuild.setBuildName(buildName);
            savedBuild.setSelectedChar(this.currBuild.getSelectedChar());
            savedBuild.setSkillList(this.currBuild.getSkillList());
            savedBuild.setSpentPoints(this.currBuild.getSpentPoints());
            savedBuild.setBuildName(buildName);
            this.savedBuilds.add(savedBuild);
            try {
                String fileName = "SavedBuilds.json";
                jsonb.toJson(this.savedBuilds, new FileWriter(fileName));
                return true;
            } catch (IOException err) {
                err.printStackTrace();
                System.out.println(err.getMessage());
            }
            return false;
        }
    }

    private boolean checkSaved(String buildName) {
        List<String> savedNames = new ArrayList<>();
        for (Build build : this.savedBuilds) {
            savedNames.add(build.getBuildName());
        }
        if (savedNames.contains(buildName)) {
            return true;
        } else {
            return false;
        }
    }

    public void loadAmara() {
        String fileName = "Amara.json";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            this.amara = JsonbBuilder.create().fromJson(inputStream, CharacterModel.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void loadFl4k() {
        String fileName = "Fl4k.json";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            this.fl4k = JsonbBuilder.create().fromJson(inputStream, CharacterModel.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void loadMoze() {
        String fileName = "Moze.json";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            this.moze = JsonbBuilder.create().fromJson(inputStream, CharacterModel.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void loadZane() {
        String fileName = "Zane.json";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            this.zane = JsonbBuilder.create().fromJson(inputStream, CharacterModel.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void addCharsToList() {
        this.charList = new ArrayList<>();
        charList.add(this.amara);
        charList.add(this.fl4k);
        charList.add(this.moze);
        charList.add(this.zane);
    }

    public CharacterModel getAmara() {
        return this.amara;
    }

    public void setAmara(CharacterModel amara) {
        this.amara = amara;
    }

    public CharacterModel getMoze() {
        return moze;
    }

    public void setMoze(CharacterModel moze) {
        this.moze = moze;
    }

    public CharacterModel getZane() {
        return zane;
    }

    public void setZane(CharacterModel zane) {
        this.zane = zane;
    }

    public Build getCurrBuild() {
        return currBuild;
    }

    public void setCurrBuild(Build currBuild) {
        this.currBuild = currBuild;
    }

    public List<Build> getSavedBuilds() {
        return savedBuilds;
    }

    public void setSavedBuilds(List<Build> savedBuilds) {
        this.savedBuilds = savedBuilds;
    }

    public CharacterModel getFl4k() {
        return fl4k;
    }

    public void setFl4k(CharacterModel fl4k) {
        this.fl4k = fl4k;
    }
}