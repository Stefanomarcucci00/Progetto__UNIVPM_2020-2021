   
package it.univpm.Project.Statistics;



import java.util.ArrayList;


import it.univpm.Project.exceptions.ParamFieldException;
import it.univpm.Project.models.Tweet;
/**
 * The class that calls the Statistics date and Source classes to build the arrayList
 * that are used to store the Stats information
 * @author Stefano Marcucci
 *
 */
public class StatisticsImpl {


    private StatisticsSource statSource=new StatisticsSource();
    private StatisticsDate statDate= new StatisticsDate();
    


public ArrayList<String> getSourceStats(ArrayList<Tweet> db, String Field,String param) throws ParamFieldException{
        
        ArrayList<String> Statistics=new ArrayList<String>();
        String tAndroid=new String();
        String tiPhone=new String();
        String tWebApp=new String();
        String tOtherplat=new String();
        if((param.equals("Android") || (param.equals("iPhone") || (param.equals("WebApp") || (param.equals("Others")  ))))){
             if(Field.equals("source")) {
            tAndroid="Number of Tweets from Android "+statSource.getAndroid_tweets(db, param);
            tiPhone="Number of Tweets from iPhone "+statSource.getiPhone_tweets(db, param);
            tWebApp="Number of Tweets from WebApp "+statSource.getWebApp_tweets(db, param);
            tOtherplat="Number of Tweets from Other Sources "+statSource.getOtherPlatforms_tweets(db, param);
             }
        Statistics.add(tAndroid);
        Statistics.add(tiPhone);
        Statistics.add(tWebApp);
        Statistics.add(tOtherplat);
        }
        else
            throw new ParamFieldException("Param must be {Android, iPhone, WebApp, Others}");
         return Statistics;
        }



public ArrayList<String> getDateStats(ArrayList<Tweet> db, String param) {
    ArrayList<String> Statistics=new ArrayList<String>();    
        if(param.equals("date")) {
            Statistics.add(statDate.getAvrageDaySatistics(db));
        }
        return Statistics;
    }
}







