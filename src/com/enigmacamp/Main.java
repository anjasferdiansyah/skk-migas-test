package com.enigmacamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        soalNoSatu(15);

        soalNoDuaA(5);
        soalNoDuaB(5);
        soalNoDuaC(5);
        soalNoDuaD(5);


       List<Integer> list = Arrays.asList(12, 9, 13, 6, 10, 4, 7, 2);
       soalNoTiga(list);
    }

    public static void soalNoSatu(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 12 == 0) {
                System.out.println("OKYES");
            } else if (i % 3 == 0) {
                System.out.println("OK");
            } else if (i % 4 == 0) {
                System.out.println("YES");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void soalNoDuaA(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void soalNoDuaB(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void soalNoDuaC(int n) {
        boolean increase = true;
        Integer currentNum = 1;


        for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(currentNum);
                    if (increase) {
                        currentNum++;
                    } else {
                        currentNum--;
                    }
                    if(currentNum >= n){
                        increase = false;
                    } else if (currentNum <= 1) {
                        increase = true;
                    }
                }

            System.out.println();
        }
    }
    public static void soalNoDuaD(int n) {
        int[][] arr = new int[n][n];

        int number = 1;

        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    arr[row][col] = number;
                    number++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    arr[row][col] = number;
                    number++;
                }
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(arr[row][col] + "\t");
            }
            System.out.println();
        }
    }

  public static void soalNoTiga(List<Integer> arr) {
        List<Integer> newArr = new ArrayList<>();

     arr.forEach(integer -> {
         if (integer % 3 == 0) {
             newArr.add(integer);
         }
     });
       newArr.sort(Integer::compareTo);
      System.out.println(newArr);

  }

    }