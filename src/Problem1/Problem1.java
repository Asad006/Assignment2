package Problem1;

import java.util.Scanner;
import java.util.concurrent.atomic.*;

public class Problem1 {
    public static void main(String[] args) throws InterruptedException {
        //
        // scanner to prompt the user to enter the number of guests.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of guests invited to the party?");
        int numberOfGuests = scanner.nextInt();


        Guest.totalGuests = numberOfGuests;
        Thread[] guestThreads = new Thread[numberOfGuests];

        AtomicBoolean hasCupcake = new AtomicBoolean(true);
        AtomicBoolean isEveryoneVisited = new AtomicBoolean(false);

        // Count the number of entries to the labyrinth.
        int partyCount = 0;

        //Thread are the Guests.
        for (int i = 0; i < guestThreads.length; i++)
            guestThreads[i] = new Guest(hasCupcake, isEveryoneVisited, i == 0);

        long startTime = System.currentTimeMillis();

        // Random selection of guests as long not all the guests have entered.
        while (!isEveryoneVisited.get())
        {

            // Select a random Problem1.Guest
            int randomGuest = (int)(Math.random() * numberOfGuests);

            // start the thread as the selected guest
            guestThreads[randomGuest].run();
            partyCount++;

            // Wait until guest has finished
            guestThreads[randomGuest].join();
        }

        // Calculate and print execution time
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.print("Execution time:\n" + executionTime);
        System.out.print("Number of entries  into the labyrinth.\n"+ partyCount);

    }
}