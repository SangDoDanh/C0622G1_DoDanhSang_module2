package person_management.service.impl;

import person_management.service.utils.exception.DateException;
import person_management.service.utils.exception.EmptyException;

import java.util.*;
import java.util.regex.Pattern;

public class InputService {
    private static final Scanner sc = new Scanner(System.in);
    static String getStr(String mes) {
        String results = "";
        while(true) {
            try{
                System.out.print(mes);
                results = sc.nextLine();
                if(results.length() == 0) {
                    throw new EmptyException("Không được để trống!");
                }
                break;
            } catch (EmptyException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return results;
    }
    public static String getDate(String mes) {
        String result = "";
        String regexDate = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
        boolean isDate = false;
        while (true) {
            try {
                System.out.print(mes);
                result = sc.nextLine();
                isDate = Pattern.matches(regexDate, result);
                if(!isDate) {
                    throw  new DateException("Vui lòng nhập theo định dạng sau : dd/mm/yyyy");
                }
                break;
            } catch (DateException e) {
                System.out.println(e.getMessage());
            }  catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
    public static int getNumberInteger(String mes, int min, int max) {
        int result;

        while (true) {
            try{
                System.out.println(mes);
                result = Integer.parseInt(sc.nextLine());
                if(result >= min || result <= max) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.printf("Vui lòng nhập số, số %d...%d: ", min, max);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return result;
    }

    public static double getNumberDouble(String mes, double min, double max) {
        double result;

        while (true) {
            try{
                System.out.println(mes);
                result = Double.parseDouble(sc.nextLine());
                if(result >= min || result <= max) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.printf("Vui lòng nhập số, số %f...%f: ", min, max);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        return result;
    }

}
