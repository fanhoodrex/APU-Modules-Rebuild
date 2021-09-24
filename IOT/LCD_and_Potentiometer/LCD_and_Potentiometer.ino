#include <LiquidCrystal.h>
LiquidCrystal lcd(8, 9, 10, 11, 12, 13);

void setup() {
  lcd.begin(16, 2);
}

void loop() {
  lcd.print("Arduino"); // Prints "Arduino" on the LCD
  delay(3000); // 3 seconds delay
  lcd.setCursor(2, 1); // Sets the location at which subsequent text written to the LCD will be displayed
  lcd.print("LCD Tutorial");
  delay(3000);
  lcd.clear(); // Clears the display
  lcd.blink(); //Displays the blinking LCD cursor
  delay(4000);
  lcd.setCursor(7, 1);
  delay(3000);
  lcd.noBlink(); // Turns off the blinking LCD cursor
  lcd.cursor(); // Displays an underscore (line) at the position to which the next character will be written
  delay(4000);
  lcd.noCursor(); // Hides the LCD cursor
  lcd.clear(); // Clears the LCD screen
  lcd.print("Origin Academy"); // Prints "Arduino" on the LCD
  delay(3000); // 3 seconds delay
  lcd.clear();
}
