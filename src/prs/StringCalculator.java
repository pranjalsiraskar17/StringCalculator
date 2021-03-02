package prs;

import java.util.Arrays;

public class StringCalculator {
    private static int count=0;
    private static int index;
    private static String numstring;
    public static int add(String numbers) throws Exception {
        count=count+1;
        if (numbers.isEmpty())
            return 0;
        String delimiter=findDelimiter(numbers);
        int[] numarray = findNumbers(delimiter);
        String negativenum=findNegativeNumbers(numarray);
        if(!negativenum.isEmpty())
            throw new IllegalArgumentException("negatives not allowed : "+negativenum);
        int sum = arrayAdd(numarray);
        return sum;
    }
    
    public static String findDelimiter(String numbers){
        String delimiter;
        if(numbers.matches("//(.*)\n(.*)")){
            index=numbers.lastIndexOf("\n");
            delimiter=numbers.substring(2, index)+"|\n";
            numstring=numbers.substring(index+1);
        }
        else{
            delimiter=",|\n";
            numstring=numbers;
        }
        if(delimiter.charAt(0)=='['){
            char[] ch=delimiter.substring(1,delimiter.length()-3).toCharArray();
            delimiter="";
            for(int i=0;i<ch.length;i++){
                if(ch[i]=='[')
                    delimiter=delimiter+'|';
                else if(ch[i]==']')
                    continue;
                else 
                    delimiter=delimiter+ch[i];
            }
        }
        return delimiter;
    }

    public static int[] findNumbers(String delimiter) {
        return  Arrays.stream(numstring.split(delimiter)).mapToInt(Integer::parseInt).toArray();
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
