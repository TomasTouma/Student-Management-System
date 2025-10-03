/**
 * 
 * @author Tomasz Touma
 * @version 1.0
 * @since 1.8
 * 
 *        <b>ValidationAndCalculationMethods</b> class provides common validation
 *        and calculation utilities for user input in text fields and key events.
 *        It helps prevent invalid characters in input, validates numbers, and
 *        provides basic rounding for monetary values.
 * 
 */
package my.val;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Utility class containing methods for input validation and rounding.
 * All methods are static and can be called without instantiating the class.
 */
public class ValidationAndCalculationMethods {

     /**
     * Validate if a given string can be parsed into an integer.
     * Displays a dialog message if the value is not valid.
     * 
     * @param value the string to validate
     * @return integer value if valid, otherwise returns 0
     */
    public static int validateInteger(String value) {
        int number = 0;
        try {
            number = Integer.parseInt(value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input a value in text field");
        }
        return number;
    }

    /**
     * Validate if a given string can be parsed into a double.
     * Displays a dialog message if the value is not valid.
     * 
     * @param value the string to validate
     * @return double value if valid, otherwise returns 0.0
     */
    public static double validateDouble(String value) {
        double number = 0.0;
        try {
            number = Double.parseDouble(value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input a value in text field");
        }
        return number;
    }
    
    
    /**
     * Ensures that only letters and spaces are allowed when typing into a text field.
     * Consumes invalid key events.
     *  
     * @param evt the KeyEvent to validate
     */
    public static void ValidateLetter(java.awt.event.KeyEvent evt){
        char keyTyped = evt.getKeyChar();
        if (!(Character.isLetter(keyTyped)||Character.isSpaceChar(keyTyped))){        
   
            evt.consume();
        }
        
    }
    
    /**
     * Ensures that only letters and digits are allowed in a text field.
     * Consumes invalid key events.
     * 
     * @param evt the KeyEvent to validate
     */
    public static void ValidateDigitAndLetter(java.awt.event.KeyEvent evt){
        char keyTyped = evt.getKeyChar();
        if (!(Character.isLetter(keyTyped)||Character.isDigit(keyTyped))){        
   
            evt.consume();
        }
    }
    
     /**
     * Ensures that only digits and a dot (for decimal values) are allowed in input.
     * Consumes invalid key events.
     * 
     * @param evt the KeyEvent to validate
     */
    public static void ValidateDigit(java.awt.event.KeyEvent evt){
        char keyTyped = evt.getKeyChar();
        if (!(Character.isDigit(keyTyped)||isDot(keyTyped))){        
   
            evt.consume();
        }
    }
    
    /**
     * Helper method to check if a character is a dot ('.').
     * 
     * @param keyTyped the character to check
     * @return true if the character is '.', otherwise false
     */
    public static boolean isDot(char keyTyped){
        if (keyTyped == '.'){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Rounds a double value to two decimal places (useful for monetary values).
     * 
     * @param money the value to round
     * @return rounded value with two decimals
     */
    public static double roundMoney(double money){
        double roundMoney =0.0;
        roundMoney = Math.round(money*100.0)/100.0;
        return roundMoney;
    }
    
    /**
     * Displays a non-blocking, temporary message dialog that automatically closes 
     * after a specified time. The dialog is always shown on top of all other windows 
     * and does not include an "OK" button.
     * <p>
     * This method is useful for showing short status or confirmation messages 
     * (e.g., login success, data saved) without requiring user interaction.
     * </p>
     * 
     * @author Tomasz Touma
     * @version 1.0
     * @since 1.8
     * 
     * @param parent     the parent component of the dialog; can be {@code null} 
     *                   to center the dialog on the screen
     * @param message    the message text to display
     * @param title      the title of the dialog window
     * @param messageType the type of message (e.g., {@link JOptionPane#INFORMATION_MESSAGE}, 
     *                   {@link JOptionPane#ERROR_MESSAGE})
     * @param timeMillis the duration in milliseconds before the dialog automatically closes
     */
    public static void showTimedMessage(Component parent, String message, String title, int messageType, int timeMillis) {
       // Create JOptionPane with NO buttons
        final JOptionPane optionPane = new JOptionPane(
                message,
                messageType,
                JOptionPane.DEFAULT_OPTION,
                null,
                new Object[]{}, // no buttons
                null);

        final JDialog dialog = optionPane.createDialog(parent, title);
        dialog.setModal(false);        // non-blocking
        dialog.setAlwaysOnTop(true);   // 🔹 force on top
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Timer to auto-close
        new Timer(timeMillis, e -> dialog.dispose()).start();

        dialog.setVisible(true);
    }
}
