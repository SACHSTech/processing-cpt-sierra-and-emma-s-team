import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PImage;

public class Sketch2 extends PApplet {

  ArrayList<PVector> trail = new ArrayList<PVector>();
  float[] circleY = new float[12];
  float[] circleX = new float[12];
  PImage[] fruits = new PImage[12];
  PImage[] fruitsCut = new PImage[12];
  PImage[] fruitsStatic = new PImage[12];
  double dblSize = 0.1;
  int lives = 3;

  // fruit points
  int[] fruitPoints = {10, 20, 15, 25, 30, 20, 15, 25, 20, 15, 30, 25};
  int score = 0; 


  // backgrounds 
  PImage imgbg1; 

  // buttons 
  PImage imgStart;
  PImage imgTutorial;

  //lives
  PImage imgHeart; 
  int heartWidth = 25; 
  int heartHeight = 25; 
  PImage imgX;

  //start button 
  int startWidth = 200;
  int startHeight = 180;
  int startX = 195;
  int startY = 250;

  //tutorial button 
  int tutorialWidth = 200;
  int tutorialHeight = 180;
  int tutorialX = 10; 
  int tutorialY = 250; 
  
  //screens
  int screen = 0; 


  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);

  }

  public void setup() {
    background(210, 255, 173);
    noStroke();

    imgbg1 = loadImage("bg1.png");
    imgbg1.resize(width, height);

    imgStart = loadImage("start.png"); 
    imgStart.resize(startWidth, startHeight);

    imgTutorial = loadImage("tutorial.png"); 
    imgTutorial.resize(tutorialWidth,tutorialHeight);

    imgHeart = loadImage("/images/heart.png");
    imgHeart.resize(heartWidth,heartHeight); 

    
    // determine Y value for circles 
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(200);
  }
  // Dertermine the X for the circles 
  for (int i = 0; i < circleX.length; i++) {
      circleX[i] = random(width);
  }

    fruitsCut[0] = loadImage("bananacut.png");
    fruitsCut[1] = loadImage("blueberrycut.png");
    fruitsCut[2] = loadImage("cherrycut.png");
    fruitsCut[3] = loadImage("coconutcut.png");
    fruitsCut[4] = loadImage("dragonfruitcut.png");
    fruitsCut[5] = loadImage("kiwicut.png");
    fruitsCut[6] = loadImage("limecut.png");
    fruitsCut[7] = loadImage("mangocut.png");
    fruitsCut[8] = loadImage("orangecut.png");
    fruitsCut[9] = loadImage("pearcut.png");
    fruitsCut[10] = loadImage("watermeloncut.png");
    fruitsCut[11] = loadImage("strawberrycut.png");

    fruitsStatic[0] = loadImage("banana.png");
    fruitsStatic[1] = loadImage("blueberry.png");
    fruitsStatic[2] = loadImage("cherry.png");
    fruitsStatic[3] = loadImage("coconut.png");
    fruitsStatic[4] = loadImage("dragonfruit.png");
    fruitsStatic[5] = loadImage("kiwi.png");
    fruitsStatic[6] = loadImage("lime.png");
    fruitsStatic[7] = loadImage("mango.png");
    fruitsStatic[8] = loadImage("orange.png");
    fruitsStatic[9] = loadImage("pear.png");
    fruitsStatic[10] = loadImage("watermelon.png");
    fruitsStatic[11] = loadImage("strawberry.png");

    //Load array with images
    fruits[0] = loadImage("banana.png");
    fruits[1] = loadImage("blueberry.png");
    fruits[2] = loadImage("cherry.png");
    fruits[3] = loadImage("coconut.png");
    fruits[4] = loadImage("dragonfruit.png");
    fruits[5] = loadImage("kiwi.png");
    fruits[6] = loadImage("lime.png");
    fruits[7] = loadImage("mango.png");
    fruits[8] = loadImage("orange.png");
    fruits[9] = loadImage("pear.png");
    fruits[10] = loadImage("watermelon.png");
    fruits[11] = loadImage("strawberry.png");

    //Scales images
    scaleImages();
    }

  public void draw() {
    fill(255);
    textSize(20);
    text("Score: " + score, 20, 20);
    if (screen == 1){
      background (50);
      lives();
      fruit();
    } else if (screen == 2){
      dblSize = 0.5;
      tutorial(); 
    }
     else {
      image(imgbg1, 0, 0);
      image(imgStart, startX, startY);
      image(imgTutorial, tutorialX, tutorialY);
      startButton();
      tutorialButton();
    }
    mouseTrail();
  }

  public void scaleImages() {
    for (int i = 0; i < fruits.length; i++) {
        fruits[i].resize((int) (Double.valueOf(fruits[i].width) * dblSize), (int) (Double.valueOf(fruits[i].height) * dblSize));
    }
    for (int i = 0; i < fruitsCut.length; i++) {
        fruitsCut[i].resize((int) (Double.valueOf(fruitsCut[i].width) * dblSize), (int) (Double.valueOf(fruitsCut[i].height) * dblSize));
    }
    for (int i = 0; i < fruitsStatic.length; i++) {
        fruitsStatic[i].resize((int) (Double.valueOf(fruitsStatic[i].width) * dblSize), (int) (Double.valueOf(fruitsStatic[i].height) * dblSize));
    }
}

