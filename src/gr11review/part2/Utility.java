package gr11review.part2;
import java.io.*;

public class Utility {

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
  
  public static String alphaWord(String filenametxt) throws IOException {

    BufferedReader thefile = new BufferedReader(new FileReader(filenametxt));

    String firstLine = "";
    String secondLine = "";
    String highestAlpha = "";
    int checkAlphaOrder = 0;

    firstLine = thefile.readLine();
    secondLine = thefile.readLine();

    highestAlpha = secondLine;

    while (secondLine != null) {

      checkAlphaOrder = firstLine.compareTo(secondLine);

      if (checkAlphaOrder < 0) {

        highestAlpha = firstLine;

      }

      firstLine = thefile.readLine();
      secondLine = thefile.readLine();

    }

    thefile.close();

    return highestAlpha;

  }

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

          if (numLeft != numRight) {

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

        theout.print(numbers[count][count2]);

      }

      theout.println();
      
    }

    theout.close();

  }

}