package Element;

import Visitor.Visitor;

import java.util.LinkedList;
import java.util.List;

public class Directory implements Element{
    String name;
    List<Element> elements =  new LinkedList<>();
    public Directory(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDirectory(this);
    }

    public String getName() {
        return name;
    }
    public List<Element> getElements() {
        return elements;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void add(Element element) {
        elements.add(element);
    }
}
