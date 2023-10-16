package org.example;

public class Calculator {
    private Number num1;
    private Number num2;

    public Calculator(Number num1, Number num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public static <T> double sum(Number num1, Number num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T> double multiply(Number num1, Number num2){
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T> double divide(Number num1, Number num2){
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <T> double subtract(Number num1, Number num2){
        return num1.doubleValue() - num2.doubleValue();
    }
}
