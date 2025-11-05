package Element;

import Visitor.Visitor;

public interface Element {
    void accept(Visitor visitor);
}
