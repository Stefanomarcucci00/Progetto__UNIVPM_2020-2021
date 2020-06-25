
    
package it.univpm.Project.Statistics;


import java.util.ArrayList;


import it.univpm.Project.models.Tweet;
/**
 * The class used to create the Stat on the Source
 * @author Stefano Marcucci
 *
 */
public class StatisticsSource {
    
    private int Android_counter;
    private int iPhone_counter;
    private int WebApp_counter;
    private int Other_platforms_tweets;
    
public int  getAndroid_tweets(ArrayList<Tweet> db, String Field) {
        for(int i=0;i<db.size(); i++) {
            if(Field.equals("Android")) {
                if(db.get(i).getSource().equals("Twitter for Android")) 
                Android_counter++;            
            }
        }
    return Android_counter;
}
public int  getiPhone_tweets(ArrayList<Tweet> db, String Field) {
        for(int i=0;i<db.size(); i++) {
            if(Field.equals("iPhone")) {
                if(db.get(i).getSource().equals("Twitter for iPhone")) 
                    iPhone_counter++;            
            }
        }
    return iPhone_counter;
}
public int  getWebApp_tweets(ArrayList<Tweet> db, String Field) {
        for(int i=0;i<db.size(); i++) {
            if(Field.equals("WebApp")) {
                if(db.get(i).getSource().equals("Twitter Web App")) 
                WebApp_counter++;            
            }
        }
    return WebApp_counter;
}
public int  getOtherPlatforms_tweets(ArrayList<Tweet> db, String Field) {
        for(int i=0; i<db.size() ; i++) {
            if( Field.equals("Others") ) {
                if( !(db.get(i).getSource().equals("Twitter for Android")) && !(db.get(i).getSource().equals("Twitter for iPhone")) &&
                        !(db.get(i).getSource().equals("Twitter Web App")) ); 
            Other_platforms_tweets++;            
            }
        }
    return Other_platforms_tweets;
    }
}




