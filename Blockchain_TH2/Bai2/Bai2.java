package Blockchain_TH2.Bai2;
import java.io.*;
import java.util.*;
class Bai2 {
    public static void main(String[] args) {
        Map<String, Double> balances = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("trans.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String from = parts[0].trim(), to = parts[1].trim();
                double amount = Double.parseDouble(parts[2].trim());
                if(!from.equals("COINBASE")) {
                    balances.put(from, balances.getOrDefault(from, 0.0) - amount);  }
                balances.put(to, balances.getOrDefault(to, 0.0) + amount);  }} 
             catch(Exception e){  e.printStackTrace();}
        balances.forEach((wallet, balance) ->
            System.out.println(wallet + " : " + balance) ); }}