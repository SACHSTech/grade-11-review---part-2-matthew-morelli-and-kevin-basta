package gr11review.part2;
import java.io.*;

public class Utility {

  /**
  * Given a string, returns sum of all numbers entered.
  * A new number is any number seperated by a non-number.
  *
  * @param str  The string that will be analyzed
  * @return The sum of the numbers in the string
  * @author Matthew Morelli
  */ 
  public static int sumNumbers(String str) {

    boolean isNum = false;
    int len = str.length();
    int count;
    int count2;
    String currentNum = "";
    int total = 0;
    String strTotal = "0";
    String currentSubstring;
    String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    for (count = 0; count < len; count++) {

      isNum = false;
      currentNum = "";

      currentSubstring = str.substring(count, count + 1);

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
  
  /**
  * Finds the word in a text file that is alphabetically
  * first.
  *
  * @param filenametxt  The name of the text file that
  * will be analyzed.
  * @return The word that is alphabetically first in the
  * file.
  * @author Matthew Morelli
  */
  public static String alphaWord(String filenametxt) throws IOException {
    
    BufferedReader thefile = new BufferedReader(new FileReader(filenametxt));

    String word = "";
    String minWord = "";
    int count = 0;

    while ((word = thefile.readLine()) != null) {

      if (count == 0) {

        minWord = word;

      } else if (word.compareToIgnoreCase(minWord) < 0) {

        minWord = word;

      }

      count++;

    }

    thefile.close();

    return minWord;

  }

  /**
  * Checks if a given number is "alone" in an array,
  * meaning if the number is not surrounded by the same
  * number and if it is not at the end of the array,
  * replace it with the number to the left or right
  * that is higher.
  *
  * @param nums  Array of numbers that will be analyze
  * @param value  The number that will be checked if it
  * is "alone"
  * @return The new array with the replaced numbers
  * @author Matthew Morelli
  */
  public static int[] notAlone(int[] nums, int value) {

    int len = nums.length;
    int count;
    int numLeft = 0;
    int numMiddle;
    int numRight = 0;
    int highestNum = 0;

    for (count = 0; count < len; count++) {

      if (count != 0 && count != len - 1) {

        numLeft = nums[count - 1];
        numMiddle = nums[count];
        numRight = nums[count + 1];

        if (numMiddle == value) {

          if (numLeft != numMiddle && numRight != numMiddle) {

            if (numLeft > numRight) {

              highestNum = numLeft;

            } else {

              highestNum = numRight;

            }

            nums[count] = highestNum;

          }

        }

      }
      
    }

    return nums;

  }

  /**
  * Checks if there is a place to split the array so that
  * the sum of numbers on one side equals the sum of
  * numbers on the other side
  *
  * @param nums  The array of numbers that will be checked
  * @return If it can be split (true or false)
  * @author Matthew Morelli
  */ 
  public static boolean canBalance(int[] nums) {

    int rightNum = 0;
    int leftNum = 0;
    int count;
    boolean rightIsLeft = false;

    for (count = 0; count < nums.length; count++) {

      rightNum += nums[count];

    }

    for (count = 0; count < nums.length; count++) {

      if (rightNum != leftNum) {

        leftNum += nums[count];
        rightNum -= nums[count];

      }
 
    }

    if (rightNum == leftNum) {
      rightIsLeft = true;
    }

    return rightIsLeft;

  }
  /**
  * Given an integer, prints out a 2d array to a text file
  * where the numbers from the top right to bottom left
  * have a value of 1, and positions above that diagonal
  * have a value of 0, and positions below that diagonal
  * have a value of 2.
  *
  * @param n  The size of the array (n*n)
  * @return nothing
  * @author Matthew Morelli
  */
  public static void diagonal(int n) throws IOException {

    PrintWriter theout = new PrintWriter(new FileWriter("src/gr11review/part2/diagonalOut.txt", false));

    int[][] numbers;
    numbers = new int[n][n];
    int count;
    int count2;

    for (count = 0; count < n; count++) {

      for (count2 = 0; count2 < n; count2++) {

        if (count2 == count) {

          numbers[count][count2] = 1;

        } else if (count2 > count) {

          numbers[count][count2] = 2;

        } else {

          numbers[count][count2] = 0;

        }

      }

    }

    for (count = n - 1; count >= 0; count--) {

      for (count2 = 0; count2 < n; count2++) {

        theout.print(numbers[count][count2] + ",");

      }

      theout.println();
      
    }

    theout.close();

  }

}