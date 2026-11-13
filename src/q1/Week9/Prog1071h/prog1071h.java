package q1.Week9.Prog1071h;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import DataStructures.QueueStack;

public class prog1071h {
    public static void main(String[] args) {
        //do inventory, read it out as you import the data
        //then, do everything in buysell
        try {
            var file = new Scanner(new File("Langdat\\bginvtry.txt"));
            var data = new QueueStack<unit>();

            while (file.hasNext()) {
                int c = file.nextInt();
                int q = file.nextInt();
                double p = file.nextDouble();

                data.enqueue(new unit(c, q, p));

                System.out.println(data.peekFront());
            }
            System.out.println();
            file.close();

            var input = new Scanner(new File("Langdat\\buysell.txt"));

            while (input.hasNext()) {
                String com = input.next();

                if (com.equalsIgnoreCase("b")) {
                    int cd = input.nextInt();
                    int amnt = input.nextInt();
                    double prc = input.nextDouble();

                    var tempData = new QueueStack<unit>();

                    while (data.peekRear().getCode() != cd) {
                        tempData.enqueue(data.pop());
                        if (data.peekRear() == null) {
                            break;
                        }
                    }

                    if (data.peekRear() == null) {
                        data.enqueue(new unit(cd, amnt, prc));
                    }
                } else if (com.equalsIgnoreCase("s")) {
                    int cd = input.nextInt();
                    int amnt = input.nextInt();
                    var tempData = new QueueStack<unit>();

                    while (amnt > 0) {
                        while (data.peekRear().getCode() != cd) {
                            tempData.push(data.pop());
                            if (data.peekRear() == null) {
                                break;
                            }
                        }

                        if (data.peekRear() == null) {
                                break;
                        }

                        var current = data.pop();
                        amnt = current.sell(amnt);

                        if (current.getQuantity() > 0) {
                            tempData.push(current);
                        }
                    }

                    while (tempData.peekFront() != null) {
                        data.enqueue(tempData.pop());
                    }
                }
            }
            input.close();

            System.out.println("Ending merchandise inventory:");
            while (data.peekRear() != null) {
                System.out.println(data.pop());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
