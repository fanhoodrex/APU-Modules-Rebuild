void setup()
{
  for (int a = 2; a <= 13; a++)
  pinMode(a, OUTPUT);
}

void loop()
{
  for (int a = 2; a <= 13; a++){
    digitalWrite(a, 1);
    delay(50);
    digitalWrite(a, 0);
    delay(50);
  }
  for (int a = 13; a >= 2; a--){
    digitalWrite(a,1);
    delay(50);
    digitalWrite(a,0);
    delay(50);
  }
}
