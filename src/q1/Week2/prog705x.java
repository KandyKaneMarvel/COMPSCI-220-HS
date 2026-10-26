package q1.Week2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class poemLine {
        public String line[];
        public poemLine(String s) {
            line = s.split(" ");
        }

        public String[] getLine() {
            return line;
        }

        public String toString() {
            String temp = "";
            for (var word : line) {
                temp += word + " ";
            }
            return temp;
        }
    } 

    class cipherLine {
        String line = "";

        public cipherLine(String s) {
            line = s;
        }

        public char getLetter(List<poemLine> list) {
            int lineLoc = Integer.parseInt(line.substring(0, 2));
            int wordLoc = Integer.parseInt(line.substring(2, 3));
            int letLoc = Integer.parseInt(line.substring(3));

            return list.get(lineLoc - 1).line[wordLoc - 1].charAt(letLoc - 1);
        }

        public String toString() {
            return line;
        }
    }

public class prog705x {
    public static List<poemLine> loadPoem(String filepath) {
        var poem = new ArrayList<poemLine>();
        try {
            var file = new Scanner(new File(filepath));

            while (file.hasNextLine()) {
                poem.add(new poemLine(file.nextLine()));
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return poem;
    }

    public static List<cipherLine> loadCipher(String filepath) {
        var cipher = new ArrayList<cipherLine>();
        try {
            var file = new Scanner(new File(filepath));

            while (file.hasNextLine()) {
                cipher.add(new cipherLine(file.nextLine()));
            }
            file.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return cipher;
    }
    public static void main(String[] args) {
        var poem = loadPoem("Langdat\\prog512h.dat");
        var cipher = loadCipher("Langdat\\prog705x.txt");

        System.out.println("Cipher code: \n");
        String word = "";
        for (var line : cipher) {
            word += line.getLetter(poem);
            System.out.println(line + "\t" + line.getLetter(poem));
        }
        System.out.println("\nThe magic word is \"" + word + "\"\n");

        for (var line : poem) {
            System.out.println(line);
        }
    }
}
/*
Cipher code: 

0831    c
0112    o
0722    o
0914    l
0821    b
1243    e
1551    a
1724    n
1816    s

The magic word is "coolbeans"

Good morning life and all 
Things glad and beautiful 
My pockets nothing hold 
But he that owns the gold 
The sun is my great friend 
His spending has no end 
Hail to the morning sky 
Which bright clouds measure high 
Hail to you birds whose throats 
Would number leaves by notes 
Hail to you shady bowers 
And you green fields of flowers 
Hail to you women fair 
That make a show so rare 
In cloth as white as milk 
Be it calico or silk 
Good morning life and all 
Things glad and beautiful
*/