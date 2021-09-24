void setup()
{
  Serial.begin (9600);
}
void loop()
{
  int Dout = analogRead(A0);
  float Vin = (Dout * 0.00488);
  Serial.print("voltage : ");
  Serial.println(Vin);
  delay(3000);
  if (Vin < 2.5)
  {
    Serial.println("Low Voltage!");
    Serial.println();
  }
  else
  {
    Serial.println("High Voltage!");
    Serial.println();
  }
}
