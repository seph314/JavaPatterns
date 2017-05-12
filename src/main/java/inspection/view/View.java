/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.view;

import inspection.controller.Controller;
import inspection.integration.DatabaseManager;
import inspection.integration.InspectionTask;
import java.time.YearMonth;
import java.util.List;
import java.util.Scanner;

/**
 * The view creates the user interface
 * Guides the user through a inspection
 * Displays available commands
 * Handles input/output
 */
public class View {

    private DatabaseManager dbMgr = new DatabaseManager();
    private Controller controller = new Controller(dbMgr);
    private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();

    /**
     * View constructor
     */
    public View() {
    }

    private void showCommandList(){
        System.out.println("C O M M A N D    L I S T\n" +
                "open       = open door and update quenumber\n" +
                "close      = close door\n" +
                "find       = find inspection\n" +
                "pay        = pay with Card\n" +
                "start      = start inspection\n" +
                "commands   = shows commands\n" +
                "quit       = exit program\n");
    }

    /**
     * Starts the user interface
     * Handles the input/output and calls necessary methods in the controller
     */
    public void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! type open to open garage door\n");
        showCommandList();
        System.out.println("To open garage door type: open");
        String command = "";
        double cost = 0;
        while (!command.equalsIgnoreCase("quit")) {
            command = in.nextLine();
            switch (command.toLowerCase()) {

                case "open":
                    controller.nextCustomer();
                    System.out.println("Door is open\n" +
                            "To close the door when customer is in the garage type: close");
                    break;

                case "close":
                    controller.closeDoor();
                    System.out.println("Door is closed\n" +
                            "To Search for booked inspection in database type: find");
                    break;

                case "find":
                    System.out.println("Enter regnumber (ABC123):");
                    String regNo = in.next();

                    if(controller.findInspection(regNo) == 0.0)
                        System.out.println("There is no booked inspection for this car\n" +
                                "To try again type: find");
                    else{
                        cost = controller.findInspection(regNo);
                        System.out.println("Amount to pay: " + cost +
                                "\nTo perform payment type: pay");
                    }
                    break;

                case "pay":
                    int pin = 1234;
                    String number = "3141 5926 5358 9793";
                    String holder = "Anders Pettersson";
                    YearMonth expiryDate = YearMonth.now();
                    int CVC = 777;
                    double payedAmount = cost;

                    System.out.println("Dummy credit card information entered:\n");
                    System.out.println( "pin: " + pin + "\n" +
                                        "number: " + number + "\n" +
                                        "holder: " + holder + "\n" +
                                        "expiryDate: " + expiryDate + "\n" +
                                        "CVC: " + CVC);

                    String receipt = controller.payWithCard(pin, number, holder, expiryDate, CVC, cost, payedAmount);
                    System.out.println(receipt + "\nTo start inspection type: start");
                    break;

                case "start":
                    System.out.println("The inspection is about to start, hang on!");
                    List<InspectionTask> inspectionProtocol = controller.startInspection();
                    String passOrFail;

                    for (InspectionTask task : inspectionProtocol){
                        System.out.println("Check: " + task.getName());
                        System.out.println("\npass or fail?");
                        passOrFail = in.nextLine();
                        if (passOrFail.equalsIgnoreCase("pass"))
                            task.setPassOrFail(true);
                        else
                            task.setPassOrFail(false);
                    }

                    System.out.println("\nS U M M A R Y\n");
                    for(InspectionTask task : inspectionProtocol){
                        String result;

                        if(task.isPassOrFail())
                            result = "pass";
                        else
                            result = "fail";
                        System.out.println(task.getName() + ": " + result);
                    }

                    System.out.println("\nAll done!\nBravissimo!");
                    break;

                case "commands":
                    showCommandList();
                    break;

                default:
                    break;
            }
        }

        System.out.println("Good bye!");
    }
}
