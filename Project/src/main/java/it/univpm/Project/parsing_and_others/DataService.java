
    
package it.univpm.Project.parsing_and_others;


import java.io.IOException;
import java.util.ArrayList;


import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;


import it.univpm.Project.Filters.FilterImpl;
import it.univpm.Project.exceptions.FilterBodyErr;
import it.univpm.Project.exceptions.ParamFieldException;
import it.univpm.Project.models.CompleteFilter;
import it.univpm.Project.models.DB;
import it.univpm.Project.models.MetaData;
import it.univpm.Project.models.Stats;
import it.univpm.Project.models.Tweet;
import it.univpm.Project.utils.FilterWordRecognizer;
/**
 * The class that provides the functions of the application 
 * @author Stefano Marcucci, Celani Alessandro
 *
 */
@Service
public class DataService{
    /**
     * The application dataPool
     */
    private ArrayList<Tweet> DataBase=new ArrayList<>();
    /**
     * Used to Create the DataBase
     */
    private Downloading_and_Parsing JSON_Info_Conteiner=new  Downloading_and_Parsing();
    /**
     * All the metadata
     */
    private DB metadata=new DB();
    /**
     * New arraylist composed of the dataPool records that are filtered
     */
    private ArrayList<Tweet> FilteredDataBase=new ArrayList<>();
    
    /**
     *The Stats of the dataPool
     */
    private Stats statistics[]=new Stats[2];
    /**
     * Costructor
     * @throws ParseException
     * @throws org.apache.tomcat.util.json.ParseException 
     * @throws IOException 
     */
    public DataService() throws ParseException, org.apache.tomcat.util.json.ParseException, IOException {
    DataBase=JSON_Info_Conteiner.Display_JSONtweets();    
    }
    /**
     * Metadata Visualizzation method
     * @return An ArrayList of metadata
     */
    public ArrayList<MetaData> displayMetadata(){
        return metadata.getMetadata();
    }
    /**
     * Stats creation metod of the sourcce field
     * @param param
     * @return An array of Stats
     * @throws ParseException
     * @throws org.apache.tomcat.util.json.ParseException
     * @throws IOException
     * @throws ParamFieldException
     * @throws StatisticException 
     */
    public Stats[] Display_SourceStats_tweets(String param) throws ParseException, org.apache.tomcat.util.json.ParseException, IOException, ParamFieldException, ParamFieldException{
        statistics[0]=new Stats("source",param , DataBase);
        return this.statistics;
    }
    /**
     * Stats creation method of the data field
     * @return An array of Stats
     * @throws ParseException
     * @throws org.apache.tomcat.util.json.ParseException
     * @throws IOException
     * @throws ParamFieldException
     */
    public Stats[] Display_DataStats_tweets() throws ParseException, org.apache.tomcat.util.json.ParseException, IOException, ParamFieldException{
        statistics[1]=new Stats("date", DataBase);
        return this.statistics;
    }
    
    /**
     * The function that shows all the Tweets
     * @return An ArrayList of Tweets
     * @throws ParseException
     * @throws org.apache.tomcat.util.json.ParseException
     * @throws IOException
     */
    public ArrayList<Tweet> Display_tweets() throws ParseException, org.apache.tomcat.util.json.ParseException, IOException{
        return JSON_Info_Conteiner.Display_JSONtweets();
    }
    /**
     * The function that compute all the Filters
     * @param Filter
     * @return An ArrayList of Tweet type that contains all the values that satisfy the Filters
     * @throws FilterBodyErr
     */
    public ArrayList<Tweet> Display_Filtered_Tweets(String Filter) throws FilterBodyErr {
        FilterWordRecognizer recognizer=new FilterWordRecognizer();
        FilterImpl executor= new  FilterImpl();
        CompleteFilter recognizefilter= recognizer.TotalFilters(Filter);
        if(recognizefilter.getMacroOp()=="$or")
            FilteredDataBase=executor.applyBothFilters(recognizefilter,DataBase);
        else
            FilteredDataBase=executor.applyFilterGerneric_and(recognizefilter,DataBase);
        return FilteredDataBase;
    }
    
    


}
 






