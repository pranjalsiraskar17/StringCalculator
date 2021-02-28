package prs;

public class StringCalculator {
    public static int add(String numbers){
        if(numbers.isEmpty())
            return 0;
        String[] numarray=numbers.split(",");
        if(numarray.length==1)
            return stringToInt(numarray[0]);
        return stringToInt(numarray[0]) + stringToInt(numarray[1]); 
    }

    public static int stringToInt(String str) {
        return Integer.parseInt(str);
    }
}
