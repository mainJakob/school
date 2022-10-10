package Pathfinder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Sample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String fxmlPath = "../pathfinder.fxml";

        Parent root =  FXMLLoader.load(getClass().getResource(fxmlPath));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Pathfinder");
        stage.setResizable(true);
        stage.show();
    }
}
