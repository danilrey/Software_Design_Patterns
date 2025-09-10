public class Director {
    public Pizza pepperoniPizza(int size) {
        return new PizzaBuilder(size)
                .crust("basic")
                .pepperoni(true)
                .sauceType("tomato")
                .cheese("mozzarella")
                .olives(true)
                .onions(true)
                .mushrooms(true)
                .build();
    }

    public Pizza pineappleChickenPizza(int size) {
        return new PizzaBuilder(size)
                .crust("fried")
                .chicken(true)
                .pineapple(true)
                .sauceType("tomato")
                .extraCheese(true)
                .cheese("cheddar")
                .build();
    }

    public Pizza baconMushroomPizza(int size) {
        return new PizzaBuilder(size)
                .crust("basic")
                .bacon(true)
                .mushrooms(true)
                .sauceType("tomato-mayonnaise")
                .cheese("mozzarella")
                .olives(true)
                .onions(true)
                .build();
    }
}
