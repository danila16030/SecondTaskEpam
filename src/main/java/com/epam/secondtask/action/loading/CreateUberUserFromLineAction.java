package java.com.epam.secondtask.action.loading;

import java.com.epam.secondtask.entity.Car;
import java.com.epam.secondtask.entity.Client;

public class CreateUberUserFromLineAction {
    public static final String SPLIT_REGEX = "\\s+";

    public Car getCarFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        int position = Integer.parseInt(parameters[0]);
        return new Car(position);
    }

    public Client getClientFromLine(String line) {
        String[] parameters = line.split(SPLIT_REGEX);
        int clientPosition = Integer.parseInt(parameters[0]);
        int destinationPosition = Integer.parseInt(parameters[1]);
        return new Client(clientPosition, destinationPosition);
    }
}
