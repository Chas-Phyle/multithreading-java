public class Animal implements Runnable {

    private String name;
    private double position;
    private double speed;
    private long restMax;
    private boolean winner;
    private Object compition;
    private int timeToEat;
    private int raceLength = 120;

    public Animal(String name, int position, double speed, long restMax, int timeToEat) {
        this.setName(name);
        this.setPosition(position);
        this.setSpeed(speed);
        this.setRestMax(restMax);
        this.setWinner(false);
        this.setTimeToEat(timeToEat);

    }

    public int getTimeToEat() {
        return timeToEat;
    }

    public void setTimeToEat(int timeToEat) {
        this.timeToEat = timeToEat;
    }

    @Override
    public void run() {
        while (!(isWinner() || ((Animal) compition).isWinner())) { // has race go on until one of the two reach the end
            setPosition(getPosition() + getSpeed());
            System.out.println(name + " is at the " + getPosition() + " position");
            Food.eat(getName(), getTimeToEat());                    // used for part II
            // try {                                                //used in part I
            // Thread.sleep((long) (Math.random()*restMax));
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            setWinner(winner); // updats winner if the object crosses the finnish line
        }
    }

    public void setComp(Object comp) {
        this.compition = comp;
    }

    public Object getComp() {
        return compition;
    }

    public boolean isWinner() {

        return winner;
    }

    public void setWinner(boolean winner) { // setting the boolean for when the animal wins
        if (getPosition() < raceLength) {
            winner = false;
        } else {
            winner = true;
        }
        this.winner = winner;
    }

    public long getRestMax() {
        return restMax;
    }

    public void setRestMax(long restMax) {
        this.restMax = restMax;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double d) {
        this.position = d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
