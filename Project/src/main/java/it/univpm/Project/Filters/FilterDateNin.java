
    
package it.univpm.Project.Filters;


import it.univpm.Project.models.Tweet;
/**
 * Class that implements the interface and does the filtering of the "created_at" tag with the "$nin" operator 
 * @author STEPO
 *
 */
public class FilterDateNin implements Filter{
      
    private String field="created_at";
    private String operator="$nin";
 
    public String getField() {
        return this.field;
    }


    public String getOperator() {
        return operator;
    }


    @Override
    public Boolean satisfied(String[] Valuefilters, Tweet recordtocmp) {
        String tmp="";
        tmp = recordtocmp.getCreated_at();
        String[] vett=tmp.split("\\s+");
        String app=Valuefilters[0];
        String[] app2=app.split("\\s+");
        
        if( vett[0].equals(app2[0]) && 
            vett[1].equals(app2[1]) &&
            vett[2].equals(app2[2]) ) 
            return false;
        return true;
    }
}
 





