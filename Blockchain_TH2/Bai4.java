package Blockchain_TH2;
import java.security.*;import java.util.*;
public class Bai4{
public static String sha256(String s){
try{byte[]h=MessageDigest.getInstance("SHA-256").digest(s.getBytes());
StringBuilder x=new StringBuilder();
for(int i=0;i<h.length;i++){String t=Integer.toHexString(0xff & h[i]);if(t.length()==1)x.append('0');x.append(t);}
return x.toString();}catch(Exception e){throw new RuntimeException(e);}}
public static void main(String[]a){
try(Scanner sc=new Scanner(System.in)){
System.out.print("Nhap du lieu: ");String d=sc.nextLine();
System.out.print("Nhap so 0 dau : ");int N=sc.nextInt();
long n=0,c=0;String pre="0".repeat(N),h;
while(true){c++;h=sha256(d+n);if(h.startsWith(pre))break;n++;}
System.out.println("Nonce: "+n+", Hash: "+h+", Attempts: "+c);}}
}
