package Blockchain_TH2;
import java.util.*;

class Block{int i;String d,p,h;Block(int x,String y,String z){i=x;d=y;p=z;h=calc();}
    String calc(){int t=i;for(char c:(d+p).toCharArray())t+=c;return t+"";}
    public String toString(){return i+"|"+d+"|"+p+"|"+h;}
}
class SimpleChain{List<Block>a=new ArrayList<>();
    void add(String d){String p=a.isEmpty()?"0":a.get(a.size()-1).h;a.add(new Block(a.size(),d,p));}
    boolean ok(){for(int i=0;i<a.size();i++){Block b=a.get(i);if(!b.h.equals(b.calc())||(i>0&&!b.p.equals(a.get(i-1).h)))return false;}return true;}
    void trace(){if(!ok())a.forEach(System.out::println);}
}

public class Bai1{public static void main(String[]x){
    SimpleChain c=new SimpleChain();c.add("Alice,5,Bob");c.add("Bob,2.5,Charlie");c.add("Charlie,1.2,Dave");
    c.trace();System.out.println("Chain OK? "+c.ok());
}}
