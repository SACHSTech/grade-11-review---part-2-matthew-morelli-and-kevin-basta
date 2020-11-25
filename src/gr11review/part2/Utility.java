package gr11review.part2;
import java.lang.*;

public class Utility {
    
  public static int sumNumbers(String str) {

    boolean isChar;
    int numOfConsecutiveChars = 0;
    int length = str.length();
    int count;
    String currentNum;
    int total = 0;
    String currentSubstring;

    for (count = 0; count < length; count++) {

      currentSubstring = str.substring(count, count + 1);

      isChar = Character.isDigit(currentSubstring);

      if (isChar) {

        numOfConsecutiveChars++;

        currentNum += currentSubstring;
        
      } else {

        total += Integer.parseInt(currentNum);

        numOfConsecutiveChars = 0;

      }

    }

  }

}