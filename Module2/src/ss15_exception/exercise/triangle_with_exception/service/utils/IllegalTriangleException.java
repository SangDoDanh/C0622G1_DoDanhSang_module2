package ss15_exception.exercise.triangle_with_exception.service.utils;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(String message) {
        super(message);
    }
}
