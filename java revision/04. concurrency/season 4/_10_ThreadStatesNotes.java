/*

    NOTES:
    - wait() and notify()

    - wait():
        - The wait() method is awakened by one of the 3 states:
            - Wait time elapsed
            - Received a notification from a nofity() method
            - Interrupted by another thread

    - Difference between interrupted and timeout:
        - timeout:
            - A thread has no way to know weather a thread was notified or it's set execution time elapsed

        - Interrupted:
            - A thread interrupted does not get is awakened but not executed immediately, it waits for the lock object after which once assigned if will cause an execution, InteruptedException, that needs to be handled

 */

public class _10_ThreadStatesNotes {

}