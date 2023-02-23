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

        // Setting up the Queue
        Guest.queueLength = queueSize;
        Guest.queue = new boolean[queueSize];
        Guest.queue[0] = true;
        Guest.tail = new AtomicInteger(0);

        // setting Guests
        Guest[] guests = new Guest[numberOfGuests];
        long startTime = System.currentTimeMillis();

        // Simulate guests
        for (int i = 0; i < guests.length; i++)
        {
            guests[i] = new Guest(i);
            guests[i].start();
        }

        // Wait for al  guests  have seen the vase

        for (int i = 0; i < guests.length; i++)
            guests[i].join();


        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("\nAll guests stop entering the showroom and left the party.");
        System.out.println("Number of entries the showroom:"+ Guest.tail.get());
        System.out.println("Execution time: "+ executionTime);
    }
}
