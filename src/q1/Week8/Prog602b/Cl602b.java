package q1.Week8.Prog602b;

public class Cl602b {
    private int number;
    private double hours;
    private int code;
    private double due;

    private void calc() {
        if (hours < 5) {
            due = 200;
        } else if (hours < 15) {
            due = 200 + (50 * (hours - 5));
        } else {
            due = 550 + (30 * (hours - 15));
        }

        if (code == 1) {
            due += 50;
        } else if (code == 2) {
            due += 150;
        }
    }

    public Cl602b(int number, double hours, int code) {
        this.number = number;
        this.hours = hours;
        this.code = code;
        this.due = 0;
        calc();
    }

    public String toString() {
        return String.format("%d\t$%.2f\t%d\t\t$%.2f", number, hours, code, due);
    }

    public int compareTo(Cl602b o) {
        return number - o.number;
    }
}
