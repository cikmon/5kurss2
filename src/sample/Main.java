package sample;

import static javafx.application.Application.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        primaryStage.setTitle("Razmeshenie");
       primaryStage.setScene(new Scene(root, 370, 275));
       primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

    }










