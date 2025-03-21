package org.example.defaultMethod;

public class MostSpecific {

  public static void main(String... args) {
    new C().hello();
    new E().hello();
    new G().hello();
  }

  static interface A {

    public default void hello() {
      System.out.println("Hello from A");
    }

  }

  static interface B extends A {

    @Override
    public default void hello() {
      System.out.println("Hello from B");
    }

  }

  static class C implements B, A {}

  static class D implements A {}

  static class E extends D implements B, A {}

  static class F implements B, A {

    @Override
    public void hello() {
      System.out.println("Hello from F");
    }

  }

  static class G extends F implements B, A {}

}
