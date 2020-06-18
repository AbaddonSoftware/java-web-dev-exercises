package org.launch.java.studios.areaofacircle.helper;

public class Helper {
    public static boolean validateInput(String input, String validator, String message) {
        input = input.toLowerCase().trim();
        boolean isValid = false;
        switch(validator) {
            case "POSITIVENUMBER":
                isValid = input.matches("^[0-9]*[.]?[0-9]+$");
                break;
            case "ANYNUMBER":
                isValid = input.matches("^[-]?[0-9]*[.]?[0-9]+$");
                break;
            default:
                System.out.println("This validator is not yet implemented");
                break;
        }
        if(isValid)
        {
            return true;
        }
        System.out.println(message);
        return false;
    }
}

