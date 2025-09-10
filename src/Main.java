public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Pizza pizza1 = director.pineappleChickenPizza(25);
        Pizza pizza2 = new PizzaBuilder(30)
                .crust("thin")
                .sauceType("mustard")
                .cheese("cheddar")
                .beef(true)
                .olives(true)
                .tomatoes(true)
                .jalapenos(true)
                .build();
        System.out.println(pizza1);
        System.out.println(pizza2);

    }
}