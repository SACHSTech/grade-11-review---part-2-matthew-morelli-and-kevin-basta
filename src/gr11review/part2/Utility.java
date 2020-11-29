package gr11review.part2;


import java.io.*;
public class Utility {
  public static String plusOut (String str, String word) {
      
        String stroldsentence = "";
        String strnewsentence = "";
        int intcount;
        stroldsentence = str.replace(word, "+");
        for (intcount = 0; intcount < stroldsentence.length(); intcount++) {
          if (stroldsentence.substring(intcount, intcount + 1).equals("+")) {
            strnewsentence += word;
          } else {
            strnewsentence += "+";
          }
        }
       
       
      

      return strnewsentence;

    }
  /*
  public static double avgWord(String filenametxt){
      String readingworld;
      int finalnumber;
      int average;
      int readingwordnumber;
      int intcount2;
      finalnumber = 0;
      intcount2 = 0;
      readingworld = "";
      BufferedReader file = new BufferedReader(new FileReader("world.txt"));
      
      
      while(file.readLine() != null){
        readingworld = file.readLine();
        readingwordnumber = readingworld.length();
        intcount2 = intcount2 +1;
        finalnumber = readingwordnumber + finalnumber;



        }
        average = finalnumber/intcount2;
        
        return "";
      }
*/
  }
