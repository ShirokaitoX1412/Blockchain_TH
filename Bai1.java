import java.util.Scanner;
public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char mode; int key; String text, rs = "";
        while (true) { System.out.print("Nhap mode (e/d): "); mode = sc.next().charAt(0); if (mode=='e'||mode=='d') break; }
        while (true) { System.out.print("Nhap key (1-255): "); key = sc.nextInt(); if (key>0&&key<=255) break; }
        System.out.print("Nhap text: "); text = sc.next();  for (int i = 0; i < text.length(); i++) rs += (char)(text.charAt(i) ^ key);
        System.out.println("Ket qua: " + rs);   sc.close();}}
