package gr11review.part2;

import gr11review.part2.Utility.*;
import java.util.Arrays;
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

    /*
    String strFile = "RandomWords.txt";
    System.out.println(Utility.longestWord(strFile));
    */

    /*
    int[] testArray = {2, 10, 3, 4, 20, 5};
    System.out.println(Arrays.toString(Utility.tenRun(testArray)));
    */

    /*
    int[] outer = {1, 2, 4, 4, 6}; 
    int[] inner = {2, 4};
    System.out.println(Utility.linearIn(outer, inner));
    */
    Utility.pascalTri(4, 5);
  }
} 