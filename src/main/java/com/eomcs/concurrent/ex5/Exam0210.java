// 비동기 방식으로 인한 문제 및 해결책
package com.eomcs.concurrent.ex5;

public class Exam0210 {

  static class Account {
    String accountId;
    long balance;

    public Account(String accountId, long balance) {
      this.accountId = accountId;
      this.balance = balance;
    }

    public long withdraw(long money) {

      // 이 메서드처럼 여러 스레드가 같은 메모리(balance 필드)의 값을 
      //동시에 변경할 때 문제가 발생할 수 있는 코드를 
      // "크리티컬 섹션(임계영역; critical section) 또는 크리티컬 리전(critical region)"
      // 이라 부른다.

      long b = this.balance;

      delay();  // CPU를 뺏길 기회를 제공

      b -= money;

      delay();  // CPU를 뺏길 기회를 제공

      if (b < 0)
        return 0;

      delay();  // CPU를 뺏길 기회를 제공

      this.balance = b;

      delay();  // CPU를 뺏길 기회를 제공

      return money;
    }

    private void delay() {
      int delayCount = (int)(Math.random() * 1000);
      for (int i = 0; i < delayCount; i++)
        Math.asin(45.765); // CPU를 뺏길 기회를 제공
    }
  }

  static class ATM extends Thread {
    Account account;

    public ATM(String name, Account account) {
      super(name);
      this.account = account;
    }

    @Override
    public void run() {
      long money = 0;
      long sum = 0;

      while (true) {
        money = account.withdraw(100);
        if (money <= 0)
          break;
        sum += money;
      }
      System.out.printf("%s에서 찾은 돈: %d원\n", this.getName(), sum);
    }
  }




  public static void main(String[] args) {
    Account account = new Account("111-11-1111-111", 100_0000);

    ATM 강남 = new ATM("강남", account);
    ATM 서초 = new ATM("서초", account);
    ATM 부산 = new ATM("부산", account);
    ATM 대전 = new ATM("대전", account);
    ATM 광주 = new ATM("광주", account);

    강남.start();
    서초.start();
    부산.start();
    대전.start();
    광주.start();

    // 강남, 서초 등 여러 개의 스레드가
    // 같은 객체에 대해 메서드를 호출하여 동시에 값을 변경하려 할 때
    // 서로 그 메모리의 값을 덮어쓰는 문제가 발생한다.
    // 이처럼 여러 스레드가 동시에 실행할 때 문제를 일으키는 코드를
    // "임계 구역(Critical Section; Critical Region)"이라 부른다.
    // 이 예제에서는 여러 스레드가 동시에 호출하고,
    // 같은 인스턴스의 변수 값을 변경하는 메서드인 "withdraw()"가
    // critical section이다.
    //
  }
}


// 용어정리!

// 임계 구역(critical section)
// - 여러 스레드가 동시에 실행할 때 문제가 발생하는 코드 블록을 말한다.
// - critical region 이라고도 부른다.
// - 같은 메모리에 여러 스레드가 동시에 접근하여 값을 변경하려 할 때 문제가 발생하는 것이다.
//   즉 다른 스레드가 사용하는 변수의 값을 임의로 변경하면 그 스레드는 원래의 의도대로 
//   동작하지 않을 것이다.
// - "스레드 안전(thread safe)하지 않다"라고 말한다.
//
// 스레드 안전(thread safe)
// - 여러 스레드가 동시에 실행하더라도 아무런 문제가 되지 않는 코드를 말한다.
// - 여러 스레드가 같은 메모리에 접근하더라도 읽기만 한다면 아무런 문제가 되지 않는다.
//
// 세마포어(semaphore)
// - critical section에 접근하는 스레드의 수를 제어하는 기법
// - 보통 다음의 형식으로 표시한다.
//          semaphore(n)
//   n은 개수를 의미한다.
//   예) semaphore(3) : 동시에 3개의 스레드가 접근할 수 있다는 의미다.
// - 자바는 2개 이상의 접근을 허용하지 않는다. 오직 한 개만 가능하다.
//
// 뮤텍스(mutual exclusion; MUTEX)
// - critical section에 오직 한 개의 스레드만이 접근하는 것.
// - semaphore(1) 과 같다.
// - 자바에서 synchronized 는 해당 블록(critical section)을 뮤텍스로 선언하는 것이다.


