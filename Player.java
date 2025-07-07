import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player: play the player frfr on god
 * Gem apple Will
 * Version 1!
 */
public class Player extends Actor
{
    
    int delay = 0, movingUp = 0, movingDown = 0, spawnDelay = 0, doubleJumpDelay, lives = 3, lifeDelay = 0;
    boolean doubleJump, firstFalling, lifeInWorld = false;
    
    public void act()
    {
        if ((getOneObjectAtOffset(0, 13, PlatformWall.class) == null) && (movingUp == 0)) { // if platform is not below and it is not moving up, begin moving down (fall)
            movingDown = 10;
            delay = 10;
            if (firstFalling == true) { // if this is the first act in which the object is falling
                firstFalling = false; // no longer the first time in which it is falling
                doubleJump = true; // can double jump
            }
        }
        if (getOneObjectAtOffset(0, 13, PlatformWall.class) != null) { // if on top of a platform
            firstFalling = true; // it sets firstFalling to true, so that when it falls without jumping it can be called in the first Act in which it falls
            doubleJumpDelay = 10; // sets a delay so that the player cannot immediately double jump (then triple) when jumping from platform
        }
        if (delay > 0) {
            delay -= 1;
            if (movingUp > 0) { // if moving up
                movingDown = 0; // not moving down
                setRotation(270); // set rotation to up
                if (movingUp > 40) {
                    move(5);
                }
                else if (movingUp > 30) {
                    move(4);
                }
                else if (movingUp > 20) {
                    move(3);
                }
                else if (movingUp > 10) {
                    move(2);
                }
                else if (movingUp > 0) {
                    move(1);
                }
                movingUp -= 1; // reduce to increment speed of upwards moving
                if (movingUp == 0) { // if no longer moving up
                    movingDown = 50; // begin moving down
                }
            }
            if (movingDown > 0) {
                setRotation(90); // set rotation to down
                if ((getOneObjectAtOffset(0, 13, PlatformWall.class) != null)) { // if impacts a platform below, stop moving down
                    movingDown = 0;
                }
                if (movingDown > 40) {
                    move(1);
                }
                else if (movingDown > 30) {
                    move(2);
                }
                else if (movingDown > 20) {
                    move(3);
                }
                else if (movingDown > 10) {
                    move(4);
                }
                else if (movingDown > 0) {
                    move(5);
                }
                movingDown -= 1; // reduce to increment speed of downwards moving
                if (movingDown == 0) { // if no longer moving down
                    if (getOneObjectAtOffset(0, 13, PlatformWall.class) == null) { // if no platform below, continue moving down at max velocity
                        movingDown = 10;
                        delay = 0;
                    }
                    else {
                        delay = 0;
                    }
                }
            }
        }
        else {
            if (Greenfoot.isKeyDown("up")) { // if up key pressed
                delay = 100; // stop form jumping mid-jump
                doubleJump = true; // allow double-jump
                doubleJumpDelay = 30; // stop from insta-doublejumping
                movingUp = 50; // start moving up
            }
        }
        if (Greenfoot.isKeyDown("left")) { // if left key pressed
            if (getOneObjectAtOffset(-13, 0, PlatformWall.class) == null) { // if there is not a wall to the left, move
                setRotation(180);
                move(3);
            }
        }
        if (Greenfoot.isKeyDown("right")) { // if right key pressed
            if (getOneObjectAtOffset(13, 0, PlatformWall.class) == null) { // if there is not a wall to the right, move
                setRotation(0);
                move(3);
            }
        }
        if (getY() >= getWorld().getHeight()-10) { // if out the bottom of the world
            setLocation(25, 840); // return to start
            lives -= 1;
            TheWorld world = (TheWorld) getWorld();
            Board livesBoard = world.getTheLivesBoard();
            livesBoard.setLives(1);
            if (lives <= 0) {
                Greenfoot.stop();
            }
        }
        doubleJumpDelay -= 1;
        if ((movingUp > 0 || movingDown > 0) && Greenfoot.isKeyDown("up") && doubleJump == true && doubleJumpDelay <= 0) { 
            // if (moving up or moving down) and up is pressed and can double jump and delay has run out
            movingDown = 0; // stop moving down
            movingUp = 50; // start moving up
            delay = 150; // add delay so cannot normal jump
            doubleJump = false; // cannot double jump
        }
        
        if (lifeDelay <= 0 && lifeInWorld == false) { // if heart spawn delay is up and there's not already another
            lifeDelay = Greenfoot.getRandomNumber(10) * 1000; // reset delay
            World world = getWorld();
            Life life = new Life();
            int lifeX = Greenfoot.getRandomNumber(900) + 50; // get random X
            int lifeY = Greenfoot.getRandomNumber(900) + 50; // get random Y
            world.addObject(life, lifeX, lifeY); // add new life at random position
            lifeInWorld = true; // now life in world
        }
        
        if (lifeDelay > 0) {
            lifeDelay -= 1;
        }
        Actor life = getOneIntersectingObject(Life.class); // if touching life
        if (life != null) {
            TheWorld world = (TheWorld) getWorld(); // get world
            world.removeObject(life); // remove life
            lifeInWorld = false; // no life in world
            Board livesBoard = world.getTheLivesBoard(); // access the lives board
            lives += 1; // add one life
            livesBoard.setLives(-1); // show that on board
            lifeDelay = Greenfoot.getRandomNumber(10) * 1000; // set respawn delay
        }
    }
}

