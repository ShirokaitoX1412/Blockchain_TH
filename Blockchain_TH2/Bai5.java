package Blockchain_TH2;
import java.security.*;import java.util.*;
public class Bai5{
public static void main(String[]a)throws Exception{
test("5 5 OP_ADD 10 OP_EQUAL",List.of("5","5","OP_ADD","10","OP_EQUAL"));
test("3 OP_DUP OP_ADD 6 OP_EQUAL",List.of("3","OP_DUP","OP_ADD","6","OP_EQUAL"));
int n=123;String h=hash(n);
test("HASH+VERIFY",List.of(""+n,"OP_HASH160",h,"OP_EQUALVERIFY"));
test("ERR",List.of("5","FOO","OP_ADD"));
}
static void test(String n,List<String>s)throws Exception{System.out.println(n+" => "+run(s));}
static boolean run(List<String>s)throws Exception{
Stack<Object>st=new Stack<>();
for(int i = 0; i < s.size(); i++){  String t = s.get(i);
if(t.equals("OP_ADD")){if(st.size()<2)return false;Object b=st.pop(),a=st.pop();if(a instanceof Integer&&b instanceof Integer)st.push((int)a+(int)b);else return false;}
else if(t.equals("OP_EQUAL")){if(st.size()<2)return false;st.push(st.pop().equals(st.pop()));}
else if(t.equals("OP_EQUALVERIFY")){if(st.size()<2)return false;return st.pop().equals(st.pop());}
else if(t.equals("OP_DUP")){if(st.isEmpty())return false;st.push(st.peek());}
else if(t.equals("OP_HASH160")){if(st.isEmpty())return false;Object v=st.pop();if(v instanceof Integer)st.push(hash((int)v));else return false;}
else try{st.push(Integer.parseInt(t));}catch(Exception e){st.push(t);}}
return !st.empty()&&st.peek() instanceof Boolean?(Boolean)st.peek():false;}
static String hash(int x)throws Exception{
byte[]b=MessageDigest.getInstance("MD5").digest(MessageDigest.getInstance("SHA-256").digest((x+"").getBytes()));
String h="";for(byte v:b){String t=Integer.toHexString(v&255);if(t.length()==1)h+="0";h+=t;}return h;}}
