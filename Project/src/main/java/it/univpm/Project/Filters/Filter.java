
    
package it.univpm.Project.Filters;


import it.univpm.Project.models.Tweet;
        /**
         * Interface
         * @author Stefano Marcucci,Alessandro Celani
         */
public interface Filter{
        /**
         * The function cheks if the ValueFilters is satisfied by the recordtocpm
         * @param Valuefilters
         * @param recordtocmp
         * @return true/false if the recordtocmp satisfy the filter
         */
    public abstract Boolean satisfied(String[] Valuefilters ,Tweet recordtocmp);
        /**
         * method that gets the operator of the field
         * @return the operator
         */
    public abstract String getOperator();
        /**
         * method that gets the operator of the field
         * @return the field
         */
    public abstract String getField();
        
            
}
 



