
    
package it.univpm.Project.Filters;


import it.univpm.Project.models.Tweet;
/**
 * Class that implements the interface and does the filtering of the "source" tag with the "$not" operator 
 * @author Sefano Marcucci,Alessandro Celani
 *
 */
public class FilterSourceNot implements Filter {
      
    private String field="source";
    private String operator="$not";
 
    public String getField() {
        return this.field;
    }


    public String getOperator() {
        return operator;
    }


    @Override
    public Boolean satisfied(String[] Valuefilters, Tweet recordtocmp) {
        for(int i=0; i<Valuefilters.length ;i++)
            if(!(recordtocmp.getSource().equals(Valuefilters[i]) ))
                return false;
        return true;
    }
}
 





