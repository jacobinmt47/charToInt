/*
/** a java implemntaion of atoi
 *
 * @author jacob
 */
public class myatoi {
    private int sum(String s){
        s=s.trim();
        return Integer.parseInt(s);//cheating needs to be done with chars and ints
    }
    private String onlyDigits(String s) {
        char array[] = new char[s.length()];
        int nextchar = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                array[nextchar] = s.charAt(i);
                nextchar++;
            }
        }
        return new String(array);
    }

    private Boolean isMax(String s, Boolean isPositive) {
        if (s.length() > 10) {
            return true;
        }
        if (s.length() == 10) {
            if (s.charAt(0) == '1') {
                return false;
            }
            if (s.charAt(0) == '2') {
                //do lots of stuff based on if greater that 2**31-1 or less that 2**31
            }
            return true;
        }
        //string should be under 10 digits
        return false;
    }

    /**
     * can only contain digits + - and .
     *
     * @param s
     * @return
     */
    private Boolean isGoodChar(Character c) {
        Boolean d = Character.isDigit(c);
        Boolean p = (c == '+');
        Boolean m = (c == '-');
        Boolean r = (c == '.');
        return (d || p || m || r);
    }

    private String splitPeriod(String s) {
        return s.split("/[^.]*/")[0];//find first string that has a period
    }

    public int myAtoi(String s) {
        Boolean isPositive = true;
        s = s.toLowerCase();
        s = s.strip();
        if (s.isBlank()) {
            return 0;
        }
        if (!this.isGoodChar(s.charAt(0))) {
            return 0;
        }
        if (s.indexOf('.') > -1) {
            s = this.splitPeriod(s);
        }
        //TODO:find if negative remove any tailing words
        if (s.charAt(0) == '-') {
            isPositive = false;
        }
        s = this.onlyDigits(s);
        if(this.isMax(s, isPositive)){
            if(isPositive){
                return Integer.MAX_VALUE;
            }
            else{
                return Integer.MIN_VALUE;
            }
        }
        if(isPositive){
            return this.sum(s);
        }
        else{
            return 0-(this.sum(s));
        }
    }

    public static void main(String args[]) {
        myatoi m = new myatoi();
        int i = m.myAtoi("-123");
        System.out.println(i);
        i = m.myAtoi("234 words");
        System.out.println(i);
    }

}
