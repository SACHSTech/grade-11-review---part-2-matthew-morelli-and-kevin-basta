package gr11review.part2;


import java.io.*;
public class Utility {
  
  public static String plusOut (String str, String word) {
      
        String stroldsentence = "";
        String strnewsentence = "";
        int intcount;
        stroldsentence = str.replace(word, "+");
        for (intcount = 0; intcount < stroldsentence.length(); intcount++) {
          if (stroldsentence.substring(intcount, intcount + 1).equals("+")) {
            strnewsentence += word;
          } else {
            strnewsentence += "+";
          }
        }
       
       
      

      return strnewsentence;

    }
    
  /*
  public static double avgWord(String filenametxt) throws IOException {
    BufferedReader file = new BufferedReader(new FileReader(filenametxt));
      
      String wordread;
      double finalnumber;
      double average;
      double intcount2;

      finalnumber = 0;
      intcount2 = 0;
      wordread = "";
      readingworld="";
      
      
      
      while((wordread = file.readLine()) != null){
        //wordread = file.readLine();
       finalnumber = wordread.length() + finalnumber;
        intcount2 = intcount2 +1;
       

       } 
        file.close();
        average = finalnumber/intcount2;
        
        return average;
      }
      */
    
    public static boolean either24(int[] nums){
    int inttwo;
    int intfour;
    int intcount3;
    boolean inttwo = false;
    boolean intfour = false;
  
    for(intcount3 = 0; intcount3<nums.length -1; intcount3++){
      if(nums[intcount3]==2 && nums[intcount3+1]==2) 
    }
    }
    
  }
