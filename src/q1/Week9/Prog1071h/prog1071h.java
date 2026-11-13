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

            System.out.println("Starting merchandise inventory:");
            while (file.hasNext()) {
                int c = file.nextInt();
                int q = file.nextInt();
                double p = file.nextDouble();

                data.enqueue(new unit(c, q, p));

                System.out.println(new unit(c, q, p));
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

                    while (!(data.peekRear().getCode() == cd && data.peekRear().getPrice() == prc))  {
                        tempData.push(data.pop());
                        if (data.peekRear() == null) {
                            break;
                        }
                    }

                    if (data.peekRear() == null) {
                        data.enqueue(new unit(cd, amnt, prc));
                    } else {
                        var temp = data.pop();
                        temp.buy(amnt);
                        tempData.push(temp);
                    }

                    while (tempData.peekRear() != null) {
                        data.enqueue(tempData.pop());
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

                    while (tempData.peekRear() != null) {
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
/*
Starting merchandise inventory:
1               50              1298.0
2               50              107.5
3               100             248.85
4               5000            1.07
5               20              489.75
6               5               586.24
7               30              84.23
8               600             24.73
9               1500            19.99
10              15              238.99

Ending merchandise inventory:
1               2               1305.75
6               4               600.0
5               20              510.25
5               2               489.75
4               5000            1.07
9               860             19.99
2               2               111.25
7               10              87.5
3               25              275.55
1               4               1355.0
8               600             24.73
7               30              84.23
10              9               238.99
10              15              250.0
3               62              248.85
1               7               1325.0
9               150             21.25
4               750             1.1
 */
//wrong output? don't know why, must be a different buysell cause I can't think of any reason there would be
//like 3 more units in my output rather than the example
//also i really hope I did QueueStack right, I don't know what was meant by what you said