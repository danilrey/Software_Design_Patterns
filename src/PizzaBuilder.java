public class PizzaBuilder {
    protected int size;
    protected String crust;
    protected String cheese;
    protected boolean extraCheese;
    protected boolean pepperoni;
    protected boolean mushrooms;
    protected boolean onions;
    protected boolean sausage;
    protected boolean bacon;
    protected boolean pineapple;
    protected boolean olives;
    protected boolean chicken;
    protected boolean beef;
    protected boolean tomatoes;
    protected boolean jalapenos;
    protected String sauceType;

    public PizzaBuilder(int size) {
        this.size = size;
    }

    public PizzaBuilder crust(String crust) {
        this.crust = crust;
        return this;
    }
    public PizzaBuilder cheese(String cheese) {
        this.cheese = cheese;
        return this;
    }
    public PizzaBuilder extraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
        return this;
    }
    public PizzaBuilder pepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
        return this;
    }
    public PizzaBuilder mushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
        return this;
    }
    public PizzaBuilder onions(boolean onions) {
        this.onions = onions;
        return this;
    }
    public PizzaBuilder sausage(boolean sausage) {
        this.sausage = sausage;
        return this;
    }
    public PizzaBuilder bacon(boolean bacon) {
        this.bacon = bacon;
        return this;
    }
    public PizzaBuilder pineapple(boolean pineapple) {
        this.pineapple = pineapple;
        return this;
    }
    public PizzaBuilder olives(boolean olives) {
        this.olives = olives;
        return this;
    }
    public PizzaBuilder chicken(boolean chicken) {
        this.chicken = chicken;
        return this;
    }
    public PizzaBuilder beef(boolean beef) {
        this.beef = beef;
        return this;
    }
    public PizzaBuilder tomatoes(boolean tomatoes) {
        this.tomatoes = tomatoes;
        return this;
    }
    public PizzaBuilder jalapenos(boolean jalapenos) {
        this.jalapenos = jalapenos;
        return this;
    }
    public PizzaBuilder sauceType(String sauceType) {
        this.sauceType = sauceType;
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }
}
