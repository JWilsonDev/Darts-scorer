package application;
	
import java.io.FileNotFoundException;
import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class Main extends Application {
	
public static void main(String[] args) {
	launch(args);	
	}

Stage window;
Scene menu, singlePlayer, multiPlayer, settings, singlePlayerEntry;

public GridPane grid;
//labels
public Label lblNumber;
public Label lblTotal;
public Label lblPlr1;
public Label lblFinish;
public Label lblSinglePlayerEntry;
//logo
public ImageView imageView;
//buttons
public Button no1,no2,no3,no4,no5,no6,no7,no8,no9,no0;
public Button backSpc;
public Button entr;
public Button undo;
public Button mainSingle;
public Button mainMulti;
public Button mainSettings;
public Button mainQuit;
public Button multiBack;
public Button singleBack;
public Button settingsBack;
public Button singlePlayerEntryBack;
public Button btn301, btn401, btn501, btn1001;
public Button btnMainMenu;
//checkboxes
public CheckBox fullscreenCheck;
public CheckBox themeCheck;
//text field
public TextField textSinglePlayerEntry;
//theme
public String theme = "darkStyle.css";
//variables
int number;
int total;
String Plr1 = "Player 1";
int lastNumber;
int x = 580;
int y = 940;
int counter = 0;
int scored;
String finish = "Unable to Checkout";
long average;
//booleans
public boolean fullscreen = false;
// Starting Stage
public void start(Stage primaryStage) throws FileNotFoundException {
//Setting up window
	window = primaryStage;
	window.setFullScreen(fullscreen);
	primaryStage.setTitle("Darts Scorer v0.1");
//Applying style sheet with fall back
	Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
	StyleManager.getInstance().addUserAgentStylesheet(theme);
	//Application.setUserAgentStylesheet("style.css");
/* ============================== Menu ============================== */	
	grid = new GridPane();
	menu = new Scene(grid, x, y);
	grid.setAlignment(Pos.CENTER);
	window.setScene(menu);
	window.show();
	grid.setVgap(15); 
//Logo
	imageView = new ImageView("file:/D|/Desktop/Eclispe Workspace/GUI1/src/application/images/logo.png");
	imageView.setFitHeight(300);
	imageView.setFitWidth(300);
	imageView.getStyleClass().add("logo");
	grid.add(imageView, 0, 0);
//Singleplayer Button
	mainSingle = new Button("Singleplayer");
	grid.add(mainSingle, 0, 1);
	mainSingle.setOnAction(this::singleGame);
	mainSingle.getStyleClass().add("button-menu");	
//Multiplayer Button
	mainMulti = new Button("Multiplayer");
	grid.add(mainMulti, 0, 2);
	mainMulti.setOnAction(this::multiGame);
	mainMulti.getStyleClass().add("button-menu");
//Settings Button
	mainSettings = new Button("Settings");
	grid.add(mainSettings, 0, 3);
	mainSettings.setOnAction(this::settings);	
	mainSettings.getStyleClass().add("button-menu");
//Quit Button
	mainQuit = new Button("Quit");
	grid.add(mainQuit, 0, 4);
	mainQuit.setOnAction(this::quit);			
	mainQuit.getStyleClass().add("button-menu");
/* ============================== Singleplayer Name/Score ============================== */	
	grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	singlePlayerEntry = new Scene(grid, x, y);
	grid.setVgap(15);
	grid.setHgap(15);
	grid.requestFocus();
//Player Name Label
	lblSinglePlayerEntry = new Label("Player Name:");
	GridPane.setColumnSpan(lblSinglePlayerEntry, 2);
	grid.add(lblSinglePlayerEntry, 0, 0);
	GridPane.setHalignment(lblSinglePlayerEntry, javafx.geometry.HPos.CENTER);
//Player Name Field
	textSinglePlayerEntry = new TextField();
	textSinglePlayerEntry.setPromptText("Player Name");
	GridPane.setColumnSpan(textSinglePlayerEntry, 2);
	grid.add(textSinglePlayerEntry, 0, 1);
	GridPane.setHalignment(textSinglePlayerEntry, javafx.geometry.HPos.CENTER);
//Objective
	//301
	btn301 = new Button("301");
	grid.add(btn301, 0, 2);
	btn301.setOnAction(this::obj301);
	btn301.getStyleClass().add("button-obj");
	//401
	btn401 = new Button("401");
	grid.add(btn401, 1, 2);
	btn401.setOnAction(this::obj401);
	btn401.getStyleClass().add("button-obj");
	//501
	btn501 = new Button("501");
	grid.add(btn501, 0, 3);
	btn501.setOnAction(this::obj501);
	btn501.getStyleClass().add("button-obj");
	//1001
	btn1001 = new Button("1001");
	grid.add(btn1001, 1, 3);
	btn1001.setOnAction(this::obj1001);
	btn1001.getStyleClass().add("1001Press");	
	btn1001.getStyleClass().add("button-obj");
//Back button
	btnMainMenu = new Button("Return to Main Menu");
	GridPane.setColumnSpan(btnMainMenu, 2);
	grid.add(btnMainMenu, 0, 6);
	btnMainMenu.setOnAction(this::mainMenu);
	btnMainMenu.getStyleClass().add("btnMainMenu");
/* ============================== Singleplayer ============================== */	
//Setting Scene	
	grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	singlePlayer = new Scene(grid, x, y);
	grid.setVgap(15);
	grid.setHgap(15);
//Player Name
	lblPlr1 = new Label();
	GridPane.setColumnSpan(lblPlr1, 3);
	grid.add(lblPlr1, 0, 0);
	GridPane.setHalignment(lblPlr1, javafx.geometry.HPos.CENTER);
//Total	
	lblTotal = new Label(String.valueOf(total));
	GridPane.setColumnSpan(lblTotal, 3);
	grid.add(lblTotal, 0, 1);
	GridPane.setHalignment(lblTotal, javafx.geometry.HPos.CENTER);
	lblTotal.getStyleClass().add("lrgHeader");
//Finishers WIP
	lblFinish = new Label(finish);
	GridPane.setColumnSpan(lblFinish, 3);
	grid.add(lblFinish, 0, 2);
	GridPane.setHalignment(lblFinish, javafx.geometry.HPos.CENTER);
//Typed Number	
	lblNumber = new Label();
	GridPane.setColumnSpan(lblNumber, 3);
	grid.add(lblNumber, 0, 3);	
	GridPane.setHalignment(lblNumber, javafx.geometry.HPos.CENTER);
	lblNumber.getStyleClass().add("lrgHeader");
// Number Buttons	
	no7 = new Button("7");
	grid.add(no7, 0, 4);
	no7.setOnAction(this::processNumber);
	no7.getStyleClass().add("button-number");
	
	no8 = new Button("8");
	grid.add(no8, 1, 4);
	no8.setOnAction(this::processNumber);
	no8.getStyleClass().add("button-number");
	
	no9 = new Button("9");
	grid.add(no9, 2, 4);
	no9.setOnAction(this::processNumber);
	no9.getStyleClass().add("button-number");
	
	no4 = new Button("4");
	grid.add(no4, 0, 5);
	no4.setOnAction(this::processNumber);
	no4.getStyleClass().add("button-number");
	
	no5 = new Button("5");
	grid.add(no5, 1, 5);
	no5.setOnAction(this::processNumber);
	no5.getStyleClass().add("button-number");
	
	no6 = new Button("6");
	grid.add(no6, 2, 5);
	no6.setOnAction(this::processNumber);
	no6.getStyleClass().add("button-number");
	
	no1 = new Button("1");
	grid.add(no1, 0, 6);
	no1.setOnAction(this::processNumber);
	no1.getStyleClass().add("button-number");
	
	no2 = new Button("2");
	grid.add(no2, 1, 6);
	no2.setOnAction(this::processNumber);
	no2.getStyleClass().add("button-number");
	
	no3 = new Button("3");
	grid.add(no3, 2, 6);
	no3.setOnAction(this::processNumber);
	no3.getStyleClass().add("button-number");
	
	no0 = new Button("0");
	grid.add(no0, 1, 7);
	no0.setOnAction(this::processNumber);
	no0.getStyleClass().add("button-number");
//Backspace and Enter Buttons	
	backSpc = new Button("<-");
	grid.add(backSpc, 0, 7);
	backSpc.setOnAction(this::backSpcPress);
	backSpc.getStyleClass().add("button-number");
	
	entr = new Button("Enter");
	grid.add(entr, 2, 7);
	entr.setOnAction(this::entrPress);
	entr.getStyleClass().add("button-number");
//Undo Button
	undo = new Button("Undo");
	GridPane.setColumnSpan(undo, 3);
	grid.add(undo, 0, 8);
	undo.setOnAction(this::undoPress);
	undo.getStyleClass().add("button-single");
//Return to menu
	btnMainMenu = new Button("Return to Main Menu");
	GridPane.setColumnSpan(btnMainMenu, 3);
	grid.add(btnMainMenu, 0, 9);
	btnMainMenu.setOnAction(this::mainMenu);
	btnMainMenu.getStyleClass().add("button-single");

/* ============================== Multiplayer ============================== */	
//Setting Scene	
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		multiPlayer = new Scene(grid, x, y);
		grid.setVgap(15);
		grid.setHgap(15);
//Buttons
		btnMainMenu = new Button("Return to Main Menu");
		grid.add(btnMainMenu, 0, 1);
		btnMainMenu.setOnAction(this::mainMenu);
		btnMainMenu.getStyleClass().add("btnMainMenu");
		
/* ============================== Settings ============================== */	
//Setting Scene	
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		settings = new Scene(grid, x, y);
		grid.setVgap(15);
//Buttons
		btnMainMenu = new Button("Return to Main Menu");
		grid.add(btnMainMenu, 0, 0);
		btnMainMenu.setOnAction(this::themeCheck);
		btnMainMenu.getStyleClass().add("btnMainMenu");
		
//Checkbox
		fullscreenCheck = new CheckBox("Fullscreen");
		grid.add(fullscreenCheck, 0, 1);
		fullscreenCheck.setOnAction(this::fullscreenChecker);
//Checkbox
		themeCheck = new CheckBox("Theme");
		grid.add(themeCheck, 0, 2);
		themeCheck.setOnAction(this::themeCheck);
}
//Event Handlers
	//Main Menu Buttons
	public void singleGame(ActionEvent event) {
		window.setScene(singlePlayerEntry);	
		window.setFullScreen(fullscreen);
	}
	public void multiGame(ActionEvent event) {
		window.setScene(multiPlayer);
		window.setFullScreen(fullscreen);
	}
	public void settings(ActionEvent event) {
		window.setScene(settings);
		window.setFullScreen(fullscreen);
	}
	public void quit(ActionEvent event) {
		window.close();
	}
	//Backspace and Enter Pressed
	public void backSpcPress(ActionEvent event) {

	}
	public void entrPress(ActionEvent event) {
		if(total-number>0) {
			total = total - number;
			lastNumber = number;
			number = 0;
			lblTotal.setText(String.valueOf(total));
			lblNumber.setText("");						
			String finishValue = "Unable to Checkout";
			switch(total){
			case 2: finishValue = "D1";
			break;
			case 3: finishValue = "1 D2";
			break;
			case 4: finishValue = "D2";
			break;
			case 5: finishValue = "1 D2";
			break;
			case 6: finishValue = "D3";
			break;
			case 7: finishValue = "1 D3";
			break;
			case 8: finishValue = "D4";
			break;
			case 9: finishValue = "1 D4";
			break;
			case 10: finishValue = "D5";
			break;
			case 11: finishValue = "1 D5";
			break;
			case 12: finishValue = "D6";
			break;
			case 13: finishValue = "1 D6";
			break;
			case 14: finishValue = "D7";
			break;
			case 15: finishValue = "D D7";
			break;
			case 16: finishValue = "D8";
			break;
			case 17: finishValue = "1 D8";
			break;
			case 18: finishValue = "D9";
			break;
			case 19: finishValue = "1 D9";
			break;
			case 20: finishValue = "D10";
			break;
			case 21: finishValue = "1 D10";
			break;
			case 22: finishValue = "D11";
			break;
			case 23: finishValue = "3 D10";
			break;
			case 24: finishValue = "D12";
			break;
			case 25: finishValue = "5 D10";
			break;
			case 26: finishValue = "D13";
			break;
			case 27: finishValue = "7 D10";
			break;
			case 28: finishValue = "D14";
			break;
			case 29: finishValue = "9 D10";
			break;
			case 30: finishValue = "D15";
			break;
			case 31: finishValue = "11 D10";
			break;
			case 32: finishValue = "D16";
			break;
			case 33: finishValue = "13 D10";
			break;
			case 34: finishValue = "D17";
			break;
			case 35: finishValue = "15 D10";
			break;
			case 36: finishValue = "D18";
			break;
			case 37: finishValue = "17 D10";
			break;
			case 38: finishValue = "D19";
			break;
			case 39: finishValue = "19 D10";
			break;
			case 40: finishValue = "D20";
			break;
			case 41: finishValue = "1 D20";
			break;
			case 42: finishValue = "2 D20";
			break;
			case 43: finishValue = "3 D20";
			break;
			case 44: finishValue = "4 D20";
			break;
			case 45: finishValue = "5 D20";
			break;
			case 46: finishValue = "6 D20";
			break;
			case 47: finishValue = "7 D20";
			break;
			case 48: finishValue = "8 D20";
			break;
			case 49: finishValue = "9 D20";
			break;
			case 50: finishValue = "10 D20";
			break;
			case 51: finishValue = "11 D20";
			break;
			case 52: finishValue = "12 D20";
			break;
			case 53: finishValue = "13 D20";
			break;
			case 54: finishValue = "14 D20";
			break;
			case 55: finishValue = "15 D20";
			break;
			case 56: finishValue = "16 D20";
			break;
			case 57: finishValue = "17 D20";
			break;
			case 58: finishValue = "18 D20";
			break;
			case 59: finishValue = "19 D20";
			break;
			case 60: finishValue = "20 D20";
			break;
			case 61: finishValue = "T15 D8";
			break;
			case 62: finishValue = "T10 D16";
			break;
			case 63: finishValue = "T13 D12";
			break;
			case 64: finishValue = "T16 D8";
			break;
			case 65: finishValue = "T19 D4";
			break;
			case 66: finishValue = "T10 D18";
			break;
			case 67: finishValue = "T17 D8";
			break;
			case 68: finishValue = "T20 D4";
			break;
			case 69: finishValue = "T15 D12";
			break;
			case 70: finishValue = "T10 D20";
			break;
			case 71: finishValue = "T13 D16";
			break;
			case 72: finishValue = "T16 D12";
			break;
			case 73: finishValue = "T19 D8";
			break;
			case 74: finishValue = "T14 D16";
			break;
			case 75: finishValue = "T17 D12";
			break;
			case 76: finishValue = "T20 D8";
			break;
			case 77: finishValue = "T19 D10";
			break;
			case 78: finishValue = "T18 D12";
			break;
			case 79: finishValue = "T13 D20";
			break;
			case 80: finishValue = "T20 D10";
			break;
			case 81: finishValue = "T19 D12";
			break;
			case 82: finishValue = "T14 D20";
			break;
			case 83: finishValue = "T17 D16";
			break;
			case 84: finishValue = "T20 D12";
			break;
			case 85: finishValue = "T15 D20";
			break;
			case 86: finishValue = "T18 D16";
			break;
			case 87: finishValue = "T17 D18";
			break;
			case 89: finishValue = "T19 D16";
			break;
			case 90: finishValue = "T20 D15";
			break;
			case 91: finishValue = "T17 D20";
			break;
			case 92: finishValue = "T20 D16";
			break;
			case 93: finishValue = "T19 D18";
			break;
			case 94: finishValue = "T18 D20";
			break;
			case 95: finishValue = "T19 D19";
			break;
			case 96: finishValue = "T20 D18";
			break;
			case 97: finishValue = "T19 D20";
			break;
			case 98: finishValue = "T20 D19";
			break;
			case 100: finishValue = "T20 D20";
			break;
			case 99: finishValue = "T19 10 D16";
			break;
			case 101: finishValue = "T20 1 D20";
			break;
			case 102: finishValue = "T20 10 D16";
			break;
			case 103: finishValue = "T20 3 D20";
			break;
			case 104: finishValue = "T18 18 D16";
			break;
			case 105: finishValue = "T19 16 D16";
			break;
			case 106: finishValue = "T20 14 D16";
			break;
			case 107: finishValue = "T19 20 D16";
			break;
			case 108: finishValue = "T20 16 D16";
			break;
			case 109: finishValue = "T19 20 D16";
			break;
			case 110: finishValue = "T20 18 D16";
			break;
			case 111: finishValue = "T20 19 D16";
			break;
			case 112: finishValue = "T20 12 D20";
			break;
			case 113: finishValue = "T20 13 D20";
			break;
			case 114: finishValue = "T20 14 D20";
			break;
			case 115: finishValue = "T20 15 D20";
			break;
			case 116: finishValue = "T20 16 D20";
			break;
			case 117: finishValue = "T20 17 D20";
			break;
			case 118: finishValue = "T20 18 D20";
			break;
			case 119: finishValue = "T19 T10 D16";
			break;
			case 120: finishValue = "T20 20 D20";
			break;
			case 121: finishValue = "T17 T10 D20";
			break;
			case 122: finishValue = "T18 T20 D4";
			break;
			case 123: finishValue = "T19 T16 D9";
			break;
			case 124: finishValue = "T20 T16 D8";
			break;
			case 125: finishValue = "25 T20 D20";
			break;
			case 126: finishValue = "T19 T19 D6";
			break;
			case 127: finishValue = "T20 T17 D8";
			break;
			case 128: finishValue = "T18 T14 D16";
			break;
			case 129: finishValue = "T19 T16 D12";
			break;
			case 130: finishValue = "T20 20 Bull";
			break;
			case 131: finishValue = "T20 T13 D16";
			break;
			case 132: finishValue = "T20 T16 D12";
			break;
			case 133: finishValue = "T20 T19 D8";
			break;
			case 134: finishValue = "T20 T14 D16";
			break;
			case 135: finishValue = "T20 T17 D12";
			break;
			case 136: finishValue = "T20 T20 D8";
			break;
			case 137: finishValue = "T19 T16 D16";
			break;
			case 138: finishValue = "T20 T18 D12";
			break;
			case 139: finishValue = "T19 T14 D20";
			break;
			case 140: finishValue = "T20 T16 D16";
			break;
			case 141: finishValue = "T20 T19 D12";
			break;
			case 142:finishValue = "T20 T14 D20";
			break;
			case 143:finishValue = "T20 T17 D16";
			break;
			case 144:finishValue = "T20 T20 D12";
			break;
			case 145: finishValue = "T20 T15 D20";
			break;
			case 146: finishValue = "T20 T18 D16";
			break;
			case 147: finishValue = "T20 T17 D18";
			break;
			case 148: finishValue = "T20 T16 D20";
			break;
			case 149: finishValue = "T20 T19 D16";
			break;
			case 150: finishValue = "T20 T18 D18";
			break;
			case 151: finishValue = "T20 T17 D20";
			break;
			case 152: finishValue = "T20 T20 D16";
			break;
			case 153: finishValue = "T20 T19 D18";
			break;
			case 154: finishValue = "T20 T18 D20";
			break;
			case 155: finishValue = "T20 T19 D19";
			break;
			case 156: finishValue = "T20 T20 D18";
			break;
			case 157: finishValue = "T20 T19 D20";
			break;
			case 158: finishValue = "T20 T20 D19";
			break;
			case 160: finishValue = "T20 T20 D20";
			break;
			case 161: finishValue = "T20 T17 Bull";
			break;
			case 164: finishValue = "T20 T18 Bull";
			break;
			case 167: finishValue = "T20 T19 Bull";
			break;
			case 170: finishValue = "T20 T20 Bull";
			}
			lblFinish.setText(finishValue);	
			counter = counter + 1;
			scored = scored + number;
		}
		else if(total-number == 0){
			lblTotal.setText("Winner");
			average = scored/counter;
			lblFinish.setText("Average Score:" + average);	
			lblNumber.setText("");
		}
		else {
			lblFinish.setText("BUST");	
			lblNumber.setText("");
		}
	}
	//Number Pressed
	public void processNumber(ActionEvent event) {
	    String value = ((Button)event.getSource()).getText();
	    lblNumber.setText(lblNumber.getText() + value);
	    number = Integer.parseInt (lblNumber.getText());
	}
	//Undo Pressed
	public void undoPress(ActionEvent event) {
	    total = total + lastNumber;
	    lblTotal.setText(String.valueOf(total));
	    lastNumber = 0;	    
	}	
	//Other
	public void mainMenu(ActionEvent event) {
	    window.setScene(menu);
	    window.setFullScreen(fullscreen);
	    number = 0;
	    textSinglePlayerEntry.clear();
	}
	public void themeCheck(ActionEvent event) {
		if(theme.equals("darkStyle.css")){
			theme = "lightStyle.css";	
			StyleManager.getInstance().addUserAgentStylesheet(theme);
		}
		else if(theme.equals("lightStyle.css")){
			theme = "darkStyle.css";	
			StyleManager.getInstance().addUserAgentStylesheet(theme);
			System.out.println("true");
		}
	}
	public void fullscreenChecker(ActionEvent event) {
		if(fullscreen == false){
			fullscreen = true;	
			window.setFullScreen(fullscreen);
			System.out.println("true");
		}
		else if(fullscreen == true){
			window.setFullScreen(false);
			fullscreen = false;		
		}
	}
	//Objective Picker
	public void obj301(ActionEvent event) {
	    window.setScene(singlePlayer);
	    window.setFullScreen(fullscreen);
	    total = 301;
	    number = 0;
	    lblTotal.setText(String.valueOf(total));
	    if(textSinglePlayerEntry.getText().trim().isEmpty()){
	    	lblPlr1.setText("Current Player: " + Plr1);
	    }else {
	  		Plr1 = textSinglePlayerEntry.getText();
	  		lblPlr1.setText("Current Player: " + Plr1);
	    }
	}
	public void obj401(ActionEvent event) {
	    window.setScene(singlePlayer);
	    window.setFullScreen(fullscreen);
	    total = 401;
	    number = 0;
	    lblTotal.setText(String.valueOf(total));
	    if(textSinglePlayerEntry.getText().trim().isEmpty()){
	    	lblPlr1.setText("Current Player: " + Plr1);
	    }else {
	  		Plr1 = textSinglePlayerEntry.getText();
	  		lblPlr1.setText("Current Player: " + Plr1);
	    }
	}
	public void obj501(ActionEvent event) {
	    window.setScene(singlePlayer);
	    window.setFullScreen(fullscreen);
	    total = 501;
	    number = 0;
	    lblTotal.setText(String.valueOf(total));
	    if(textSinglePlayerEntry.getText().trim().isEmpty()){
	    	lblPlr1.setText("Current Player: " + Plr1);
	    }else {
	  		Plr1 = textSinglePlayerEntry.getText();
	  		lblPlr1.setText("Current Player: " + Plr1);
	    }
	}
	public void obj1001(ActionEvent event) {
	    window.setScene(singlePlayer);
	    window.setFullScreen(fullscreen);
	    total = 1001;
	    number = 0;
	    lblTotal.setText(String.valueOf(total));
	    if(textSinglePlayerEntry.getText().trim().isEmpty()){
	    	lblPlr1.setText("Current Player: " + Plr1);
	    }else {
	  		Plr1 = textSinglePlayerEntry.getText();
	  		lblPlr1.setText("Current Player: " + Plr1);
	    }
	}
}
