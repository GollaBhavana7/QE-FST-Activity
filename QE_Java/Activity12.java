package javatraining;
interface Addable
{
    int add(int num1,int num2);
}
public class Activity12 {
    public static void main(String[] args) {
        Addable ad1=(a,b)->(a+b);
        Addable ad2=(int a, int b)->
    {
            return (a+b);
    };
        int num1=10;
        int num2=20;
        System.out.println("ad1 result:"+ad1.add(num1,num2));
        System.out.println("ad2 result:"+ad1.add(num1,num2));
    }
}


