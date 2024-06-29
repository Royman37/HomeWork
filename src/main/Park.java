package main;

import java.util.WeakHashMap;

public class Park {
    private String name;
    private Attraction[] attractions = {new Attraction("Lala", "From 9:00 to 20:00", 30)};

    public Park(String name) {
        this.name = name;
    }

    private class Attraction {

        private String newattractions, workingHours;
        private double cost;

        public Attraction(String pAttractions, String pWorkingHours, double pCost) {
            this.newattractions = pAttractions;
            this.workingHours = pWorkingHours;
            this.cost = pCost;
        }

        public String getAttractions() {
            return newattractions;
        }
        public void setAttractions(String pAttractions) {
            this.newattractions = pAttractions;
        }

        public String getWorkingHours() {
            return workingHours;
        }

        public void setWorkingHours(String workingHours) {
            this.workingHours = workingHours;
        }

        public double getCost() {
            return cost;

        }

        public void setCost(double pCost) {
            this.cost = pCost;
            System.out.println("Стоимость: " + this.cost + "\n");
        }
        public void addAttraction() {
            Attraction attraction = new Attraction(newattractions, workingHours, cost);
            attractions.add(attraction);

        }


        }
}