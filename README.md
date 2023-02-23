# Programming Assignment 2.
This project is my answer to the two problems asked in assignment 2.

### Execution Instructions
This is an IntelliJ project. it can easily clone to a new project from IntelliJ,
by clicking on Open from CVS then copy the clone link of the project. This project
can be also executed by downloading the project then open it by any IDE.
On a Terminal, get into the problem 1 and problem 2 folder  where **Problem1.Problem1.java** and **Problem2.java** is located, then execute the following commands
**javac Problem1.Problem1.java** or **javac Problem2.java** followed with **java Problem1** to run problem 1 and **javac Problem2** to run problem2.

## Problem1.Problem1 

### Correctness and Efficiency
I chose to use the prisoner strategy as  discussed in class. The idea is to choose 
a  designated guest to be leader which does the counting, and for that I selected a leader thread that does
just that where the rest of the threads play the game. A random generator is used to select 
which thread will be executed as a simulation of the Minotaur selection of random guest. the leader will check for the 
id the cake has been eating at every entry, and if so it will increment the counter.
the guest will eat the cake at the first entry, and do not eat the cake at another visit.
The game will stop when the  counter reach the number of guest indicating that all guests
have entered the game.

## Problem2

### Correctness and Efficiency
For problem 2. I think guests should choose strategy 3 because of the following reasons:
* It makes sure that one guest enters the showroom at time.
* It makes sure and equal wait time for the threads to enter the showroom.
* It manages the entry priority to the showroom on the basis of FIFO. As such, threads do not fight over resources. 
* It makes sure that any guest wanting to visit will have its turn to enter the showroom. 

The disadvantages of this strategy is as the follow:
* It consumes a lot of memory as it needs to continue enqueuing and the entries go on.
* Threads take CPU resources as they are waiting and do not do anything this lacks efficiency.
* 
