package com.eomcs.net.ex11.my;

import java.net.ServerSocket;

public class CalculatorServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");
      while (true) {

        RequestProcessor thread = new RequestProcessor(serverSocket.accept());

        thread.start();

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}