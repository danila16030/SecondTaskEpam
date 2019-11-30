package main.com.epam.secondtask.action;

import main.com.epam.secondtask.action.loading.LoadUberUsersAction;
import main.com.epam.secondtask.entity.Car;
import main.com.epam.secondtask.entity.Client;
import main.com.epam.secondtask.entity.Dispatcher;
import main.com.epam.secondtask.entity.UberUsers;
import main.com.epam.secondtask.exception.FileIsEmptyException;

import main.com.epam.secondtask.exception.TxtFileNotFoundException;

import java.util.List;

public class Main {
    private static final String FILE_PATH = "data/info.txt";

    public static void main(String[] args) throws TxtFileNotFoundException, FileIsEmptyException {
        LoadUberUsersAction loadUsersAction = new LoadUberUsersAction();
        loadUsersAction.loadUsersFromFile(FILE_PATH);
        Dispatcher.getDispatcher().run();

    }
}
