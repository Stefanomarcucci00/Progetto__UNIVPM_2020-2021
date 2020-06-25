    
package it.univpm.Project.models;


import java.util.ArrayList;
import java.util.HashMap;


import it.univpm.Project.Statistics.StatisticsImpl;
import it.univpm.Project.exceptions.ParamFieldException;
    /**
     * The class used to create all the stats
     * @author Stefano Marcucci
     *
     */
public class Stats extends StatisticsImpl{
        /**
         * the field of the stat
         */
        private String field;
        /**
         * the param passed by the user is used to create
         * the source stat that requires a param like "Android"
         */
        private String param;
        /**
         * Database
         */
        private ArrayList<Tweet> DataBase=new ArrayList<Tweet>();
        /**
         * ArrayList used to call the method in SourceStat
         */
        private ArrayList<String> SourceStat=new ArrayList<String>();
        /**
         * ArrayList used to call the method in DateStat
         */
        private ArrayList<String> DateStat=new ArrayList<String>();
        private HashMap<String,String> Statistics=new HashMap<String, String>();
        
        /**
         * Constructor used to create the Source Stat
         * @param f
         * @param p
         * @param db
         * @throws ParamFieldException
         */
        public Stats(String f,String p,ArrayList<Tweet> db) throws ParamFieldException {
            this.field=f;
            this.param=p;
            this.DataBase=db;
            SourceStat=getSourceStats(DataBase, f, p);
            
            for(int i=0;i<SourceStat.size();i++) {
            Statistics.put("source", SourceStat.get(i));
            }
        }
        /**
         * Constructor used to create the Date Stat
         * @param f
         * @param p
         * @param db
         * @throws ParamFieldException
         */
            public Stats(String p,ArrayList<Tweet> db){
                this.param=p;
                this.DataBase=db;
                DateStat=getDateStats(DataBase, p);
                for(int j=0;j<DateStat.size();j++) {
                Statistics.put("date", DateStat.get(j));
                }
            }
        
        public HashMap<String, String> getStatistics() {
            return Statistics;
        }
        public void setStatistics(HashMap<String, String> statistics) {
            Statistics = statistics;
        }
        
}
 




