package Problem2;

import java.util.concurrent.atomic.AtomicInteger;

public class Guest extends Thread{
    static int queueLength;
    static volatile boolean[] queue;
    static AtomicInteger tail;

    int id;
    int myQueueIndex = 0;
    volatile double questsHadEnough = 0;

    public Guest(int id)
    {
        this.id = id;
    }

    public void run()
    {
        while (questsHadEnough < 1)
        {
            // This determines randomly if a guest to enter the queue.
            double r = Math.random();
            if (r < 0.2)
            {
                waitingInQueue();
                inTheShowRoom();
                exitTheRoomAndRiseFlag();
            }
        }
    }

    public void waitingInQueue()
    {
        // This simulates waiting in the  queue to enter the room.
        //Mutually exclusive
        myQueueIndex = tail.getAndIncrement() % queueLength;

        // This makes the thread wait.
        while (!queue[myQueueIndex]) {};
    }

    public void inTheShowRoom()
    {


        // time in the showroom is random.
        while (Math.random() > 0.1) {}

        questsHadEnough +=  Math.random();
    }

    public void exitTheRoomAndRiseFlag()
    {
        queue[myQueueIndex] = false;

        queue[(myQueueIndex + 1) % queueLength] = true;
    }
}
