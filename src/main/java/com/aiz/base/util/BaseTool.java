package com.aiz.base.util;

import java.util.List;
import java.util.Objects;

/**
 * @author ZhangYao
 * @className AizTool
 * @description 判断相等的工具
 * @date Create in 16:56 2023/8/10
 */
public class BaseTool {
    public static void equals(int[] a, int[] b) {
        assert a.length == b.length;
        for (int i = 0; i < a.length; i++) {
            assert a[i] == b[i];
        }
    }

    public static void equals(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                assert a[i][j] == b[i][j];
            }
        }
    }

    public static void equals(List<?> listA, List<?> listB) {
        assert listA.size() == listB.size();
        for (int j = 0; j < listA.size(); j++) {
            if (listA.get(j) instanceof List) {
                equals((List<?>) listA.get(j), (List<?>) listB.get(j));
            } else {
                assert Objects.equals(listA.get(j), listB.get(j));
            }
        }
    }

}
