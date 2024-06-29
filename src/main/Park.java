package main;

import java.util.WeakHashMap;

public class Park {
    private String name;
    private static Attraction attractions = new Attraction("Carousel", "From 9:00 to 20:00", 30);

    public Park(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println("!!!WELCOME TO PARK!!!: " + name);
        attractions.info();
    }

     static class Attraction {
        private String nameAttractions, workingHours;
        private double cost;

        public String getNameAttractions() {
            return nameAttractions;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public double getCost() {
            return cost;
        }

        public Attraction(String pAttractions, String pWorkingHours, double pCost) {
            this.nameAttractions = pAttractions;
            this.workingHours = pWorkingHours;
            this.cost = pCost;
        }

        public void addAttraction(String nameAttractions, String workingHours, double cost) {
            Attraction attraction = new Attraction(nameAttractions, workingHours, cost);
        }

        public void info() {
            System.out.println("Attraction name: " + getNameAttractions() + "\nWorking Hours: " + getWorkingHours() + "\nCost: " + getCost() + "\n");
        }
    }
}