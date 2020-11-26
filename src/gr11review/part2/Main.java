package gr11review.part2;
import java.io.*;
import gr11review.part2.Utility.java;

public class Main {
  public static void main(String[] args) throws IOException {

    String sentence;

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter a sentence: ");
    sentence = keyboard.readLine();

    System.out.println(Utility.sumNumbers(sentence));

  }
}