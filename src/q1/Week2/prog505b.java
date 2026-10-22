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
        if (avg >= 90)
    }
}

public class prog505b {
    public static List<student> loadScores(String filepath) {
        var records = new ArrayList<student>();
        try {
            var file = new Scanner(new File(filepath));

            while (file.hasNextLine()) {
                String[] name = {file.nextLine(), file.nextLine()};
                int[] scores = {file.nextInt(), file.nextInt(), file.nextInt()};
                records.add(new student(name, scores));
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return records;
    }
    public static void main(String[] args) {
        
    }
}
