package gr11review.part2;


import java.io.*;
public class Utility {
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
