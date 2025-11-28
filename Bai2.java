import java.io.*; 
import java.security.*;
public class Bai2 {
    public static String calcSHA256(File f) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream(f);
        byte[] buf = new byte[4096]; int n;
        while ((n=fis.read(buf))!=-1) md.update(buf,0,n);
        fis.close();
        byte[] h = md.digest();
        StringBuilder sb = new StringBuilder();
        for(byte b:h){ String x=Integer.toHexString(b&0xff); if(x.length()==1) sb.append('0'); sb.append(x); }
        return sb.toString();}
    public static String calcSHA256(String s) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] h = md.digest(s.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for(byte b:h){ String x=Integer.toHexString(b&0xff); if(x.length()==1) sb.append('0'); sb.append(x); }
        return sb.toString();}
    public static void main(String[] args) throws Exception {
        if(args.length!=1){ System.out.println("Nhap ten file"); return; }
        System.out.println(calcSHA256(new File(args[0])));}}
