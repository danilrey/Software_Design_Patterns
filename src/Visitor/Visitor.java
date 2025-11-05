package Visitor;

import Element.Directory;
import Element.File;

public interface Visitor {
    void visitFile(File file);
    void visitDirectory(Directory dir);
}
