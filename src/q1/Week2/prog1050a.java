package q1.Week2;

//Region,Country,Item Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,Units Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit
import java.io.*;
import java.util.*;
import java.text.*;

    class salesrecord {
        public String[] fields;
        public salesrecord(String[] data) {
            fields = data;
        }

        public double getProfits() {
            return Double.parseDouble(fields[13]);
        }

        public double getUnitsSold() {
            return Double.parseDouble(fields[8]);
        }
    }
public class prog1050a {
    public static List<salesrecord> loadSalesData(String filepath) {
        var records = new ArrayList<salesrecord>();
        try {
            var file = new Scanner(new File(filepath));
            file.nextLine();
            
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] data = line.split(",");
                records.add(new salesrecord(data));
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return records;
    }

    public static void main(String[] args) {
        var records = loadSalesData("Langdat/Lang1050a.csv");
        if (records != null) {
            var moneyFormat = new DecimalFormat("$#,###.00");
            
        }
    }
}