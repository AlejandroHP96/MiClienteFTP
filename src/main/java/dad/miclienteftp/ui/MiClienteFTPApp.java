package dad.miclienteftp.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MiClienteFTPApp extends Application{

    MainController controller;

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        controller = new MainController();

        Scene scene = new Scene(controller.getView());

        primaryStage.setTitle("MiClienteFTP");
        primaryStage.setScene(scene);
        primaryStage.show(); 

    }

    public static Stage getPrimaryStage(){
        return primaryStage;
    }


    public static void main(String[] args) {
        launch(args);
    }


    
}
