package gr11review.part2;
import java.util.*;
import java.io.*;

public class Utility {

   /**
  * This method takes a string input and if the letters z and p
  * exsist in the string with only one letter between them, then 
  * that letter gets taken out of the string.
  *
  * @param str  This is the string given
  * @return this method returns a String that does not include 
  * the letters between the z's and p's in the original string
  * @author Kevin Basta
  */
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
  

  /**
  * This method is given a txt file an it determines what is the
  * longest word in that file
  *
  * @param filenametxt  This is the name of the text file that contains the words
  * @return this method returns the longes word it found in the text file
  * @author Kevin Basta
  */
  public static String longestWord(String filenametxt) throws IOException{
    BufferedReader textFile = new BufferedReader(new FileReader("src/gr11review/part2/" + filenametxt));
    int intLengthOfWord = 0;
    String strLongestWord = "";
    String strBufferWord = textFile.readLine();;

    while (strBufferWord != null) {
      if (strBufferWord.length() == strLongestWord.length()) {
        strLongestWord = strBufferWord;
      } else if (strBufferWord.length() > intLengthOfWord) {
        intLengthOfWord = strBufferWord.length();
        strLongestWord = strBufferWord;
      }
      strBufferWord = textFile.readLine();
    }
    textFile.close();

    return strLongestWord;
  } 


  /**
  * For each multiple of 10 in a given array, all the values following it 
  * are changed to that multiple of 10, until encountering another multiple 
  * of 10 in which that one gets repeated and so on. 
  *
  * @param nums  This is the array initially given
  * @return This returns a new array with the repeated multiples of 10 format
  * @author Kevin Basta
  */
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


   /**
  * This method tests to see if the values of one array
  * are all in a different array.
  * 
  * @param outer  an array of numbers longer than inner
  * @param inner  an array of numers shorter than outer 
  * @return a boolean value is returned depending on if all 
  * the inner values were in outer or not
  * @author Kevin Basta
  */
  public static boolean linearIn(int[] outer, int[] inner) {
    boolean trueOrFalse = true;
    int i;
    int ii;
    for (i = 0; i < inner.length; i++) {
      for (ii = 0; ii < outer.length; ii++) {
        if (outer[ii] == inner[i]) {
          trueOrFalse = true;
          break;
        } else if (outer[ii] != inner[i] && (ii == outer.length - 1)) {
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
  * This method is given the amount of rows and columns, and then 
  * generates a comma separted table containing i rows and j columns of pascal's triangle.
  *
  * @param i  The height of the array (or amount of rows)
  * @param j  The width of the array (or amount of columns)
  * @output prints the pascal's trinagle in the text file "pascalOut.txt"
  * @author Kevin Basta
  */
  public static void pascalTri(int i, int j) throws IOException {
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
    
    PrintWriter printTriangle = new PrintWriter(new FileWriter("src/gr11review/part2/pascalOut.txt", false));
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