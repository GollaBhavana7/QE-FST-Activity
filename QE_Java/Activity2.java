package javatraining;

public class Activity2 {
    public static void main(String args[])
        {
            int arr[]={10,77,10,54,-11,10};
            int s=0;
            for(int i:arr)
            {
                if(i==10)
                {
                    s+=i;
                }
            }
         if (s == 30) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
}
}
