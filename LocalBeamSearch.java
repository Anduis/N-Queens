import java.util.Arrays;
import java.util.Comparator;

class LocalBeamSearch {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      printBoard(solve(8, 10, 10));
      System.out.println();
    }
  }

  static int[] solve(int n, int maxNumOfIterations, int numOfStates) {
    int[][] states = new int[numOfStates][];
    for (int i = 0; i < numOfStates; i++)
      states[i] = generateRandomState(n);
    for (int x = 0; x < maxNumOfIterations; x++) {
      int[][] newStates = new int[n * numOfStates][];// 80
      for (int i = 0; i < numOfStates; i++) {
        int activeThreats = threats(states[i]);
        if (activeThreats == 0) {
          System.out.println(x);
          return states[i];
        }
        for (int col = 0; col < n; col++) {
          newStates[i * n + col] = makeMove(states[i], col, activeThreats);
          // if stuck
          if (newStates[i * n + col] == null)
            newStates[i * n + col] = generateRandomState(n);
        }
      }
      Arrays.sort(newStates, Comparator.comparingInt(LocalBeamSearch::threats));
      states = Arrays.copyOfRange(newStates, 0, numOfStates);
    }
    return new int[n];
  }

  static int[] makeMove(int r[], int col, int activeThreats) {
    for (int row = 0; row < r.length; row++) {
      if (row == r[col])
        continue;
      int tmpRow = r[col];
      r[col] = row;
      if (activeThreats > threats(r)) {
        r[col] = row;
        return r;
      }
      r[col] = tmpRow;
    }
    return null;
  }

  static int[] generateRandomState(int n) {
    int[] r = new int[n];
    for (int i = 0; i < r.length; i++)
      r[i] = (int) (Math.random() * r.length);
    return r;
  }

  static int threats(int[] r) {
    int t = 0;
    for (int i = 0; i < r.length; i++)
      for (int j = i + 1; j < r.length; j++)
        if (r[i] == r[j] || Math.abs(r[i] - r[j]) == j - i)
          t++;
    return t;
  }

  static void printBoard(int[] A) {
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A.length; j++)
        System.out.print((A[j] != i || A[j] == -1) ? "|_" : "|Q");
      System.out.println("|");
    }
  }
}
