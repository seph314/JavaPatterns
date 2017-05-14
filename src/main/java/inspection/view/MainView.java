package inspection.view;

import inspection.controller.Controller;
import inspection.integration.DatabaseManager;
import inspection.integration.IllegalLicenseNumberException;
import inspection.model.InspectionTask;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.time.YearMonth;
import java.util.List;

/**
 * This is a personal test where I try to build an alternative graphical view
 * Expect limited functionality
 */
public class MainView {

    private Controller controller = new Controller(new DatabaseManager());
    double cost;
    String inputString;

    @FXML
    TextField textInput;

    @FXML
    Label printOut;


    public void initialize(){

    }

    public void openButton(){
        controller.nextCustomer();
        printOut.setText("The door is open.\n(close when the customer arrived)");
    }

    public void closeButton(){
        controller.closeDoor();
        printOut.setText("The door is closed.\nchoose find inspection");
    }

    public  void  enterRegnumber(){
        printOut.setText("Enter registrationnumber (ABC123)");
    }

    public void createStringFromInputField(){
        inputString = textInput.getText();
    }

    public void  findInspection() throws IllegalLicenseNumberException{
        cost = controller.findInspection(inputString);
        printOut.setText("The cost is " + cost + "$\nchoose pay");
    }

    public void pay(){
        int pin = 1234;
        String number = "3141 5926 5358 9793";
        String holder = "Anders Pettersson";
        YearMonth expiryDate = YearMonth.now();
        int CVC = 777;
        double payedAmount = cost;

        String receipt = controller.payWithCard(pin, number, holder, expiryDate, CVC, cost, payedAmount);
        printOut.setText("" + receipt);
    }

    public void startInspection(){
        List<InspectionTask> inspectionProtocol = controller.startInspection();
        for (InspectionTask task : inspectionProtocol){
            printOut.setText("Check: " + task.getName());
            printOut.setText("\npass or fail?");
            String passOrFail = textInput.getText();
            if (passOrFail.equalsIgnoreCase("pass"))
                task.setPassOrFail(true);
            else
                task.setPassOrFail(false);
        }

        printOut.setText("\nS U M M A R Y\n");
        for(InspectionTask task : inspectionProtocol){
            String result;
            if(task.isPassOrFail())
                result = "pass";
            else
                result = "fail";
            printOut.setText(task.getName() + ": " + result);
        }
        printOut.setText("\nAll done!\nBravissimo!");
    }
}
