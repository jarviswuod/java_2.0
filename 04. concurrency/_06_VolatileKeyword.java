/*

    NOTES:
    - Diagram
        - Thread 1  <--->  CPU  <--->  Cache  <--->  RAM
        - Thread 2  <--->  CPU  <--->  Cache  <--->  ''

        - We have 2 threads which interact with the CPU and the CPU intern interacts with the main memory/ RAM
        - We introduce the cache which helps reduce the access time as it's far more easier to access data from the cache than from RAM
        - Both the Threads 1 and 2 don't directly read from the (RAM)memory, they have there own cache and all the access the shared variable(Flag) locally from their respective cache.
        - The problem that might arise here is if Thread 2 changes the value of the shared varible (Flag = false) it won't directly update it to the RAM, it will just update it to it's local cache. Thread 2 doesnot see this change done by Thread 2 because it's not update in it's cache(Thread 1 cache) or the memory(RAM). It will take sometime for the value of the shared memory to be updated to the main memory and eventually the (Thread 1)cache 

        - To get rid of this problem, we will declear the variable shared variable as volatile;
            - private volatile Flag flag = true;


        - What happens now is that both Threads don't read the variable from their respective cache, they all read it directly from the main memory(RAM) as a result if the Flag varible changes to false both threads will have access to the updated variable too



    - Singleton design pattern:
        - In a singleton design pattern we can only create one instance of a particular class
        - We have to design the class in such a way that only one instance can be created


        - We create a static variable of the instance and set it to null, because when there is no object created, the instance is null
            - private static volatile TVSet tvSetInstance = null;

        - We declare a private constructor, this is becasue we don't want any other client to instanciate the class outside
            - private TVSet() {...}

        - If any client want to instanciate the class, they can have that access via the public getTVSetInstance() method, where we run some checks first
            - public static TVSet getTVSetInstance() {...}

        - TVSetInstance is acting as a Flag coz, if the reference is null then create an object otherwise don't create an object, return that same object

 */

public class _06_VolatileKeyword {
}

class TVSet {
    private static volatile TVSet tvSetInstance = null;

    private TVSet() {
        System.out.println("TV Set instantiated");
    }

    public static TVSet getTVSetInstance() {
        if (tvSetInstance == null) { // optimization
            synchronized (TVSet.class) {
                if (tvSetInstance == null) // Double checking
                    tvSetInstance = new TVSet();
            }
        }
        return tvSetInstance;
    }
}