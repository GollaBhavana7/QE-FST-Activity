package javatraining;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer,String> colours=new HashMap<Integer,String>();
        colours.put(1,"Red");
        colours.put(2,"Green");
        colours.put(3,"Blue");
        colours.put(4,"Yellow");
        colours.put(5,"Voilet");
        System.out.println(colours);
        System.out.println(colours.remove(3));
        System.out.println(colours);
        System.out.println(colours.containsValue("Green"));
        System.out.println(colours.size());
    }

}
