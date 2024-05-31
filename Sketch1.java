import processing.core.PApplet;

public class Sketch1 extends PApplet {
	
  float[] circleY = new float[20];
  float[] circleX = new float[20];

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
	  
    background(50);
    snow();
    
  }

  public void snow(){
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
}