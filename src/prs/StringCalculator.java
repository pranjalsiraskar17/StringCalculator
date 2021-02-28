package prs;

public class StringCalculator {
    public static int add(String numbers){
        if(numbers.isEmpty())
            return 0;
        String[] numarray=numbers.split(",");
        if(numarray.length==1)
            return stringToInt(numarray[0]);
        int sum=0;
        for(int i=0;i<numarray.length;i++){
            sum=sum+stringToInt(numarray[i]);
        }
        return sum; 
    }

    public static int stringToInt(String str) {
        return Integer.parseInt(str);
    }
}
