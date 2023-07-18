package com.aiz.nowcoder.od;

import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 五键键盘的输出
 * @description https://blog.nowcoder.net/n/c7bb482cddb647b5965c2f55ef13f7da
 * @date Create in 18:46 2023/7/18
 */
public class 五键键盘的输出 {
    /**
     * 屏幕
     */
    static String screen = "";
    /**
     * 剪贴板
     */
    static String clipboard = "";
    /**
     * 是否被选中
     */
    static boolean selected = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            int i = aChar - '0';
            handleKeyboard(i);
        }
        System.out.println(screen.length());
    }

    private static void handleKeyboard(int directives) {
        switch (directives) {
            case 1:
                handleA();
                break;
            case 2:
                handleCtrlC();
                break;
            case 3:
                handleCtrlX();
                break;
            case 4:
                handleCtrlV();
                break;
            case 5:
                handleCtrlA();
                break;
            default:
        }
    }

    private static void handleCtrlA() {
        selected = true;
    }

    private static void handleCtrlV() {
        if (selected) {
            screen = clipboard;
            selected = false;
        } else {
            screen += clipboard;
        }
    }

    private static void handleCtrlX() {
        if (selected) {
            clipboard = screen;
            screen = "";
            selected = false;
        }
    }

    private static void handleCtrlC() {
        if (selected) {
            clipboard = screen;
        }
    }

    private static void handleA() {
        if (selected) {
            screen = "a";
            selected = false;
        } else {
            screen += 'a';
        }
    }

}
