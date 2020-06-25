
    package it.univpm.Project.utils;
    /**
     * This class splits the created_at strings by removing the things typer in the angle brackests
     * @author Celani alessandro, Stefano Marcucci
     */
public class SourceStringSplitter {
   
    public String StringSplitter(String jsonstr) {
        String str_final="";
        boolean isin=true;
        for(char c:jsonstr.toCharArray()) {
            if(c=='<')
                isin =true;
            if(!isin)
                str_final+= c;
            if(c=='>')
                isin =false;
        }
        return str_final;
    }
}
 
