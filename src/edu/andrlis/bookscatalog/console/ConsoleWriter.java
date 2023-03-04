package edu.andrlis.bookscatalog.console;

import edu.andrlis.bookscatalog.utils.Writer;


/**
 * @author Andrei Lisouski (Andrlis) 04/03/2023 - 18:24
 */
public class ConsoleWriter implements Writer {
    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
