import java.util.*;
public class Bai4 {
    public static List<List<String>> buildMerkleTree(List<String> txs) throws Exception {
        List<List<String>> levels = new ArrayList<>();
        if (txs.isEmpty()) return levels;
        List<String> cur = new ArrayList<>();
        for (String t:txs) cur.add(Bai2.calcSHA256(t));
        levels.add(new ArrayList<>(cur));
        while (cur.size()>1) {
            if (cur.size()%2==1) cur.add(cur.get(cur.size()-1));
            List<String> next = new ArrayList<>();
            for (int i=0;i<cur.size();i+=2) next.add(Bai2.calcSHA256(cur.get(i)+cur.get(i+1)));
            cur = next;
            levels.add(new ArrayList<>(cur));}
        return levels;}
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so giao dich N: ");
        int N = Integer.parseInt(sc.nextLine().trim());
        List<String> txs = new ArrayList<>();
        for (int i=0;i<N;i++){ System.out.print("TX "+i+": "); txs.add(sc.nextLine().trim()); }
        List<List<String>> tree = buildMerkleTree(txs);
        System.out.println("MERKLE ROOT: "+tree.get(tree.size()-1).get(0));
        sc.close();}}
