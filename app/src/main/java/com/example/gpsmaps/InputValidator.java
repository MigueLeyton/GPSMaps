package com.example.gpsmaps;

public class InputValidator {

    // Método para validar que una entrada solo contenga caracteres alfanuméricos
    public static boolean isAlphanumeric(String input) {
        return input != null && input.matches("^[a-zA-Z0-9]+$");
    }

    // Método para validar que la longitud de la entrada esté dentro de un rango
    public static boolean isLengthValid(String input, int minLength, int maxLength) {
        return input != null && input.length() >= minLength && input.length() <= maxLength;
    }

    // Se pueden añadir más métodos
}