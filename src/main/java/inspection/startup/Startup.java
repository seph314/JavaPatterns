/*
* This program is created by Anders Pettersson as a seminar task in the course
* Object oriented design (IV1350) at KTH University.
*/
package inspection.startup;

import inspection.view.View;

/**
 * Startup contains the main function
 */
public class Startup {

    /**
     * main function creates an instance of the view and calls the start method
     * @param args
     */
    public static void main(String[] args) {

        new View().start();
    }
}
