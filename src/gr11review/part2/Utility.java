package gr11review.part2;
import java.io.*;

public class Utility {
    
  public static void main(String[] args) throws IOException {

    String sentence;

    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Enter a sentence: ");
    sentence = keyboard.readLine();

    System.out.println(sumNumbers(sentence));

  }

  public static int sumNumbers(String str) {

    boolean isNum = false;
    int length = str.length();
    int count;
    int count2;
    String currentNum = "";
    int total = 0;
    String strTotal = "0";
    String currentSubstring;
    String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    for (count = 0; count < length; count++) {

      isNum = false;
      currentNum = "";

      currentSubstring = str.substring(count, count + 1);

      // check if substring is a number
      for (count2 = 0; count2 < 10; count2++) {
        if (currentSubstring.contains(nums[count2])) {
          isNum = true;
          break;
        }
      }

      if (isNum) {
        
        currentNum += currentSubstring;
        
        strTotal += currentNum;

      } else {

        total += Integer.parseInt(strTotal);
        strTotal = "0";

      }

    }

    total += Integer.parseInt(strTotal);

    return total;
  }
}