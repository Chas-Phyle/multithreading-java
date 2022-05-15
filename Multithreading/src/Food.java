public class Food {
    public synchronized static void eat(String name, int timeToEat) {   //making a synchronized method so only one thread has a lock at a time
        System.out.println(name + " is eating!");
        try {
            Thread.sleep(timeToEat);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}