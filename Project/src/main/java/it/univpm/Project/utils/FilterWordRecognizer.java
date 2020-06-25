
    
package it.univpm.Project.utils;


import it.univpm.Project.exceptions.FilterBodyErr;
import it.univpm.Project.models.CompleteFilter;
import it.univpm.Project.models.SecondFilter;
    /**
     * The class that recognizes the "body" typer from the user in postman
     * @author Stefano Marcucci,Alessandro Celani
     *
     */
public class FilterWordRecognizer {
        /**
         * This method cheks the format (so all the {},[],:, ecc... )of the filter that the user has typed in the body section of postman
         * it recognize also the words typed by the user 
         * @param body
         * @return
         * @throws FilterBodyErr
         */
    public CompleteFilter TotalFilters(String body) throws FilterBodyErr {
        CompleteFilter allFilters= new CompleteFilter();
        int pos=0;
        try 
        {
        if(!body.substring(0,1).equals("{")) 
            throw new FilterBodyErr("The start must be \"{\"");
        
            String filterStringStart=analyzeWord(body, 0)[1];
            
            if(filterStringStart.equals("$or")) {
                allFilters.setMacroOp("$or");
                pos=5;
            if(!(body.charAt(7)=='{' || body.charAt(7)=='['))
                throw new FilterBodyErr("After macroOperator filter has to respect the format with '{' or '[' ");
            }
            else if (filterStringStart.equals("$and")) {
                allFilters.setMacroOp("$and");
                pos=6;
                if(!(body.charAt(8)=='{' || body.charAt(8)=='['))
                    throw new FilterBodyErr("After macroOperator filter has to respect the format with '{' or '[' ");
        }
            
            else {
            body= "{ :["+body+"] }";
            allFilters.setMacroOp("");
            pos=body.indexOf(':');
                }
            SecondFilter basicFilter;
        do {
            String[] fields=new String[2];
            basicFilter=new SecondFilter();
            
            
            fields=analyzeWord(body, pos);
            basicFilter.setField(fields[1]);
            pos=Integer.parseInt(fields[0]);
            
            fields=analyzeWord(body, pos);
            basicFilter.setOperator(fields[1]);
            pos=Integer.parseInt(fields[0]);
            
            if(body.charAt(pos) != ':') 
                throw new FilterBodyErr("No \":\" before the typed values");
                pos++;
                //Cheks if it is an array
                if(body.charAt(pos)=='[') {
                    String tmp="";
                    while(body.charAt(pos)!=']') {
                        tmp+=(body.charAt(pos));
                        pos++;
                    }
                    basicFilter.setValues(tmp.split(","));
                    while(body.charAt(pos)!='}')
                        pos++;
                }
                else {
                    String value[] = new String [1];
                    value[0]="";
                    while(body.charAt(pos)!='}') {
                        value[0]+=(body.charAt(pos));
                        pos++;
                    }
                    basicFilter.setValues(value);
                }
                allFilters.setFilter1(basicFilter);
                allFilters.setFilter2(basicFilter);
                pos++;
                if(body.charAt(pos) !='}' )
                    throw new FilterBodyErr("The filter does not have the \"}\"");
                pos++;
                if(body.charAt(pos) =='}' || body.charAt(pos+1)=='}')
                    break;
                
        }while(!allFilters.getMacroOp().equals(""));
        }
        catch(Exception e) {
            throw new FilterBodyErr("Filter is incomplete");
        }
        return allFilters;
}
    /**
     * The class cheks the Format of the string that you pass (toAnalyze) it's used in the method TotalFilter to
     * check if the first part of the Filter is typed correctly
     * @param toAnalyze
     * @param pos
     * @return An array of String 
     * @throws FilterBodyErr
     */
    public String[] analyzeWord(String toAnalyze,int pos) throws FilterBodyErr{
        String[] word= new String [2];
        String tmp=new String();
        try 
        {
        while(toAnalyze.charAt(pos) != '{')
            pos++;
        while(toAnalyze.charAt(pos) !=':' ) {
            tmp+=(toAnalyze.charAt(pos));
            pos++;
        }
            word[0]=""+pos;
            word[1]= (tmp.split("\""))[1]; 
        }catch(Exception e) {
            throw new FilterBodyErr("The filter does not have the correct format whatch out for '{' or ':'");
            }
        return word;
        }
    
    
}
 



