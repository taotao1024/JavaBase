package com.lsy.oop.Exception;

import org.junit.runner.RunWith;

/**
 * @author yuanyuan
 * @version 1.0
 * @date 2020/10/09
 */
public class CustomException extends RuntimeException {
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public static void main(String[] args) {
        new CustomException().firstMethod();
    }

    private void firstMethod() {
        this.secondMethod();
    }

    private void secondMethod() {
        this.thirdMethod();
    }

    private void thirdMethod() {
        throw new CustomException("自定义异常");
    }
}
