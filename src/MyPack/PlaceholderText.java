package MyPack;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class PlaceholderText extends FocusAdapter{
	
	private String pcholderText;
	private JTextField textField;
	
	
	public PlaceholderText(String pcholderText, JTextField textField) {
		this.pcholderText = pcholderText;
		this.textField = textField;
	}
	
	public void focusGained(FocusEvent e) {
		if(textField.getText().equals(pcholderText)) {
		   textField.setText("");
		}
	}
	
	public void focusLost(FocusEvent e) {
		if(textField.getText().isEmpty()) {
		   textField.setText(pcholderText);
		}
		
	}

}
