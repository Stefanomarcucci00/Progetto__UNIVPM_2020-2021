
    
package it.univpm.Project.Filters;


import java.util.ArrayList;


import it.univpm.Project.models.Tweet;
/**
 * Class that implements the interface and does the filtering of the "source" tag with the "$in" operator 
 * @author Sefano Marcucci,Alessandro Celani
 *
 */
public class FilterSourceIn implements Filter {
       
    private String field="source";
    private String operator="$in";
 
    public String getField() {
        return this.field;
    }


    public String getOperator() {
        return operator;
    }


    @Override
    public Boolean satisfied(String[] Valuefilters, Tweet recordtocmp) {
        for(int i=0; i<Valuefilters.length ;i++)
            if(recordtocmp.getSource().equals(Valuefilters[i]))
                return true;
        return false;
    }
}
 






