
import java.io.*;
import java.util.Scanner;
import net.sourceforge.jiu.codecs.*;
import net.sourceforge.jiu.data.*;
import net.sourceforge.jiu.color.reduction.*;
import net.sourceforge.jiu.filters.*;
import net.sourceforge.jiu.geometry.*;

import net.sourceforge.jiu.data.Gray8Image;
public class Menu {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 int ch;
		do
        {
            System.out.println("\n");
            System.out.println("Menu:");
            System.out.println("1.template function");
            System.out.println("2.form function");
            System.out.println("3.display result");
            System.out.println("4.Exit");
            System.out.println("Enter your choice: ");

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
             ch = Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1:
                	ProcessTemplate template =new ProcessTemplate();
                    template.Template(args);
             
                	break;
                case 2:
                	break;
                case 3:
                	break;
                case 4:
                	break;
                default:
            }
        }
		while(ch!=4);
	}
	}
