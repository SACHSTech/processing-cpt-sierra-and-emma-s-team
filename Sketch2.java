import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PImage;

public class Sketch2 extends PApplet {
	
  
  ArrayList<PVector> trail = new ArrayList<PVector>();
  float[] circleY = new float[20];
  float[] circleX = new float[20];

  // backgrounds 
  PImage imgbg1; 
  PImage imgStart;

  //fruit pngs

  //start button 
  int startWidth = 220;
  int startHeight = 220;
  int startX = 200;
  int startY = 200;
  
  //screens
  int screen = 0; 


  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);

  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
    noStroke();
    
    // determine Y value for circles 
    for (int i = 0; i < circleY.length; i++){
      circleY[i] = random(height);
    }
    // Dertermine the X for the circles 
    for (int i = 0; i < circleX.length; i++){
      circleX[i] = random(width);
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    mouseTrail();
    startButton();
    if (screen == 1){
      snow();
    } else {
      image(imgbg1, 0, 0);
      image(imgStart, startX, startY);
    }
  }

  public void snow(){
    background(0);
    for (int i = 0; i < circleY.length; i++){
      fill(255, 255, 255);
      ellipse(circleX[i], circleY[i], 25, 25);
      circleY[i]++;
      if (keyCode == DOWN){
        circleY[i] += 3;
      }
      else if (keyCode == UP){
        circleY[i] -= 0.5;
      }
      if (circleY[i] > height){
        circleY[i] = 0;
      }
    }
  }

  public void mouseDragged(){
  for (int i = 0; i < circleX.length; i++){
    if (dist(mouseX, mouseY, circleX[i], circleY[i]) < 25){
      ellipse(circleX[i], circleY[i], 25, 25);
      fill (252, 126, 191);
    }
  }

  }

  public void mouseTrail(){
    trail.add(new PVector(mouseX,mouseY));
    if(trail.size() > 10){
      trail.remove(0);
    }

    for (int i = 0; i < trail.size(); i++){
      PVector p = trail.get(i); 

      float size = 10 * i / trail.size();
      ellipse (p.x, p.y, size,size);
    }
  }

  public void startButton(){
    image(imgbg1, 0, 0);
    image(imgStart, startX, startY);
    if (mouseX > startX && mouseX < startX + startWidth && mouseY > startY && mouseY < startY + startHeight) {
      if (mousePressed) {
        screen = 1;
        background(0);
      } 
    else {
      image(imgbg1, 0, 0);
      image(imgStart, startX, startY);
    }
  }
  }
}



/*banana = loadImage("/Images/banana.png");
    blueberry = loadImage("/Images/blueberry.png");  
    cherry = loadImage("/Images/cherry.png");
    coconut = loadImage("/Images/coconut.png");
    dragonfruit = loadImage("/Images/dragonfruit.png");
    kiwi = loadImage("/Images/kiwi.png");
    lime = loadImage("/Images/lime.png");
    mango = loadImage("/Images/mango.png");
    orange = loadImage("/Images/orange.png");
    pear = loadImage("/Images/pear.png");
    strawberry = loadImage("/Images/strawberry.png");
    watermelon = loadImage("/Images/watermelon.png");
    
    PImage banana; 
  PImage blueberry;
  PImage cherry;
  PImage coconut;
  PImage dragonfruit;
  PImage kiwi;
  PImage lime;
  PImage mango;
  PImage orange;
  PImage pear;
  PImage strawberry;
  PImage watermelon;
    */