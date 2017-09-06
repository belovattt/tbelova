package ru.job4j;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public List<Integer> toList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int[] x : array) {
            for (int y : x) {
                list.add(y);
            }
        }
        return list;
    }

    public int[][] toArray(List<Integer> list, int rows) {
        int col = list.size() / rows;
        if (list.size() % rows != 0) {
            col++;
        }
        int[][] array = new int[rows][col];
        int i = 0;
        int j = 0;
        for (Integer x : list) {
            array[i][j] = x;
            if (j < col - 1) {
                j++;
            } else {
                j = 0;
                i++;
            }
        }
        for (int k = j; k < col; k++) {
            array[rows - 1][k] = 0;
        }
        return array;
    }
}
