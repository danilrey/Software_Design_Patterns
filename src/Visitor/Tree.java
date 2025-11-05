package Visitor;

import Element.Directory;
import Element.Element;
import Element.File;

public class Tree implements Visitor{
    int depth = 0;
    @Override
    public void visitFile(File file) {
        System.out.println("    ".repeat(depth) + "Visiting " + file.getName() + " size: " + file.getSize());
    }

    @Override
    public void visitDirectory(Directory dir) {
        System.out.println("    ".repeat(depth) + "Visiting directory " + dir.getName());
        depth++;
        for (Element el : dir.getElements()) {
            el.accept(this);
        }
        depth--;
    }
}
