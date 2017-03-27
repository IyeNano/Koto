
//********************************************************************
//********************************************************************
//  SmilingFace.java       Author: Lewis/Loftus
//
//  Demonstrates the use of a separate panel class.
//********************************************************************

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SmilingFace
{
   //-----------------------------------------------------------------
   //  Creates the main frame of the program.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Smiling Face");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      JPanel panel = new SmilingFacePanel();

      frame.getContentPane().add(panel);

      frame.pack();
      frame.setVisible(true);

   }
}