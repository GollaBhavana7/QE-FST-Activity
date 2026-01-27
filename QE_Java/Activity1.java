package javatraining;

public class Activity1
 {
public static void main(String[] args) {
    Car carName=new Car();
    carName.color="Black";
    carName.transmission="Mannual";
    carName.make=2014;

    carName.displayCharacterstics();
    carName.accelerate();
    carName.brake();
    }


}