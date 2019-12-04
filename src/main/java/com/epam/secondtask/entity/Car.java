
package com.epam.secondtask.entity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable,UberUsers {
    private int position;
    private AtomicBoolean withPassenger=new AtomicBoolean();
    private int time;

    public Car(int position) {
        this.position = position;
    }


    public void setWithPassenger(AtomicBoolean withPassenger) {
        this.withPassenger = withPassenger;
    }

    public int getPosition() {
        return position;
    }

    public AtomicBoolean isWithPassenger() {
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
        result = 31 * result + (withPassenger != null ? withPassenger.hashCode() : 0);
        result = 31 * result + time;
        return result;
    }

    public AtomicBoolean getWithPassenger() {
        return withPassenger;
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
        int sleepTime = time;
        withPassenger.set(true);
        System.out.println("Поехал");
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Приехал");
        withPassenger.set(false);
    }
}
