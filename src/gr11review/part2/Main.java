package gr11review.part2;
import gr11review.part2.Utility.*;
import java.io.*;


public class Main{
  public static void main(String[] args) throws IOException{
  String strsentence;
  /*
  String word;
  BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Enter the sentence");
  strsentence = keyboard.readLine(); 
  System.out.println("Enter the only character to be shown");
  word = keyboard.readLine(); 
  System.out.println (Utility.plusOut(strsentence, word));
  */
  String files; 
  files = "world.txt";
  System.out.println(Utility.avgWord(files));
  }



}
