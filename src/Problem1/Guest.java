package Problem1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Guest extends Thread{
    static int totalGuests;
    boolean designatedLeader;
    int counter = 1;

    AtomicBoolean hasCupcake;
    AtomicBoolean isAllVisited;
    boolean haveEaten;

    public Guest(AtomicBoolean cupcake, AtomicBoolean allVisited, boolean designatedLeader)
    {
        this.hasCupcake = cupcake;
        this.isAllVisited = allVisited;
        this.designatedLeader = designatedLeader;
    }

    public void run()
    {

        //This checks for the leader, and if the cake has been eaten,
        // the counter will be increased because it means that a quest has visited, and ask for a new cake.

        if (designatedLeader && !hasCupcake.get())
        {
            counter++;
            hasCupcake.set(true);

            // check if all guests visited.
            if (counter == totalGuests)
            {
                isAllVisited.set(true);
                System.out.println("All the guests have visited the labyrinth!. Game is over.\n");
            }
        }

        // If I am not the counter, see the cupcake is there, and have not yet eaten, I will eat it.
        // This will let the counter know that I have entered the labyrinth.
        //If the thread is not the leader then it's a guest. if the thread has not eaten yet, then it will
        // eat by setting haseating to false
        if (!designatedLeader && hasCupcake.get() && !haveEaten)
        {
            hasCupcake.set(false);
            haveEaten = true;
        }


    }
}
