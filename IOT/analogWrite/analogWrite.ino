int ledpin = 9; //definition digital 9 pins as pin to control the LED
int ledpin1 = 10;
int ledpin2 = 11;
  
void setup ()
{
  pinMode(ledpin, OUTPUT); //Set digital 11 port mode, the OUTPUT for the output
  pinMode(ledpin1, OUTPUT);
  pinMode(ledpin2, OUTPUT);
}

void loop()
{
  for (int a = 0; a <= 255; a++) //Loop, PWM control of LED brightness increase
  {
    analogWrite(ledpin, a); //PWM output value a (0~255)
    analogWrite(ledpin1, a);
    analogWrite(ledpin2, a);
    delay(15); //The duration of the current brightness level. 15ms
  }
  
  for (int a = 255; a >= 0; a--) //Loop, PWM control of LED brightness Reduced
  {
    analogWrite(ledpin, a); //PWM output value a (255~0)
    analogWrite(ledpin1, a);
    analogWrite(ledpin2, a);
    delay(15); //The duration of the current brightness level. 15ms
  }
  delay(2000); //100ms delay
}
