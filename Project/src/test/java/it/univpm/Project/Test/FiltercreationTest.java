
    
package it.univpm.Project.Test;


import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import it.univpm.Project.exceptions.FilterBodyErr;
import it.univpm.Project.utils.FilterWordRecognizer;


class FiltercreationTest {
    
    FilterWordRecognizer toanalyze= new FilterWordRecognizer(); 
    
    @BeforeEach
    void setUp() throws Exception {
    }


    @AfterEach
    void tearDown() throws Exception {
    }


    @Test
    void test() {
        assertThrows(FilterBodyErr.class, ()-> toanalyze.TotalFilters("{\"source\":{\"$in\":Twiter for Android}}"));
        assertThrows(FilterBodyErr.class, ()-> toanalyze.TotalFilters("{\"source\":{\"$nin\":Twiter for iPhone}}"));
        assertThrows(FilterBodyErr.class, ()-> toanalyze.TotalFilters("{\"follower\":{\"$gt\":400}}"));
        assertThrows(FilterBodyErr.class, ()-> toanalyze.TotalFilters("{\"source\":{\"$gggggge\": 400}}"));
        assertThrows(FilterBodyErr.class, ()-> toanalyze.TotalFilters("{\"sourcceee\":{\"$gte\": 400}}"));
        assertThrows(FilterBodyErr.class, ()-> toanalyze.TotalFilters("{\"follower\":{\"$nin\": 400}}"));
    }


}
 









