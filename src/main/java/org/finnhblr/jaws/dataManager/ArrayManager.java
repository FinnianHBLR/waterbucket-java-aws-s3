package org.finnhblr.jaws.dataManager;
// Import array reverser
import java.util.*;

public class ArrayManager {
    // Properties
    public String[] arrayStorage;

    // Constructors

    public ArrayManager() {
        arrayStorage = new String[] {"BMW", "Ford", "Jag"};
    }

    public ArrayManager(String[] array) {
        arrayStorage = array;
    }

    public String[] reverseArray(){
        // Reverse array then return.
        Collections.reverse(Arrays.asList(arrayStorage));
        return arrayStorage;
    }

    public StringBuilder getCurrentStatus(){
        StringBuilder logger =  new StringBuilder();

        for (String i: arrayStorage) {
            logger.append(i);
        }

        return logger;
    }

}
