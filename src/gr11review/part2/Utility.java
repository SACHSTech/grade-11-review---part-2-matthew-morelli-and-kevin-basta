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

  /**
  * Given a string, returns sum of all numbers entered.
  * A new number is any number seperated by a non-number.
  *
  * @param str  The string that will be analyzed
  * @return The sum of the numbers in the string
  * @author Matthew Morelli
  */ 
  public static int sumNumbers(String str) {

    int len = str.length();
    int count;
    String currentNum = "";
    int total = 0;
    String strTotal = "0";
    String currentSubstring;

    for (count = 0; count < len; count++) {

      currentNum = "";

      currentSubstring = str.substring(count, count + 1);

      if (Character.isDigit(str.charAt(count))) {
        
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

  //plusOut
  /**
* a string and a non-empty word string, return a version of the original String where all chars have 
*been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
*
* @param str  gets the sentence
* @param word gets the word to be only shown and is excluded
* @return retruns the sentence with ++ instead of the word thats was excluded
* @author Addison Chan
*/
  public static String plusOut (String str, String word) {
    

      //varaibles
        String stroldsentence = "";
        String strnewsentence = "";
        int intcount;
        stroldsentence = str.replace(word, "+");
        //for loop
        for (intcount = 0; intcount < stroldsentence.length(); intcount++) {
          //if statement
          if (stroldsentence.substring(intcount, intcount + 1).equals("+")) {
            strnewsentence += word;
          } else {
            strnewsentence += "+";
          }
        }
       
       
      
        //returning answer to main
      return strnewsentence;

    }
    
  
  /**
* a method longestWord(String filenametxt) such that given the name of a file filenametxt that contains 
* a single word on each line, returns the longest word in the file.
*
* @param filenametxt picks the txt document
* @return gets the average
* @author Addison Chan
*/
  public static double avgWord(String filenametxt) throws IOException {
    BufferedReader file = new BufferedReader(new FileReader(filenametxt));
      //varaibles
      String wordread;
      String readingworld;
      double finalnumber;
      double average;
      double intcount2;
      //initializing varaibles
      finalnumber = 0;
      intcount2 = 0;
      wordread = "";
      readingworld="";
      
      
      //while loop to read every word
      while((wordread = file.readLine()) != null){
        //wordread = file.readLine();
       finalnumber = wordread.length() + finalnumber;
        intcount2 = intcount2 +1;
       

       } 
        file.close();
        average = finalnumber/intcount2;
        
        return average;
      }
      
        //either24
        /**
* an array of ints, return true if the array contains a 2 next to a 2 or a 4 next to a 4, but not both.
*
* @param nums gets the array and performs the either24 code
* @return either is true or false if 2 is beside a 2 or a 4 beside 4
* @author Addison Chan
*/
      
      public static boolean either24(int[] nums){
    //variables
    int intcount3;
    boolean inttwos = false;
    boolean intfours = false;
  
      for(intcount3 = 0; intcount3<nums.length -1; intcount3++){
        if(nums[intcount3]==2 && nums[intcount3+1]==2)inttwos = true;
        if(nums[intcount3]==4 && nums[intcount3]==4)intfours = true;
      
    }
      return(inttwos ^ intfours);
    }
    
      //maxSpan
      /**
* the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the 
* number of elements between the two inclusive. A single value has a span of 1. Returns the largest span 
* found in the given array. (Efficiency is not a priority.)
*
* @param nums gets the array and performs the max span of the array
* @return finds the span of the array
* @author Addison Chan
*/
      public static int maxSpan(int[] nums){
        //variables
      int intcount4;
      int intcount5;
      int intspan;
      int intcalculation;
      //initializing 
      intspan = 0;
        for(intcount4 = 0; intcount4 < nums.length; intcount4++){
          for(intcount5 = 0; intcount5 < nums.length; intcount5++){
            if(nums[intcount4] == nums[intcount5]){
            intcalculation = intcount5 - intcount4 + 1;
            intspan = Math.max(intcalculation,intspan);

      }

    }
    }
    return intspan;
    
  }
  //year average
  /**
* a method that defines a two dimensional array that holds the table of scoring average data shown above 
* (the grey area). The method will compute the average value of each of the 5 years and output the 
* averages to a file yearAvg.txt. Each value will be on it's own line.
*
* @param N/A
* @return prints the 6 averages into the txt document
* @author Addison Chan
*/
  public static void yearAvg() throws IOException {
    //varaibles
    double dblaverage;
    int intcount6;
    int intcount7;
    //initializing varaibles
    dblaverage = 0;
    //array with all players
    double[][] yeararray;
    yeararray= new double[5][4];
    yeararray[0][0]=19.1;
    yeararray[0][1]=26.5;
    yeararray[0][2]=17.6;
    yeararray[0][3]=21.1;
    yeararray[1][0]=23.1;
    yeararray[1][1]=32.6;
    yeararray[1][2]=21.4;
    yeararray[1][3]=23.3;
    yeararray[2][0]=26.5;
    yeararray[2][1]=33.4;
    yeararray[2][2]=18.9;
    yeararray[2][3]=27.5;
    yeararray[3][0]=24.1;
    yeararray[3][1]=31.2;
    yeararray[3][2]=21.2;
    yeararray[3][3]=25.6;
    yeararray[4][0]=26.8;
    yeararray[4][1]=29.1;
    yeararray[4][2]=25.1;
    yeararray[4][3]=26.2;
   //writing into a file 
    PrintWriter out = new PrintWriter(new FileWriter("src/gr11review/part2/yearAvg.txt", false));
    //2 for loops
    for(intcount6 = 0;intcount6<yeararray.length;intcount6++){
      for(intcount7=0;intcount7<yeararray[intcount6].length;intcount7++){
        dblaverage = (dblaverage+yeararray[intcount6][intcount7])/4;
        
        
      }
      out.println(dblaverage);
    }
    out.close();

  }
}

