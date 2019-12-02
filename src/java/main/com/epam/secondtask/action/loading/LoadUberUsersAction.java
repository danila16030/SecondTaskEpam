package main.com.epam.secondtask.action.loading;

import main.com.epam.secondtask.entity.Car;
import main.com.epam.secondtask.entity.Client;
import main.com.epam.secondtask.entity.Dispatcher;
import main.com.epam.secondtask.exception.FileIsEmptyException;
import main.com.epam.secondtask.exception.TxtFileNotFoundException;
import main.com.epam.secondtask.pattern.SetOfPatterns;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LoadUberUsersAction {
    private static Logger logger = LogManager.getLogger();
    private static CreateUberUserFromLineAction createUserFromLine = new CreateUberUserFromLineAction();
    private static LineValidationAction lineValidationAction = new LineValidationAction();


    public void loadUsersFromFile(String filePath) throws FileIsEmptyException,
            TxtFileNotFoundException {
        logger.info("loading figures from " + filePath);
        List<String> listOfLines = new ArrayList<>();
        boolean flag = checkFile(filePath);
        if (flag) {
            throw new TxtFileNotFoundException("Check file path");
        } else {
            Path path = Paths.get(filePath);
            try (Stream<String> stringStream = Files.lines(path)) {
                stringStream.forEach(listOfLines::add);
            } catch (IOException ex) {
                throw new FileIsEmptyException(ex);
            }
            for (String line : listOfLines) {
                if (lineValidationAction.carComplianceCheck(line, SetOfPatterns.CAR_PATTERN)) {
                    Car car = createUserFromLine.getCarFromLine(line);
                    Dispatcher.getCarList().add(car);
                } else if (lineValidationAction.clientComplianceCheck(line, SetOfPatterns.CLIENT_PATTERN)) {
                    Client client = createUserFromLine.getClientFromLine(line);
                    Dispatcher.getClientList().add(client);
                } else {
                    logger.warn("incorrect line in position "+(listOfLines.lastIndexOf(line)+1));
                }
            }
        }
    }


    private boolean checkFile(String filePath) {
        File testFile = new File(filePath);
        if (testFile.length() == 0 || !testFile.exists()) {
            return true;
        } else {
            return false;
        }
    }
}
