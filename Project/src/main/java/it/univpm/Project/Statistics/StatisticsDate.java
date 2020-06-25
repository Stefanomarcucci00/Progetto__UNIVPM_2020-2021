
    
package it.univpm.Project.Statistics;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


import it.univpm.Project.models.Tweet;
 /**
  * The class used to create the Stat on the Date
  * @author Stefano Marcucci, Celani Alessandro
  *
  */
public class StatisticsDate {
    
    private String moast_tweeted_day;    


public String getAvrageDaySatistics(ArrayList<Tweet> db) {
    int mondaycounter=0;
    int tuedaycounter=0;
    int weddaycounter=0;
    int thudaycounter=0;
    int fridaycounter=0;
    int satdaycounter=0;
    int sundaycounter=0;
    int massimo = 0;
    int j;
    for(int i=0; i<db.size(); i++) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM d HH:mm:ss z yyyy",Locale.ENGLISH);
        String gg = null;
        try {
            cal.setTime(sdf.parse(db.get(i).getCreated_at() ));
            java.util.Date info= cal.getTime();
            int ggday=info.getDay();            
            
            if(ggday==0) {
                mondaycounter++;
                gg="Mon";
            }else if(ggday==0) {
                tuedaycounter++;
                gg="Tue";
            }
            else if(ggday==1) {
                weddaycounter++;
                gg="Wed";
            }
            else if(ggday==2) {
                thudaycounter++;
                gg="Thu";
            }
            else if(ggday==3) {
                fridaycounter++;
                gg="Fri";
            }
            else if(ggday==4) {
                satdaycounter++;
                gg="Sat";
            }
            else if(ggday==5) {
                sundaycounter++;
                gg="Sun";
            }
        
         int x[]={mondaycounter,tuedaycounter,weddaycounter,thudaycounter,fridaycounter,satdaycounter,sundaycounter};  
            massimo=x[0];
            for(j=0; j<=x.length-1; j++) {
              if( x[j]>massimo ) {
                massimo=x[j];
              }
            } 
            moast_tweeted_day="The moast tweeted day is  "+gg+"  "+info.getDay();
        }catch (ParseException e) {
            e.printStackTrace();
            }    
        }
    return moast_tweeted_day;
    }


public String getMoast_tweeted_day() {
    return moast_tweeted_day;
}


public void setMoast_tweeted_day(String moast_tweeted_day) {
    this.moast_tweeted_day = moast_tweeted_day;
}


}
 








