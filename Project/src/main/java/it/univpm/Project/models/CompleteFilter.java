
    package it.univpm.Project.models;
    /**
     * This class is the structure of the filters
     * @author Stefano Marcucci,Alessandro Celani
     */
public class CompleteFilter {
    /**
     * The Macro operator of the filter ("$and","$or")
     */
    private String macroOp="";
    /**
     * The first filter
     */
    private SecondFilter filter1;/**
     * The second filter
     */
    private SecondFilter filter2;
   
    /**
     * Getter and Setters to get all the info from the SecondFilter class
     */
    public String getMacroOp() {
        return this.macroOp;
    }
    public void setMacroOp(String macroOp) {
        this.macroOp = macroOp;
    }
   
    public SecondFilter getFilter1() {
        return this.filter1;
    }
    public void setFilter1(SecondFilter filter1) {
        this.filter1 = filter1;
    }
   
    public SecondFilter getFilter2() {
        return this.filter2;
    }
    public void setFilter2(SecondFilter filter2) {
        this.filter2 = filter2;
    }
   
   
   
}
 
