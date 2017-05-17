package inspection.startup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Anders on 2017-05-10.
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts an alternative graphical view under development
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Inspect vehicle");

        /**
         * Hämtar från res mappen
         */
        BorderPane root = FXMLLoader.load(getClass().getResource("/views/main_view.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/css/main.css");

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
