package dev_java.design;

public class DuckSimulation {
  public static void main(String[] args) {
    Duck mallard = new MallardDuck();
    mallard.performQuack();
    mallard.performFly();
    Duck yourDuck = new WoodDuck();
    yourDuck.performQuack();
    yourDuck.performFly();
    Duck himDuck = new RubberDuck();
    himDuck.performQuack();
    himDuck.performFly();
  }
}