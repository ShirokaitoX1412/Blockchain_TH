import java.io.*;
public class Bai3 {
    public static void main(String[] args) throws Exception {
        File[] files;
        if (args.length > 0) {
            files = new File[args.length];
            for (int i = 0; i < args.length; i++) {
                files[i] = new File(args[i]);
            } } else {
            files = new File(".").listFiles(File::isFile);}
        if (files != null) {
            for (int i = 0; i < files.length; i++) { 
                File f = files[i];
                String hash = Bai2.calcSHA256(f);
                System.out.println(hash + "  " + f.getName());}}}}