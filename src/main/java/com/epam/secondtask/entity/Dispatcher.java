package com.epam.secondtask.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;


public class Dispatcher implements Runnable {
    private static List<Car> carList = new ArrayList<>();
    private static List<Client> clientList = new ArrayList<>();
    private static Car closerCar = new Car(Integer.MAX_VALUE);
    private static Dispatcher dispatcher = new Dispatcher();
    private static Logger logger = LogManager.getLogger();
    private static final Lock notInitialized = null;

    private Dispatcher() {
    }

    public void run() {
        while (!clientList.isEmpty()) {
            int clientPosition = clientList.get(0).getClientPosition();
            for (Car car : carList) {
                int carPosition = car.getPosition();
                if (!car.getWithPassenger().get() && Math.abs(clientPosition - carPosition) < Math.abs(clientPosition - closerCar.getPosition())) {
                    closerCar = car;
                }
            }
            if (closerCar.getPosition() != Integer.MAX_VALUE) {
                clientList.remove(0);
                closerCar.setTime(Math.abs(clientPosition - closerCar.getPosition() * 115));
                Executor executor=closerCar->{
                    new Thread(closerCar).start();
                };
                executor.execute(closerCar);
                logger.info("Car on the way" + closerCar.toString());
                closerCar = null;
                closerCar = new Car(Integer.MAX_VALUE);
            }
        }
    }


    public static List<Car> getCarList() {
        return carList;
    }

    public static List<Client> getClientList() {
        return clientList;
    }


    public static Dispatcher getDispatcher() {
        if (dispatcher == null) {
            notInitialized.lock();
            if (dispatcher == null) {
                dispatcher = new Dispatcher();
            }
            notInitialized.unlock();
        }
        return dispatcher;
    }
}
