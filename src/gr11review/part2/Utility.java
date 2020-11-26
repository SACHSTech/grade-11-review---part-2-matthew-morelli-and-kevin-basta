package gr11review.part2;
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
  }

  public int[] tenRun(int[] nums) {

    return l;
  }
}