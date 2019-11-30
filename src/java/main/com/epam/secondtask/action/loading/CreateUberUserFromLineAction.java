package main.com.epam.secondtask.action.loading;

import main.com.epam.secondtask.entity.Car;
import main.com.epam.secondtask.entity.Client;

public class CreateUberUserFromLineAction {
    public static final String SPLIT_REGEX = "\\s+";
    public Car getPointFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        int position=Integer.parseInt(parameters[0]);
        return new Car(position);
    }

    public Client getCircleFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        int clientPosition=Integer.parseInt(parameters[0]);
        int destinationPosition=Integer.parseInt(parameters[1]);
        return new Client(clientPosition,destinationPosition);
    }
}
