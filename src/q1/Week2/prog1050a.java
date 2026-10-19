package q1.Week2;

//Region,Country,Item Type,Sales Channel,Order Priority,Order Date,Order ID,Ship Date,
//Units Sold,Unit Price,Unit Cost,Total Revenue,Total Cost,Total Profit
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
            System.out.println("Sales to Europe: " + computeCount(records, 0, "Europe"));
            System.out.println("Cereal sold to Cambodia: " + computeUnitsSold(records, 1, "Cambodia", 2, "Cereal"));
            System.out.println("Profits on meat: " + moneyFormat.format(computeSum(records, 2, "Meat")));
            System.out.println("High priority sales percentage: " + computePercent(records, 4, "H") + "%");
            System.out.println("Fruits profits lost in 2012: " + moneyFormat.format(computeProfitLostIn2012(records, "Fruit")));
            System.out.println("High priority sales shipped late: " + computeHighPriorityLateSales(records));
            System.out.println("Country with highest profit on personal care items: " + computeHighestProfit(records, 2, "Personal Care"));


        }
    }

    public static int computeCount(List<salesrecord> records, int fIndex, String value) {
        int count = 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(value)) {
                count++;
            }
        }
        return count;
    }

    public static int computeUnitsSold(List<salesrecord> records, int fIndex1, String value1, int fIndex2, String value2) {
        int total = 0;
        for (var record : records) {
            if (record.fields[fIndex1].equalsIgnoreCase(value1) && record.fields[fIndex2].equalsIgnoreCase(value2)) {
                total += (int) record.getUnitsSold();
            }
        }
        return total;
    }

    public static double computeSum(List<salesrecord> records, int fIndex, String value) {
        double sum = 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(value)) {
                sum += record.getProfits();
            }
        }
        return sum;
    }

     public static double computePercent(List<salesrecord> records, int fIndex, String value) {
        return ((double) computeCount(records, fIndex, value) / records.size()) * 100;
     }

     public static double computeProfitLostIn2012(List<salesrecord> records, String itemType) {
        double lostProfit = 0;
        for (var record : records) {
            if (record.fields[2].equalsIgnoreCase(itemType) && record.fields[5].endsWith("2012")) {
                lostProfit += record.getProfits();
            }
        }
        return lostProfit;
     }

     public static int computeHighPriorityLateSales(List<salesrecord> records) {
        int count = 0;
        var dateFormat = new SimpleDateFormat("M/d/yyyy");
        for (var record : records) {
            if (record.fields[4].equalsIgnoreCase("H")) {
                try {
                    Date orderDate = dateFormat.parse(record.fields[5]);
                    Date shipDate = dateFormat.parse(record.fields[7]);

                    long diffInMs = Math.abs(shipDate.getTime()) - Math.abs(orderDate.getTime());
                    long diffInDays = diffInMs / (1000 * 60 * 60 * 24);
                    if (diffInDays > 3) {
                        count++;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return count;
    }

    public static String computeHighestProfit(List<salesrecord> records, int fIndex, String itemType) {
        String highestCountry = "N/A";
        double highestProfit = 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(itemType)) {
                double profit = record.getProfits();
                if (profit > highestProfit) {
                    highestProfit = profit;
                    highestCountry = record.fields[1];
                }
            }
        }
        return highestCountry;
    }

    public static String computeMaxByField(List<salesrecord> records, int fIndex, String itemType, int resultFIndex) {
        String topRegion = "N/A";
        
    }
}