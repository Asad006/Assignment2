package Problem2;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Problem2 {
    public static void main(String[] args) throws InterruptedException {
         // scanner to prompt the user to enter the number of guests.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of guests invited to the party?");
        int numberOfGuests = scanner.nextInt();


        int queueSize = numberOfGuests;

        // Declare queue
        Guest.queueLength = queueSize;
        Guest.queue = new boolean[queueSize];
        Guest.queue[0] = true;
        Guest.tail = new AtomicInteger(0);

        // Declare guests
        Guest[] guests = new Guest[numberOfGuests];
        long startTime = System.currentTimeMillis();

        // Simulate guests queuing up randomly
        for (int i = 0; i < guests.length; i++)
        {
            guests[i] = new Guest(i);
            guests[i].start();
        }

        // Wait until all guests are done seeing the vase for good
        for (int i = 0; i < guests.length; i++)
            guests[i].join();

        // Calculate and print execution time
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("\nAll guests are now bored and left the party.");
        System.out.printf("Room was entered %d times\n", Guest.tail.get());
        System.out.printf("Execution time: %dms\n", executionTime);
    }
}
