import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends Actor
{
    protected GreenfootImage background = null; 
    
    int lives = 3;
    
    public void StatusBoard() {
        background = new GreenfootImage (50, 20); // creates a background image
        background.setColor(Color.YELLOW); // sets it to yellow
        background.fillRect (0, 0, 50, 20); // creates a rectangle where the coords are in reference to the background image
        setImage(background); // set this image to the background
    }
    
    public void setLives(int lifeChange) {
        lives -= lifeChange;
        GreenfootImage img = new GreenfootImage(background); /// create new thing on background
        img.setColor(Color.BLACK); // make it black
        img.drawString("Lives: " + lives, 5, 15); // create this string
        setImage(img); // set this image onto the background
    }
    
    public void act()
    {
        setLocation(55, 30);
        StatusBoard();
        int lifeChange = 0;
        setLives(lifeChange);
    }  
}
