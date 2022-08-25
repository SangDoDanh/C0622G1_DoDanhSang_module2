package ss19_regex.exercise;

public class RegexPhoneNumber {
    public static void main(String[] args) {
        System.out.println(regexNumberPhone("(84)-(0978489648)"));//true
        System.out.println(regexNumberPhone("(a8)-(22222222)"));//false
    }
    static boolean regexNumberPhone(String phoneNumber) {
        String regex = "[(]\\d{2}[)]-[(]0\\d{9}[)]";
        return phoneNumber.matches(regex);
    }
}
