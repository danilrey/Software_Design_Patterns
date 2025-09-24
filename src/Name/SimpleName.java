package Name;

public class SimpleName implements Name{
    private final String name;

    public SimpleName(String name) {
        this.name = name;
    }

    @Override
    public String showName() {
        return name;
    }
}
