import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PImage;

/**
 * This game is called Splash N Slice. There are 4 levels created that the user has to slice the fruits to be 
 * able to move on. Each time a fruit is cut the score will increase by 10. If a fruit is not cut the health
 * bar will decrease. Once the health bar fully decreases the game is over and the user lost. Each level the
 * game gets harder with the fruits getting smaller and faster. On the home page the user can also go to the
 * tutorial page to see how the game works and how to play.
 * @sierrarajabali
 * @Emmmmmaaaa
 */
public class Sketch extends PApplet {

  // Arrays of amount of fruits on screen
  ArrayList<PVector> trail = new ArrayList<PVector>();
  float[] circleY = new float[12];
  float[] circleX = new float[12];
  PImage[] fruits = new PImage[12];
  PImage[] fruitsCut = new PImage[12];
  PImage[] fruitsStatic = new PImage[12];
  
  // Size of fruit
  double dblSize = 0.3;
  
  // lives amount starting
  int lives = 400;
  
  // Fruit Speed
  int fruitSpeed = 1;

  // fruit points
  int score = 0; 
  int scoreTutorial = 0;

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
  PImage imgHeart; 
  int heartWidth = 25; 
  int heartHeight = 25; 

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
   PImage[] tutorialText = new PImage[4];
   int textWidth = 100;
   int textHeight = 50;
   int tutorialTextIndex = 0;
   float watermelonY = 0;
  
  //screens
  int screen = 0; 

  public void settings() {
	// put your size call here
    size(400, 400);
  }

  public void setup() {
    // Sets color of the background
    background(210, 255, 173);
    noStroke();

    // Background image of home
    imgbg1 = loadImage("bg1.png");
    imgbg1.resize(width, height);

    // Start button
    imgStart = loadImage("start.png"); 
    imgStart.resize(startWidth, startHeight);

    // toutorial button
    imgTutorial = loadImage("tutorial.png"); 
    imgTutorial.resize(tutorialWidth,tutorialHeight);


    // Tutorial texts
    tutorialText[0] = loadImage("firsttext.png"); 
    tutorialText[1] = loadImage("secondtext.png");
    tutorialText[2] = loadImage("thirdtext.png");
    tutorialText[3] = loadImage("fourthtext.png");

    // Sizing of tutorial text
    for(int loop = 0; loop < tutorialText.length; loop++){
        tutorialText[loop].resize(textWidth*4,textHeight*8);
    }

    // Going to level 2
    imgLvlTwo = loadImage("level2.png"); 
    imgLvlTwo.resize(width, height);

    // Next Level button
    imgNextLvl = loadImage("NextLvl.png");
    imgNextLvl.resize(nextLvlWidth, nextLvlHeight);

    // Level three background
    imgLvlThree = loadImage("level3.png"); 
    imgLvlThree.resize(width, height);
    
    // Losing background
    imgYouLose = loadImage("youLose.png"); 
    imgYouLose.resize(width, height);

    // Going to level four background
    imgLvlFour = loadImage("level4.png"); 
    imgLvlFour.resize(width, height);

    // Winning background image
    imgYouWin = loadImage("win.png"); 
    imgYouWin.resize(width, height);

    // determine Y value for circles 
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(200);
    }

    // Sets watermelon Y
    watermelonY = circleY[10];

    // Dertermine the X for the circles 
    for (int i = 0; i < circleX.length; i++) {
      circleX[i] = random(0,width-100);
    }

    // Assigns array values to each fruit cut image
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

    // Assigns array values to each fruit static image
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

    // Assigns array values to each fruit image
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

