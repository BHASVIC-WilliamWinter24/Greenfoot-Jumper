import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheWorld extends World
{
    private Board theLivesBoard;
    
    public TheWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 1000, 1); 
        prepare();
    }
    
    public Board getTheLivesBoard() {
        return theLivesBoard;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,25,850);
        PlatformWall platformWall = new PlatformWall();
        addObject(platformWall,9,909);
        platformWall.setLocation(22,906);
        PlatformWall platformWall2 = new PlatformWall();
        addObject(platformWall2,22,906);
        PlatformWall platformWall3 = new PlatformWall();
        addObject(platformWall3,331,787);
        PlatformWall platformWall4 = new PlatformWall();
        addObject(platformWall4,612,876);
        PlatformWall platformWall5 = new PlatformWall();
        addObject(platformWall5,860,656);
        PlatformWall platformWall6 = new PlatformWall();
        addObject(platformWall6,855,472);
        PlatformWall platformWall7 = new PlatformWall();
        addObject(platformWall7,387,469);
        PlatformWall platformWall8 = new PlatformWall();
        addObject(platformWall8,149,316);
        PlatformWall platformWall9 = new PlatformWall();
        addObject(platformWall9,629,228);
        theLivesBoard = new Board();
        addObject(theLivesBoard,138,108);
    }
}
