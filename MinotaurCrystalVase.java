// Ramir Dalencour
// COP 4520, Spring 2024
// Prof. Juan Parra

import java.util.*;
import java.util.concurrent.Semaphore;


class ShowRoom
{
    private Semaphore SRSemaphore = new Semaphore(1);

    public void enteredShowRoom(int guestID) throws InterruptedException
    {
        System.out.println("Guest " + guestID + " is waiting outside.");

        // Taking Access Away (NOW BUSY)
        SRSemaphore.acquire();

        System.out.println("Guest " + guestID + " is in the room.");
    }

    public void exitShowRoom(int guestID)
    {
        System.out.println("Guest " + guestID + " going out of the room");

        // Give access back (NOW AVAILABLE)
        SRSemaphore.release();
    }
}

class Guest extends Thread
    {
        private int guestID;
        private final ShowRoom showroom;

        public Guest(int guestID, ShowRoom showroom)
        {
            this.guestID = guestID;
            this.showroom = showroom;
        }

        public void run()
        {
            try 
            {
                showroom.enteredShowRoom(guestID);

                // Mimick time spent in room...
                sleep(1000);

                showroom.exitShowRoom(guestID);
            } catch (InterruptedException e){} // Do nothing
        }
    }

public class MinotaurCrystalVase
{

    public static void main(String [] args)
    {
        // Handling Input for number of guests
        Scanner sc = new Scanner(System.in);
        System.out.print("Please specify N (Number of guests): ");
        int N = sc.nextInt();
        ShowRoom showRoom = new ShowRoom();


        // Close Scanner
        sc.close();

        Guest [] guests = new Guest [N];

        for (int i = 0; i < N; i++)
        {
            guests[i] = new Guest(i + 1, showRoom);
            guests[i].start();
        }

        // Wait for the threads to be done by joining...
        try
        {
            for (Guest g : guests)
                g.join();
        } catch (InterruptedException e) { } // Just do nothing
    }
}