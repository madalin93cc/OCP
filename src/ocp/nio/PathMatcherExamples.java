package ocp.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Madalin.Colezea on 2/22/2017.
 * starts wirh "glob:"
 * ** anything including directories
 * * anything excluding directories
 * {A, B} A or B
 * [a-b] interval
 * ? any character
 * \\* literal *
 */
public class PathMatcherExamples {
    public static void main(String[] args) throws IOException{
        DirsVisitor dirsVisitor = new DirsVisitor();
        Files.walkFileTree(Paths.get("D:/Alte documente"), dirsVisitor);
    }
}

class DirsVisitor extends SimpleFileVisitor<Path> {

    private PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/**/{[a-e],p}*.?x?");
    public FileVisitResult visitFile(Path p, BasicFileAttributes attributes) {
        if (pathMatcher.matches(p)) {
            System.out.println(p.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}
