/*

  created -> new
               |
     (started) |
           Ready-to-run  <------------------------------
      |   |    ^                                        | Leaving non-runnable
      |   |    |                |-----------------------------------------------------------
      |   |    |                | Sleeping          Blocked for            Blocked          |
      |  Scheduling             |                   join completion       for I/O           |
      |   |    |                |                                                           |
      |   |    |                |                                                           |
      |   |    |  Entering      | Waiting for     on notification          Blocked for      |
      |   v    |  non-runnable  | notification    --------------->      Lock acquisition    |
      |    Running----------->  |                                                           |
      |        |                |                                                           |
      |        |                |                                                           |
      v        v                |-----------------------------------------------------------|
       completed/Terminated
               |
               v
              Dead


    - Running and Yielding:
        - Whenever the start() method is called in a thread, its basically eligible for running, and that it's waiting for it's time to be executed by the CPU. The thread scehduler decided on which thread to run and for how long, whenever the thread gets scheduled to run by the CPU from the 'ready to run' state, it transition in to the running state.
        - If you however call the yield() method on running thread, you are informing the CPU to put the curretly thread back into the 'ready to run' state and pick another thread to run
        - No guarantee that if you call the yield method the CPU will pause and pick another thread to execute

    - Sleeping and Waking up:
        - A thread calls the start() method, and hence the thread is ready to be run and then the CPU schedules a particular thread to run and now it is in the runnable state or in running state, and then we call sleep() method.
        - Whenever, we call the sleep() method, the thread goes to the sleeping state and it can only be awakened on 2 conditions;
            - Time elapsed(Example ater a minute sleep)
            - Thread interrupted(some other thread interrupted this thread when sleeping, it won't wait for the time elapse, it will go to the ready to run state and when it gets to the running state it wil throw an interrupted exception). Hense need to wrap the sleep method with exception. Same for the wait method as well, it will not throw immediately but will once it gets to the 'running' state

            After either condition the thread will go to the 'ready to run' state to start its execution


        - Waiting and Notifying:
            - A thread was running and it was asked to wait, it will be waiting for the notification and whenever some other object call the nofity() of notifyAll() methods on this thread, it goes to the 'blocked for lock acquisition' state and doesnot go to the 'ready to run' state directly and whenever this thread acquires the 'lock' only then it goes to the 'ready to run' state

        - Difference betweeen wait() and sleep() methods;
            - The sleep() method doesnot reliquish/let go any 'lock' but whenever it's waiting for a notification it let's go of a 'lock'
 
*/

public class _09_ThreadStates {

    public static void main(String[] args) {

    }
}