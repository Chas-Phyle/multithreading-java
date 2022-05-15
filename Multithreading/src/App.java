

public class App {
    public static void main(String[] args) throws Exception {
     //   Scanner input = new Scanner(System.in); // Used to input lock the main thread FIX!!
        Animal hare = new Animal("Hare", 0, 9, 220, 550); // new Animals
        Animal tortoise = new Animal("Tortoise", 0, 5, 120, 100);

        hare.setComp(tortoise); // used in the run method to know who its racing against
        tortoise.setComp(hare);

        Thread temp = new Thread(hare); // new threads for the animals
        Thread temp2 = new Thread(tortoise);

        temp.setDaemon(false); // setting to user Threads
        temp2.setDaemon(false);

        temp.start(); // starting threads
        temp2.start();
        do{                                         //used to cycle through the winner output until a winner is determined
        if (hare.isWinner()) {
            System.out.println("The Winner is: ");
            System.out.print(hare.getName());
            System.exit(0); ;
        } else if (tortoise.isWinner()) {
            System.out.println("The Winner is: ");
            System.out.print(tortoise.getName());
            System.exit(0);
        }Thread.sleep(1);                                 //Used to let the threads update
                                                        //without this the program hangs here forever
    }while(!(hare.isWinner()&&tortoise.isWinner()));
    }
}
