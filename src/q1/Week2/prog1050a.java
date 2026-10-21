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
        var records = loadSalesData("Langdat\\Lang1050.csv");
        if (records != null) {
            var moneyFormat = new DecimalFormat("$#,###.00");
            System.out.println("Sales to Europe: " + computeCount(records, 0, "Europe"));
            System.out.println("Cereal sold to Cambodia: " + computeUnitsSold(records, 1, "Cambodia", 2, "Cereal"));
            System.out.println("Profits on meat: " + moneyFormat.format(computeSum(records, 2, "Meat")));
            System.out.println("High priority sales percentage: " + computePercent(records, 4, "H") + "%");
            System.out.println("Fruits profits lost in 2012: " + moneyFormat.format(computeProfitLostIn2012(records, "Fruit")));
            System.out.println("High priority sales shipped late: " + computeHighPriorityLateSales(records));
            System.out.println("Country with highest profit on personal care items: " + computeHighestProfit(records, 2, "Personal Care"));
            System.out.println("Region that bought the most snacks: " + computeMaxByField(records, 2, "Snacks", 0));

            //my part of the assignment
            double profitsLost = computeProfits(records);
            System.out.println();
            System.out.println("Number of Sales to African Nations: " + (computeCount(records, 0, "Sub-Saharan Africa") + computeCount(records, 0, "Middle East and North Africa")));
            deleteRecords(records, 1, "Kuwait");
            limitUnitsByField(records, 100, 1, "Uganda", 2, "Cosmetics");
            deleteRecords(records, 2, "Office Supplies");
            deleteRecords(records, 4, "L", 1, "Sub-Saharan Africa");
            deleteRecords(records, 4, "L", 1, "Middle East and North Africa");
            profitsLost -= computeProfits(records);
            System.out.println("Profits lost in trade war with Africa: " + moneyFormat.format(profitsLost));
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

    public static int computeCount(List<salesrecord> records, int fIndex1, String value1, int fIndex2, String value2) {
        int count = 0;
        for (var record : records) {
            if (record.fields[fIndex1].equalsIgnoreCase(value1) && record.fields[fIndex2].equalsIgnoreCase(value2)) {
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

     public static double computeProfits(List<salesrecord> records, String itemType) {
        double profit = 0;
        for (var record : records) {
            if (record.fields[2].equalsIgnoreCase(itemType)) {
                profit += record.getProfits();
            }
        }
        return profit;
     }

     public static double computeProfits(List<salesrecord> records) {
        double profit = 0;
        for (var record : records) {
            profit += record.getProfits();
        }
        return profit;
     }

     public static int computeHighPriorityLateSales(List<salesrecord> records) {
        int count = 0;
        var dateFormat = new SimpleDateFormat("M/d/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
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
        int maxCount = 0;
        var regions = new ArrayList<String>();

        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(itemType)) {
                String region = record.fields[resultFIndex];
                if (!regions.contains(region)) {
                    regions.add(region);
                }
            }
        }

        for (var region : regions) {
            int count = computeCount(records, fIndex, itemType, resultFIndex, region);
            if (count > maxCount) {
                maxCount = count;
                topRegion = region;
            }
        }

        return topRegion;
    }

    public static void limitUnitsByField(List<salesrecord> records, int limit, int fIndex, String value) {
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(value)) {
                record.fields[8] = "100";
                record.fields[11] = "" + (100 * Double.parseDouble(record.fields[9]));
                record.fields[12] = "" + (100 * Double.parseDouble(record.fields[10]));
                record.fields[13] = "" + (Double.parseDouble(record.fields[11]) - Double.parseDouble(record.fields[12]));
                //what's the proper way to do this?
            }
        }
    }

    public static void limitUnitsByField(List<salesrecord> records, int limit, int fIndex1, String value1, int fIndex2, String value2) {
        for (var record : records) {
            if (record.fields[fIndex1].equalsIgnoreCase(value1) && record.fields[fIndex2].equalsIgnoreCase(value2)) {
                record.fields[8] = "100";
                record.fields[11] = "" + (100 * Double.parseDouble(record.fields[9]));
                record.fields[12] = "" + (100 * Double.parseDouble(record.fields[10]));
                record.fields[13] = "" + (Double.parseDouble(record.fields[11]) - Double.parseDouble(record.fields[12]));
                //what's the proper way to do this?
            }
        }
    }

    public static void deleteRecords(List<salesrecord> records, int fIndex, String value) {
        for (int itr = 0; itr < records.size(); itr++) {
            if (records.get(itr).fields[fIndex].equalsIgnoreCase(value)) {
                records.remove(itr);
            }
        }
    }

    public static void deleteRecords(List<salesrecord> records, int fIndex1, String value1, int fIndex2, String value2) {
        for (int itr = 0; itr < records.size(); itr++) {
            if (records.get(itr).fields[fIndex1].equalsIgnoreCase(value1) && records.get(itr).fields[fIndex2].equalsIgnoreCase(value2)) {
                records.remove(itr);
            }
        }
    }
}
/*
Sales to Europe: 129286
Cereal sold to Cambodia: 1164596
Profits on meat: $11,933,838,488.00
High priority sales percentage: 24.9974%
Fruits profits lost in 2012: $.00
High priority sales shipped late: 115166
Country with highest profit on personal care items: Iceland
Region that bought the most snacks: Sub-Saharan Africa

Number of Sales to African Nations: 192442
Profits lost in trade war with Africa: $25,374,082,505.66
*/