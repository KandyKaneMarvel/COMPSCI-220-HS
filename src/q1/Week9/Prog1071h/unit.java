package q1.Week9.Prog1071h;

public class unit implements Comparable<unit> {
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
        return this.code + "\t\t" + this.quantity + "\t\t" + this.price;
    }

    public int compareTo(unit a) {
        return (int) (this.price * 1000 - a.price * 1000);
    }

    //will return what's left of "a" if it exceeds the value of "quantity", else returns 0
    public int sell(int a) {
        this.quantity -= a;
        if (quantity < 0) {
            return quantity * (-1);
        }
        return 0;
    }

    public void buy(int a) {
        quantity += a;
    }
}
