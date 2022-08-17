package ss13_binary_search.exercise;

import java.util.Scanner;

public class SubStringAscendMaxLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        String strAscenMaxLength;

        System.out.print("Nhập vào một chuỗi:");
        str = sc.nextLine();
        strAscenMaxLength = stringAscendingMaxLength(str);
        System.out.printf("Chuỗi con liên tiếp lớn nhất trong %s : %s", str, strAscenMaxLength );
    }

    /**
     * Lấy ra chuỗi con liên tiếp có độ dài lớn nhất trong một chuỗi
     * các phần tử trong chuỗi con tăng dần theo theo bảng mã ascii
     * @param str kiểm tra chuỗi con liên tiếp lớn trong này
     * @return chuỗi con liên tiếp có độ dài lớn nhất
     */
    static String stringAscendingMaxLength(String str) {
        String strSub = "";
        String result = "";
        for (int i = 0; i < str.length()-1; i++) {
            strSub += str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    strSub += str.charAt(j);
                    i = j;
                } else {
                    i = j;
                    break;
                }

            }
            result = strSub.length() > result.length() ? strSub : result;
            strSub ="";
        }
        return result;
    }
}
