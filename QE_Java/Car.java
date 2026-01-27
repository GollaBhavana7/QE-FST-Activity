package javatraining;

public class Car { 
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
public Car()
{
    tyres=4;
    doors=4;
}


void displayCharacterstics()
    {
        System.out.println("car make:"+make);
        System.out.println("car color:"+color);
        System.out.println("car transmission:"+transmission);
        System.out.println("car tyres:"+tyres);
        System.out.println("car doors:"+doors);
    }
void accelerate()
{
    System.out.println("Car is moving forward"); 
}
void brake()
{
    System.out.println("car has stopped"); 
}

}