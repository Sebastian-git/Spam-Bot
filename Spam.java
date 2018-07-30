import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/*
 * Take input on what to spam, how many times,
 * and the delay between the spams, then type
 * it out onto whatever window that is open in
 * 3 seconds.
 * 
 */

public class Spam {

	private GUI gui;
	public Robot robot;
	public boolean spam;

	public Spam(GUI gui) {
		this.gui = gui;
	}

	public void run() {

		String word = gui.getInput();
		int amount = gui.getAmount();
		int delay = gui.getDelay();

		try {
			robot = new Robot();
			stringConverter(robot, word, amount, delay);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public void stringConverter(Robot robot, String word, int amount, int delay) {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		StringSelection stringSelection = new StringSelection(word);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
		int counter = 0;
		while (counter < amount) {
			if (spam) {
				System.out.println(gui.getTypeKeys());
				if (gui.getTypeKeys()) {
					System.out.println(word);
					for (char c : word.toCharArray()) {
						System.out.println(c);
						if (c == '|' || c == '"' || c == '*' || c == '(' || c == ')' || c == '}' || c == '{' || c == ':'
								|| c == '+' || c == '_' || c == '?' || c == '!' || c == '@' || c == '#' || c == '$'
								|| c == '%' || c == '^' || c == '&' || c == '~' || c == '<' || c == '>') {
							specialChars(c);
						} else {
							int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
							if (Character.isUpperCase(c)) {
								robot.keyPress(KeyEvent.VK_SHIFT);
							} 
							robot.keyPress(keyCode);
							robot.keyRelease(keyCode);
							if (Character.isUpperCase(c)) {
								robot.keyRelease(KeyEvent.VK_SHIFT);
							}
						}
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else {
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_V);
					robot.keyRelease(KeyEvent.VK_CONTROL);
					robot.keyRelease(KeyEvent.VK_V);
				}
				if (gui.getClickEnter()) {
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
				}
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				counter++;
			} else {
				break;
			}
		}
	}

	public void specialChars(char c) {
		int shiftCode = KeyEvent.VK_SHIFT;
		if (c == '|') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_BACK_SLASH);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_BACK_SLASH);
		} else if (c == '"') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_QUOTE);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_QUOTE);
		} else if (c == '*') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_8);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_8);
		} else if (c == '(') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_9);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_9);
		} else if (c == ')') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_0);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_0);
		} else if (c == '{') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
		} else if (c == '}') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
		} else if (c == ':') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_SEMICOLON);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_SEMICOLON);
		} else if (c == '+') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_EQUALS);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_EQUALS);
		} else if (c == '_') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_MINUS);
		} else if (c == '?') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_SLASH);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_SLASH);
		} else if (c == '!') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_1);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_1);
		} else if (c == '@') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_2);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_2);
		} else if (c == '#') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_3);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_3);
		} else if (c == '$') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_4);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_4);
		} else if (c == '%') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_5);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_5);
		} else if (c == '^') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_6);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_6);
		} else if (c == '&') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_7);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_7);
		} else if (c == '~') {
			robot.keyPress(shiftCode);
			robot.keyPress(192);
			robot.keyRelease(shiftCode);
			robot.keyRelease(192);
		} else if (c == '<') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_COMMA);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_COMMA);
		} else if (c == '>') {
			robot.keyPress(shiftCode);
			robot.keyPress(KeyEvent.VK_PERIOD);
			robot.keyRelease(shiftCode);
			robot.keyRelease(KeyEvent.VK_PERIOD);
		}
	}
}
