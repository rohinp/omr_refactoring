/*
 * ProcessTemplate.java
 *
 * Created on June 30, 2007, 12:12 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package omrproj_oldcode;

import net.sourceforge.jiu.data.Gray8Image;

/**
 *
 * @author Aaditeshwar Seth
 */
public class ProcessTemplate {

    public static void main(String args[]) {
        //String filename = args[0];
    	String filename = "data/template.tif";

        Gray8Image grayimage = ImageUtil.readImage(filename);
//        Gray8Image grayimage = ImageUtil.readImage("../../2circle-org-colored-whole.tif");
        
        ImageManipulation image = new ImageManipulation(grayimage);
        image.locateConcentricCircles();
        image.locateMarks();
        
        image.writeAscTemplate(filename + ".asc");
        image.writeConfig(filename + ".config");
//        image.writeAscTemplate("2circle-org-colored-whole.asc");
//        image.writeConfig("2circle-org-colored-whole.config");
    }    
}
