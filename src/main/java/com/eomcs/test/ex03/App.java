package com.eomcs.test.ex03;

public class App {

  public static void main(String[] args) {
    // 2 * 3 + 7 - 2 = 11
    calculator.result = 0;

    calculator.plus(2);
    calculator.multiple(3);
    calculator.plus(7);
    calculator.minus(2);

    System.out.println(calculator.result);
  }

}
