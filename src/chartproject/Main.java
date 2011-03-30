
package chartproject;

import processing.core.*;

/**
 *
 * @author naveeouthaphone
 */
public class Main extends PApplet {


    public static void main(String[] args) {
        String tempArgs[] = new String[args.length + 2];

        //Set the parameters which will be used by Processing's API
        tempArgs[0] = "--bgcolor=#FFFFFF";
        tempArgs[1] = "chartproject.Main";

        //Append the arguments from the command line to the end of the tempArray
        for (int i = 2; i < tempArgs.length; i++) {
            tempArgs[i] = args[i - 2];
        }

        //Send the String array to the PApplet's main function.
        PApplet.main(tempArgs);
    }
    @Override
    public void setup() {
        float[] barValues = new float[args.length-3];
        float highestBar = 0;

        for(int i=3; i<args.length; i++) {
            int currentBarValue = Integer.parseInt(args[i]);
            barValues[i-3] = currentBarValue;
            if(highestBar<currentBarValue) {
                highestBar = currentBarValue;
            }
        }
    }
}


    