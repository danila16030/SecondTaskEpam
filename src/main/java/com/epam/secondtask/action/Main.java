package java.com.epam.secondtask.action;

import java.com.epam.secondtask.action.loading.LoadUberUsersAction;
import java.com.epam.secondtask.entity.Dispatcher;
import java.com.epam.secondtask.exception.FileIsEmptyException;

import java.com.epam.secondtask.exception.TxtFileNotFoundException;

public class Main {
    private static final String FILE_PATH = "data/info.txt";

    public static void main(String[] args) throws TxtFileNotFoundException, FileIsEmptyException {
        LoadUberUsersAction loadUsersAction = new LoadUberUsersAction();
        loadUsersAction.loadUsersFromFile(FILE_PATH);
        Dispatcher.getDispatcher().run();

    }
}
