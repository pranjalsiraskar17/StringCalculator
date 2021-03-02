package prs;

public class StringCalculator {
    public static int add(String numbers){
        if(numbers.isEmpty())
            return 0;
        String[] numarray=findNumbers(numbers);
        int sum=arrayAdd(numarray);
        return sum; 
    }

    public static int stringToInt(String str) {
        return Integer.parseInt(str);
    }

    public static String[] findNumbers(String numbers) {
        String delimiter;
        String[] numarray;
        if(numbers.matches("//(.*)\n(.*)")){
            delimiter=numbers.charAt(2)+"|\n";
            String sub=numbers.substring(4);
            numarray = sub.split(delimiter);
        }
        else{
            delimiter=",|\n";
            numarray = numbers.split(delimiter);
        }
        return numarray;
    }

    public static int arrayAdd(String[] numarray){
        int sum=0;
        for(String str:numarray)
            sum=sum+stringToInt(str);
        return sum;
    }
}
