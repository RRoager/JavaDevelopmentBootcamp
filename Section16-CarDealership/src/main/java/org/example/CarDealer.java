package org.example;

public class CarDealer {
    private Car[] cars;

    public CarDealer(Car[] cars) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        }
    }

    public Car getCars(int index) {
        return new Car(this.cars[index]);
    }

    public void setCars(Car car, int index) {
        this.cars[index] = new Car(car);
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < cars.length; i++) {
            temp += "Parking Spot: " + i + "\n";

            if (this.cars[i] == null) {
                temp += "Empty\n";
            } else {
                temp += this.cars[i].toString() + "\n";
            }
        }
        return temp;
    }

    public void sell(int index) {
        this.cars[index].drive();
        this.cars[index] = null;
    }

    public int search(String make, int budget) {
        for (int i = 0; i < this.cars.length; i++) {
            if (this.cars[i] == null) {
                continue;
            } else if (this.cars[i].getMake().equalsIgnoreCase(make) && this.cars[i].getPrice() <= budget) {
                System.out.println("\nWe found one in spot " + i + ".\n" + this.cars[i].toString());
                System.out.print("If you are interested type 'yes': ");
                return i;
            }
        }
        System.out.println("\nSorry, we couldn't find any cars matching your requirements.\n");
        return 404;
    }
}
