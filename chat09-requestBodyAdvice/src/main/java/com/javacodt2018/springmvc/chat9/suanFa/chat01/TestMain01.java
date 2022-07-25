package com.javacodt2018.springmvc.chat9.suanFa.chat01;

/**
 * @author crush
 */
public class TestMain01 {

    public static void main(String[] args) {
        String[] args2 = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        String xiang = "J";
        System.out.println(getRollNo(args2, xiang));
    }

    public static int getRollNo(String[] args, String xiang) {
        int low = 0;
        int high = args.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String x = args[mid];
            System.out.println("mid = " + mid);
            if (xiang.compareTo(x) == 0) {
                return mid;
            } else if (xiang.compareTo(x) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
