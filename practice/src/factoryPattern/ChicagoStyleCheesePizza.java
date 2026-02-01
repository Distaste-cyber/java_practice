public class ChicageStyleCheesePizza extends Pizza {
  public ChicageStyleCheesePizza() {
    name = "Chicago Style Deep Dish and Cheese Pizza"
    dough = "Extra Thick Crust Dough";
    sauce = "Plum Tomato Sauce";

    toppings.add("Shredded Mozzarella Cheese");
  }

  void cut(){
    System.out.println("Cutting the pizza into square slices");
  }
}