public void fruit() {
  for (int i = 0; i < circleY.length; i++) {
      image(fruits[i], circleX[i], circleY[i]);
      circleY[i]++;
      if (keyCode == DOWN) {
          circleY[i] += 3;
      } else if (keyCode == UP) {
          circleY[i] -= 0.5;
      }
      if (circleY[i] > height) {
        if(fruits[i] == fruitsStatic[i]){
          lives--;
          System.out.println(lives);
        }else{
          //Code for points
        }
        fruits[i] = fruitsStatic[i];
        circleY[i] = 0;
      }
  }
  //Code for next level
}

  public void mouseDragged(){
    for (int i = 0; i < circleX.length; i++) {
      if (dist(mouseX, mouseY, circleX[i], circleY[i]) < (int) (500 * dblSize)) {
          fruits[i] = fruitsCut[i];
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
      image(imgTutorial, tutorialX, tutorialY);
    if (mouseX > startX && mouseX < startX + startWidth && mouseY > startY && mouseY < startY + startHeight) {
      if (mousePressed) {
        screen = 1;
      } 
    else {
      image(imgbg1, 0, 0);
      image(imgStart, startX, startY);
      image(imgTutorial, tutorialX, tutorialY);
    }
  }
  }

  public void tutorialButton(){
    image(imgbg1, 0, 0);
      image(imgStart, startX, startY);
      image(imgTutorial, tutorialX, tutorialY);
    if (mouseX > tutorialX && mouseX < tutorialX + tutorialWidth && mouseY > tutorialY && mouseY < tutorialY + tutorialHeight) {
      if (mousePressed) {
        screen = 2;
      } 
    else {
      image(imgbg1, 0, 0);
      image(imgStart, startX, startY);
      image(imgTutorial, tutorialX, tutorialY);
    }
  }
  }

  public void tutorial(){
    
    background(50);
    int i = 10;
      image(fruits[i], circleX[i], circleY[i]);
      circleY[i]++;
      if (keyCode == DOWN) {
          circleY[i] += 3;
      } else if (keyCode == UP) {
          circleY[i] -= 0.5;
      }
      if (circleY[i] > height) {
        if(fruits[i] == fruitsStatic[i]){
          lives--;
          System.out.println(lives);
        }else{
          //Code for points
        }
        fruits[i] = fruitsStatic[i];
        circleY[i] = 0;
      }
  }

  public void lives(){
    if (screen == 1) {
      for (int i = 0; i < lives; i++) {
        float x = width - 35 - i * 35;
        float y = 20;
        image(imgHeart, x, y);
      }
    if (lives <= 0){
      background(255);
      textSize(50);
      fill(0);
      textAlign(CENTER,CENTER);
      text("You Lose", width/2, height/2);
    }
  }
}
}

