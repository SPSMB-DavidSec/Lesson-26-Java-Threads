package cz.spsmb.sec.threads;

public class CircuitSolver extends Thread {

    public void run(){
        for (int r1 = 1; r1 < 1000; r1++) {
            for (int r2 = 1; r2 < 1000; r2++) {
                for (int r3 = 1; r3 < 1000; r3++) {
                    double result = solve3Parallel(r1,r2,r3);
                    if (result %1 == 0){
                        System.out.println(String.format("R = %s; R1=%s, R2=%s, R3=%s", result, r1, r2, r3));
                    }
                }
            }
        }
    }

    /**
     *  °------
     *         |
     *    -----------
     *    |
     *
     * Vzorec pro výpočet 3 rezistorů paraleleně
     * @param r1
     * @param r2
     * @param r3
     * @return
     */
    private double solve3Parallel(int r1, int r2, int r3){
        return (r1*r2*r3)/((double)(r1*r2) + (r1*r3) + (r2*r3));
    }
}
