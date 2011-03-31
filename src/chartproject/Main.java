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
        //Setting up the width and height of the window from the args.
        windowWidth = Integer.parseInt(args[1]);
        windowHeight = Integer.parseInt(args[2]);
        size(windowWidth, windowHeight);
        smooth();
        background(200);

        //Assigning args values into variable to be loop in the algorithm.
        float[] barValues = new float[args.length - 3];
        float maxHeight = Float.parseFloat(args[2]) - 80;
        float barHeight = Float.parseFloat(args[2]);
        float highestBar = 0;
        float barWidth = 0;

        //Checking for the largest value and and setting it as the highestBar.
        for (int i = 3; i < args.length; i++) {
            float currentBarValue = Float.parseFloat(args[i]);
            barValues[i - 3] = currentBarValue;
            if (highestBar < currentBarValue) {
                highestBar = currentBarValue;
            }
        }
        //Setting the barWidth equally 5 pixies apart.
        barWidth = (Float.parseFloat(args[1]) - ((barValues.length + 1) * 5)) / barValues.length;

        //Using random to assign random numbers for the fill.
        Random randomGenerator = new Random();

        for (int j = 0; j < barValues.length; j++) {
            //Setting up the width and height of the bars.
            float y = (barValues[j] / highestBar) * maxHeight;
            float x = 5 + ((barWidth + 5) * j);

            //Randomly assigning colors for each bar.
            int r = randomGenerator.nextInt(255);
            int g = randomGenerator.nextInt(255);
            int b = randomGenerator.nextInt(255);
            fill(r, g, b);

            //This function draws the bar graph.
            rect(x, barHeight - y - 40, barWidth, y);

            //This will display the data values under the center of the bars.
            float center = ((barWidth / 2) + (barWidth + 5) * j);

            //Search a list of fonts to create the font to use.
            //I chose "Osaka" in the size 10 font with the color black.
            list();
            PFont f;
            f = loadFont("Osaka-10.vlw");
            textFont(f, 10);
            fill(0);

            //Text() will display the values on the screen.
            text((int)barValues[j], center, barHeight);
        }
    }
}
