package prs;

public class StringCalculator {
    public static int add(String numbers){
        if(numbers.isEmpty())
            return 0;
        String[] numarray=numbers.split(",");
        if(numarray.length==1)
            return Integer.parseInt(numarray[0]);
        return Integer.parseInt(numarray[0])+Integer.parseInt(numarray[1]);
    }
}
