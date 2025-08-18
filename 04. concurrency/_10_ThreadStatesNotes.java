/*

    NOTES:
    - Waiting and Notifying:
        - A thread in the Waiting-for-notification state can be awaked by the occurence of any one of the three incidents:
            - Another thread invokes the notify() method on the object of the waiting thread, and the waiting thread is selected as the thread to be awakened
            - The waiting thread times out
            - Another thread interrupts the waiting thread

    - Notify:
        - Invoking the notify() method on an object wakes up a single thread that is waiting for the lock of this object
        - The selection of a thread to awaken is dependent on the thread policies implmetened by the JVM
        - On being notified, a waiting thread first transits to the Blocked-for-lock-acquisition state to acquire the lock on the object, and not directly to the Ready-to-run state
        - The thread is also removed from the wait set of the object

    - Important Methods:
        - wait(timeout) throws InterruptedException
        - wait(timeout, int nanos) throws InterruptedException
        - wait() throws InterruptedException
        - notify()
        - notifyAll()

    - Timed Out:
        - The wait() call specified the time the thread should wait before begin timed out, if it was awakened by being notified
        - The awakened thread completes in the usual manner to execute again
        - The awakened thread has no way of knowing wheather it was timed out or woken up by one of the notification methods

    - Interrupted:
        - Another thread invoked the interrupt() method on the waiting thread
        - The awakened thread is enabled, but the return from the wait() call will result in an IntteruptedException if and when the awakned thread finally ets a chance to run
        - The code invoking the wait() method must be prepared to handle this checked exception

    - Difference between Timed Out and Interrupted:
        - In Interrupted you get to know that this thread got Interrupted by some other thread but in timeout you dont know if the thread got timeout or got notified

 */

public class _10_ThreadStatesNotes {
}
