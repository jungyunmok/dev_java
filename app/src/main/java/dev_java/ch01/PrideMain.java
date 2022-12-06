package dev_java.ch01;

public class PrideMain {
  public static void main(String[] args) {
    Pride myCar = new Pride();
    System.out.println(myCar); // @1c4af82c
    Pride herCar = new Pride();
    System.out.println(herCar); // @379619aa

    herCar = myCar;
    System.out.println(myCar); // @1c4af82c
    System.out.println(herCar); // @1c4af82c

    System.out.println(myCar == herCar);
  }
}
