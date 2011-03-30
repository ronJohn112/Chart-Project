
package chartproject;

import processing.core.*;

import java.util.Random;
/**
 *
 * @author naveeouthaphone
 */
public class Main extends PApplet {
    int windowWidth = 0;
    int windowHeight = 0;
    float[] values = null;


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
        windowWidth = Integer.parseInt(args[1]);
        windowHeight = Integer.parseInt(args[2]);
        size(windowWidth, windowHeight);
        smooth();
        background(100);
        float[] barValues = new float[args.length-3];
        float maxHeight = Float.parseFloat(args[2])-40;
        float barHeight = Float.parseFloat(args[2]);
        float highestBar = 0;
        float barWidth = 0;

        for(int i=3; i<args.length; i++) {
            int currentBarValue = Integer.parseInt(args[i]);
            barValues[i-3] = currentBarValue;
            if(highestBar<currentBarValue) {
                highestBar = currentBarValue;
            }
        }
    barWidth = (Float.parseFloat(args[1])-((barValues.length+1)*5))/barValues.length;

    for(int j=0; j<barValues.length; j++) {
        float y = (barValues[j]/highestBar)*maxHeight;
        float x = 5+((barWidth+5)*j);
        rect(x, barHeight-y-20, barWidth, y);
    }
    }
}


    