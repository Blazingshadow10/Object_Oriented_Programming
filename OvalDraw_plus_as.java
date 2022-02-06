/* Austin Schaibley
*  OvalDraw_Plus
*  Object-Oriented Programming
*  Spring 2022
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container; 
import java.awt.Color;
import java.util.Random;

// Decides the color of the shapes
class shapeColor extends JPanel {

    private Color ovalColor;
    private Color rectColor = new Color(25,25,112);

    public void setColorOval(int red, int green, int blue) {
        ovalColor = new Color(red, green, blue);
    }
    
    // Random picks the color
    shapeColor() {
        int r = 0,g = 0,b = 0;
        Random rand = new Random();
        int randomColors = rand.nextInt(3);

        // 
        if (randomColors == 0) 
        {
            r = 0;
            g = 255;
            b = 0;
        } 
        else if (randomColors == 1)
        {
            r = 255;
            g = 0;
            b = 0;
        }
        else if (randomColors == 2)
        {
            r = 0;
            g = 0;
            b = 0;
        }
        setColorOval(r, g, b);
    }

    // Drawing the shapes to there sizes
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int shapeWidth = getWidth();
        int shapeHeight = getHeight();

        g.setColor(rectColor);
        g.fillRect(20, 20, shapeWidth-40, shapeHeight-40);
        g.setColor(ovalColor);
        g.fillOval(0, 0, shapeWidth, shapeHeight);
    }
}

// Draws the window and the shapes within
class DrawShapes extends JFrame {
    DrawShapes() {
        setTitle("Oval Draw Plus");
        setBounds(250,150,500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Closing OvalDrawPlus...");
                System.exit(0);
            }
        });

        shapeColor shapes = new shapeColor();

        Container contentPane = getContentPane();

        contentPane.add(shapes); 
    }
}

public class OvalDraw_plus_as {
    public static void main(String[] args) throws Exception {
        System.out.println("OvalDrawPlus Starting...");
        DrawShapes shapes = new DrawShapes();
        shapes.setVisible(true);
    }
}
