package com.eomcs.test;

public class Test {
  public static void main(String[] args) {
    Engine setaEngine = new Engine();
    Car sonata = new Car();
    sonata.engine = setaEngine;

    sonata.start();
    sonata.stop();
  }
}
