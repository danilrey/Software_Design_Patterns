import Element.*;
import Visitor.*;

public class Client {
    public static void run() {
        Directory dir1 = new Directory("Documents");
        File file1 = new File("main.txt", 30);
        File file2 = new File("assignment.pdf", 60);
        File file3 = new File("certificate.txt", 30);
        Directory dir2 = new Directory("MyDir");
        File file4 = new File("funnyCat.png",150);
        File file5 = new File("toDoList.txt", 20);
        File file6 = new File("script.sh", 40);

        dir1.add(file1);
        dir1.add(file2);
        dir1.add(file3);
        dir2.add(file4);
        dir2.add(file5);
        dir2.add(file6);

        Size sizeCount = new Size();
        Tree treeLs = new Tree();
        TarCompress tarCompress = new TarCompress();
        ZipCompress zipCompress = new ZipCompress();

        sizeCount.visitFile(file1);
        System.out.println("File " + file1.getName() + " size - " + sizeCount.getSize());
        treeLs.visitDirectory(dir1);
        file4.accept(tarCompress);
        file5.accept(zipCompress);
        file6.accept(zipCompress);
        sizeCount.visitDirectory(dir2);
        System.out.println("Directory " + dir2.getName() + " size - " + sizeCount.getSize());
        treeLs.visitDirectory(dir2);

    }
}