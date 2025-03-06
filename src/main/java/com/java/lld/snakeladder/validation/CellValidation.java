package com.java.lld.snakeladder.validation;

public class CellValidation {


    public static boolean validateNewPosition(int playerNewPos) {

        if (playerNewPos > 100) {
            return false;
        }

        return true;
    }
}
