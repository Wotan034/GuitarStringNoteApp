package com.company;


public class GuitarString { // Basic guitar class with a name and its tuned note value represented as a number. 0-11 A-G#

    private String name;
    private int baseTuning;

    public GuitarString(String name, int baseTuning) {
        this.name = name;
        this.baseTuning = baseTuning;
    }

    public String getName() {

        return name;
    }

    public int getBaseTuning() {

        return baseTuning;
    }
}
