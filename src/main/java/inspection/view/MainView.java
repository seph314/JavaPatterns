package inspection.view;

import inspection.controller.Controller;
import inspection.integration.DatabaseManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * Created by Anders on 2017-05-10.
 */
public class MainView {

    Controller controller = new Controller(new DatabaseManager());

    @FXML
    Button openButton;

    @FXML
    TabPane tabPane;


    public void initialize(){

    }

    public void openButton(){
        controller.nextCustomer();
    }

    public void closeButton(){
        controller.closeDoor();
    }

    public  void  findInspection(){
        controller.findInspection("ABC123");
    }

    public void startInspection(){
        controller.startInspection();
    }


}
