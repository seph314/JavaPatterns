package inspection.view;
import inspection.controller.Controller;
import inspection.integration.DatabaseManager;
import inspection.integration.InspectionTask;

import java.time.YearMonth;
import java.util.Date;
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
                "pay        = pay with Card" +
                "start      = start inspection\n" +
                "commands   = shows commands\n" +
                "quit       = exit program");
    }

    public void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! type open to open garage door\n");
        showCommandList();
        String command = "";
        double cost = 0;
        while (!command.equalsIgnoreCase("quit")) {
            command = in.nextLine();
            switch (command.toLowerCase()) {

                case "open":
                    controller.nextCustomer();
                    System.out.println("Door is open");
                    break;

                case "close":
                    controller.closeDoor();
                    System.out.println("Door is closed");
                    break;

                case "find":
                    System.out.println("Enter regnumber:");
                    String regNo = in.next();
                    if(controller.findInspection(regNo) == 0.0)
                        System.out.println("There is no booked inspection for this car");
                    else{
                        cost = controller.findInspection(regNo);
                        System.out.println("Amount to pay: " + cost);
                    }
                    break;

                case "pay":
                    // creates dummy information for credit card
                    int pin = 1234;
                    String number = "3141 5926 5358 9793";
                    String holder = "Anders Pettersson";
                    YearMonth expiryDate = null;
                    expiryDate.withYear(2020);
                    expiryDate.withMonth(12);
                    int CVC = 777;
                    double payedAmount = 500;

                    // prints dummy information
                    System.out.println("Dummy credit card information already entered:\n");
                    System.out.println( "pin" + pin +
                                        "number" + number +
                                        "holder" + holder +
                                        "expiryDate" + expiryDate +
                                        "CVC" + CVC);

                    //Pay with card hanldes credit card, receipt and amount
                    controller.payWithCard(pin, number, holder, expiryDate, CVC, cost, payedAmount);
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
