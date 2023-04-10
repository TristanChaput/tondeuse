package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File file = new File("src/main/resources/test.txt");

        TondeuseManager tondeuseManager = new TondeuseManager(file);

        tondeuseManager.run();
    }
}
