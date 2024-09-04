package cz.spsmb.sec.threads;

import java.math.BigInteger;

public class MD5HashDecrypt extends Thread{
    int limit = 10;
    static String hashToCrack = "8b1a9953c4611296a827abf8c47804d7";

    static boolean found = false;

    double status;
    static long iterations = 0l;

    public MD5HashDecrypt(String hash, int maxLength){
        this.hashToCrack = hash;
        this.limit = maxLength;
    }

    static char[] alphabet = new char[] {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '
    };

    long possibleCombinations = (long)(Math.pow(alphabet.length, limit));


    @Override
    public void run(){
        for (int length = 1; length <= limit; length++) {
            if (!found) {
                generateVariations("", length);
                status = length / (double) limit;
            }
        }
    }

    public static void generateVariations(String prefix, int length) {
        if (length == 0) {
            //System.out.println(prefix);
            iterations++;
            if ((MD5Utils.hash(prefix)).equalsIgnoreCase(hashToCrack)){
                System.out.println("Password found " + prefix);
                found = true;
            }
            return;
        }
        for (char letter : alphabet) {
            if (!found){
                generateVariations(prefix + letter, length - 1);
            }
        }
    }

    public double getStatus() {
        return iterations/(double)(possibleCombinations);
    }
}
