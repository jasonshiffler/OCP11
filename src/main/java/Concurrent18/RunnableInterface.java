package Concurrent18;

public class RunnableInterface {

    public static void main(String[] args) {

        Runnable runMe01 = () -> {};
        Runnable runMe02 = () -> {return;};
        Runnable runMe03 = () -> System.out.println("Hello Concurrent");

        //Running a thread
        //1 - Create a new thread passing a Runnable to the constructor
        //2 - Call the start() method on the Thread
        new Thread(runMe03).start();

        //Create a class that extends thread and call run
        new LittleThread().run();
    }
}

class LittleThread extends Thread {

    public void run() {
        System.out.println("Hello Concurrent");
    }
}
