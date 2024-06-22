package main;

public class Park {
   static class Attractions {
        private String attractions, workingHours;
        private double cost;

        public Attractions(String pAttractions, String pWorkingHours, double pCost) {
            this.attractions = pAttractions;
            this.workingHours = pWorkingHours;
            this.cost = pCost;
        }

        public String getAttractions() {
            return attractions;
        }
        public void setAttractions(String pAttractions) {
            this.attractions = pAttractions;
            System.out.println("Аттракционы: " + this.attractions);
        }

        public String getWorkingHours() {
            return workingHours;
        }
        public void setWorkingHours(String pWorkingHours) {
            this.workingHours = pWorkingHours;
            System.out.println("Время работы: " + this.workingHours);
        }

        public double getCost() {
            return cost;

        }
        public void setCost(double pCost) {
            this.cost = pCost;
            System.out.println("Стоимость: " + this.cost + "\n");
        }
    }
}