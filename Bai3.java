import java.io.*;
public class Bai3 {
    public static void main(String[] args) throws Exception {
        File[] files;
        if (args.length > 0) {
            files = new File[args.length];
            for (int i = 0; i < args.length; i++) files[i] = new File(args[i]);
        } else {
            files = new File(".").listFiles(File::isFile); }
        for (File f : files) {
            String hash = Bai2.calcSHA256(f);  
            System.out.println(hash + "  " + f.getName()); }}}
