import java.util.*;
public class Bai5 {
    public static class ProofNode { 
        String hash;  char pos;  int lvl; 
        ProofNode(String h,char p,int l){hash=h;pos=p;lvl=l;} }
    public static List<ProofNode> getSPVProof(int idx,List<List<String>> tree){
        List<ProofNode> proof=new ArrayList<>();
        for(int lvl=0;lvl<tree.size()-1;lvl++){
            List<String> layer=tree.get(lvl); boolean isLeft=(idx%2==0);
            int partner=isLeft?idx+1:idx-1; if(partner>=layer.size()) partner=idx;
            proof.add(new ProofNode(layer.get(partner),isLeft?'R':'L',lvl+1)); idx/=2; }
        return proof;  }
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap so giao dich N: "); int N=Integer.parseInt(sc.nextLine().trim());
        List<String> txs=new ArrayList<>(); for(int i=0;i<N;i++){ System.out.print("TX "+i+": "); txs.add(sc.nextLine().trim()); }
        List<List<String>> tree=Bai4.buildMerkleTree(txs); String root=tree.get(tree.size()-1).get(0);
        System.out.println("MERKLE ROOT: "+root);
        System.out.print("Nhap chi so giao dich can xac thuc: "); int idx=Integer.parseInt(sc.nextLine().trim());
        List<ProofNode> proof=getSPVProof(idx,tree); String cur=tree.get(0).get(idx);
        System.out.println("\n*** MERKLE PATH (SPV) ***");
        for(int i = 0; i < proof.size(); i++){
            ProofNode p = proof.get(i); 
            System.out.println("Cap do "+p.lvl+" | Hash doi tac: "+p.hash.substring(0,10)+"... | Vi tri: "+p.pos);
            cur=Bai2.calcSHA256(p.pos=='R'?cur+p.hash:p.hash+cur);} 
        System.out.println("\nHash tinh toan cuoi: "+cur+"\nMerkle Root: "+root);
        System.out.println(cur.equals(root)?"XAC THUC THANH CONG":"XAC THUC THAT BAI"); sc.close();}}