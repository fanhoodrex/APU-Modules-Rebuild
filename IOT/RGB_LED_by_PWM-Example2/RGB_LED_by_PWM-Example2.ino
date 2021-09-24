void setup()
{
  Serial.begin(9600);
  Serial.println("R LED Red On");
  Serial.println("r LED Red Off\n");
  Serial.println("G LED Red On");
  Serial.println("g LED Red Off\n");
  Serial.println("B LED Red On");
  Serial.println("b LED Red Off\n");
  Serial.println("Enter Your Chooice..");

  for (int a = 2; a <= 4; a++)
    pinMode(a, OUTPUT);
}

void loop()
{
  // read the sensor:
  if (Serial.available() > 0)
  {
    int inByte = Serial.read();
    switch (inByte)
    {
      case 'R':
        digitalWrite(2, 1);
        break;

      case 'r':
        digitalWrite(2, 0);
        break;

      case 'G':
        digitalWrite(3, 1);
        break;

      case 'g':
        digitalWrite(3, 0);
        break;

      case 'B':
        digitalWrite(4, 1);
        break;

      case 'b':
        digitalWrite(4, 0);
        break;
    }
  }
}
