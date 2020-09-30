package app.view;

import app.model.Skill;
import app.model.Build;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import app.Controller;

public class View {
    private Controller controller;
    private AppFrame appFrame;
    private MainMenuPanel mainMenuPanel;
    private CharacterSelectPanel charSelectPanel;
    private BuildLoadPanel buildLoadPanel;
    private CharacterPanel amaraPanel;
    private CharacterPanel fl4kPanel;
    private CharacterPanel mozePanel;
    private CharacterPanel zanePanel;

    public View(Controller controller) {
        this.controller = controller;
        this.initComponents();
        this.addMainMenuListeners();
        this.addCharSelectListeners();

    }

    private void initComponents() {
        this.controller.loadCurrBuild();
        this.appFrame = new AppFrame();
        this.mainMenuPanel = new MainMenuPanel();
        checkResumeEnable();
        this.charSelectPanel = new CharacterSelectPanel();
        this.buildLoadPanel = new BuildLoadPanel(controller.getSavedBuilds());
        this.appFrame.add(mainMenuPanel);
        this.appFrame.repaint();
        this.appFrame.revalidate();
    }

    private void checkResumeEnable() {
        if (this.controller.getCurrBuild().getSelectedChar() == null) {
            this.mainMenuPanel.getResumeBuild().setEnabled(false);
        } else {
            this.mainMenuPanel.getResumeBuild().setEnabled(true);
        }
    }

