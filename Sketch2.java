import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PImage;

public class Sketch2 extends PApplet {

  //trail 
  ArrayList<PVector> trail = new ArrayList<PVector>();

  //fruits
  float[] circleY = new float[12];
  float[] circleX = new float[12];
  PImage[] fruits = new PImage[12];
  PImage[] fruitsCut = new PImage[12];
  PImage[] fruitsStatic = new PImage[12];
  double dblSize = 0.3;
  int fruitSpeed = 1;

  // fruit points
  int score = 0; 

  // backgrounds 
  PImage imgbg1; 
  PImage imgLvlTwo;
  PImage imgLvlThree; 
  PImage imgLvlFour; 
  PImage imgYouWin;
  PImage imgYouLose; 

  // buttons 
  PImage imgStart;
  PImage imgTutorial;
  PImage imgNextLvl;

  //lives
  int lives = 400;

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

  // next level button 
  int nextLvlWidth = 200;
  int nextLvlHeight = 180;
  int nextLvlX = 110; 
  int nextLvlY = 250; 

   //tutorial text
   PImage imgTextOne;
   PImage imgTextTwo;
   int textWidth = 100;
   int textHeight = 50;
  
  //screens
  int screen = 0; 

  public void settings() {
	//size call
    size(400, 400);
  }

  public void setup() {
    background(210, 255, 173);
    noStroke();

    //load and resize images 
    imgbg1 = loadImage("bg1.png");
    imgbg1.resize(width, height);

    imgStart = loadImage("start.png"); 
    imgStart.resize(startWidth, startHeight);

    imgTutorial = loadImage("tutorial.png"); 
    imgTutorial.resize(tutorialWidth,tutorialHeight);

    imgTextOne = loadImage("firsttext.png"); 
    imgTextOne.resize(textWidth*4,textHeight*8);

    imgTextTwo = loadImage("secondtext.png"); 
    imgTextTwo.resize(textWidth*4,textHeight*8);

    imgLvlTwo = loadImage("level2.png"); 
    imgLvlTwo.resize(width, height);

    imgNextLvl = loadImage("NextLvl.png");
    imgNextLvl.resize(nextLvlWidth, nextLvlHeight);

    imgLvlThree = loadImage("level3.png"); 
    imgLvlThree.resize(width, height);
    
    imgYouLose = loadImage("youLose.png"); 
    imgYouLose.resize(width, height);

    imgLvlFour = loadImage("level4.png"); 
    imgLvlFour.resize(width, height);

    imgYouWin = loadImage("win.png"); 
    imgYouWin.resize(width, height);

    // determine Y value for circles 
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(200);
    }

    // Dertermine the X for the circles 
    for (int i = 0; i < circleX.length; i++) {
      circleX[i] = random(0,width-100);
    }

    //load images for fruits cut 
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

