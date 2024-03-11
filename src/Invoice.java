import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Invoice extends JFrame {
    private JTextArea invoiceTextArea;

    public Invoice() {
        setTitle("Invoice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        invoiceTextArea = new JTextArea();
        invoiceTextArea.setEditable(false);
        invoiceTextArea.setFont(new Font("Courier New", Font.PLAIN, 12));

        setLayout(new BorderLayout());
        add(new JScrollPane(invoiceTextArea), BorderLayout.CENTER);


        generateSampleInvoice();
    }

    private void generateSampleInvoice() {

        String businessAddress = "Best Electronics\n123 Market Street\nAnytown, NY 12345";


        ArrayList<LineItem> lineItems = new ArrayList<>();
        lineItems.add(new LineItem("Smartphone", 2, 499.99));
        lineItems.add(new LineItem("Laptop", 1, 899.99));
        lineItems.add(new LineItem("Tablet", 3, 299.99));


        double totalAmountDue = 0;
        for (LineItem item : lineItems) {
            totalAmountDue += item.getTotal();
        }


        StringBuilder invoiceText = new StringBuilder();
        invoiceText.append("INVOICE\n\n");
        invoiceText.append(businessAddress).append("\n\n");
        invoiceText.append(String.format("%-15s %-5s %-8s %s\n", "Item", "Qty", "Price", "Total"));
        for (LineItem item : lineItems) {
            invoiceText.append(item).append("\n");
        }
        invoiceText.append("\n").append(String.format("%-28s $%.2f", "AMOUNT DUE:", totalAmountDue));


        invoiceTextArea.setText(invoiceText.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Invoice gui = new Invoice();
            gui.setVisible(true);
        });
    }
}

