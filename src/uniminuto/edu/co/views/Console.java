package uniminuto.edu.co.views;

import uniminuto.edu.co.models.Client;

import java.math.BigInteger;
import java.util.Scanner;

public class Console {

    private final Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public String readString(){
        return scanner.nextLine();
    }

    public int readInt(){
        return Integer.parseInt(readString());
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void destroy(){
        scanner.close();
    }

}
