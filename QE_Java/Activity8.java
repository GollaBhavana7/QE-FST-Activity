package javatraining;
class CustomException extends Exception
{
    private String message=null;
    CustomException(String message)
    {
        this.message=message;
    }
    //@Override
public String getMessage(String message){
    return this.message;
}
}
public class Activity8 {
    public static void main(String[] args) {
        try{
            exceptionTest("");
        }
        catch(CustomException e)
        {
            System.out.println("Inside catch block:"+e.getMessage());
        }
    }
    static void exceptionTest(String str) throws CustomException
    {
        if(str.length()==0)
        {
            throw new CustomException("Invalid String");
        }
        else{
            System.out.println(str);
        }

    }

}