    private void addMainMenuListeners() {
        this.mainMenuPanel.getNewBuild().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newBuildAction();
            }
        });
        this.mainMenuPanel.getResumeBuild().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resumeBuildAction();
            }
        });
        this.mainMenuPanel.getLoadBuild().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadBuildAction();
            }
        });
    }

    private void newBuildAction() {
        this.mainMenuPanel.setVisible(false);
        this.charSelectPanel.setVisible(true);
        this.appFrame.getContentPane().removeAll();
        this.appFrame.getContentPane().add(charSelectPanel);
        this.appFrame.getContentPane().revalidate();
    }

    private void resumeBuildAction() {
        this.controller.loadCurrBuild();
        this.mainMenuPanel.setVisible(false);
        this.reloadCharPanel();
    }

    private void reloadCharPanel() {
        if (this.controller.getCurrBuild().getSelectedChar().getCharName().equals("Amara")) {
            this.controller.reloadAmara();
            this.amaraPanel = new CharacterPanel(controller.getCurrBuild().getSelectedChar());
            this.addSkillTreeListeners(amaraPanel);
            this.amaraPanel.setVisible(true);
            this.appFrame.getContentPane().removeAll();
            this.appFrame.getContentPane().add(amaraPanel);
            this.appFrame.getContentPane().revalidate();
        } else if (this.controller.getCurrBuild().getSelectedChar().getCharName().equals("Fl4k")) {
            this.controller.reloadFl4k();
            this.fl4kPanel = new CharacterPanel(controller.getCurrBuild().getSelectedChar());
            this.addSkillTreeListeners(fl4kPanel);
            this.fl4kPanel.setVisible(true);
            this.appFrame.getContentPane().removeAll();
            this.appFrame.getContentPane().add(fl4kPanel);
            this.appFrame.getContentPane().revalidate();
        } else if (this.controller.getCurrBuild().getSelectedChar().getCharName().equals("Moze")) {
            this.controller.reloadMoze();
            this.mozePanel = new CharacterPanel(controller.getCurrBuild().getSelectedChar());
            this.addSkillTreeListeners(mozePanel);
            this.mozePanel.setVisible(true);
            this.appFrame.getContentPane().removeAll();
            this.appFrame.getContentPane().add(mozePanel);
            this.appFrame.getContentPane().revalidate();
        } else if (this.controller.getCurrBuild().getSelectedChar().getCharName().equals("Zane")) {
            this.controller.reloadZane();
            this.zanePanel = new CharacterPanel(controller.getCurrBuild().getSelectedChar());
            this.addSkillTreeListeners(zanePanel);
            this.zanePanel.setVisible(true);
            this.appFrame.getContentPane().removeAll();
            this.appFrame.getContentPane().add(zanePanel);
            this.appFrame.getContentPane().revalidate();
        }
    }

    private void loadBuildAction() {
        this.controller.loadSavedBuilds();
        this.buildLoadPanel = new BuildLoadPanel(controller.getSavedBuilds());
        this.addBuildLoadListeners();
        this.mainMenuPanel.setVisible(false);
        this.buildLoadPanel.setVisible(true);
        this.appFrame.getContentPane().removeAll();
        this.appFrame.getContentPane().add(buildLoadPanel);
        this.appFrame.getContentPane().revalidate();
    }

    private void addCharSelectListeners() {
        this.charSelectPanel.getAmaraButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amaraButtonAction();
            }
        });
        this.charSelectPanel.getFl4kButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fl4kButtonAction();
            }
        });
        this.charSelectPanel.getMozeButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mozeButtonAction();
            }
        });
        this.charSelectPanel.getZaneButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zaneButtonAction();
            }
        });
        this.charSelectPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnToMainMenu();
            }
        });
    }

    private void amaraButtonAction() {
        this.controller.newCurrBuild();
        this.controller.loadAmara();
        this.controller.reloadAmara();
        this.controller.getCurrBuild().setSelectedChar(controller.getAmara());
        this.controller.saveCurrBuild(this.controller.getCurrBuild());
        this.amaraPanel = new CharacterPanel(controller.getAmara());
        this.addSkillTreeListeners(amaraPanel);
        this.charSelectPanel.setVisible(false);
        this.amaraPanel.setVisible(true);
        this.appFrame.getContentPane().removeAll();
        this.appFrame.getContentPane().add(amaraPanel);
        this.appFrame.getContentPane().revalidate();
    }

    private void fl4kButtonAction() {
        this.controller.newCurrBuild();
        this.controller.loadFl4k();
        this.controller.reloadFl4k();
        this.controller.getCurrBuild().setSelectedChar(controller.getFl4k());
        this.controller.saveCurrBuild(this.controller.getCurrBuild());
        this.fl4kPanel = new CharacterPanel(controller.getFl4k());
        this.addSkillTreeListeners(fl4kPanel);
        this.charSelectPanel.setVisible(false);
        this.fl4kPanel.setVisible(true);
        this.appFrame.getContentPane().removeAll();
        this.appFrame.getContentPane().add(fl4kPanel);
        this.appFrame.getContentPane().revalidate();
    }

    private void mozeButtonAction() {
        this.controller.newCurrBuild();
        this.controller.loadMoze();
        this.controller.reloadMoze();
        this.controller.getCurrBuild().setSelectedChar(controller.getMoze());
        this.controller.saveCurrBuild(this.controller.getCurrBuild());
        this.mozePanel = new CharacterPanel(controller.getMoze());
        this.addSkillTreeListeners(mozePanel);
        this.charSelectPanel.setVisible(false);
        this.mozePanel.setVisible(true);
        this.appFrame.getContentPane().removeAll();
        this.appFrame.getContentPane().add(mozePanel);
        this.appFrame.getContentPane().revalidate();
    }

    private void zaneButtonAction() {
        this.controller.newCurrBuild();
        this.controller.loadZane();
        this.controller.reloadZane();
        this.controller.getCurrBuild().setSelectedChar(controller.getZane());
        this.controller.saveCurrBuild(this.controller.getCurrBuild());
        this.zanePanel = new CharacterPanel(controller.getZane());
        this.addSkillTreeListeners(zanePanel);
        this.charSelectPanel.setVisible(false);
        this.zanePanel.setVisible(true);
        this.appFrame.getContentPane().removeAll();
        this.appFrame.getContentPane().add(zanePanel);
        this.appFrame.getContentPane().revalidate();
    }

    private void returnToMainMenu() {
        this.charSelectPanel.setVisible(false);
        this.buildLoadPanel.setVisible(false);
        this.mainMenuPanel.setVisible(true);
        this.checkResumeEnable();
        this.appFrame.getContentPane().removeAll();
        this.appFrame.getContentPane().add(mainMenuPanel);
        this.appFrame.getContentPane().revalidate();
    }

    private void addSkillTreeListeners(CharacterPanel characterPanel) {
        addSkillListener(characterPanel);
        addSaveButtonListener(characterPanel);
        characterPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                characterPanel.setVisible(false);
                mainMenuPanel.setVisible(true);
                checkResumeEnable();
                appFrame.getContentPane().removeAll();
                appFrame.getContentPane().add(mainMenuPanel);
                appFrame.getContentPane().revalidate();
            }
        });
    }

    private void addSkillListener(CharacterPanel characterPanel) {
        List<SkillTreePanel> skillTreePanels = characterPanel.getMainTreePanel().getSkillTreePanels();
        for (SkillTreePanel skillTreePanel : skillTreePanels) {
            Map<JButton, Skill> treeMap = skillTreePanel.getTreeMap();
            List<JButton> buttonList = skillTreePanel.getButtonList();
            for (JButton button : buttonList) {
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Skill skill = treeMap.get(button);
                        if (skill.getCurrPoints() < skill.getMaxPoints()) {
                            skill.addPoint();
                            String buttonString = "<html><div style='text-align: center;'>" + skill.getSkillName()
                                    + "<br />" + skill.getCurrPoints() + "/" + skill.getMaxPoints() + "</div></html>";
                            button.setText(buttonString);
                            boolean skillAdded = false;
                            int skillIndex = -1;
                            Build currBuild = controller.getCurrBuild();
                            for (Skill savedSkill : currBuild.getSkillList()) {
                                if (savedSkill.getSkillName().equals(skill.getSkillName())) {
                                    skillAdded = true;
                                    skillIndex = currBuild.getSkillList().indexOf(savedSkill);
                                }
                            }
                            if (skillAdded && skillIndex != -1) {
                                for (Skill tempSkill : currBuild.getSelectedChar().findSkillTreeByNum(skill.getTreeNum()).getSkillList()) {
                                    if (tempSkill.getSkillName().equals(skill.getSkillName())) {
                                        tempSkill.setCurrPoints(skill.getCurrPoints());
                                    }
                                }
                            } else {
                                currBuild.getSkillList().add(skill);
                            }
                            currBuild.addSpentPoint();
                            controller.saveCurrBuild(currBuild);
                            if (skill.getCurrPoints() == skill.getMaxPoints()) {
                                button.setToolTipText("<html>" + skill.getSkillDesc() + "<br><br>" + "Current Rank:<br>"
                                        + skill.findTierByNum(skill.getCurrPoints()).getTierDesc() + "</html>");
                            } else if (skill.getCurrPoints() > 0) {
                                button.setToolTipText("<html>" + skill.getSkillDesc() + "<br><br>" + "Current Rank:<br>"
                                        + skill.findTierByNum(skill.getCurrPoints()).getTierDesc()
                                        + "<br><br>Next Rank:<br>"
                                        + skill.findTierByNum(skill.getCurrPoints() + 1).getTierDesc() + "</html>");
                            } else {
                                button.setToolTipText("<html>" + skill.getSkillDesc() + "<br><br>" + "Next Rank:<br>"
                                        + skill.findTierByNum(1).getTierDesc() + "</html>");
                            }
                        }
                    }
                });
            }
        }
    }

    private void addSaveButtonListener(CharacterPanel characterPanel) {
        characterPanel.getSaveButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(characterPanel.getBuildNameField().getText().isEmpty())) {
                    String buildName = characterPanel.getBuildNameField().getText();
                    if (controller.addSavedBuild(buildName)) {
                        characterPanel.getBuildNameLabel().setText("Build Saved!");
                    } else {
                        characterPanel.getBuildNameLabel()
                                .setText("Build with that name already exists. Please enter another name.");
                    }
                } else {
                    characterPanel.getBuildNameLabel()
                            .setText("Error: Invalid Name. Please enter a name for your build.");
                }
            }
        });
    }

    private void addBuildLoadListeners() {
        Map<JButton, Build> loadMap = this.buildLoadPanel.getLoadMap();
        List<JButton> buttonList = this.buildLoadPanel.getButtonList();
        for (JButton button : buttonList) {
            Build build = loadMap.get(button);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    loadAction(build);
                }
            });
        }
        this.buildLoadPanel.getBackButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnToMainMenu();
            }
        });
    }

    private void loadAction(Build build) {
        this.controller.saveCurrBuild(build);
        this.buildLoadPanel.setVisible(false);
        this.resumeBuildAction();
    }
}