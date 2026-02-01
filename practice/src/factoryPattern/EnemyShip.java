public abstract class EnemyShip {

  private String name;

  private double amtDamage;

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public double getDamage() {
    return amtDamage;
  }

  public void setDamage(double damage) {
    this.amtDamage = damage;
  }

  public void followHeroShip() {
    System.out.println(getName() + " is following the Hero Ship");
  }

  public void displayEnemyShip() {
    System.out.println(getName() + " is on the screen");
  }

  public void enemyShipShoots() {
    System.out.println(
      getName() + " shoots and does " + getDamage() + " damage"
    );
  }
}
