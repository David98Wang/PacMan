import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class movePacman 
{
  public static JFrame game;
  public static JPanel panel;
  public static int pacmanX = 200; //initialize PacMan's x-initial position
  public static int pacmanY = 200; //initialize PacMan's y-initial position
  public static boolean up = false,down= false,left= false,right = false; //initialize the status of the movements to false
  
  public static class GamePanel extends JPanel
  {
    /**
     * This method import the image of PacMan and displays it on the console window
     * @param:
     * @return: returns an image of PacMan
     */
    public void paintComponent(Graphics g)
    {
      Image pacman = new ImageIcon("pacman.png").getImage();
      pacmanMove();
      g.drawImage(pacman,pacmanX,pacmanY,40,40, null);
    }
  }
  
  public static class movementKey implements KeyListener
  {
    public void keyPressed(KeyEvent e)
    {
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_UP)//when the "up" cursor key is pressed
      {
        up = true; //set the status of the upward movement to true
      }
      else if (key == KeyEvent.VK_DOWN)//when the "down" cursor key is pressed
      {
        down = true; //set the status of the down movement to true
      }
      if (key == KeyEvent.VK_LEFT)//when the "left" cursor key is pressed
      {
        left = true; //set the status of the left movement to true
      }
      else if (key == KeyEvent.VK_RIGHT)//when the "right" cursor key is pressed
      {
        right = true; //set the status of the right movement to true
      }
    }
    
    public void keyReleased(KeyEvent e)
    {
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_UP)//when the "up" cursor key is released
      {
        up = false;//set the status of the up movement to false
      }
      else if (key == KeyEvent.VK_DOWN)//when the "down" cursor key is released
      {
        down = false; //set the status of the down movement to false
      }
      if (key == KeyEvent.VK_LEFT)//when the "left" cursor key is released
      {
        left = false; //set the status of the left movement to false
      }
      else if (key == KeyEvent.VK_RIGHT)//when the "right" cursor key is released
      {
        right = false; //set the status of the right movement to false
      }
    }

      public void keyTyped(KeyEvent e)
      {
      }
    }
    
    public static void pacmanMove()
    {
     //while the "up" key is pressed, PacMan's vertical position increases by 1
     if(up)
     {
      pacmanY --;
     }
     //while the "down" key is pressed, PacMan's vertical position decreases by 1
     if(down)
     {
      pacmanY ++;
     }
     //while the "left" key is pressed, PacMan's horizontal position decreases by 1
     if(left)
     {
      pacmanX --;
     }
     //while the "right" key is pressed, PacMan's horizontal position increases by 1
     if(right)
     {
       pacmanX ++;
     }
    }
    
    public static void animate()
    {
      while (true)
      {
        try
        {
          Thread.sleep(2);
          panel.requestFocusInWindow();
        }
        catch (Exception exc)
        {
        }
        game.repaint();
      }
    }
    
    public static void main(String[] args)
    {
      game = new JFrame();//make a console window called game
      game.setSize(1400, 1000);//set the size of the window
      panel = new GamePanel();//make a new panel
      KeyListener pacmanListener = new movementKey();
      panel.addKeyListener(pacmanListener);//implement the key listener
      game.add(panel);//add panel to the frame
      game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//allows users to exit the window when they hit the "close" icon
      game.setVisible(true);
      game.setResizable(true);
      panel.requestFocusInWindow();
      animate();//call the animate method
    }//end of main program
}//end of class