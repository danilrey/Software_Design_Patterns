public class Pizza {
    private final int size;
    private final String crust;
    private final String cheese;
    private final boolean extraCheese;
    private final boolean pepperoni;
    private final boolean mushrooms;
    private final boolean onions;
    private final boolean sausage;
    private final boolean bacon;
    private final boolean pineapple;
    private final boolean olives;
    private final boolean chicken;
    private final boolean beef;
    private final boolean tomatoes;
    private final boolean jalapenos;
    private final String sauceType;

    protected Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.cheese = builder.cheese;
        this.extraCheese = builder.extraCheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.onions = builder.onions;
        this.sausage = builder.sausage;
        this.bacon = builder.bacon;
        this.pineapple = builder.pineapple;
        this.olives = builder.olives;
        this.chicken = builder.chicken;
        this.beef = builder.beef;
        this.tomatoes = builder.tomatoes;
        this.jalapenos = builder.jalapenos;
        this.sauceType = builder.sauceType;
    }

    @Override
    public String toString() {
        return "Pizza: size=" + size + ", crust=" + crust + ", cheese=" + cheese + ", extraCheese=" + extraCheese
                + ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + ", onions=" + onions + ", sausage="
                + sausage + ", bacon=" + bacon + ", pineapple=" + pineapple + ", olives=" + olives + ", chicken="
                + chicken + ", beef=" + beef + ", tomatoes=" + tomatoes + ", jalapenos=" + jalapenos + ", sauceType="
                + sauceType;
    }
}
