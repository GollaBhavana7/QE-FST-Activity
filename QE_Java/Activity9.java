package javatraining;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
    ArrayList<String> myList=new ArrayList<String>();
    myList.add("Bhavana");
    myList.add("Deepthi");
    myList.add("Harshilika");
    myList.add("Haasa");
    myList.add("Buddi");
    for(String names:myList)
    {
        System.out.println(names);
    }
    if(myList.contains("Bhavana"))
    {
        System.out.println("True");
    }
     else
            {
        System.out.println("False");
    
    }
System.out.println(myList.size());
System.out.println(myList.remove("Buddi"));
System.out.println(myList.size());
}
}