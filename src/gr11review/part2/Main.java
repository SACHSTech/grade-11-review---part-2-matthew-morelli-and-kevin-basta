package gr11review.part2;
import java.io.*;
import gr11review.part2.Utility.java;

public class Main { 
  public static void main(String[] args) throws IOException {
    BufferedReader keybaord = new BufferedReader(new InputStreamReader(System.in));
    String strUserInput;
    String strOutPut;
    strUserInput = keybaord.readLine();

    strOutPut = Utility.zipZap(strUserInput);
    System.out.println(strOutPut);
  }
}