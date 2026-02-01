public class MiniDuckSim {

  public static void main(String[] args) {
    Duck modelDuck = new ModelDuck();
    modelDuck.performFly();
    modelDuck.setFlyBehaviour(new FlyWithRocket());
    modelDuck.performFly();
  }
}
