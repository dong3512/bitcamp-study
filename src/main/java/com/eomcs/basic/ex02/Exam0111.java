// String - 문자열 리터럴
package com.eomcs.basic.ex02;

public class Exam0111 {
  public static void main(String[] args) {

    // 문자열 리터럴
    // - string constant pool 메모리 영역에 String 인스턴스를 생성한다.
<<<<<<< HEAD
    // - 내용물이 같으면 기존 인스턴스의 주소를 리턴한다.
    // - 즉 메모리 절약을 위해 중복 데이터를 갖는 인스턴스를 생성하지 않는다.
=======
    // - 상수풀에 이미 같은 문자열의 인스턴스가 있다면, 그 주소를 리턴한다.
    // - 왜? 메모리 절약을 위해 중복 데이터를 갖는 인스턴스를 생성하지 않는다.
>>>>>>> 5215881aba7260f9ada34bd7e8e91b6648c42cb7
    // - JVM이 끝날 때까지 메모리에 유지된다.
    //
    String x1 = "Hello"; // 새 String 인스턴스의 주소를 리턴한다.
    String x2 = "Hello"; // 기존의 String 인스턴스 주소를 리턴한다.

    // 인스턴스의 주소를 비교해 보면,
    System.out.println(x1 == x2); // true => 두 String 객체는 같다.
  }
}

