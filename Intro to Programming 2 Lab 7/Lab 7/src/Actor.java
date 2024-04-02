import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;

class Kart extends Actor {
    // declare the class properties here:
    String name;
    int raceRank;
    int speed;
    int maxSpeed;
    int acceleration;
    int da;
    int lapNum;
    int maxLaps;
    private int currentTime;
    private int[] lapTimes;
    int coins;
    int lives;
    // 1.1 & 1.2 Declare the two boolean variables here:
    boolean gasOn;
    boolean breakOn;
    
    public Kart(String i, double x, double y, String n, int a,int m, int r) {
        super(i, x, y); // calls the Actor constructor
        name = n;
        acceleration = a;
        raceRank = r;
        coins = 5;
        lives = 3;
        speed = 0;
        da = 0;
        maxSpeed = m;
        lapNum = 1; 
        maxLaps = 5; 
        currentTime = 0;
        // 1.1 & 1.2 Initialize the two boolean variable here:
        gasOn = false;
        breakOn = false;

        lapTimes = new int[maxLaps];
    }
    // Write your class functions here:
    void increaseSpeed()
    {
        speed += acceleration;
        if (speed > maxSpeed)
            speed = maxSpeed;
    }
    
    void decreaseSpeed()
    {
        speed -= 3;
        if (speed < 0)
            speed = 0;
    }
    
    void increaseLap()
    {
        if (lapNum > maxLaps)
        {
            System.out.println("Cannot increase lap - already at max number of laps!");
        }
        else
        {
            lapTimes[lapNum - 1] = currentTime;
            currentTime = 0;
            lapNum += 1;
        }
    }
    
    void incTime()
    {
        currentTime += 1;
    }
    
    int getCurrentTime()
    {
        return currentTime;
    }
    
    int getIthTime(int i)
    {
        if (i >=0 && i < maxLaps )
            return lapTimes[i];
        else
            return -1;
    }
    
    int getBestTime()
    {
        int min = lapTimes[0];
        for (int i =0; i < lapNum; i++ )
        {
            if (min > lapTimes[i])
                min = lapTimes[i];
        }
        return min;
    }
    
    int getWorstTime()
    {
        int max = lapTimes[0];
        for (int i =0; i < lapNum; i++ )
        {
            if (max < lapTimes[i])
                max = lapTimes[i];
        }
        return max;
    }
}
/*****************************************************************************
    // This part should not be modified
    * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
  
public class Actor {
	public double x;
	public double y;
        public int width;
	public int height;
        public int angle;
        private String image;
        private Image i;


	public Actor(String img) {
            changeImage(img); 
            angle = 0;
	}
        
        public Actor(String img, double a, double b) {
            x = a;
            y = b;
            angle = 0;
            changeImage(img); 
	}
        
        public String getImage(){
            return image;
        }
                
        public void changeImage(String img) {
            image = img;
            String separator = System.getProperty("file.separator");
            i = new ImageIcon("images" + separator + image + ".png").getImage();
            width = i.getWidth(null);
            height = i.getHeight(null);
	}

	public void draw(Graphics2D g) {
            if (angle!=0)
                g.rotate(Math.toRadians(-angle),x - i.getWidth(null)/2, y - i.getHeight(null)/2);
                
            g.drawImage(i, (int)x, (int) y, null);
	}
}