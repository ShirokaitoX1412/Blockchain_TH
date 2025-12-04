package Blockchain_TH2.Bai3;
import java.io.*;
import java.util.*;
class Transaction {
    String id; int size,fee;double rate;   
    Transaction(String i, int s, int f){ id = i; size = s; fee = f; rate = (double)f / s; }
    public String toString() { return id + " | size: " + size + " | fee: " + fee + " | rate: " + rate;}}
class Bai3{
    public static void main(String[] args) {
        final int MAX_SIZE = 1000;
        List<Transaction> txs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("trans_fee.txt"))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                String id = parts[0].trim();
                int size = Integer.parseInt(parts[1].trim());
                int fee = Integer.parseInt(parts[2].trim());
                txs.add(new Transaction(id, size, fee));
            }
        } catch(Exception e){ e.printStackTrace(); }
        txs.sort((t1, t2) -> Double.compare(t2.rate, t1.rate));
        List<Transaction> selected = new ArrayList<>();
        int totalSize = 0, totalFee = 0;
       for (int i = 0; i < txs.size(); i++) {
            Transaction t = txs.get(i);
            if(totalSize + t.size <= MAX_SIZE){
                selected.add(t);
                totalSize += t.size;
                totalFee += t.fee;} }
        System.out.println("Cac giao dich duoc chon:");
        for (int i = 0; i < selected.size(); i++) {System.out.println(selected.get(i)); }
        System.out.println("Tong co: " + totalSize + " kB");
        System.out.println("Tong phi: " + totalFee + " satoshi");  }}