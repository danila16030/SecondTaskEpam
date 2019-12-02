package main.com.epam.secondtask.entity;


import static java.lang.Thread.sleep;

public class Car implements Runnable, UberUsers {
    private int position;
    private boolean withPassenger;
    private int time;

    public Car(int position) {
        this.position = position;
    }


    public void setWithPassenger(boolean withPassenger) {
        this.withPassenger = withPassenger;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWithPassenger() {
        return withPassenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (position != car.position) return false;
        if (withPassenger != car.withPassenger) return false;
        return time == car.time;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + (withPassenger ? 1 : 0);
        result = 31 * result + time;
        return result;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", withPassenger=" + withPassenger +
                ", time=" + time +
                '}';
    }

    @Override
    public void run() {
        withPassenger = true;
        int sleepTime = time;
        System.out.println("Поехал");
        try {
            sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Приехал");
    }
}
