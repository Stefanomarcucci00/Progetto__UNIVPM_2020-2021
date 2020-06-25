
    
package it.univpm.Project.Filters;


import java.util.ArrayList;
/**
 * Class that implements the interface and does the filtering of the "follower" tag with the "$gt" operator 
 * @author Sefano Marcucci,Alessandro Celani
 *
 */
import it.univpm.Project.models.Tweet;


public class FilterFollowerGt implements Filter {
       
    private String field="follower";
    private String operator="$gt";
 
    public String getField() {
        return this.field;
    }


    public String getOperator() {
        return operator;
    }


    @Override
    public Boolean satisfied(String[] Valuefilters, Tweet recordtocmp) {
        long num1 = 0;
    
        for(int i=0; i<Valuefilters.length ;i++)
            num1=Long.parseLong(Valuefilters[i]);
            if(( num1 < recordtocmp.getFollower() ) )
                return true;
        return false;
    }
}
 






