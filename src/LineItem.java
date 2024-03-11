class LineItem {
    private String productName;
    private int quantity;
    private double unitPrice;

    public LineItem(String productName, int quantity, double unitPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getTotal() {
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-5d $%-7.2f $%.2f", productName, quantity, unitPrice, getTotal());
    }
}










