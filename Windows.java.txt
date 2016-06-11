import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Windows extends JFrame implements ActionListener{
 
 JPanel pan1 = new JPanel();
 JPanel pan2 = new JPanel();

 JButton startButton = new JButton("START");
 JTextField nameField = new JTextField(" ", 20);
 JLabel nameLabel = new JLabel("Please Enter Name:", JLabel.RIGHT);
 JLabel title = new JLabel("P A C M A N");

 // txt.setFont(title);
 // txt.setForeground(Color.BLUE);

 JLabel instructionTitle = new JLabel("Instructions");
 JLabel instruction1 = new JLabel("1. Use the arrow keys to move PacMan around the maze.");
 JLabel instruction2 = new JLabel("2. Complete each level by eating all the dots.");
 JLabel instruction3 = new JLabel("3. Avoid monsters! If they catch you, you will lose a life.");

 JFrame maze = new JFrame();

 JFrame endWindow = new JFrame();
 JLabel endTitle = new JLabel("Y O U   L O S E!");
 JButton resetButton = new JButton("PLAY AGAIN?");
 JLabel score = new JLabel("SCORE:", JLabel.RIGHT);

 int[][] mazeOrig = { 
   { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
   { 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
   { 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 2, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
   { 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
   { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0 }, 
   { 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 1 }, 
   { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
 
 // *****************************************starting window****************************************************
 public Windows() {
  setTitle("Menu"); // Create a window with a title
  setSize(800, 700); // set the window size

  // Create some Layouts
  GridLayout layout1 = new GridLayout(2, 1);
  FlowLayout layout2 = new FlowLayout();

  // Set the frame and both panel layouts
  setLayout(layout1);
  pan1.setLayout(layout2);
  pan1.setLayout(layout2);

  startButton.addActionListener(this); // Add an action listener to the button
            // this allows the program to know if
            // the button was pressed

  // Add all the components to the panels
  pan1.add(title);
  title.setFont(new Font("Serif", Font.PLAIN, 110));

  pan1.add(instructionTitle);
  instructionTitle.setFont(new Font("Serif", Font.PLAIN, 48));

  pan1.add(instruction1);
  instruction1.setFont(new Font("Serif", Font.PLAIN, 25));

  pan1.add(instruction2);
  instruction2.setFont(new Font("Serif", Font.PLAIN, 25));

  pan1.add(instruction3);
  instruction3.setFont(new Font("Serif", Font.PLAIN, 25));

  pan2.add(nameLabel);
  nameLabel.setFont(new Font("Serif", Font.PLAIN, 15));

  pan2.add(nameField);

  pan2.add(startButton);

  // add the panels to the frame and display the window
  add(pan1);
  add(pan2);
  setVisible(true);

  // **************************************maze window**********************************************
class movePacman 
{
  public JFrame game;
  public JPanel panel;
  public int pacmanX = 200; //initialize PacMan's x-initial position
  public int pacmanY = 200; //initialize PacMan's y-initial position
  public boolean up = false,down= false,left= false,right = false; //initialize the status of the movements to false
  
  class GamePanel extends JPanel
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
  
  class movementKey implements KeyListener
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
    
    public void pacmanMove()
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
    
    public void animate()
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
    
    public void main(String[] args)
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
      animate();//call the animate metho
    }//end of main program
}//end of class
  
  maze.setSize(1500, 1000);
  maze.setResizable(true);
  maze.setTitle("Maze"); // sets the title
  

  final int boxWidth = (int) Math.floor((double) maze.getWidth() / (mazeOrig.length));
  final int boxHeight = (int) Math.floor((double) maze.getHeight() / (mazeOrig[0].length));

  System.out.println(mazeOrig.length + ", " + maze.getWidth() + " = BoxWidth " + boxWidth);
  System.out.println(mazeOrig[0].length + ", " + maze.getHeight() + " = BoxHeight " + boxHeight);

  maze.add(new JPanel(){
   @Override
   public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < mazeOrig.length; i++) {
     for (int j = 0; j < mazeOrig[i].length; j++) {
      switch (mazeOrig[i][j]) {
      case 0:
       g.setColor(Color.WHITE);
       g.fillRect(i * boxWidth, j * boxHeight, boxWidth,  boxHeight);
       //g.setColor(Color.BLACK);
       //g.drawRect(i * boxWidth, j * boxHeight, boxWidth, boxHeight);
      
       //imports the images of monsters and displays them in the maze
       Image monster1 = new ImageIcon("monster1.png").getImage();
       g.drawImage(monster1,0,0,null);
       Image monster2 = new ImageIcon("monster2.png").getImage();
       g.drawImage(monster2,0,0,null);
       Image monster3 = new ImageIcon("monster3.png").getImage();
       g.drawImage(monster3,0,0,null);
       Image monster4 = new ImageIcon("monster4.png").getImage();
       g.drawImage(monster4,0,0,null);
       repaint();
    
       break;
      case 1:
       g.setColor(Color.BLACK);
       g.fillRect(i * boxWidth, j * boxHeight, boxWidth, boxHeight);
       //g.setColor(Color.BLACK);
       //g.drawRect(i * boxWidth, j * boxHeight, boxWidth, boxHeight);
       break;
      case 2:
       g.setColor(Color.YELLOW);
       g.fillRect(i * boxWidth, j * boxHeight, boxWidth, boxHeight);
       //g.setColor(Color.BLACK);
      // g.drawRect(i * boxWidth, j * boxHeight, boxWidth, boxHeight);
       System.out.println("2: " + i + ", " + j);
       break;
      }
     }
    }
   }
  });
  maze.setVisible(false);

  // ************************************reset window********************************************
  endWindow.setSize(800, 700);
  endWindow.setTitle("Reset Menu"); // sets the title
  FlowLayout flow2 = new FlowLayout(); // constructor to organize how components are added to the frame
  endWindow.setLayout(flow2); // flow layout... components added across each row, then added down the console

  endWindow.add(endTitle);
  endTitle.setFont(new Font("Serif", Font.PLAIN, 100));

  endWindow.add(score);
  score.setFont(new Font("Serif", Font.PLAIN, 50));

  endWindow.add(resetButton); // add the component object, button to the frame
  endWindow.setVisible(false);
 }

 // ACTION LISTENER - This method runs when an event occurs; code in here only runs when a user interactes with a
 // component that has an action listener attached to it

 public void actionPerformed(ActionEvent event) {

  String command = event.getActionCommand(); // find out the name of the component
             // that was used

  if (command.equals("START")) { // if the start button was pressed
   System.out.println("button pressed"); // display message in console(for testing)
   System.out.println("name:" + nameField.getText()); // get the info located in the field component
   setVisible(false);
   maze.setVisible(true);
   maze.requestFocusInWindow();
  } // no other conditions

 }

 public static int randomMonsters(int monster_x, int monster_y, int lengthGridX, int lengthGridY) {

  int direction;

  direction = (int) ((Math.random() * 4) + 1);
  return direction;

 }

 // Main method
 public static void main(String[] args) {
  Windows frame1 = new Windows(); // Start the GUI

  
 }// end of main

} // end of class