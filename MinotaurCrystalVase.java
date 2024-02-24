// Ramir Dalencour
// COP 4520, Spring 2024
// Prof. Juan Parra

import java.util.*;
import java.util.concurrent.Semaphore;



public class MinotaurCrystalVase
{

    public static int N;
    private static Semaphore bigDude = new Semaphore(1); // Allowing one access...



    static class Guest extends Thread
    {
        private int guestID;

        public Guest(int guestID)
        {
            this.guestID = guestID;
        }

        public void run()
        {

        }
    }



    public static void main(String [] args)
    {
        // Handling Input for number of guests
        Scanner sc = new Scanner(System.in);
        System.out.print("Please specify N (Number of guests): ");
        N = sc.nextInt();
        // Close Scanner
        sc.close();

        Guest [] guests = new Guest [N];
    }
}