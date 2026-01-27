package javatraining;

public class Activity3 {
    public static void main(String args[])
    {

    double seconds=1000000000;
    double Earthseconds=31557600;
    double Mercuryseconds=0.2488467;
    double Venuseconds=6.61519726;
    double Marsseconds=1.8888158;
    double Jupiterseconds=11.862615;
    double Saturnseconds=29.447495;
    double Uranuseconds=84.016846;
    double Neptuneseconds=164.79132;

    System.out.println("Age on earth:"+seconds/Earthseconds);
    System.out.println("Age on Mercury:"+seconds/(Mercuryseconds*Earthseconds));
    System.out.println("Age on Venus:"+seconds/(Venuseconds*Earthseconds));
    System.out.println("Age on Mars:"+seconds/(Marsseconds*Earthseconds));
    System.out.println("Age on Jupiter:"+seconds/(Jupiterseconds*Earthseconds));
    System.out.println("Age on Saturn:"+seconds/(Saturnseconds*Earthseconds));
    System.out.println("Age on Uranus:"+seconds/(Uranuseconds*Earthseconds));
    System.out.println("Age on Neptune:"+seconds/(Neptuneseconds*Earthseconds)); 

    }
}
