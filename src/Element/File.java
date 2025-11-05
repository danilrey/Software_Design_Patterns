package Element;

import Visitor.Visitor;

public class File implements Element {
    String name;
    double size;

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFile(this);
    }

    public String getName() {
        return name;
    }
    public double getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(double size) {
        this.size = size;
    }


}
