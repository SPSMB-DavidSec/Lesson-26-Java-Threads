package cz.spsmb.sec.threads;

public class Main {



    public static void main(String[] args) throws InterruptedException {

        MD5HashDecrypt myThread = new MD5HashDecrypt(MD5Utils.hash("ahojahoj"), 8);
        myThread.start();
        while (myThread.isAlive()){
            System.out.println(String.format(" Status: %f", myThread.getStatus()));
            Thread.sleep(10000);
        }

        myThread.join();
        System.out.println("Finished.");
    }
}
