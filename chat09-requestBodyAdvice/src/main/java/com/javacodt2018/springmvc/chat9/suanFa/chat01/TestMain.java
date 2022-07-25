package com.javacodt2018.springmvc.chat9.suanFa.chat01;

/**
 * @author crush
 */
public class TestMain {

    public static void main(String[] args) {
        int[] shuZu = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int xiang = 100;
        System.out.println(getXiaBiao(shuZu, xiang));
    }

    public static int getXiaBiao(int[] shuZu, int xiang) {
        int low = 0;
        int high = shuZu.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = shuZu[mid];
            System.out.println("mid=====" + mid);
            if (guess == xiang) {
                return mid;
            } else if (guess > xiang) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
