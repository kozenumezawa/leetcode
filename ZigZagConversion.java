// https://leetcode.com/problems/zigzag-conversion/
public class ZigZagConversion {
  public String convert(String s, int numRows) {
      if(numRows == 1) {
          return s;
      }

      int N_BLOCK = s.length() / (2 * (numRows - 1)) + 1;

      int[][] index = new int[numRows][numRows * s.length()];
      for (int i = 0; i < numRows; i++) {
          for (int j = 0; j < (numRows * s.length()); j++) {
              index[i][j] = 0;
          }
      }

      for (int rows = 0; rows < numRows; rows++) {
          for (int block = 0; block < N_BLOCK; block++) {
              for (int column = 0; column < (numRows - 1); column++) {
                  if (column == 0 || rows == ((numRows - 1) - column)) {
                      index[rows][(numRows - 1) * block + column] = 1;
                  }
              }
          }
      }


      for (int i = 0; i < numRows; i++) {
          String test = "";
          for (int j = 0; j < s.length(); j++) {
              test += String.valueOf(index[i][j]) + " ";
          }
      }


      String answer = "";
      char[] charArray = s.toCharArray();
      int count = 0;

      char[][] answerChar = new char[numRows][numRows * s.length()];

      for (int j = 0; j < numRows * s.length(); j++) {
          for (int i = 0; i < numRows; i++) {
              if(index[i][j] == 1 && count < s.length()) {
                  answerChar[i][j] = charArray[count++];
              } else {
                  answerChar[i][j] = ' ';
              }

          }
      }

      // for (int i = 0; i < numRows; i++) {
      //     String test = "";
      //     for (int j = 0; j < s.length(); j++) {
      //         test += String.valueOf(answerChar[i][j]) + " ";
      //     }
      //     System.out.println(test);
      // }

      for (int rows = 0; rows < numRows; rows++) {
          for (int column = 0; column < numRows * s.length(); column++) {
              if (answerChar[rows][column] == ' ') {
                  continue;
              }
              answer += String.valueOf(answerChar[rows][column]);
          }
      }
      return answer;
  }
}
