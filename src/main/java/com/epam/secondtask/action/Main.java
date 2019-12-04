package com.epam.secondtask.action;

import com.epam.secondtask.action.loading.LoadUberUsersAction;
import com.epam.secondtask.entity.Dispatcher;
import com.epam.secondtask.exception.FileIsEmptyException;

import com.epam.secondtask.exception.TxtFileNotFoundException;

public class Main {
    private static final String FILE_PATH = "data/info.txt";

    public static void main(String[] args) throws TxtFileNotFoundException, FileIsEmptyException {
        LoadUberUsersAction loadUsersAction = new LoadUberUsersAction();
        loadUsersAction.loadUsersFromFile(FILE_PATH);
        Dispatcher.getDispatcher().run();

    }
}
