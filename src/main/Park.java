package main;

import java.util.WeakHashMap;

public class Park {
    private String name;
    private Attraction attractions = new Attraction("Carousel", "From 9:00 to 20:00", 30);

    public Park(String name) {
        this.name = name;
    }
    public void info() {
        attractions.info();
    }

    private class Attraction {
        private String nameAttractions, workingHours;
        private double cost;

        public Attraction(String pAttractions, String pWorkingHours, double pCost) {
            this.nameAttractions = pAttractions;
            this.workingHours = pWorkingHours;
            this.cost = pCost;
        }
        public void addAttraction(String nameAttractions, String workingHours, double cost) {
            Attraction attraction = new Attraction(nameAttractions, workingHours, cost);

        }

        public void info() {
            System.out.println(attractions.nameAttractions + " " + workingHours + " " + cost);
        }
    }

}