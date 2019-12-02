package main.com.epam.secondtask.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Dispatcher implements Runnable {
    private static List<Car> carList = new ArrayList<>();
    private static List<Client> clientList = new ArrayList<>();
    private static Car closerCar = new Car(Integer.MAX_VALUE);
    private static Dispatcher dispatcher = new Dispatcher();
    private static Logger logger = LogManager.getLogger();

    private Dispatcher() {
    }
    
    public void run() {
        while (!clientList.isEmpty()) {
            int clientPosition = clientList.get(0).getClientPosition();
            for (Car car : carList) {
                int carPosition = car.getPosition();
                if (!car.isWithPassenger() && Math.abs(clientPosition - carPosition) < Math.abs(clientPosition - closerCar.getPosition())) {
                    closerCar = car;
                }
            }
            clientList.remove(0);
            closerCar.setTime(Math.abs(clientPosition - closerCar.getPosition() * 115));
            closerCar.setWithPassenger(true);
            logger.info("Car on the way" + closerCar.toString());
            Thread thread = new Thread(closerCar);
            thread.start();
        }
    }


    public static List<Car> getCarList() {
        return carList;
    }

    public static void setCarList(List<Car> carList) {
        Dispatcher.carList = carList;
    }

    public static List<Client> getClientList() {
        return clientList;
    }

    public static void setClientList(List<Client> clientList) {
        Dispatcher.clientList = clientList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dispatcher that = (Dispatcher) o;

        return closerCar != null ? closerCar.equals(that.closerCar) : that.closerCar == null;
    }

    @Override
    public int hashCode() {
        return closerCar != null ? closerCar.hashCode() : 0;
    }


    public static Dispatcher getDispatcher() {
        return dispatcher;
    }
}
