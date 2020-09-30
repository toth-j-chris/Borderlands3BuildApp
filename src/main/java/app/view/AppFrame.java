package app.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;

public class AppFrame extends JFrame {
    private Dimension screenSize;
    private GridLayout mainLayout;

    public AppFrame() {
        this.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.mainLayout = new GridLayout();
        setLayout(mainLayout);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(screenSize.width, screenSize.height);
        setVisible(true);
    }
}