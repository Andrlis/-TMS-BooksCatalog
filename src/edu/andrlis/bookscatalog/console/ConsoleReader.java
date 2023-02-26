package edu.andrlis.bookscatalog.console;

import edu.andrlis.bookscatalog.exception.InvalidInputException;
import edu.andrlis.bookscatalog.utils.Reader;

import java.util.Scanner;

/**
 * @author Andrei Lisouski (Andrlis) - 27/02/2023 - 1:05
 */
public class ConsoleReader implements Reader, AutoCloseable {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String readString() {
        return scanner.next();
    }

    @Override
    public double readDouble() throws InvalidInputException {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }
        throw new InvalidInputException("Non double input.");
    }

    @Override
    public int readInt() throws InvalidInputException {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        throw new InvalidInputException("Non integer input.");
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }
}
