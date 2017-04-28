package inspection.model;

import java.time.LocalDateTime;

/**
 * Created by Anders on 2017-04-28.
 */
public class Receipt {
    private Amount amount;
    private Vehicle vehicle;

    public Receipt(Amount amount, Vehicle vehicle) {
        this.amount = amount;
        this.vehicle = vehicle;
    }

    /**
     * Creates a well-formatted string with the entire content of the receipt.
     *
     * @return The well-formatted receipt string.
     */
    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "Vehicle Inspection");
        endSection(builder);

        LocalDateTime rentalTime = LocalDateTime.now();
        builder.append("Inspection time: ");
        appendLine(builder, rentalTime.toString());
        endSection(builder);

        builder.append("Inspected vehicle: ");
        appendLine(builder, vehicle.getRegNo());
        builder.append("Cost: ");
        appendLine(builder, String.valueOf(amount.getCost()));
        builder.append("Change: ");
        appendLine(builder, "No change: payed with credit card.");
        endSection(builder);

        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
}

