
    
package it.univpm.Project.Filters;


import java.util.ArrayList;


import it.univpm.Project.models.Tweet;
/**
 * Class that implements the interface and does the filtering of the "source" tag with the "$nin" operator 
 * @author Sefano Marcucci,Alessandro Celani
 *
 */
public class FilterSourceNin implements Filter {
        
        private String field="source";
        private String operator="$nin";
     
        public String getField() {
            return this.field;
        }


        public String getOperator() {
            return operator;
        }


        @Override
        public Boolean satisfied(String[] Valuefilters, Tweet recordtocmp) {
            for(int i=0; i<Valuefilters.length ;i++)
                if(recordtocmp.getCreated_at().equals(Valuefilters[i]))
                    return false;
            return true;
        }
}
 






