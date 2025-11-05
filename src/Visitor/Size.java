package Visitor;

import Element.Directory;
import Element.Element;
import Element.File;

public class Size implements Visitor {
    double size = 0;
    @Override
    public void visitFile(File file) {
            size += file.getSize();
    }

    @Override
    public void visitDirectory(Directory dir) {
            for (Element el : dir.getElements()) {
                el.accept(this);
            }
    }

    public double getSize() {
        double result = size;
        size = 0;
        return result;
    }
}
