package edu.receitps.api;

import java.util.List;
import java.util.function.Consumer;

public class LambdaExceptionHandlingDemo {

    public static void main(String[] args) {
        List<String> listOfPossibleNumbers = List.of("10", "20", "100", "xx");
        //listOfPossibleNumbers.stream().map(n->Long.valueOf(n)).forEach(System.out::println);
        //listOfPossibleNumbers.stream().map(n -> handleException(n)).forEach(System.out::println);
        //listOfPossibleNumbers.stream().forEach(handleExceptionIfAny(n->Long.valueOf(n)));
        listOfPossibleNumbers.stream().forEach(handleGenericException(n -> Long.valueOf(n), NumberFormatException.class));
    }

    public static Long handleException(String numberString) {
        Long l = null;
        try {
            l = Long.valueOf(numberString);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException with input: " + numberString);
        }
        return l;
    }

    public static Consumer<String> handleExceptionIfAny(Consumer<String> payload) {
        return obj -> {

            try {
                payload.accept(obj);
                System.out.println(obj);
            } catch (Exception e) {
                System.out.println("Exception with input: " + e.getMessage());
            }
        };
    }

    static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> consumer, Class<ExObj> exceptionClass) {
        return obj -> {

            try {
                consumer.accept(obj);
                System.out.println(obj);
            } catch (Exception e) {
                try {
                    ExObj exObj = exceptionClass.cast(e);
                    System.out.println("Exception with input: " + e.getMessage());
                } catch (Exception ex) {
                    throw e;
                }

            }
        };
    }
}
