package by.taskmanager.domain;

import java.util.InputMismatchException;

public class CountException extends RuntimeException {
    public CountException(String y){
        System.out.println(y);
    }
}
