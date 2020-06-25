
    

package it.univpm.Project.exceptions;


public class ParamFieldException extends Exception {


    /**
     * The Exception that is trown if The param of the Source Stats is not {Android, iPhone, WebApp, Others}
     * @param message
     */
    private static final long serialVersionUID = 1L;


    public  ParamFieldException(String message) {
        super(message);
    }
}
 





