package gr11review.part2;

/**
* Utility with all the codes
* 
* @author: Addison Chan
*
*/

import java.io.*;
public class Utility {
  
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
       
       
      
        /returning answer to main
      return strnewsentence;

    }
    
  
  //average word in a text document
  public static double avgWord(String filenametxt) throws IOException {
    BufferedReader file = new BufferedReader(new FileReader(filenametxt));
      //varaibles
      String wordread;
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
    //2 for loop
    for(intcount6 = 0;intcount6<yeararray.length;intcount6++){
      for(intcount7=0;intcount7<yeararray[intcount6].length;intcount7++){
        dblaverage = (dblaverage+yeararray[intcount6][intcount7])/4;
        
        out.println(dblaverage);
      }
    }
    out.close();

  }
}
