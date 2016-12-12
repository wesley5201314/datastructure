package com.datastructure.strmatch;

/**
 * Created by wesley on 2016/12/12.
 * 字符串匹配算法
 *
 * @author wesley
 */
public class StringMatch {

    //BF算法
    public static int bfPatter(String sourceStr, String patternStr) {
        //标识是否已找到该字符串，i是源字符串的下标，j是匹配字符串的下标，k的作用是记录i的值
        int pos = -1, i = 0, j = 0, k = 0;
        //如果还没找到该字符串或者i已经到源字符串的末尾，则结束循环
        while (pos == -1 && i < sourceStr.length()) {
            //如果源字符串的第i字符串与匹配字符串的第j个相同，则i和j都指向下一个字符
            while (j < patternStr.length() && sourceStr.charAt(i) == patternStr.charAt(j)) {
                //i指向源字符串的下一个下标
                i++;
                //j指向匹配字符串的下一个下标
                j++;
                System.out.println("第" + (k + 1) + "趟:i=" + i + "j=:" + j);
            }
            //如果源字符串已完全匹配到匹配字符串
            if (j == patternStr.length()) {
                //返回i的位置
                pos = i - j;
            }
            //如果还没匹配完，则从i的下一个下标开始匹配
            else {
                k++;
                System.out.println("第" + k + "趟结束，因为源字符串下标为" + i + "的字符和匹配字符串的下标为" + j + "的字符不匹配");
                System.out.println("---------------------------------------------------------");
                i = k;
                //j从0开始
                j = 0;

            }

        }
        return pos;
    }

    //KMP算法
    public static int patternByKMP(String sourceStr, String patternStr) {
        int[] next = generateNext(patternStr);
        //i是源字符串的下标，j是匹配字符串的下标
        for (int i = 0, j = 0; i < sourceStr.length(); i++) {
            //匹配发生错误时，在 next 数组中向前迭代找到匹配的结果。这是整个算法的核心位置！
            while (j > 0 && sourceStr.charAt(i) != patternStr.charAt(j)) {
                j = next[j - 1];
            }
            //如果相等，pattern 中的索引往后移动一位
            if (sourceStr.charAt(i) == patternStr.charAt(j)){
                j++;
            }
            //pattern数组所有位置均连续的匹配完成
            if (j == patternStr.length()) {
                return i - patternStr.length() + 1;
            }
        }
        return -1;
    }

    /**
     * 获得字符串的next函数值
     *
     * @param patternStr
     * @return
     */
    public static int[] generateNext(String patternStr) {
        int[] next = new int[patternStr.length()];
        next[0] = 0; //第一个元素的 next 值为0。
        for (int i = 1, j = 0; i < patternStr.length(); i++) {
            while (j > 0 && patternStr.charAt(i) != patternStr.charAt(j)) {
                j = next[j - 1];

            }
            if (patternStr.charAt(i) == patternStr.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //int patterResult = bfPatter("acbacdabcacb", "abc");
        int patterResult1 = patternByKMP("acbacdabcacb", "abc");
       // System.out.println(patterResult == -1 ? "未匹配到该字符串" : "该字符串在源字符串的起始位置下标是" + patterResult);

        System.out.println(patterResult1 == -1 ? "未匹配到该字符串" : "该字符串在源字符串的起始位置下标是" + patterResult1);
    }

}
