package ocp.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 */
public class FileVisiterExamples {
    public static void main(String[] args) throws IOException{
        TestFileVisiter testFileVisiter = new TestFileVisiter();
        Files.walkFileTree(Paths.get("deldir"), testFileVisiter);
    }
}

class TestFileVisiter extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path p, BasicFileAttributes attributes) {
        System.out.println("Pre: " + p.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path p, BasicFileAttributes attributes) {
        System.out.println("Visit: " + p.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path p, IOException e) {
        System.out.println("Post: " + p.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path p, IOException e) {
        System.out.println("Failed: " + p.getFileName());
        return FileVisitResult.CONTINUE;
    }
}
