// Original coursework: May 2022.
package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import javax.swing.JOptionPane;

/*
Test data

Case #1
1. Enter $10
2. Click Spin button
   2.1. if no equal symbols the won should be $0, check total Won value
   2.2. if two equal symbols the won should be $30, check total Won value
   2.3. if three equal symbols the won should be $40, check total Won value
3. Click Spin button again until all three cases fulfill

Case #2 (invalid User input validation)
1. Enter zero, negative value or string
2. Click Spin button
3. The error Message Box will display
*/

public class SlotMachineGame extends Application
{
  
   // Array of image filenames
   private final String[] fileName =
   {
      "BlankFruit.png",
      "Apple.png",
      "Banana.png",
      "Cherries.png",
      "Grapes.png",
      "Lemon.png",
      "Lime.png",
      "Orange.png",
      "Pear.png",
      "Strawberry.png",
      "Watermelon.png"
   };
   
   // Instance Fields
   private TextField moneyTextField;
   private Label wonLabel;
   private Label wonTotalLabel;
   
   private Image[] images; // Array of Images
   private ImageView[] imageView;   //Array of ImageViews
   
   SlotMachineGameImpl slotMachineGame;
   
   public static void main(String []args) 
   {
      //launch the application
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      primaryStage.setTitle("Slot Machine Game");
      
      slotMachineGame = new SlotMachineGameImpl();

      Label moneyLabel = new Label("Insert Money");
      moneyTextField = new TextField("0");
   
      images = new Image[slotMachineGame.IMAGES];
      imageView = new ImageView[slotMachineGame.SYMBOLS];
      
      // Create an Image components.
      for (int i = 0; i < slotMachineGame.IMAGES; i++)
         images[i] = new Image(SlotMachineGame.class.getResourceAsStream("/images/" + fileName[i]));
     
      // Create an ImageView controls.
      for (int i = 0; i < slotMachineGame.SYMBOLS; i++)
         imageView[i] = new ImageView(images[0]);

      // call method to show the images
      ShowImages();
                 
      HBox hbox1 = new HBox(10, moneyLabel, moneyTextField);
      
      // Put the ImageView in an HBox.
      HBox hbox2 = new HBox(10);
      
      for (int i = 0; i < slotMachineGame.SYMBOLS; i++)
         hbox2.getChildren().add(imageView[i]);
      
      // Create a Button to perform the spin.
      Button spinButton = new Button("Spin");
      
      // Register the event handler.
      spinButton.setOnAction(new SpinButtonHandler());
      
      wonLabel = new Label("");
      wonTotalLabel = new Label("");
      
      // Put the controls in a VBox.
      VBox vbox = new VBox(10, hbox1, hbox2, spinButton, wonLabel, wonTotalLabel);
      
      // Set the HBox's alignment to center.
      hbox1.setAlignment(Pos.CENTER);
      hbox2.setAlignment(Pos.CENTER);

      // Set the VBox's alignment to center.
      vbox.setAlignment(Pos.CENTER);

      // Set the VBox's padding to 10 pixels.
      vbox.setPadding(new Insets(10));

      // Create a Scene with the HBox as its root node.
      Scene scene = new Scene(vbox);

      // Add the Scene to the Stage.
      primaryStage.setScene(scene);
            
      // Show the window.
      primaryStage.show();
   }
   
   /**
   * Event handler class for spinButton
   */
   class SpinButtonHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         // create variables
         double money = 0;
         
         // get money from User
         String moneyText = moneyTextField.getText();
         
         // validate user imput
         try
         {
            money = Double.parseDouble(moneyText);
            if (money <= 0) throw new NumberFormatException();
         }
         catch (NumberFormatException e)
         {
            JOptionPane.showMessageDialog(null, "Please insert a valid number greater than 0");
            return;
         }
         
         // call method for Spin
         double won = slotMachineGame.Spin(money);
         
         // call method to show images
         ShowImages();
         
         // display money won and total money won
         wonLabel.setText(String.format("You have won: $%.2f", won));
         wonTotalLabel.setText(String.format("In total you have won: $%.2f", slotMachineGame.GetTotalWon()));
     }
   }
   
   /**
   * Show Images from randomized symbol array
   */
   private void ShowImages()
   {
      int[] symbols = slotMachineGame.GetSymbols();
      
      for (int i = 0; i < slotMachineGame.SYMBOLS; i++)
         imageView[i].setImage(images[symbols[i]]);
   }
}
