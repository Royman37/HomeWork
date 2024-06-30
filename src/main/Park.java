package main;

import java.util.WeakHashMap;

public class Park {
    private String name;
    private Attraction attractions = new Attraction("Сarousel", "From 9:00 to 20:00", 50);

    public Park(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void info() {
        attractions.info();
    }

    public void newAttraction(String name, String workingHours, double cost) {
        Attraction newAttraction = new Attraction(name, workingHours, cost);
        newAttraction.info();
    }

    private class Attraction {
        private String nameAttractions, workingHours;
        private double cost;

        public Attraction(String pAttractions, String pWorkingHours, double pCost) {
            this.nameAttractions = pAttractions;
            this.workingHours = pWorkingHours;
            this.cost = pCost;
        }

        public void info() {
            System.out.println("!!!WELCOME TO PARK!!!: " + getName() + "\nAttraction name: " + this.nameAttractions + "\nWorking Hours: " + this.workingHours + "\nCost: " + this.cost + "\n");

        }
    }
}