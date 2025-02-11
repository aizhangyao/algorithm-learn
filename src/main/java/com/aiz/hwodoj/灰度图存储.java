package com.aiz.hwodoj;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 灰度图存储
 * @description 灰度图存储
 * @date Create in 00:47 2025/2/9
 */
public class 灰度图存储 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*
        String[] lines = in.nextLine().split(" ");
        String[] size = new String[2];
        String[] data = new String[lines.length - 2];
        String[] target = in.nextLine().split(" ");
        for (int i = 0; i < lines.length; i++) {
            if (i < 2) {
                size[i] = lines[i];
            } else {
                data[i - 2] = lines[i];
            }
        }
         */
        in.close();

        String[] size = in.nextLine().split(" ");
        String[] data = in.nextLine().split(" ");
        String[] target = in.nextLine().split(" ");
        in.close();
        int targetValue = getValue(size, data, target);

        System.out.println(targetValue);
    }

    public static int getValue(String[] size, String[] data, String[] target) {
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        int index = 0;
        int currentRow = 0, currentCol = 0;
        int[][] imageMatrix = new int[row][col];
        while (index < data.length) {
            int value = Integer.parseInt(data[index++]);
            int count = Integer.parseInt(data[index++]);

            for (int i = 0; i < count; i++) {
                imageMatrix[currentRow][currentCol++] = value;
                if (currentCol == col) {
                    currentRow++;
                    currentCol = 0;
                }
            }
        }

        int targetRow = Integer.parseInt(target[0]);
        int targetCol = Integer.parseInt(target[1]);

        return imageMatrix[targetRow][targetCol];
    }

    @Test
    public void test() {
        String[] size = {"10", "10"};
        String[] data = {"56", "34", "99", "1", "87", "8", "99", "3", "255", "6", "99", "5", "255", "4", "99", "7", "255", "2", "99", "9", "255", "21"};
        String[] target = {"3", "4"};
        assert getValue(size, data, target) == 99;
    }

}
