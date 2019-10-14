package com.mvabiguzzi.hackerrank.arrays;

import java.util.Arrays;
import java.util.Collections;

public class TwoDimensionsArrayDs {
    public static void main(final String[] args) {
//        int[][] param = {
//                {1, 1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0},
//                {1, 1, 1, 0, 0, 0},
//                {0, 0, 2, 4, 4, 0},
//                {0, 0, 0, 2, 0, 0},
//                {0, 0, 1, 2, 4, 0}
//        };
//        int result = hourglassSum(param);
//        System.out.println(result);

        int[][] param = new int[][]{
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        int result = hourglassSum(param);
        System.out.println(result);
    }

    static int hourglassSum(final int[][] arr) {
        final Integer[] hourglass = new Integer[(arr.length-2)*(arr[0].length-2)];
        Arrays.fill(hourglass, 0);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr[i].length-1); j++) {
                if (j < (arr[j].length-2)) {
                    final int hourglassId = (i*(arr[j].length-2)) + j;
                    hourglass[hourglassId] = hourglass[hourglassId]+arr[i][j]+arr[i][j+1]+arr[i][j+2];
                }
                if (i > 0 && j > 0) {
                    final int hourglassId = (i*(arr[j].length-2)) + (j - 1);
                    hourglass[hourglassId] = hourglass[hourglassId]+arr[i][j];
                }
                if (i > 1 && j < (arr[j].length-2)) {
                    final int hourglassId = (i*(arr[j].length-2)) + j;
                    hourglass[hourglassId] = hourglass[hourglassId]+arr[i][j]+arr[i][j+1]+arr[i][j+2];
                }
            }
        }

        Arrays.sort(hourglass, Collections.reverseOrder());

        return hourglass[0];
    }
}
