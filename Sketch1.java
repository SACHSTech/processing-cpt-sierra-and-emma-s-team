import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PImage;
import java.util.concurrent.TimeUnit;

public class Sketch1 extends PApplet {
  int intImageX = 0;
  int intImageY = 0;
  int randomFruit = (int)random(12);
	
  PImage imgBanana;
  PImage imgBlueberry;
  PImage imgCherry;
  PImage imgCoconut;
  PImage imgDragonfruit;
  PImage imgKiwi;
  PImage imgLime;
  PImage imgMango;
  PImage imgOrange;
  PImage imgPear;
  PImage imgStrawberry;
  PImage imgWatermelon;

  PImage fallingImage;
  
  ArrayList<PVector> trail = new ArrayList<PVector>();

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

    // load images
    imgBanana = loadImage("banana.png");
    imgBlueberry = loadImage("blueberry.png");
    imgCherry = loadImage("cherry.png");
    imgCoconut = loadImage("coconut.png");
    imgDragonfruit = loadImage("dragonfruit.png");
    imgKiwi = loadImage("kiwi.png");
    imgLime = loadImage("lime.png");
    imgMango = loadImage("mango.png");
    imgOrange = loadImage("orange.png");
    imgPear = loadImage("pear.png");
    imgStrawberry = loadImage("strawberry.png");
    imgWatermelon = loadImage("watermelon.png");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(50);
    scaleImages(50, 50);
    snow();
    mouseTrail();
  }

  public void scaleImages(int intX, int intY){
    imgBanana.resize(intX, intY);
    imgBlueberry.resize(intX, intY);
    imgCherry.resize(intX, intY);
    imgCoconut.resize(intX, intY);
    imgDragonfruit.resize(intX, intY);
    imgKiwi.resize(intX, intY);
    imgLime.resize(intX, intY);
    imgMango.resize(intX, intY);
    imgOrange.resize(intX, intY);
    imgPear.resize(intX, intY);
    imgStrawberry.resize(intX, intY);
    imgWatermelon.resize(intX, intY);
  }

  public void snow(){
    System.out.println(randomFruit);
    if(randomFruit == 0){
      fallingImage = imgBanana;
    }else if(randomFruit == 1){
      fallingImage = imgBlueberry;
    }else if(randomFruit == 2){
      fallingImage = imgCherry;
    }else if(randomFruit == 3){
      fallingImage = imgCoconut;
    }else if(randomFruit == 4){
      fallingImage = imgDragonfruit;
    }else if(randomFruit == 5){
      fallingImage = imgKiwi;
    }else if(randomFruit == 6){
      fallingImage = imgLime;
    }else if(randomFruit == 7){
      fallingImage = imgMango;
    }else if(randomFruit == 8){
      fallingImage = imgOrange;
    }else if(randomFruit == 9){
      fallingImage = imgPear;
    }else if(randomFruit == 10){
      fallingImage = imgStrawberry;
    }else if(randomFruit == 11){
      fallingImage = imgWatermelon;
    }

    image(fallingImage, intImageX, intImageY);
    if(intImageY > height){
      intImageY = 0;
      randomFruit = (int)random(12);
    }else{
      intImageY += 10;
    }
    System.out.println(intImageY);
  }

  /*public void mouseDragged(){
  for (int i = 0; i < circleX.length; i++){
    if (dist(mouseX, mouseY, circleX[i], circleY[i]) < 25){
      ellipse(circleX[i], circleY[i], 25, 25);
      fill (252, 126, 191);
    }
  }

  }*/

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
}