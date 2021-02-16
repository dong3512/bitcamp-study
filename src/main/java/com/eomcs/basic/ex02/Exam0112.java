// String - String 객체와 문자열 리터럴의 타입
package com.eomcs.basic.ex02;

public class Exam0112 {
  public static void main(String[] args) {

    String s1 = new String("Hello");
    String s2 = "Hello";

    // 문자열 리터럴이 String 객체인지 확인해보자.
<<<<<<< HEAD
=======
    System.out.println(s1 == s2);
>>>>>>> 5215881aba7260f9ada34bd7e8e91b6648c42cb7
    System.out.println(s1 instanceof String);
    System.out.println(s2 instanceof String);
  }
}


