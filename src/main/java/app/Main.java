package app;

import app.model.Model;
import app.view.View;

public class Main {
    
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller);
    }
}