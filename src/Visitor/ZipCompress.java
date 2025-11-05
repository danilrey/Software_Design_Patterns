package Visitor;

import Element.Directory;
import Element.Element;
import Element.File;

public class ZipCompress implements Visitor {

    @Override
    public void visitFile(File file) {
        file.setSize(file.getSize()*0.85);
    }

    @Override
    public void visitDirectory(Directory dir) {
            for (Element el : dir.getElements()) {
                el.accept(this);
            }
    }
}
