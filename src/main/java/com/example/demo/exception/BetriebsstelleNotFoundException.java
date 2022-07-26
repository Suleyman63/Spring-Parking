package com.example.demo.exception;

public class BetriebsstelleNotFoundException extends RuntimeException{

    public BetriebsstelleNotFoundException(String code){

        super("Betribsstelle data with code "+ code +" not found");
    }
}
