package q1.Week2;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class student {
    public String[] name = new String[2];
    public int[] scores = new int[5];
    public student(String[] n, int[] s) {
        name = n;
        scores = s;
    }

    public String getName() {
        return name[0] + " " + name[1];
    }

    public String getAvg() {
        var scoreFormat = new DecimalFormat("##.0");
        double avg = 0;
        for (var s : scores) {
            avg += s;
        }
        return scoreFormat.format(avg / scores.length);
    }

    public String getLetterGrade() {
        double avg = Double.parseDouble(getAvg());
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        }
        else if (avg >= 70) {
            return "C";
        }
        else if (avg >= 60) {
            return "D";
        }
        return "F";
    }
}

public class prog505b {
    public static List<student> loadScores(String filepath) {
        var records = new ArrayList<student>();
        try {
            var file = new Scanner(new File(filepath));

            while (file.hasNext()) {
                String[] name = {file.next(), file.next()};
                int[] scores = {file.nextInt(), file.nextInt(), file.nextInt(), file.nextInt(), file.nextInt()};
                records.add(new student(name, scores));
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return records;
    }
    public static void main(String[] args) {
        var list = loadScores("Langdat\\prog505b.dat");

        for (var student : list) {
            System.out.print(student.getName() + "\t");
            for (int x = 0; x < student.scores.length; x++) {
                System.out.print(student.scores[x] + "\t");
            }
            System.out.println("\t" + student.getAvg() + "\t" + student.getLetterGrade());
        }
        System.out.println();

        for (int x = 0; x < list.get(0).scores.length; x++) {
            System.out.print("Test " + (x + 1) + "\t\t");
            for (var student : list) {
                System.out.print(student.scores[x] + "\t");
            }
            double avg = Double.parseDouble(getAvgByTest(list, x));
            System.out.print("\t" + avg);
            System.out.println("\t" + getLetterGrade(avg));
        }
    }

    public static String getLetterGrade(double avg) {
        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        }
        else if (avg >= 70) {
            return "C";
        }
        else if (avg >= 60) {
            return "D";
        }
        return "F";
    }

    public static String getAvgByTest(List<student> list, int test) {
        var scoreFormat = new DecimalFormat("##.0");
        double avg = 0;
        for (var student : list) {
            avg += student.scores[test];
        }
        avg /= list.size();
        return  scoreFormat.format(avg); 
    }
}
/*
Sam Lilly       80      77      82      86      90              83.0    B
Fred Biggie     70      72      88      90      93              82.6    B
Sally Awesome   92      91      85      99      93              92.0    A

Test 1          80      70      92              80.7    B
Test 2          77      72      91              80.0    B
Test 3          82      88      85              85.0    B
Test 4          86      90      99              91.7    A
Test 5          90      93      93              92.0    A
*/