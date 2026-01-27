package javatraining;
 
public class Activity4 {
    void sort_(int a[])
    {
        for (int i = 1; i<a.length;i++) {
            int k = a[i];
            int j = i - 1; 
            while (j >= 0 && a[j] > k) {
                a[j + 1] = a[j];
                j = j - 1;
            }
          
            a[j + 1] = k;
        }
    }

    public static void main(String args[])
    {
        int a[] = { 4,3,2,10,6,1 };

        Activity4 ob = new Activity4();
        ob.sort_(a);
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

}

