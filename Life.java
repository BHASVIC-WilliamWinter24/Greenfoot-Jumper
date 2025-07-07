import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    public void act()
    {
        Actor platform = getOneIntersectingObject(PlatformWall.class);
        if (platform != null) {
            setLocation(Greenfoot.getRandomNumber(900)+10, Greenfoot.getRandomNumber(900)+10);
        }
    }
}
