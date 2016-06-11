/**
 * Created By: Peter Wu, Amanda Oprisan, Georgina Chen
 * Created on: 5/16/2016
 * 
 */

public class PacMan {
   
  
   public static void main(String args[]){
    
    boolean freezingMonster = false;
    
    int[][] statusOfGridOrig = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,2,0,0,0,1,1,1,1,0,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1},
                            {1,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
                            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0},
                            {1,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
   
    int[][] statusOfGrid = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                            {0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,2,0,0,0,1,1,1,1,0,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1},
                            {1,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1},
                            {0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,1,0,1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,0},
                            {1,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,1,1,1,1},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};  
        
    int pacMan_xReset = 3;
    int pacMan_yReset = 1;
    int pacMan_x = 3;
    int pacMan_y = 1;
    int speedOfMonster = 1;
    int speedOfPacMan = 3;
    int points = 0;
    
    int lengthGridX = statusOfGrid.length - 1;
    int lengthGridY = statusOfGrid[1].length - 1; 
  
     
    int[][] monsterReset = {{1,1},{lengthGridX-2,lengthGridY},{1,2}};
    int[][] monster = {{1,1},{lengthGridX-2,lengthGridY},{1,2}}; 
    
    int food = 0;
    for(int row = 0; row<=lengthGridX; row++){
      
      for(int column = 0; column<=lengthGridY; column++){
        
        if(statusOfGrid[row][column] != 1){
          food++;
        }
        
      }
    }  

    
    int x;
    int y;
    int direction;
    int life = 3;
    
    int test = 1;
    
    do{
      
      for(int moves = 1; moves <= speedOfPacMan; moves++){
        //movePacMan();
      }
      
      boolean eaten = false;
      
      for(int moves = 1; moves<=speedOfMonster; moves++){
        for(int monsters = 0; monsters<=2; monsters++){
          do{
                                  
            direction = randomMonsters(monster[monsters][0],monster[monsters][1],lengthGridX,lengthGridY);
            
            x = monster[monsters][0];
            y = monster[monsters][1];
            
            if(direction == 1){
              x = monster[monsters][0] + 1;
            }else{
              if(direction == 2){
                y = monster[monsters][1] + 1;
              }else{
                  if(direction == 3){
                    y = monster[monsters][1] -1;
                  }else{
                    x = monster[monsters][0] -1;
                  } 
                  
               }
          
            }
            
            if(x > lengthGridX){
              x = 0;
            }
            
            if(y > lengthGridY){
              y = 0;
            }
            
            if(x < 0){
              x = lengthGridX;
            }
            
            if(y < 0 ){
              y = lengthGridY;
            }
                                
          }while(statusOfGrid[x][y]==1);         
        
          
          monster[monsters][0] = x;
          monster[monsters][1] = y;

          
        }
        
        for(int monsterss = 0; monsterss<=2; monsterss++){
          
          if(pacMan_x == monster[monsterss][0] && pacMan_y == monster[monsterss][1]){
            eaten = true;
          }
          
        }
                 
        
       }
                           
                 
      if(statusOfGrid[pacMan_x][pacMan_y] == 0){
        food--;
        statusOfGrid[pacMan_x][pacMan_y] = 3;
        points += 50;
        if(food==0){
          statusOfGrid = statusOfGridOrig;
          monster = monsterReset;
          pacMan_x = pacMan_xReset;
          pacMan_y = pacMan_yReset;
          speedOfMonster++;
        }
      }

      
      if(eaten!=false){
        eaten = true;
        life--;
        statusOfGrid = statusOfGridOrig;
        pacMan_x = pacMan_xReset;
        pacMan_y = pacMan_yReset;
        for(int monsters = 0; monsters<=2; monsters++){
          for(int index = 0; index <= 1; index++){
            monster[monsters][index] = monsterReset[monsters][index];
          }
        }
      }    
                  
    }while(life!=0);
    
  }//end of main
  
  public static int randomMonsters(int monster_x,int monster_y,int lengthGridX,int lengthGridY){
    
    int direction;
        
    direction = (int)((Math.random()*4)+1);
    return direction;
    
  }
}
  
  //public static 
      