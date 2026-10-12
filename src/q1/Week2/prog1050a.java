package q1.Week2;

//Region,Country,Item Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,Units Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit
import java.io.*;
import java.util.*;
import java.text.*;

    class salesrecord {
        public String[] fields;
        public salesrecord(String[] data) {

        }
    }
public class prog1050a {
    public static void main(String[] args) {
        try {
            var file = new Scanner(new File("Langdat/Lang1050a.csv"));
            file.nextLine();
            

            while (file.hasNext()) {

            }
            file.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}