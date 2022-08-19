package ss10_dsa_list.model;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size = 0;
    private final static int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
    }

    /**
     * Lấy ra số lượng phần tử có trong myArrayList
     *
     * @return int : số lượng phần tử
     */
    public int size() {
        return this.size;
    }

    /**
     * Xóa tất cả phần tử có trong mảng
     */
    public void clear() {
        this.size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    /**
     * Thêm một phần tử vào cuối myArrayList
     *
     * @param e
     */
    public boolean add(E e) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = e;
        size++;
        return true;
    }

    /**
     * Thêm một phần tử vào myArrayList ở vị trí xác định
     *
     * @param e     : phần tử thêm vào
     * @param index : vị trí muốn thêm
     */
    public void add(E e, int index) {
        if (index > size || index < 0) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            ensureCapacity(5);
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
        size++;

    }

    /**
     * tìm kiếm phần tử trong myArrayList nếu có trả về vị
     * trí đầu tiên tìm thấy, ngược lại trả về -1
     *
     * @param e phần tử muốn tìm
     * @return vị trí tìm thấy
     */
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * kiểm tra có phần tử trong mản không, nếu có
     * trả về true ngược lại trả về false
     *
     * @param e
     * @return true or flase
     */
    public boolean contains(E e) {
        return indexOf(e) > -1;
    }

    /**
     * tạo một bản sao của myArrayList
     *
     * @return bản sao của myArraList
     */
    public MyArrayList<E> clone() {
        MyArrayList<E> myArrayListCopy = new MyArrayList<>();
        myArrayListCopy.size = this.size;
        myArrayListCopy.elements = Arrays.copyOf(elements, size);
        return myArrayListCopy;
    }

    /**
     * tăng kích thước của myArrayList
     *
     * @param capacity kích thước tăng lên
     */
    private void ensureCapacity(int capacity) {
        if (capacity >= 0) {
            int newSize = elements.length + capacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("Capacity:" + capacity);
        }
    }

    /**
     * Xóa một phần tử khỏi myArrayList, dựa trên vị trí của phần tử đó
     *
     * @param index vị trí phần tử
     * @return phần tử bị xóa
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        } else {
            E result = this.get(index);
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
            return result;
        }
    }

    /**
     * lấy ra phần tử, dựa vào vị trí của
     * phần tử ở trong myAaaryList
     *
     * @param index vị trí phần tử
     * @return phần tử tương ứng với vị trí truyền vào
     */
    public E get(int index) {
        return (E) this.elements[index];
    }
}
