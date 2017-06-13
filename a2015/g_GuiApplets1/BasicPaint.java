package g_GuiApplets1;
import javax.swing.*;
import java.awt.*;

public class BasicPaint extends JApplet
{
  final int radius = 25;

  public void paint ( Graphics gr )
  { 
    gr.setColor( Color.red );
    gr.fillOval( 50,50,100,100);
    gr.setColor( Color.green );
    gr.fillRect( 90, 90, 20, 20);
    gr.setColor(Color.black);
    gr.drawString("Veamos que pasa",75,75 );
   }
}
