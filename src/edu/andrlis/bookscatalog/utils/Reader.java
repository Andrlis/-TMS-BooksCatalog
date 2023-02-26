package edu.andrlis.bookscatalog.utils;

import edu.andrlis.bookscatalog.exception.InvalidInputException;

/**
 * @author Andrei Lisouski (Andrlis) - 27/02/2023 - 1:03
 */
public interface Reader {
    String readString();
    double readDouble() throws InvalidInputException;
    int readInt() throws InvalidInputException;
}
