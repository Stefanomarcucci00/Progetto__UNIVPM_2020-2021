
    
package it.univpm.Project.Test;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.univpm.Project.Filters.FilterFollowerGt;
import it.univpm.Project.Filters.FilterImpl;
import it.univpm.Project.models.CompleteFilter;
import it.univpm.Project.models.SecondFilter;


class CreationFilterTest {


    CompleteFilter All=new CompleteFilter();
    SecondFilter filter= new SecondFilter();
    String[] values= new String[] {"100"};
    FilterImpl Fprocessing= new FilterImpl();
    
    
    @BeforeEach
    void setUp() throws Exception {
    }


    @AfterEach
    void tearDown() throws Exception {
    }
    
    @Test
    void test() {
    All.setMacroOp("");
    filter.setField("follower");
    filter.setValues(values);
    filter.setOperator("$gt");
    All.setFilter1(filter);
    assertEquals(FilterFollowerGt.class, Fprocessing.DefineFilters(All.getFilter1()));
    }


}
 









