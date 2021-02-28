package prs;

public class StringCalculator {
    public static int add(String numbers){
        if(numbers.isEmpty())
            return 0;
        String delimeter=",|\n";
        String[] numarray = numbers.split(delimeter);
        int sum=arrayAdd(numarray);
        return sum; 
    }

    public static int stringToInt(String str) {
        return Integer.parseInt(str);
    }

    public static int arrayAdd(String[] numarray){
        int sum=0;
        for(String str:numarray)
            sum=sum+stringToInt(str);
        return sum;
    }
}
