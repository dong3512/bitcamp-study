// Object 클래스 - getClass() : 해당 클래스의 정보를 리턴한다.
package com.eomcs.basic.ex01;

public class Exam0160 {

  static class My {
  }

<<<<<<< HEAD
  static String m() {
    return "100";
  }

  public static void main(String[] args) {
    My obj1 = new My();

    String a = m();

    // 레퍼런스를 통해서 인스턴스의 클래스 정보를 알아낼 수 있다.

=======
  public static void main(String[] args) {
    My obj1 = new My();

    // 레퍼런스를 통해서 인스턴스의 클래스 정보를 알아낼 수 있다.
>>>>>>> 5215881aba7260f9ada34bd7e8e91b6648c42cb7
    Class classInfo = obj1.getClass();

    // 클래스 정보로부터 다양한 값을 꺼낼 수 있다. 
    System.out.println(classInfo.getName());
    System.out.println(classInfo.getSimpleName());
  }
}







