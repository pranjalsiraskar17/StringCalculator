package prs;

import java.util.Arrays;

public class StringCalculator {
    private static int count=0;
    public static int add(String numbers) throws Exception {
        count=count+1;
        if (numbers.isEmpty())
            return 0;
        int[] numarray = findNumbers(numbers);
        String negativenum=findNegativeNumbers(numarray);
        if(!negativenum.isEmpty())
            throw new IllegalArgumentException("negatives not allowed : "+negativenum);
        int sum = arrayAdd(numarray);
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
    
    public static String findNegativeNumbers(int[] numarray){
        String neg="";
        for(int n:numarray){
            if(n<0){
                if(neg.isEmpty())
                    neg=""+n;
                else    
                    neg=neg+","+n;   
            }
        }
        return neg;
    }

    public static int arrayAdd(int[] numarray) throws Exception {
        int sum=0;
        for(int temp:numarray){
            if(temp>1000)
                continue;
            sum=sum+temp;
        }
        return sum;
    }

	public static Object getCalledCount() {
		return count;
	}

}
