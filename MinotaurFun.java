// Ramir Dalencour
// COP 4520
// Prof. Juan Parra

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class MinotaurFun 
{
    // We make this global so we keep track of the number Guests
    public static int N;

    // We're making use of semaphores to keep track of traffic inside the labyrith
    // and using it as a mechanism to alert the minotaur(host) when everyone went through
    public static Semaphore labyrinthSemaphore = new Semaphore(1); // Let 1 Guest in at a time
    public static Semaphore everyoneInSemaphore = new Semaphore(0);


    static class Guest extends Thread 
    {
        private int id;
        private boolean hasEatenCupcake; // how we track if a guest had a cupcake

        public Guest(int id) 
        {
            this.id = id;
            hasEatenCupcake = false;
        }

        public void run() 
        {
            while (true) 
            {
                try 
                {
                    // We now enter the labyrinth
                    labyrinthSemaphore.acquire();
                    System.out.println("Guest " + id + " is in now.");

                    // Might remove
                    hasEatenCupcake = true;

                    // Our mechanism to check if everyone entered...
                    if (id == N - 1 && hasEatenCupcake) 
                    {
                        System.out.println("Everyone entered. Pinging Minotaur");
                        everyoneInSemaphore.release();
                        break;
                    }

                    labyrinthSemaphore.release();


                } catch (InterruptedException e) { } // Just do nothing
            }
        }
    }

    // This is just a representation of the minotaur and have there to receive signals
    static class Minotaur extends Thread 
    {
        public void run()
        {
            try 
            {
                // We have to wait for the signal that all guests entered...
                everyoneInSemaphore.acquire();

                // Minotaur thanking his guests for coming out to hang out
                System.out.println("Thanks for coming by!");
            } catch (InterruptedException e) { } // Do nothing
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        // Handling Input for number of guests
        Scanner sc = new Scanner(System.in);
        System.out.print("Please specify N (Number of guests): ");
        N = sc.nextInt();
        // Close Scanner
        sc.close();


        Guest [] guests = new Guest [N];

        for (int i = 0; i < N; i++)
        {
            guests[i] = new Guest(i);
            guests[i].start();
        }

        // Let's create one instance of host
        Minotaur minotaur = new Minotaur();

        minotaur.start();
        // System.out.println("We have made it here");
    }
}