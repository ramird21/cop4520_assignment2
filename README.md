# Problem 1:
## MinotaurFun.java

### Effiency:
- Problem 1 has some slight issues, I am thinking mainly because of
- some data corruption or weird logic happening between both of the
- semaphores that I have... But for the most part it seems to be working
- I have also left some comments om the code to explain what I was doing along
### Experimental Evaluation
- This is waiting for a user input for the amount of guests coming in
- I did include a time counter for this one, as I was not sure if it was needed.
- Also, because at each run even if the input is the same there will be some variations
- in the time it takes to process, depending on which guest is going in and how many
- times each...

# Problem 2:
## MinotaurCrystalVase.java

- I would say that Strategy 1 and 2 have quite some similarities here. The approach I am thinking there
- would be to use Semaphores, by allowing 1 guest in at a time. When a guest go in the room they acquire
- and when they exit they release that semaphore and allow entrance for other guest to enter the room
- For as far that I can see Strategy 3 may introduce some race conditions, I am not sure as of how to
- work around it. Thus, I will proceed with Strategy 2 to implement this...

### Effiency:
- I think this one was slightly easier and should work perfectly fine. I have also some
- comments in the code to explain the process... It also takes in user input for the amount of
- guests going in.
### Experimental Evaluation