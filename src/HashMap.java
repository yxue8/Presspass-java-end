public class HashMap {

  //Data fields
  private char[] translation;
  private final int SIZE = 38;

  //Constructor
  public HashMap() {
      translation = new char[SIZE];
      translation[0] = 'a';
      translation[1] = 'b';
      translation[2] = 'c';
      translation[3] = 'd';
      translation[4] = 'e';
      translation[5] = 'f';
      translation[6] = 'g';
      translation[7] = 'h';
      translation[8] = 'i';
      translation[9] = 'j';
      translation[10] = 'k';
      translation[11] = 'l';
      translation[12] = 'm';
      translation[13] = 'n';
      translation[14] = 'o';
      translation[15] = 'p';
      translation[16] = 'q';
      translation[17] = 'r';
      translation[18] = 's';
      translation[19] = 't';
      translation[20] = 'u';
      translation[21] = 'v';
      translation[22] = 'w';
      translation[23] = 'x';
      translation[24] = 'y';
      translation[25] = 'z';
      translation[26] = '1';
      translation[27] = '2';
      translation[28] = '3';
      translation[29] = '4';
      translation[30] = '5';
      translation[31] = '6';
      translation[32] = '7';
      translation[33] = '8';
      translation[34] = '9';
      translation[35] = '0';
      translation[36] = '@';
      translation[37] = '.';
  }

  public void convert() {
    int index = translation.length - 1;

    while (index > 0) {
      char temp = translation[index-1];
      translation[index-1] = translation[index];
      translation[index] = temp;
      index--;
    }
  }

  public void revert() {
    int index = 0;

    while (index < translation.length - 1) {
      char temp = translation[index + 1];
      translation[index + 1] = translation[index];
      translation[index] = temp;
      index++;
    }
  }

  public int getIndex(char convert) {
    for (int i = 0; i < translation.length; i++) {
      char temp = translation[i];
      if (temp == convert) {
        return i + 1;
      }
    }

    return -1;
  }

  public char getChar(int index) {
      return translation[index - 1];
  }

  public void printMap() {
    for (int i = 0; i < translation.length; i++) {
      System.out.println(translation[i]);
    }
    System.out.println("");
  }
}