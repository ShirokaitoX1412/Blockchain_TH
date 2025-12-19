package Blockchain_TH3;
public class Bai2 {
    public static void main(String[] args) {
        String Hex = "00000000ffff0000000000000000000000000000000000000000000000000000";
        //at=actualTime,et=expectedTime,ft=finalTime,c=carry,r=remainder,ts=TimeStart,te=TimeEnd
        long ts = 1600000000L,te = 1600500000L,at = te - ts,et = 2016 * 10 * 60,ft = at,c=0,r = 0;
        if (at < et / 4) ft = et / 4;
        if (at > et * 4) ft = et * 4;
        byte[] target = new byte[32]; 
        for (int i = 0; i < 32; i++) {
            String sub = Hex.substring(i * 2, i * 2 + 2);
            target[i] = (byte) Integer.parseInt(sub, 16);}
        for (int i = target.length - 1; i >= 0; i--) {
            long current = (target[i] & 0xFF) * ft + c;
            target[i] = (byte) (current % 256); 
            c = current / 256;}
        for (int i = 0; i < target.length; i++) {
            long current = (target[i] & 0xFF) + r * 256;
            target[i] = (byte) (current / et); 
            r = current % et; }
        System.out.println("Thoi gian thuc te: " + (at / 60) + " phut");
        System.out.println("Ty le (ratio): " + ((double)ft / et));
        System.out.print("New Target (Hex): ");
        for (int i = 0; i < target.length; i++) {
            int v = target[i] & 0xFF;
            if (v < 16) System.out.print("0"); 
            System.out.print(Integer.toHexString(v));}System.out.println();}}