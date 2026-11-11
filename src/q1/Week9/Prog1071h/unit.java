package q1.Week9.Prog1071h;

public class unit {
    private int code;
    private int quantity;
    private double price;

    public unit(int c, int q, double p) {
        this.code = c;
        this.quantity = q;
        this.price = p;
    }

    public String getName() {
        String[] names = {"Computer", "Monitor", "Disk Drive", "Diskette", "Printer", "Scanner", "Hard Drive", "Modem", "Digital Camera"};
        return names[this.code - 1];
    }
    
    public int getCode() {
        return this.code;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return this.getName() + "\t" + this.quantity + "\t" + this.price;
    }
}