    //load images for uncut fruit 
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
    // level 1
    if (screen == 1){
      background(50);
      lives();
      fruit();
      // Display the score in the top left in white font
      fill(255);
      textSize(20);
      text("Score: " + score, 20, 30);
      if (score == 300){
        screen = 3;
        backTop();
      }
    } 
    // to go to tutorial level 
    else if (screen == 2){
      dblSize += 0.3;
      tutorial(); 
    } 
    else if (screen == 3){
      // cut screen to level 2 
      background (0);
      image(imgLvlTwo, 0, 0);
      nextLevel();
    } 
    else if (screen == 4){
      // level 2 - increase speed and make fruit smaller
      fruitSpeed = 2;
      if(dblSize == 0.3){
        dblSize = 0.83;
        scaleImages();
      }
      background(50);
      lives();
      fruit();
      // Display the score in the top left in white font
      fill(255);
      textSize(20);
      text("Score: " + score, 20, 30);
      if (score == 600){}
        if (score == 900){
          screen = 5;
          backTop();
        }
      }
    } 
    else if (screen == 5){
      // cut screen to go to level three 
      background(0);
      image(imgLvlThree, 0, 0);
      nextLevel();
    } else if (screen == 6){ 
      //level three 
        fruitSpeed = 3;
        if(dblSize == 0.83){
          dblSize = 0.73;
          scaleImages();
         }
        background(50);
        lives();
        fruit();
        // Display the score in the top left in white font
        fill(255);
        textSize(20);
        text("Score: " + score, 20, 30);
        if (score == 1000){
        if (score == 1800){
          screen = 7;
        }
      } 
    }
    else if (screen == 7) {
      //cut screen to go to level 4 
      background(0);
      image(imgLvlFour, 0, 0);
      nextLevel();
    } 
    else if (screen == 8){
      // level 4 - increase speed and make fruit smaller
      fruitSpeed = 4; 
      if(dblSize == 0.73){
        dblSize = 0.63;
        scaleImages();
      }
      background(50);
      fruit();
      lives();
      // Display the score in the top left in white font
      fill(255);
      textSize(20);
      text("Score: " + score, 20, 30);
      if (score >= 2100){
        screen = 9;
      }
    } 
    else if (screen == 9){
      //you win screen
      background(0);
      image(imgYouWin, 0, 0);
    }
    else {
      //start page 
      image(imgbg1, 0, 0);
      image(imgStart, startX, startY);
      image(imgTutorial, tutorialX, tutorialY);
      startButton();
      tutorialButton();
    }
    mouseTrail();
  }
  

  public void scaleImages() {
    //scale images 
    for (int i = 0; i < fruits.length; i++) {
      fruits[i].resize((int) (Double.valueOf(fruits[i].width) * dblSize), (int) (Double.valueOf(fruits[i].height) * dblSize));
      fruitsCut[i].resize((int) (Double.valueOf(fruitsCut[i].width) * dblSize), (int) (Double.valueOf(fruitsCut[i].height) * dblSize));
      fruitsStatic[i].resize((int) (Double.valueOf(fruitsStatic[i].width) * dblSize), (int) (Double.valueOf(fruitsStatic[i].height) * dblSize));
      fruits[i] = fruitsStatic[i];
    }
  }

  public void fruit() {
    if (lives == 0){
      return; 
    } else {
      for (int i = 0; i < circleY.length; i++) {
        image(fruits[i], circleX[i], circleY[i]);
        circleY[i]+= fruitSpeed;
        if (keyCode == DOWN) {
        circleY[i] += 3;
        } else if (keyCode == UP) {
        circleY[i] -= 0.5;
        }
        // determining weather or not you lose lives 
        if (circleY[i]+(fruits[i].height/2) > height) {
          if(fruits[i] == fruitsStatic[i]){
            lives -= 40;
           }
        fruits[i] = fruitsStatic[i];
        circleY[i] = 0;
        }
      } 
    }
  }

  public void mouseDragged(){
    // points when you cut fruit
    for (int i = 0; i < circleX.length; i++) {
      if (dist(mouseX, mouseY, circleX[i], circleY[i]) < (int) (fruitsStatic[i].width)) {
        if (fruits[i] != fruitsCut[i]) {
          fruits[i] = fruitsCut[i];
          score += 10;
        }
      }
    }
  }

  public void mouseTrail(){
    // trail code 
    trail.add(new PVector(mouseX, mouseY));
    if(trail.size() > 10){
      trail.remove(0);
    }

    for (int i = 0; i < trail.size(); i++){
      PVector p = trail.get(i); 
      float size = 10 * i / trail.size();
      ellipse (p.x, p.y, size, size);
    }
  }

  public void startButton(){
    //start button
    image(imgbg1, 0, 0);
    image(imgStart, startX, startY);
    image(imgTutorial, tutorialX, tutorialY);
    if (mouseX > startX && mouseX < startX + startWidth && mouseY > startY && mouseY < startY + startHeight) {
      if (mousePressed) {
        screen = 1;
      } else {
        image(imgbg1, 0, 0);
        image(imgStart, startX, startY);
        image(imgTutorial, tutorialX, tutorialY);
      }
    }
  }

  public void tutorialButton(){
    //tutorial button
    image(imgbg1, 0, 0);
    image(imgStart, startX, startY);
    image(imgTutorial, tutorialX, tutorialY);
    if (mouseX > tutorialX && mouseX < tutorialX + tutorialWidth && mouseY > tutorialY && mouseY < tutorialY + tutorialHeight) {
      if (mousePressed) {
        screen = 2;
      } else {
        image(imgbg1, 0, 0);
        image(imgStart, startX, startY);
        image(imgTutorial, tutorialX, tutorialY);
      }
    }
  }

  public void tutorial(){
    //tutorial code 
    background(50);
    image(imgTextOne, -30, -100);
    int i = 10;
    image(fruits[i], circleX[i], circleY[i]);
    circleY[i]++;

    //image(imgTextTwo, -30, -100);
  }

  public void lives(){
    //heath bar 
    if (screen >= 1) {
      fill(0, 255, 115);
      rect(0,0,20,lives);
      }
      // you loose screen 
      if (lives <= 0){
        background(0);
        image(imgYouLose, 0, 0);
      }
    }
  
  public void nextLevel(){
    // bringing you to next level using button
    image(imgNextLvl, nextLvlX, nextLvlY); 
    if (mouseX > nextLvlX && mouseX < nextLvlX + nextLvlWidth && mouseY > nextLvlY && mouseY < nextLvlY + nextLvlHeight) {
      if (mousePressed) {
        screen += 1;
      }
    }
  }

  public void backTop(){
    //brining fruit back to the top after each level
    for(int i = 0; i < fruits.length; i++){
      circleY[i] = random(200);
    }
  }
}
