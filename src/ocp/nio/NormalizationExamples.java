package ocp.nio;

import java.nio.file.Paths;

/**
 * Created by Madalin.Colezea on 2/21/2017.
 * Ignores ./
 * Removes dir/..
 */
public class NormalizationExamples {
    public static void main(String[] args) {
        System.out.println("Initial: " + "/a/./b/./c" + " Normalized: " + Paths.get("/a/./b/./c").normalize());
        System.out.println("Initial: " + ".classpath" + " Normalized: " + Paths.get(".classpath").normalize());
        System.out.println("Initial: " + "/a/../../.././c" + " Normalized: " + Paths.get("/a/../.././c").normalize());
        System.out.println("Initial: " + "/a/b/c/.." + " Normalized: " + Paths.get("/a/b/c/..").normalize());
        System.out.println("Initial: " + "../a/b/c" + " Normalized: " + Paths.get("../a/b/c").normalize());
    }
}
