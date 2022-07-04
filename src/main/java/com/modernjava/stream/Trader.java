package com.modernjava.stream;

public record Trader(String name, String city) {

    @Override
    public String toString() {
        return "Trader: " + name + " in " + city;
    }
}
