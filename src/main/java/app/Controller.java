package app;

import app.model.Model;

import java.util.List;

import app.model.Build;
import app.model.CharacterModel;

public class Controller {
    private Model model;
    private Build currBuild;
    private CharacterModel amara;
    private CharacterModel fl4k;
    private CharacterModel moze;
    private CharacterModel zane;

    public Controller(Model model) {
        this.model = model;
        this.currBuild = model.getCurrBuild();
        this.amara = model.getAmara();
        this.fl4k = model.getFl4k();
        this.moze = model.getMoze();
        this.zane = model.getZane();
    }

    public void saveCurrBuild(Build build) {
        this.model.saveCurrBuild(build);
    }

    public void loadCurrBuild() {
        this.model.loadCurrBuild();
        this.currBuild = this.model.getCurrBuild();
    }

    public void newCurrBuild() {
        this.model.newCurrBuild();
        this.currBuild = model.getCurrBuild();
    }

    public boolean addSavedBuild(String buildName) {
        return this.model.addSavedBuild(buildName);
    }

    public List<Build> getSavedBuilds() {
        return this.model.getSavedBuilds();
    }

    public void loadSavedBuilds() {
        this.model.loadSavedBuilds();
    }
    
    public Build getCurrBuild() {
        return this.currBuild;
    }

    public void loadAmara() {
        this.model.loadAmara();
    }

    public void loadFl4k() {
        this.model.loadFl4k();
    }

    public void loadMoze() {
        this.model.loadMoze();
    }

    public void loadZane() {
        this.model.loadZane();
    }

    public void reloadAmara() {
        this.amara = this.model.getAmara();
    }

    public void reloadFl4k() {
        this.fl4k = this.model.getFl4k();
    }

    public void reloadMoze() {
        this.moze = this.model.getMoze();
    }

    public void reloadZane() {
        this.zane = this.model.getZane();
    }

    public CharacterModel getAmara() {
        return this.amara;
    }

    public CharacterModel getFl4k() {
        return this.fl4k;
    }

    public CharacterModel getMoze() {
        return this.moze;
    }

    public CharacterModel getZane() {
        return this.zane;
    }
}