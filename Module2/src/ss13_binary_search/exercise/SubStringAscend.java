package ss13_binary_search.exercise;

import java.util.Scanner;

public class SubStringAscend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        String strAscenMaxLength;

        System.out.print("Nhập vào một chuỗi:");
        str = sc.nextLine();
        strAscenMaxLength = stringAscending(str);
        System.out.printf("Chuỗi con lớn nhất trong %s : %s", str, strAscenMaxLength );
    }

    private static String stringAscending(String str) {
        String result = "";
        String strSub = "";
        for(int i = 0; i < str.length() -1; i++) {
            strSub += str.charAt(i);
            for(int j = i +1; j < str.length(); j++) {
                if(str.charAt(j) > str.charAt(i)) {
                    strSub += str.charAt(j);
                    i = j;
                }
            }
            result = strSub.length() > result.length() ? strSub : result;
        }
        return result;
    }
}
