import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * 
 */

public class GUI extends Application {

	private Stage window;

	private TextArea input = new TextArea();
	private TextField amount = new TextField("10");
	private TextField delay = new TextField("20");
	private CheckBox yesEnter;
	private CheckBox yesType;

	boolean typeKeys = false;
	boolean stopSpam = false;

	private Spam spam = new Spam(this);

	public static void main(String args[]) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		// Window settings

		window = primaryStage;
		window.setTitle("Spam Bot");

		// Labels, Buttons and Check Boxes

		yesEnter = new CheckBox();

		yesType = new CheckBox();

		Label inputDesc = new Label("Input: ");

		Label amountDesc = new Label("Amount: ");

		Label delayDesc = new Label("Delay: ");

		Label enterDesc = new Label("Click enter after each repetition?");

		Label charDesc = new Label("Type individual keys?");

		Button start = new Button("Start");
		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Thread thread = new Thread() {
					public void run() {
						spam.run();
					}
				};
				spam.spam = true;
				thread.start();
			}
		});

		Button stop = new Button("Stop");
		stop.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				spam.spam = false;
			}
		});

		// TextFields

		input.setPrefSize(300, 100);
		input.setTooltip(new Tooltip("Text to spam"));
		input.setFont(new Font("Monospaced Regular", 15));
		amount.setMaxSize(100, 20);
		amount.setTooltip(new Tooltip("How many times it will be sent"));

		delay.setMaxSize(100, 20);
		delay.setTooltip(new Tooltip("Delay between each send"));

		// GUI Settings 

		GridPane layout = new GridPane();
		layout.setHgap(30);
		layout.setVgap(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		GridPane.setConstraints(inputDesc, 1, 2);
		GridPane.setConstraints(input, 2, 2);
		GridPane.setConstraints(amountDesc, 1, 4);
		GridPane.setConstraints(amount, 2, 4);
		GridPane.setConstraints(delayDesc, 1, 5);
		GridPane.setConstraints(delay, 2, 5);
		GridPane.setConstraints(enterDesc, 1, 6);
		GridPane.setConstraints(yesEnter, 2, 6);
		GridPane.setConstraints(charDesc, 1, 7);
		GridPane.setConstraints(yesType, 2, 7);
		GridPane.setConstraints(start, 1, 9);
		GridPane.setConstraints(stop, 2, 9);

		layout.setAlignment(Pos.TOP_CENTER);
		layout.getChildren().addAll(inputDesc, input, amountDesc, amount, delayDesc, delay, enterDesc, yesEnter,
				charDesc, yesType, start, stop);

		Scene scene = new Scene(layout, 600, 400);
		window.setX(1250);
		window.setY(50);
		window.setAlwaysOnTop(true);
		window.setScene(scene);
		window.show();

	}

	public String getInput() {
		return input.getText();

	}

	public int getAmount() {
		return Integer.parseInt(amount.getText());
	}

	public int getDelay() {
		return Integer.parseInt(delay.getText());
	}

	public boolean getClickEnter() {
		return yesEnter.isSelected();
	}
	
	public boolean getTypeKeys() {
		return yesType.isSelected();
	}

	public void setVisibility(boolean setting) {
		if (setting) {
			window.show();
		} else {
			window.hide();
		}
	}

	public void stopSpam() {
		stopSpam = true;
	}

}
