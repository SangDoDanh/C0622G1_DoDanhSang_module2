package ss3_array_and_method.exercise;

public class AddElementArray {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        addElementByIndex(3, 10, numbers);
        displayArr(numbers);
    }
    static void addElementByIndex(int index, int value, int [] arr) {
        if(index >= arr.length) {
            System.out.println("array is full");
        } else {
            for(int i = arr.length -1; i > index; i--) {
                arr[i] = arr[i -1];
            }
            arr[index] = value;
        }
    }
    static void displayArr(int[] arr) {
        for (int item: arr) {
            System.out.print(item + "\t");
        }
    }
}
