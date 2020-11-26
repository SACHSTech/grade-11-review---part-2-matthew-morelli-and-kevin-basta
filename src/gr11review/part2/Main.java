package gr11review.part2;

import gr11review.part2.Utility.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    /* BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    String strUserInput;
    String strOutPut;
    strUserInput = keyboard.readLine();

    strOutPut = Utility.zipZap(strUserInput);
    System.out.println(strOutPut);
    */

    String strFile = "RandomWords.txt";
    System.out.println(Utility.longestWord(strFile));
  }
} 