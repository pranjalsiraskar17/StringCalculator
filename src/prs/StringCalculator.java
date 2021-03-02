package prs;

import java.util.Arrays;

public class StringCalculator {
    public static int add(String numbers) throws Exception {
        if(numbers.isEmpty())
            return 0;
        int[] numarray=findNumbers(numbers);
        int sum=arrayAdd(numarray);
        return sum; 
    }

    public static int[] findNumbers(String numbers) {
        String delimiter;
        if(numbers.matches("//(.*)\n(.*)")){
            delimiter=numbers.charAt(2)+"|\n";
            return Arrays.stream(numbers.substring(4).split(delimiter)).mapToInt(Integer::parseInt).toArray();
        }
        else{
            delimiter=",|\n";
        }
        return  Arrays.stream(numbers.split(delimiter)).mapToInt(Integer::parseInt).toArray();
    }

    public static int arrayAdd(int[] numarray) throws Exception {
        int sum=0;
        boolean bool=false;
        String msg="";
        for(int temp:numarray){
            if(temp<0){
                bool=true;
                if(msg.isEmpty())
                    msg=""+temp;
                else
                    msg=msg+","+temp;
            }
            else
                sum=sum+temp;
        }
        if(bool)
            throw new IllegalArgumentException("negatives not allowed : "+msg);
        return sum;
    }
}
