/*
/** a java implemntaion of atoi
 *
 * @author jacob
 */
public class myatoi {
    /**
     * can only contain digits + - and .
     * @param s
     * @return 
     */
    private Boolean isGoodChar(Character c){
        Boolean d = Character.isDigit(c);
        Boolean p =(c=='+');
        Boolean m =(c=='-');
        Boolean r =(c=='.');
        return (d||p||m||r);
    }

    private String splitPeriod(String s){
        return s.split("/[^.]*/")[0];//find first string that has a period
    }
    public int myAtoi(String s){
       Boolean isPositive =true;
       s = s.strip();
       if(s.isBlank()){
           return 0;
       }
       if(!this.isGoodChar(s.charAt(0)))
       {
           return 0;
       }
       if(s.indexOf('.')>-1){
           s = this.splitPeriod(s);
       }
       //TODO:find if negative remove any tailing words
       if(s.charAt(0)=='-'){
           isPositive = false;
       }
       return 0; 
    }
    
    public static void main(String args[]){
        
    }
    
}
