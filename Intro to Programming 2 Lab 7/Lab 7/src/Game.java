import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * Please enter your information.
 * Name: Patrick Mull
 * CWID#: 50305380
 */
public class Game extends JPanel implements KeyListener{
    public int WIDTH;
    public int HEIGHT;
    boolean startScreen;
    // 1.3  kart should be of type Kart
    Kart kart;
    Actor track;
    // 3.1 Declare finishLine
    Actor finishLine;
    
    public void init() {
        WIDTH = 640;
        HEIGHT = 640;
        startScreen = true;
        // 1.4 the kart object should be an instance of the Kart class
        kart = new Kart("mario", 0.4*WIDTH, 0.9*HEIGHT, "Mario", 1, 30, 3);
        
        track = new Actor("track", -3.9*WIDTH, -2.05 * HEIGHT);
        
        // 3.2 Initialize finishLine
        finishLine = new Actor("finish", 205, 345);
    }	
  
    public void draw(Graphics2D screen) {
        screen.setColor(Color.BLACK);
        screen.setFont(new Font("Verdana", Font.BOLD, 30));
        if (startScreen)
        {
            blit(screen,"background1", 0,0);
            blit(screen,"background2", 0.1*WIDTH, 0.2*HEIGHT);
            screen.drawString("Press Enter", (int)(0.38*WIDTH), (int)(0.73*HEIGHT));  
        }
        else
        {
           track.draw(screen);
           // 3.3 Draw finishLine
           finishLine.draw(screen);
           kart.draw(screen); 
        }
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (startScreen)
        {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
                startScreen = false;
        }
        else
        {
            if (e.getKeyCode() == KeyEvent.VK_UP)
                kart.gasOn = true;
            else if (e.getKeyCode() == KeyEvent.VK_DOWN)
                kart.breakOn = true;
            // 2.1 modify da when up or down is pressed
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                kart.changeImage("marior");
                kart.da = -1;
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                kart.changeImage("mariol");
                kart.da = 1;
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP)
            kart.gasOn = false;
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
            kart.breakOn = false;
        // 2.2 return da to 0 when up or down is released
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            kart.changeImage("mario");
            kart.da = 0;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            kart.changeImage("mario");
            kart.da = 0;
        }
    }
    
    void move_forward(int angle, double speed)
    {
        double rAngle = Math.toRadians(angle);
        speed /= 100;
        double dy = -speed * Math.cos(rAngle);
        double dx = -speed * Math.sin(rAngle);
        
        // 2.6 update the kart's position
        kart.x += dx;
        kart.y += dy;
        
        // 2.7 update the track's position
        track.x -= dx*20;
        track.y -= dy*20;
        // 3.4 update the track's position
        finishLine.x -= dx*20;
        finishLine.y -= dy*20;
    }
    
    public void update()
    {
        // 2.3 update the kart's angle
        kart.angle += kart.da;
        
        // 2.4 Handle the change in the kart's speed
        if (kart.gasOn) {
        	kart.increaseSpeed();
        }
        
        if (kart.breakOn) {
        	kart.decreaseSpeed();
        }
        
        // 2.5 call the move_forward function 
        move_forward(kart.angle,kart.speed);
        
    }  
 /*****************************************************************************
    // This part should not be modified
    * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    
    public Game() 
    {
        setBackground(Color.black);
        setSize(WIDTH, HEIGHT);
        addKeyListener(this);
        setFocusable(true);
        init();
    }
    
        public void blit(Graphics g, String img, double x, double y) {
            String separator = System.getProperty("file.separator");
            Image i = new ImageIcon("images" + separator + img + ".png").getImage();
            g.drawImage(i, (int)x, (int)y, null);
    }

    @Override   
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        draw(g2d);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    /*************************************************************************/
}