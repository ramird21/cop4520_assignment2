import java.util.Scanner;

class actualThreading extends Thread
{
    public void run()
    {

    }
}

public class Threading2
{
    public static void main(String [] args)
    {
        // Problem 1: Minotaur's Birthday Party
        int N;
        Scanner sc = new Scanner(System.in);

        System.out.print("Please specify N (Number of guests): ");

        N = sc.nextInt();

        // This is maybe the infrastructure things will have
        // for (int i = 0; i < N; i++)
        // {
        //     actualThreading t = new actualThreading();

        //     t.start();
        // }
        
    }
}