
    
package it.univpm.Project.Filters;


import java.util.ArrayList;


import org.springframework.stereotype.Service;


import it.univpm.Project.models.CompleteFilter;
import it.univpm.Project.models.SecondFilter;
import it.univpm.Project.models.Tweet;



@Service
public class FilterImpl{
/**
 * Apply Filter1
 * @param filter
 * @param db
 * @return
 */
public ArrayList<Tweet> applyFilter1(CompleteFilter filter, ArrayList<Tweet> db) {
        ArrayList<Tweet> result=new ArrayList<Tweet>();
        result=applyFilter(filter.getFilter1(),db);
        return result;
}
/**
 * Apply Filter2
 * @param filter
 * @param db
 * @return
 */
public ArrayList<Tweet> applyFilter2(CompleteFilter filter, ArrayList<Tweet> db) {
        ArrayList<Tweet> result=new ArrayList<Tweet>();
        result=applyFilter(filter.getFilter2(),db);
    return result;
}
/**
 * Apply Both Filters if needed
 * @param filter
 * @param db
 * @return
 */
public ArrayList<Tweet> applyFilterGerneric_and(CompleteFilter filter, ArrayList<Tweet> db) {
    
    ArrayList<Tweet> results=new ArrayList<Tweet>();
    
    results=applyFilter(filter.getFilter1(), db);
    //results=applyFilter(filter.getFilter2(), db);
    return results;
}
/**
 * Filtering With Macrooperator OR
 * @param filter
 * @param db
 * @return
 */
public ArrayList<Tweet> applyFilterOR(CompleteFilter filter, ArrayList<Tweet> db) {
    
    ArrayList<Tweet> FirstFilterSatisfied=new ArrayList<Tweet>();
    ArrayList<Tweet> results=new ArrayList<Tweet>();
    
    
    FirstFilterSatisfied=applyFilter(filter.getFilter1(),db);
    
    boolean dups=false;
    
    if(results.size()==0) 
    results.addAll(FirstFilterSatisfied);
    
    else {
    
      for(int i=0; i< FirstFilterSatisfied.size() ;i++) {
        dups=false;
        for(int j=0; j<results.size();j++)
            if(results.get(j).getIdtweet()==(FirstFilterSatisfied.get(i).getIdtweet())) {
                dups=true;
            }
                if(!dups)
                    results.add(FirstFilterSatisfied.get(i));
            }
    }
return results;
}
/**
 * APPLY FUNCTION calls all the methods even of other classes to get the filter going
 * @param filter
 * @param db
 * @return
 */
public ArrayList<Tweet> applyFilter(SecondFilter filter, ArrayList<Tweet> db) {
        ArrayList<Tweet> filteredTweets= new ArrayList<Tweet>();
        Filter var=DefineFilters(filter);
            for(int i=0; i<db.size() ;i++) {
                if(var.satisfied(filter.getValues(), db.get(i))) {
                    filteredTweets.add(db.get(i));
                }
            }
        return filteredTweets;
}


public Filter DefineFilters(SecondFilter value) {
        int i;
        Filter[] ArrayOfFilter=DefineFilterTypes();
        for( i=0; i<8;    i++)
            if(ArrayOfFilter[i].getOperator().equals(value.getOperator()) &&
                    ArrayOfFilter[i].getField().equals(value.getField()))
            break;
        return ArrayOfFilter[i];    
}


public Filter[] DefineFilterTypes() {
        
        Filter[] allFilters=new Filter[8];
        //Source
        allFilters[0]=new FilterSourceNin();
        allFilters[1]=new FilterSourceIn();    
        allFilters[2]=new FilterSourceNot();    
        //Follower
        allFilters[3]=new FilterFollowerGt();
        allFilters[4]=new FilterFollowerLt();
        //Date
        allFilters[5]=new FilterDateIn();
        allFilters[6]=new FilterDateNin();
        allFilters[7]=new FilterDateNot();
        
        return allFilters;
    }


public ArrayList<Tweet> applyBothFilters(CompleteFilter filter, ArrayList<Tweet> db) {    
        ArrayList<Tweet> FirstFilterSatisfied=new ArrayList<Tweet>();
        ArrayList<Tweet> SecondFilterSatisfied=new ArrayList<Tweet>();
        
        ArrayList<Tweet> results=new ArrayList<Tweet>();
        
        FirstFilterSatisfied=applyFilter1(filter,db);
        SecondFilterSatisfied=applyFilter2(filter, db);
        boolean dups=false;
    
          for(int i=0; i< FirstFilterSatisfied.size() ;i++) {
            dups=false;
            for(int j=0; j<results.size();j++)
                if(results.get(j).getIdtweet()==(FirstFilterSatisfied.get(i).getIdtweet())) {
                    dups=true;
                    if(!dups)
                        results.add(FirstFilterSatisfied.get(i));
                }
            }
    return results;
    }
    
}









