import java.util.Arrays;

public class MathUtils {

  public static void printInfo(
    String name,
    int age,
    String roll_num,
    String semester
  ) {
    System.out.println(name);
    System.out.println(age);
    System.out.println(roll_num);
    System.out.println(semester);
  }

  public static void arthematicOperations(int n_1, int n_2) {
    System.out.println(n_1 + " + " + n_2 + " = " + (n_1 + n_2));
    System.out.println(n_1 + " - " + n_2 + " = " + (n_1 - n_2));
    System.out.println(n_1 + " * " + n_2 + " = " + (n_1 * n_2));
    System.out.println(n_1 + " / " + n_2 + " = " + (n_1 / n_2));
  }

  public static double calculateDiscriminant(double a, double b, double c) {
    double discriminant = b * b - 4 * a * c;
    return discriminant;
  }

  public static double convertTemprature(double temp, char convert_to) {
    double new_temp = 0.0;
    if (convert_to == 'C') {
      return new_temp = ((temp - 32) * 5.0) / 9.0;
    } else if (convert_to == 'F') {
      return new_temp = ((temp * 9.0) / 5.0) + 32;
    } else {
      return new_temp;
    }
  }

  public static double performOperation(double n_1, double n_2, char operator) {
    double res;
    switch (operator) {
      case '+':
        res = n_1 + n_2;
        break;
      case '-':
        res = n_1 - n_2;
        break;
      case '*':
        res = n_1 * n_2;
        break;
      case '/':
        res = n_1 / n_2;
        break;
      default:
        res = 0.0;
        break;
    }

    return res;
  }

  public static int greaterOfThree(int n1, int n2, int n3) {
    int res;

    res = (n1 > n2) ? n1 : n2;

    res = (res > n3) ? res : n3;

    return res;
  }

  public static int sumOfHundredNumbers() {
    int res = 0;
    for (int k = 1; k <= 100; k++) {
      res += k;
    }
    return res;
  }

  public static int factorial(int n) {
    int res = 1;
    if (n == 1 || n == 0) {
      return res;
    }

    for (int k = n; k > 0; k--) {
      res *= k;
    }

    return res;
  }

  public static int linear_search(int arr[], int item) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      if (arr[i] == item) return i;
    }

    return -1;
  }

  public static int binary_search(int arr[], int item) {
    int beg = 0;
    int end = arr.length - 1;
    int mid = (beg + end) / 2;

    while (beg <= end && arr[mid] != item) {
      if (arr[mid] < item) {
        beg = mid + 1;
        mid = (beg + end) / 2;
      } else {
        end = mid - 1;
        mid = (beg + end) / 2;
      }
    }

    if (arr[mid] == item) {
      return mid;
    } else {
      return -1;
    }
  }

  public static void printArray(float arr[]) {
    for (float e : arr) {
      System.out.print(e + " , ");
    }
  }

  public static void bubbleSort(float arr[], String order) {
    int n = arr.length;

    for (int k = 0; k < n - 1; k++) {
      for (int ptr = 0; ptr < n - k - 1; ptr++) {
        if (order.equals("ascending")) {
          if (arr[ptr] > arr[ptr + 1]) {
            float temp = arr[ptr];
            arr[ptr] = arr[ptr + 1];
            arr[ptr + 1] = temp;
          }
        } else if (order.equals("descending")) {
          if (arr[ptr] < arr[ptr + 1]) {
            float temp = arr[ptr];
            arr[ptr] = arr[ptr + 1];
            arr[ptr + 1] = temp;
          }
        }
      }
    }
  }

  public static void selectionSort(int arr[]) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      int tmep = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = tmep;
    }
  }

  public static int median(int arr[]) {
    selectionSort(arr);

    int n = arr.length;

    if (n % 2 == 1) {
      return arr[n / 2];
    } else {
      return (arr[n / 2] + arr[n / 2 - 1]) / 2;
    }
  }

  public static void insertionSort(int arr[]) {
    int n = arr.length;

    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j = j - 1;
      }

      arr[j + 1] = key;
    }
  }

  public static int[][] matrixMultiplication(int A[][], int B[][]) {
    int col_A = A[0].length;
    int row_A = A.length;
    int col_B = B[0].length;
    int row_B = B.length;

    if (row_B != col_A) {
      throw new IllegalArgumentException("Incompatible matrix dimensions!");
    }

    int[][] C = new int[row_A][col_B];

    for (int i = 0; i < row_A; i++) {
      for (int j = 0; j < col_B; j++) {
        C[i][j] = 0;
        for (int k = 0; k < col_A; k++) {
          C[i][j] += A[i][k] * B[k][j];
        }
      }
    }

    return C;
  }

  public static void printMatrix(int M[][]) {
    for (int[] row : M) {
      for (int elm : row) {
        System.out.print(elm + " ");
      }
      System.out.println();
    }
  }

  public static double ratio(int likes, int dislikes) {
    if (likes + dislikes == 0) {
      return 0;
    }
    return ((double) likes / (likes + dislikes)) * 100;
  }
}
