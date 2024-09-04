package cz.spsmb.sec.threads;

public class MyThread implements Runnable {

    private int progress;

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            progress = i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getProgress() {
        return progress;
    }
}
