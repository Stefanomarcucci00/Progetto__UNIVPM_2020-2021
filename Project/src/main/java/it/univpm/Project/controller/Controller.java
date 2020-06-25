
    
package it.univpm.Project.controller;


import java.io.IOException;
import java.util.ArrayList;


import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import it.univpm.Project.exceptions.FilterBodyErr;
import it.univpm.Project.exceptions.ParamFieldException;
import it.univpm.Project.models.MetaData;
import it.univpm.Project.models.Stats;
import it.univpm.Project.models.Tweet;
import it.univpm.Project.parsing_and_others.DataService;



@RestController
public class Controller {
    /**
     * The dataservices that provides all the request
     */
    @Autowired
    private DataService dataservice;
    
    /**
     * The root that shows all the Tweets
     * @return An ArrayList of tweets that contains all the data
     * @throws org.json.simple.parser.ParseException
     * @throws ParseException
     * @throws IOException
     */
    @GetMapping("/GetTweets")
    public     ArrayList<Tweet> GetTweets() throws org.json.simple.parser.ParseException, ParseException, IOException{
        return new ArrayList<Tweet>(dataservice.Display_tweets());
    }
    /**
     * The root that shows the MetaData
     * @return An ArrayList of Metadata
     * @throws org.json.simple.parser.ParseException
     * @throws ParseException
     * @throws IOException
     */
    @GetMapping("/GetMetaData")
    public     ArrayList<MetaData> GetMetadata() throws org.json.simple.parser.ParseException, ParseException, IOException{
        return new ArrayList<MetaData>(dataservice.displayMetadata());
    }
    
    /**
     * The root that shows all the Filtered Tweets
     * @param filtro
     * @return An ArrayList of tweets that contains all the Filtered data
     * @throws FilterBodyErr
     */
    @PostMapping("/Filter")
    public ArrayList<Tweet> Get_filtered_tweets(@RequestBody String filter) throws FilterBodyErr{
        return new ArrayList<Tweet>(dataservice.Display_Filtered_Tweets(filter));
    }
    /**
     * The root that shows the Statistics of the tag "created_at"
     * @return An array of the class Stats
     * @throws FilterBodyErr
     * @throws org.json.simple.parser.ParseException
     * @throws ParseException
     * @throws IOException
     * @throws ParamFieldException
     */
    @PostMapping("/DataStatistic")
    public Stats[] Display_DateStats_tweets() throws FilterBodyErr, org.json.simple.parser.ParseException, ParseException, IOException, ParamFieldException{
        return dataservice.Display_DataStats_tweets();
    }
    /**
     * The root that shows the Statistics of the tag "source"
     * @param param
     * @return An array of the class Stats
     * @throws FilterBodyErr
     * @throws org.json.simple.parser.ParseException
     * @throws ParseException
     * @throws IOException
     * @throws ParamFieldException
     * @throws StatisticException
     */
    @PostMapping("/SourceStatistic")
    public Stats[] Display_SourceStats_tweets(@RequestBody String param) throws FilterBodyErr, org.json.simple.parser.ParseException, ParseException, IOException, ParamFieldException{
        return dataservice.Display_SourceStats_tweets(param);
    }    
}






