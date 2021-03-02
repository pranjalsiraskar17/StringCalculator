package prs;

public class StringCalculator {
    public static int add(String numbers) throws Exception {
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

    public static int arrayAdd(String[] numarray) throws Exception {
        int sum=0;
        boolean bool=false;
        String msg="";
        for(String str:numarray){
            int temp=stringToInt(str);
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