    //Scales images to good size
    scaleImages();
  }

  public void draw() {
    // sets up each screen
    // screen one is for the first level
    if (screen == 1){
      background(50);
      lives();
      fruit();
      // Display the score in the top left in white font
      fill(255);
      textSize(20);
      text("Score: " + score, 20, 30);
      // Once the score is high enough it goes to level 2 page
      if (score == 300){
        screen = 3;
        backTop();
      }
      // Screen 2 is the tutorial page if the tutorial button is clicked
    } else if (screen == 2){
      dblSize += 0.3;
      tutorial();
      // screen 3 is for level 2 background page
    } else if (screen == 3){
      // cut screen to level 2 
      background (0);
      image(imgLvlTwo, 0, 0);
      nextLevel();
      // screen 2 game page
    } else if (screen == 4){
      // lvl 2 
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
        if (score == 900){
          screen = 5;
          dblSize = 0.73;
          scaleImages();
        }
        // Level three intro page 
    } else if (screen == 5){
    // cut screen to go to level three 
      background(0);
      image(imgLvlThree, 0, 0);
      nextLevel();
    } else if (screen == 6){ 
      //level three game page
        fruitSpeed = 3;
        background(50);
        lives();
        fruit();
        // Display the score in the top left in white font
        fill(255);
        textSize(20);
        text("Score: " + score, 20, 30);
        if (score == 1800){
          screen = 7;
          dblSize = 0.63;
          scaleImages();
        }
        // Level 4 game intro page
    } else if (screen == 7) {
    //cut screen to go to level 4 
      background(0);
      image(imgLvlFour, 0, 0);
      nextLevel();
    } else if (screen == 8){
      // level 4 
      fruitSpeed = 4; 
      background(50);
        fruit();
        lives();
        // Display the score in the top left in white font
        fill(255);
        textSize(20);
        text("Score: " + score, 20, 30);
        if (score == 2500){
          screen = 9;
        }
        // Once the game is complete its the win page
      } else if (screen == 9){
        background(0);
        image(imgYouWin, 0, 0);
      // The home page
    } else {
      image(imgbg1, 0, 0);
      image(imgStart, startX, startY);
      image(imgTutorial, tutorialX, tutorialY);
      startButton();
      tutorialButton();
    }
    // To have the mouse trial the whole time
    mouseTrail();
  }
  

  public void scaleImages() {
    // Scales images depending on the size of the fruit
    for (int i = 0; i < fruits.length; i++) {
      fruits[i].resize((int) (Double.valueOf(fruits[i].width) * dblSize), (int) (Double.valueOf(fruits[i].height) * dblSize));
      fruitsCut[i].resize((int) (Double.valueOf(fruitsCut[i].width) * dblSize), (int) (Double.valueOf(fruitsCut[i].height) * dblSize));
      fruitsStatic[i].resize((int) (Double.valueOf(fruitsStatic[i].width) * dblSize), (int) (Double.valueOf(fruitsStatic[i].height) * dblSize));
    }
  }

  public void fruit() {
    // Lives is 0 so the lives are at 4000
    if (lives == 0){
      return; 
    }else{
    // Gets images on the screen at random times to cut
    for (int i = 0; i < circleY.length; i++) {
      image(fruits[i], circleX[i], circleY[i]);
      circleY[i]+= fruitSpeed;
      // Users can speed up the fruits
      if (keyCode == DOWN) {
        circleY[i] += 3;
      } else if (keyCode == UP) {
        circleY[i] -= 0.5;
      }
      // Health bar goes down if fruits are not cut
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
    // For cutting the fruit and going from uncut fruit to cut fruit
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
    // So their is a trail when the the fruit is cut
    fill(255);
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
    // Makes the image clicable and can go to the first level if clicked
    // If not clicked stays on the home page
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
    // So the user can go to the tutorial page
    // If not clicked stays on home page
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
    // Gets the images of text to appear at random times
    background(50);
    // Sets the image to a watermelon
    int i = 10;
    // First text
    image(fruits[i], circleX[i], circleY[i]);
    fill(255);
    textSize(20);
    text("Score: " + scoreTutorial, 20, 30);
    image(fruits[i], circleX[i], circleY[i]);
    lives();
    // If the first image is on the screen the watermelon will fall
    if(tutorialTextIndex == 0){
        image(tutorialText[tutorialTextIndex], -30, -70);
        circleY[i]++;
     // If the first image is on the screen and the watermelon is cut and gone the second text will show up
    // The score will also increase to 10
    } else if(tutorialTextIndex == 1){
        image(tutorialText[tutorialTextIndex], 10, 100);
        circleY[i]++;
    // After a few sconds the third image will appear and the fruit will also show
    // The health bar will decrease
    } else if(tutorialTextIndex == 2){
        image(tutorialText[tutorialTextIndex], -30, -70);
        circleY[i] += 7;
    // After a few seconds the final image will appear
    // The screen will go back to the home page
    }else if(tutorialTextIndex == 3){
        image(tutorialText[tutorialTextIndex], -30, -70);
        circleY[i]++;
    }

    // Does the delays so the user have time to read before the next action happens
    if(Double.valueOf(circleY[i]) >= width && fruits[i] == fruitsCut[i] && tutorialTextIndex == 0){
        tutorialTextIndex++;
        scoreTutorial += 10;
        fruits[i] = fruitsStatic[i];
    } else if(circleY[i] >= 600 && tutorialTextIndex == 1){
        tutorialTextIndex++;
        circleY[i] = watermelonY;
    }else if(circleY[i] >= width && tutorialTextIndex == 2 && lives == 400){
        lives -= 40;
    }else if(circleY[i] >= 1000 && tutorialTextIndex == 2 && lives != 400){
        tutorialTextIndex++;
    }else if(circleY[i] >= 1400 && tutorialTextIndex == 3){
        screen = 10;
        tutorialTextIndex = 0;
        lives = 400;
        score = 0;
        circleY[i] = watermelonY;
    }
  }

  public void lives(){
    // Sets the health bar to 400
    if (screen >= 1) {
      fill(0, 255, 115);
      rect(0,0,20,lives);
      }
      // Once the health bar is gone the lose screen will appear
      if (lives <= 0){
        background(0);
        image(imgYouLose, 0, 0);
      }
    }
  
  public void nextLevel(){
    // The next level button will appear and can be pressed to go to the next level
    // If not clicked will stay on the level page
    image(imgNextLvl, nextLvlX, nextLvlY); 
    if (mouseX > nextLvlX && mouseX < nextLvlX + nextLvlWidth && mouseY > nextLvlY && mouseY < nextLvlY + nextLvlHeight) {
      if (mousePressed) {
        screen += 1;
      }
    }
  }

  public void backTop(){
    // For each level the fruits will go back to the top
    for(int i = 0; i < fruits.length; i++){
      circleY[i] = random(200);
    }
  }
}