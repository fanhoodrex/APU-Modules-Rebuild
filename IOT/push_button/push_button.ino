int LED[] = {8, 9, 10};
int Button = 4;

void setup()
{
  pinMode(2, INPUT_PULLUP);
  for (int x = 0; x <= 2; x++)
    pinMode(LED[x], OUTPUT);
}

void loop()
{
  if (digitalRead(Button) == LOW)
  {
    for (int x = 0; x <= 2; x++)
    {
      digitalWrite(LED[x], HIGH);
      delay(1000);
    }
  }
  else if (digitalRead(Button) == HIGH)
    for (int x = 0; x <= 2; x++)
    {
      digitalWrite(LED[x], LOW);
    }
}
