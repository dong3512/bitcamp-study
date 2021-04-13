// 여러 개의 인터페이스를 구현한 객체를 자동 생성하기
package com.eomcs.reflect.ex06.e;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Exam0120 {

  public static void main(String[] args) {

    // Calculator, Calculator2, Calculator3 인터페이스를 구현한 
    // 클래스를 만들고 그 인스턴스를 생성하여 리턴한다.
    Object proxy = Proxy.newProxyInstance(
        Exam0120.class.getClassLoader(), 
        new Class[] {
            Calculator.class, 
            Calculator2.class, 
            Calculator3.class}, 
        // 2) 익명 클래스 문법을 이용하여 InvocationHandler 구현하기
        new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // newProxyInstance()가 생성한 객체에 대해 메서드를 호출할 때마다 이 메서드가 호출된다.
            int a = (int) args[0]; // auto-unboxing => ((Integer)args[0]).intValue();
            int b = (int) args[1]; // auto-unboxing => ((Integer)args[1]).intValue();

            switch (method.getName()) {
              case "plus":
                return a + b;
              case "minus":
                return a - b;
              case "multiple":
                return a * b;
              case "divide":
                return a / b;
              case "mod":
                return a % b;
            }
            return 0;
          }
        });

    // 자동 생성된 인터페이스 구현체를 사용하기
    // 1) Object 레퍼런스로 바로 사용하기
    // => 비록 proxy 레퍼런스가 가르키는 객체가 Calculator,calculator2,calculator3 인터페이스를
    //    구현한 클래스일지라도
    // 일단 proxy 레퍼런스의 타입이 Object

    //    int result = 0;
    //    result = proxy.plus(10,20); // 컴파일 오류!
    //    result = proxy.plus(10,20);// 컴파일 오류!
    //    result = proxy.plus(10,20);// 컴파일 오류!
    //    result = proxy.plus(10,20);// 컴파일 오류!
    //    result = proxy.plus(10,20);// 컴파일 오류!


    Calculator c1 = (Calculator) proxy;
    System.out.println(c1.plus(10, 20));
    System.out.println(c1.minus(10, 20));

    Calculator2 c2 = (Calculator2) proxy;
    System.out.println(c2.multiple(10, 20));
    System.out.println(c2.divide(10, 20));

    Calculator3 c3 = (Calculator3) proxy;
    System.out.println(c3.mod(10, 20));
  }

}






