package gr11review.part2;
import java.util.*;
import java.io.*;

public class Utility {
  public static String zipZap(String str) {
    String strLetterBefore;
    String strFirstLetter;
    String strSecondLetter;
    String strReturnPattern;
    strReturnPattern = "";
    int i;
    i = 0;

    for (i = 0; i <= str.length() - 2; i++) {
      strFirstLetter = str.substring(i, i + 1);
      
      if (i == 0) {
        strReturnPattern += strFirstLetter;
      } else {
        strSecondLetter = str.substring(i + 1, i + 2);
        strLetterBefore = str.substring(i - 1, i);
        
        if (strLetterBefore.equalsIgnoreCase("z") && strSecondLetter.equalsIgnoreCase("p")) {
          
        } else {
          strReturnPattern += strFirstLetter;
        }

        if (i == str.length() - 2) {
          strReturnPattern += strSecondLetter;
        }
      }
    }

    return strReturnPattern;
  }

  /*
  public static String longestWord(String filenametxt) {
    BufferedReader textFile = new BufferedReader(new FileReader("RandomWords.txt"));
    int intLengthOfWord = 0;
    int intLengthOfFile = 0;
    String strLongestWord = "";
    String strBufferWord = "";
    int i = 0;

    while (textFile.readLine() != null) {
      strBufferWord = textFile.readLine();
      if (strBufferWord.length() > intLengthOfWord) {
        intLengthOfWord = strBufferWord.length();
        strLongestWord = strBufferWord;
      }
    }
    textFile.close();

    return strLongestWord;
  } */

  public static int[] tenRun(int[] nums) {
    int[] outputNumbers;
    outputNumbers = new int[nums.length]; 
    int numberAdding = 0;
    boolean blnRepeat = false;
    int i;
    for (i = 0; i < nums.length; i ++) {
      if (nums[i] % 10 == 0) {
        numberAdding = nums[i];
        blnRepeat = true;
      } else if (blnRepeat == true){

      } else {
        blnRepeat = false;
        numberAdding = nums[i];
      }

      outputNumbers[i] = numberAdding;
    }
    return outputNumbers;
  }

  public static boolean linearIn(int[] outer, int[] inner) {
    boolean trueOrFalse = true;
    int i;
    int ii;
    for (i = 0; i < inner.length; i++) {
      for (ii = 0; ii < outer.length; ii++) {
        if (outer[ii] == inner[i]) {
          System.out.println("P outer: " + outer[ii]);
          System.out.println("P inner: " + inner[i]);
          trueOrFalse = true;
          break;
        } else if (outer[ii] != inner[i] && (ii == outer.length - 1)) {
          System.out.println("N outer: " + outer[ii]);
          System.out.println("N inner: " + inner[i]);
          trueOrFalse = false;
          break;
        }
      }
      if (trueOrFalse == false) {
        break;
      }
    }

    return trueOrFalse;
  }

  /**
  * Description
  *
  * @param
  * @param
  * @return
  * @author Kevin Basta
  */

  public static void pascalTri(int i, int j) throws IOException{
    int intHeight;
    int intWidth;
    int intFillRowOne;
    int intFillColOne;
    int intLeft;
    int intAbove;
    int intPascalValue;
    int[][] pascalTriangle;
    pascalTriangle = new int[i][j];

    for (intFillRowOne = 0; intFillRowOne < i; intFillRowOne++) {
      pascalTriangle[intFillRowOne][0] = 1;
    }
    for (intFillColOne = 0; intFillColOne < j; intFillColOne++) {
      pascalTriangle[0][intFillColOne] = 1;
    }

    for (intHeight = 1; intHeight < i; intHeight++) {
      for (intWidth = 1; intWidth < j; intWidth++) {
        if (intHeight > 0) {
          intLeft = pascalTriangle[intHeight][intWidth - 1];
          intAbove = pascalTriangle[intHeight - 1][intWidth];
          intPascalValue = intLeft + intAbove;
          pascalTriangle [intHeight][intWidth] = intPascalValue;
        }
      }
    }
    
    PrintWriter printTriangle = new PrintWriter(new FileWriter("src/gr11review/part2/pascalTriangleFile.txt", true));
    for (intHeight = 0; intHeight < i; intHeight++) {
      for (intWidth = 0; intWidth < j; intWidth++) { 
        if (intWidth == j - 1) {
          printTriangle.print(pascalTriangle[intHeight][intWidth]);
        } else {
          printTriangle.print(pascalTriangle[intHeight][intWidth] + ", ");
        }
      }
      printTriangle.println("");
    }
    printTriangle.close();
  }
}