public class NQueensBFS {

  private static int s = 0;

  static boolean isValid(int[] A, int k) {
    for (int i = 0; i < k; i++)
      if (A[i] == A[k] || Math.abs(A[i] - A[k]) == Math.abs(i - k))
        return false;
    return true;
  }

  public static void putboard(int[] A) {
    System.out.println("\nSolution " + (++s));
    for (int y = 0; y < A.length; y++) {
      for (int x = 0; x < A.length; x++) {
        System.out.print((A[y] == x) ? "|Q" : "|_");
      }
      System.out.println("|");
    }
  }

  static void printBoard(int[] A) {
    System.out.println();
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A.length; j++)
        System.out.print((A[j] != i || A[j] == -1) ? "|_" : "|Q");
      System.out.println("|");
    }
  }

  public static void main(String[] args) {
    int A[] = { -1, -1, -1, -1, -1, -1, -1, -1 };
    int i = 0;

    while (i >= 0) {

      do {
        A[i]++;
        printBoard(A);
      } while ((A[i] < A.length) && !isValid(A, i));

      if (A[i] < A.length)
        if (i < A.length - 1)
          A[++i] = -1;
        else
          putboard(A);
      else
        i--;

    }
  }
}