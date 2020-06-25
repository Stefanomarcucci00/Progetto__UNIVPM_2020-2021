
    package it.univpm.Project.models;
    /**
     * The second class that describes the  fields ,values and operator of a filter
     * @author STEPO
     *
     */
public class SecondFilter {
    /**
     * field of the filter operation
     */
    private String field;
    /**
     * values typed by the user that uses the application
     */
    private String [] values;
    /**
     * possible operators to use
     */
    private String operator;
   
    public String getField() {
        return this.field;
    }
    public void setField(String field) {
        this.field = field;
    }
   
    public String[] getValues() {
        return this.values;
    }
    public void setValues(String[] values) {
        this.values = values;
    }
   
    public String getOperator() {
        return this.operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
   
   
}
 
