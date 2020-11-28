package gr11review.part2;
import java.io.*;
import gr11review.part2.Utility.*;

public class Main{
  public static void main(String[] args) throws IOException{
  String strsentence;
  String strnewsentence;
  String word;
  BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Enter the sentence");
  strsentence = keyboard.readLine(); 
  System.out.println("Enter the only character to be shown");
  word = keyboard.readLine(); 
  System.out.println (plusOut(strsentence));


  }



}
