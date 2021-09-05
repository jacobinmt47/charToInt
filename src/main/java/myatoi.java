/*
/** a java implemntaion of atoi
 *
 * @author jacob
 */
public class myatoi {

    private String rmLeadingZeros(String s) {
        char arr[] = new char[s.length()];
        int nextChar = 0;
        Boolean leading = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0' || leading) {
                arr[nextChar] = s.charAt(i);
                nextChar++;
            } else {
                leading = false;
                break;
            }
        }
        String ret = new String(arr);
        return ret.strip();
    }

    private int sum(String s) {
        s = s.trim();
        int len = s.length() - 1;
        int powten = 1;
        int arr[] = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int l = (len - i);
            arr[i] = s.charAt(l) - '0';
            arr[i] = arr[i] * powten;
            powten = powten * 10;

        }
        int sum = 0;
        for (int j = 0; j < s.length(); j++) {
            sum = sum + arr[j];
        }
        return sum;
    }

    private String onlyDigits(String s) {
        char array[] = new char[s.length()];
        int nextchar = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i)>='0'&&(s.charAt(i)<='9'))) {
                array[nextchar] = s.charAt(i);
                nextchar++;
            }
            else{
                return "0";
            }
        }
        String ret = new String(array);

        return ret.trim();
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
                char arr[] = new char[9];
                for (int i = 0; i < 9; i++) {
                    arr[i] = s.charAt(i + 1);
                }
                int sht = this.sum(new String(arr));
                if (sht > (147483647) && isPositive) {
                    return true;
                }
                if (sht > (147483648) && !isPositive) {
                    return true;
                }
                return false;
            }
            return true; // 3 or greater
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
        Boolean d = (c>='0'&&c<='9');
        Boolean p = (c == '+');
        Boolean m = (c == '-');
        Boolean r = (c == '.');
        return (d || p || m || r);
    }

    public int myAtoi(String s) {
        Boolean isPositive = true;
        s = s.toLowerCase();
        s = s.strip();
        if (s.contains("+-") || s.contains("-+")) {
            return 0;
        }
        if (s.indexOf('.') > -1) {
            String t = s.substring(0, s.indexOf('.'));
            s = t;
        }
        if (s.isBlank()) {
            return 0;
        }

        if (s.charAt(0) == '-') {
            isPositive = false;
        }
        if (!this.isGoodChar(s.charAt(0))) {
                return 0;
            }
        s = this.onlyDigits(s);
        s = this.rmLeadingZeros(s);
        if (this.isMax(s, isPositive)) {
            if (isPositive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if (isPositive) {
            return this.sum(s);
        } else {
            return 0 - (this.sum(s));
        }
    }

    public static void main(String args[]) {
        myatoi m = new myatoi();
        int i = m.myAtoi("-123");
        System.out.println(i);
        i = m.myAtoi("234 words");
        System.out.println(i);
       i = m.myAtoi("00000-42a1234");
        System.out.println(i);
        System.out.println(m.myAtoi("9999999999"));
        System.out.println(m.myAtoi("4193 with words"));
        System.out.println(m.myAtoi("3.14159"));
        System.out.println(m.myAtoi("21474836460"));
        System.out.println(m.myAtoi("0100"));
        System.out.println(m.myAtoi("+-12"));

    }
}
