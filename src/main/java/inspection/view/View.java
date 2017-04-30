package inspection.view;

import inspection.controller.Controller;
import inspection.integration.DatabaseManager;
import inspection.integration.InspectionTask;

import java.time.YearMonth;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Anders on 2017-04-24.
 */
public class View {

    private DatabaseManager dbMgr = new DatabaseManager();
    private Controller controller = new Controller(dbMgr);

    public View() {
    }

    void showCommandList(){
        System.out.println("C O M M A N D    L I S T\n" +
                "open       = open door and update quenumber\n" +
                "close      = close door\n" +
                "find       = find inspection\n" +
                "pay        = pay with Card\n" +
                "start      = start inspection\n" +
                "commands   = shows commands\n" +
                "quit       = exit program");
    }

    /**
     * Starts the user view and presents available commands
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
                    System.out.println("Door is closed" +
                            "To Search for booked inspection in database type: find");
                    break;

                case "find":
                    System.out.println("Enter regnumber (ABC123):");
                    String regNo = in.next();
                    if(controller.findInspection(regNo) == 0.0)
                        System.out.println("There is no booked inspection for this car" +
                                "To try again type: find");
                    else{
                        cost = controller.findInspection(regNo);
                        System.out.println("Amount to pay: " + cost +
                                "To perform payment type: pay");
                    }
                    break;

                case "pay":
                    // creates dummy information for credit card
                    int pin = 1234;
                    String number = "3141 5926 5358 9793";
                    String holder = "Anders Pettersson";
                    YearMonth expiryDate = YearMonth.now();
                    int CVC = 777;
                    double payedAmount = 500;

                    // prints dummy information
                    System.out.println("Dummy credit card information entered:\n");
                    System.out.println( "pin: " + pin + "\n" +
                                        "number: " + number + "\n" +
                                        "holder: " + holder + "\n" +
                                        "expiryDate: " + expiryDate + "\n" +
                                        "CVC: " + CVC + "\n" +
                                        "To start inspection type: start:");

                    //Pay with card hanldes credit card, receipt and amount
                    String receipt = controller.payWithCard(pin, number, holder, expiryDate, CVC, cost, payedAmount);
                    System.out.println(receipt);
                    break;

                case "start":
                    System.out.println("The inspection is about to start, hang on!");
                    List<InspectionTask> inspectionProtocol = controller.startInspection();
                    //should show one inspection at the time
                    for (InspectionTask task : inspectionProtocol){
                        System.out.println("Check: " + task.getName());
                    }
                    System.out.println("All done!\nBravissimo!");
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
