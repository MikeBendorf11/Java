package i_GUI_Advan;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class SimplePaintMenusFrame extends JFrame {
	JMenu colorChoice, figureChoice, options;  // Pop-up menus, defined as instance
     // variables so that the Display
     // class can see them.
	 JRadioButtonMenuItem red, green, blue,       // Control the color
     cyan, magenta, yellow,  //    of newly added shapes.
     black, gray, white, curve, straightLine, rectangle, oval, roundRect,
		filledRectangle, filledOval, filledRoundRect;
	 

	 
public SimplePaintMenusFrame() {

setBackground(Color.gray); 
getContentPane().setBackground(Color.gray);

Display canvas = new Display();  // The drawing area.
getContentPane().add(canvas,BorderLayout.CENTER);

JMenuBar menuBar = new JMenuBar();
setJMenuBar(menuBar);

options = new JMenu("Options");
menuBar.add(options);
colorChoice = new JMenu("Color");
menuBar.add(colorChoice);
figureChoice = new JMenu("Figure");
menuBar.add(figureChoice);

// changes background but shape color
JMenuItem fill = new JMenuItem("Set Background");
fill.setAccelerator( KeyStroke.getKeyStroke("ctrl B") );
fill.addActionListener(canvas);

//erases all shapes but bg color 
JMenuItem clear = new JMenuItem("Clear");
clear.setAccelerator( KeyStroke.getKeyStroke("ctrl C") );
clear.addActionListener(canvas);

// one step back only
JMenuItem undo = new JMenuItem("Undo");
undo.setAccelerator( KeyStroke.getKeyStroke("ctrl U") );
undo.addActionListener(canvas);
/*check what the listener is going to be (use off screen image method)*/

options.add(fill);
options.add(clear);
options.add(undo);

ButtonGroup colorGroup = new ButtonGroup();
black = new JRadioButtonMenuItem("Black");
colorGroup.add(black);
red = new JRadioButtonMenuItem("Red");
colorGroup.add(red);
green = new JRadioButtonMenuItem("Green");
colorGroup.add(green);
blue = new JRadioButtonMenuItem("Blue");
colorGroup.add(blue);
cyan = new JRadioButtonMenuItem("Cyan");
colorGroup.add(cyan);
magenta = new JRadioButtonMenuItem("Magenta");
colorGroup.add(magenta);
yellow = new JRadioButtonMenuItem("Yellow");
colorGroup.add(yellow);
white = new JRadioButtonMenuItem("White");
colorGroup.add(white);
black.setSelected(true);

colorChoice.add(black);
colorChoice.add(red);
colorChoice.add(green);
colorChoice.add(blue);
colorChoice.add(cyan);
colorChoice.add(magenta);
colorChoice.add(yellow);
colorChoice.add(white);

ButtonGroup shapeGroup = new ButtonGroup();
curve = new JRadioButtonMenuItem("Curve");
shapeGroup.add(curve);
straightLine = new JRadioButtonMenuItem("Straight Line");
shapeGroup.add(straightLine);
rectangle = new JRadioButtonMenuItem("Rectangle");
shapeGroup.add(rectangle);
oval = new JRadioButtonMenuItem("Oval");
shapeGroup.add(oval);
roundRect= new JRadioButtonMenuItem("RoundRect");
shapeGroup.add(roundRect);
filledRectangle = new JRadioButtonMenuItem("Filled Rectangle");
shapeGroup.add(filledRectangle);
filledOval = new JRadioButtonMenuItem("Filled Oval");
shapeGroup.add(filledOval);
filledRoundRect = new JRadioButtonMenuItem("Filled RoundRect");
shapeGroup.add(filledRoundRect);
curve.setSelected(true);

figureChoice.add(curve);
figureChoice.add(straightLine);
figureChoice.add(rectangle);
figureChoice.add(oval);
figureChoice.add(roundRect);
figureChoice.add(filledRectangle);
figureChoice.add(filledOval);
figureChoice.add(filledRoundRect);
try {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
 catch (Exception e) {
 }
 setLocation(20,50);
 setSize(550,420);
 show();
 
}  // end init()



private class Display extends JPanel 
implements MouseListener, MouseMotionListener, ActionListener {

    private final static int 
    BLACK = 0,
    RED = 1,            // Some constants to make
    GREEN = 2,          // the code more readable.
    BLUE = 3,           // These numbers code for
    CYAN = 4,           // the different drawing colors.
    MAGENTA = 5,
    YELLOW = 6,
    WHITE = 7;

private final static int
   CURVE = 0,
   LINE = 1,
   RECT = 2,               // Some constants that code
   OVAL = 3,               // for the different types of
   ROUNDRECT = 4,          // figure the program can draw.
   FILLED_RECT = 5,
   FILLED_OVAL = 6,
   FILLED_ROUNDRECT = 7;


/* Some variables used for backing up the contents of the panel. */

Image undoBuffer, OSI;  // The off-screen image (created in checkOSI()).



int widthOfOSI, heightOfOSI;  // Current width and height of OSI.  These
                      // are checked against the size of the applet,
                      // to detect any change in the panel's size.
                      // If the size has changed, a new OSI is created.
                      // The picture in the off-screen image is lost
                      // when that happens.


/* The following variables are used when the user is sketching a
curve while dragging a mouse. */

private int mouseX, mouseY;   // The location of the mouse.

private int prevX, prevY;     // The previous location of the mouse.

private int startX, startY;   // The starting position of the mouse.
                      // (Not used for drawing curves.)

private boolean dragging;     // This is set to true when the user is drawing.

private int figure;    // What type of figure is being drawn.  This is
               //    specified by the figureChoice menu.
               
private Graphics dragGraphics;  // A graphics context for the off-screen image,
                        // to be used while a drag is in progress.

private Color dragColor;  // The color that is used for the figure that is
                  // being drawn.

Display() {
// Constructor.  When this component is first created, it is set to
// listen for mouse events and mouse motion events from
// itself.  The initial background color is white.
addMouseListener(this);
addMouseMotionListener(this);
setBackground(Color.white);
}

public int getColorIndex(){
	if (black.isSelected()){
		return BLACK;
	}
	else if (red.isSelected()){
		return RED;
	}
	else if (green.isSelected()){
		return GREEN;
	}
	else if (blue.isSelected()){
		return BLUE;
	}
	else if (cyan.isSelected()){
		return CYAN;
	}
	else if (magenta.isSelected()){
		return MAGENTA;
	}
	else if (yellow.isSelected()){
		return YELLOW;
	}
	else 
		return WHITE;
	}
public int getShapeIndex(){
	if (curve.isSelected()){
		return CURVE;
	}
	if (straightLine.isSelected()){
		return LINE;
	}
	if (rectangle.isSelected()){
		return RECT;
	}
	if (oval.isSelected()){
		return OVAL;
	}
	if (roundRect.isSelected()){
		return ROUNDRECT;
	}
	if (curve.isSelected()){
		return CURVE;
	}
	if (filledRectangle.isSelected()){
		return FILLED_RECT;
	}
	if (filledOval.isSelected()){
		return FILLED_OVAL;
	}
	else 
		return FILLED_ROUNDRECT;
	
}

private void drawFigure(Graphics g, int shape, int x1, int y1, int x2, int y2) {
// This method is called to do ALL drawing in this applet!
// Draws a shape in the graphics context g.
// The shape paramter tells what kind of shape to draw.  This
// can be LINE, RECT, OVAL, ROUNTRECT, FILLED_RECT,
// FILLED_OVAL, or FILLED_ROUNDRECT.  (Note that a CURVE is
// drawn by drawing multiple LINES, so the shape parameter is
// never equal to CURVE.)  For a LINE, a line is drawn from
// the point (x1,y1) to (x2,y2).  For other shapes,  the
// points (x1,y1) and (x2,y2) give two corners of the shape
// (or of a rectangle that contains the shape).
if (shape == LINE) {
 // For a line, just draw the line between the two points.
g.drawLine(x1,y1,x2,y2);
return;
}
int x, y;  // Top left corner of rectangle that contains the figure.
int w, h;  // Width and height of rectangle that contains the figure.
if (x1 >= x2) {  // x2 is left edge
x = x2;
w = x1 - x2;
}
else {          // x1 is left edge
x = x1;
w = x2 - x1;
}
if (y1 >= y2) {  // y2 is top edge
y = y2;
h = y1 - y2;
}
else {          // y1 is top edge.
y = y1;
h = y2 - y1;
}
switch (shape) {   // Draw the appropriate figure.
case RECT:
 g.drawRect(x, y, w, h);
 break;
case OVAL:
 g.drawOval(x, y, w, h);
 break;
case ROUNDRECT:
 g.drawRoundRect(x, y, w, h, 20, 20);
 break;
case FILLED_RECT:
 g.fillRect(x, y, w, h);
 break;
case FILLED_OVAL:
 g.fillOval(x, y, w, h);
 break;
case FILLED_ROUNDRECT:
 g.fillRoundRect(x, y, w, h, 20, 20);
 break;
}
}


private void repaintRect(int x1, int y1, int x2, int y2) {
// Call repaint on a rectangle that contains the points (x1,y1)
// and (x2,y2).  (Add a 1-pixel border along right and bottom 
// edges to allow for the pen overhang when drawing a line.)
int x, y;  // top left corner of rectangle that contains the figure
int w, h;  // width and height of rectangle that contains the figure
if (x2 >= x1) {  // x1 is left edge
x = x1;
w = x2 - x1;
}
else {          // x2 is left edge
x = x2;
w = x1 - x2;
}
if (y2 >= y1) {  // y1 is top edge
y = y1;
h = y2 - y1;
}
else {          // y2 is top edge.
y = y2;
h = y1 - y2;
}
repaint(x,y,w+1,h+1);
}


private void checkOSI() {
// This method is responsible for creating the off-screen image. 
// It should be called before using the OSI.  It will make a new OSI if
// the size of the panel changes.
if (OSI == null || widthOfOSI != getSize().width || heightOfOSI != getSize().height) {
  // Create the OSI, or make a new one if panel size has changed.
OSI = null;  // (If OSI already exists, this frees up the memory.)
undoBuffer=null;
OSI = createImage(getSize().width, getSize().height);
undoBuffer = createImage(getSize().width, getSize().height);
widthOfOSI = getSize().width;
heightOfOSI = getSize().height;

Graphics OSG = OSI.getGraphics();  // Graphics context for drawing to OSI.
OSG.setColor(getBackground());
OSG.fillRect(0, 0, widthOfOSI, heightOfOSI);
OSG.dispose();
undoBuffer = createImage(widthOfOSI,heightOfOSI);
OSG = undoBuffer.getGraphics();  // Graphics context for drawing to undoBuffer
OSG.setColor(getBackground());
OSG.fillRect(0, 0, widthOfOSI, heightOfOSI);
OSG.dispose();


	}
}


public void paintComponent(Graphics g) {
// Copy the off-screen image to the screen,
// after checking to make sure it exists.  Then,
// if a shape other than CURVE is being drawn, 
// draw it on top of the image from the OSI.
checkOSI();
g.drawImage(OSI, 0, 0, this);
if (dragging && figure != CURVE) {
g.setColor(dragColor);
drawFigure(g,figure,startX,startY,mouseX,mouseY);
	}
}

public void actionPerformed(ActionEvent evt) {
// Respond when the user clicks on a button.  The
// command must be either "Clear" or "Set Background".
String command = evt.getActionCommand();
checkOSI();
if (command.equals("Set Background")) {
  // Set background color before clearing.
  // Change the selected color so it is different
  // from the background color.
setBackground(getCurrentColor());
if (getColorIndex() == BLACK)
 white.setSelected(true);
else
 black.setSelected(true);
}

	

if (command.equals("Undo")){
	Image temp = OSI;
    OSI = undoBuffer;
    undoBuffer = temp;
    repaint();
}

if (command.equals("Clear")){
	Graphics g = OSI.getGraphics();
	g.setColor(getBackground());
	g.fillRect(0,0,getSize().width,getSize().height);
	g.dispose();
	repaint();
}


}


private Color getCurrentColor() {
 // Check the colorChoice menu to find the currently
 // selected color, and return the appropriate color
 // object.
int currentColor = getColorIndex();
switch (currentColor) {
case BLACK:
 return Color.black;
case RED:
 return Color.red;
case GREEN:
 return Color.green;
case BLUE:
 return Color.blue;
case CYAN:
 return Color.cyan;
case MAGENTA:
 return Color.magenta;
case YELLOW:
 return Color.yellow;
default:
 return Color.white;
}
}


public void mousePressed(MouseEvent evt) {
// This is called when the user presses the mouse on the
// panel.  This begins a draw operation in which the user
// sketches a curve or draws a shape.  (Note that curves
// are handled differently from other shapes.  For CURVE,
// a new segment of the curve is drawn each time the user
// moves the mouse.  For the other shapes, a "rubber band
// cursor" is used.  That is, the figure is drawn between
// the starting point and the current mouse location.)

if (dragging == true)  // Ignore mouse presses that occur
return;            //    when user is already drawing a curve.
                  //    (This can happen if the user presses
                  //    two mouse buttons at the same time.)

prevX = startX = evt.getX();  // Save mouse coordinates.
prevY = startY = evt.getY();

figure = getShapeIndex();
dragColor = getCurrentColor();      
checkOSI();

Graphics undoGraphics = undoBuffer.getGraphics();
undoGraphics.drawImage(OSI,0,0,null);  // Remember the current image,
                                       // for "Undo" operations,
                                       // before changing the image.
undoGraphics.dispose();   

dragGraphics = OSI.getGraphics();
dragGraphics.setColor(dragColor);


dragging = true;  // Start drawing.

} // end mousePressed()


public void mouseReleased(MouseEvent evt) {
// Called whenever the user releases the mouse button.
// If the user was drawing a shape, we make the shape
// permanent by drawing it to the off-screen image.
if (dragging == false)
return;  // Nothing to do because the user isn't drawing.
dragging = false;
mouseX = evt.getX();
mouseY = evt.getY();
if (figure == CURVE) {
   // A CURVE is drawn as a series of LINEs
drawFigure(dragGraphics,LINE,prevX,prevY,mouseX,mouseY);
repaintRect(prevX,prevY,mouseX,mouseY);
}
else if (figure == LINE) {
repaintRect(startX,startY,prevX,prevY);
if (mouseX != startX || mouseY != startY) {
     // Draw the line only if it has non-zero length.
  drawFigure(dragGraphics,figure,startX,startY,mouseX,mouseY);
  repaintRect(startX,startY,mouseX,mouseY);
}
}
else {
repaintRect(startX,startY,prevX,prevY);
if (mouseX != startX && mouseY != startY) {
     // Draw the shape only if both its height
     // and width are both non-zero.
  drawFigure(dragGraphics,figure,startX,startY,mouseX,mouseY);
  repaintRect(startX,startY,mouseX,mouseY);
}
}
dragGraphics.dispose();
dragGraphics = null;
}


public void mouseDragged(MouseEvent evt) {
 // Called whenever the user moves the mouse while a mouse button
 // is down.  If the user is drawing a curve, draw a segment of
 // the curve on the off-screen image, and repaint the part
 // of the panel that contains the new line segment.  Otherwise,
 // just call repaint and let paintComponent() draw the shape on
 // top of the picture in the off-screen image.

if (dragging == false)
return;  // Nothing to do because the user isn't drawing.

mouseX = evt.getX();   // x-coordinate of mouse.
mouseY = evt.getY();   // y=coordinate of mouse.

if (figure == CURVE) { 
   // A CURVE is drawn as a series of LINEs.
drawFigure(dragGraphics,LINE,prevX,prevY,mouseX,mouseY);
repaintRect(prevX,prevY,mouseX,mouseY);
}
else {
  // Repaint two rectangles:  The one that contains the previous
  // version of the figure, and the one that will contain the
  // new version.  The first repaint is necessary to restore
  // the picture from the off-screen image in that rectangle.
repaintRect(startX,startY,prevX,prevY);
repaintRect(startX,startY,mouseX,mouseY);
}

prevX = mouseX;  // Save coords for the next call to mouseDragged or mouseReleased.
prevY = mouseY;

} // end mouseDragged.


public void mouseEntered(MouseEvent evt) { }   // Some empty routines.
public void mouseExited(MouseEvent evt) { }    //    (Required by the MouseListener
public void mouseClicked(MouseEvent evt) { }   //    and MouseMotionListener
public void mouseMoved(MouseEvent evt) { }     //    interfaces).


} // end nested class Display


} // end class SimplePaint3