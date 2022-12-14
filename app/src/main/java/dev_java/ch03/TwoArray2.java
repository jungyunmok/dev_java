package dev_java.ch03;

public class TwoArray2 {
  public static void main(String[] args) {
    int arr[][] = new int[3][];
    // arr[0] = new int [3];
    arr[0] = new int[] { 1, 2, 3 };
    // arr[1] = new int [3];
    arr[1] = new int[] { 4, 5, 6, 7};
    // arr[2] = new int [3];
    arr[2] = new int[] { 8, 9, 10, 11, 12};


    
    // insert here-5출력
    System.out.println(arr[1][1]);
    // insert here-9출력
    System.out.println(arr[2][2]);
  }
}