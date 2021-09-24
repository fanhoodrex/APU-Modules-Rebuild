int pin[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}; // global declaration of array pin
int a, b;

void setup(){
  for (a = 0; a <= 11; a++) {// Setup all the pins as output at one line of code using for loop
    pinMode(pin[a], OUTPUT);
  }
}

void loop()
{
  for (b = 1; b <= 3; b++)
    example1();

  for (b = 1; b <= 3; b++)
    example2();

  for (b = 1; b <= 3; b++)
  {
    example3();
    example4();
  }
  for (b = 1; b <= 3; b++)
    example5();
}

void example1()// flash light from left to right
{
  for (b = 0; b <= 11; b++)
  {
    digitalWrite(pin[b], 1);
    delay(200);
  }
  all_off();
}
void example2()// flash light from right to left
{
  for (int b = 11; b >= 0; b--)
  {
    digitalWrite(pin[b], 1);
    delay(200);
  }
  all_off();
}

void example3()
{
  for (a = 0, b = 11; a <= 5, b >= 6; a++, b--)// Light up from outer to inner
  {
    digitalWrite(pin[a], 1);
    digitalWrite(pin[b], 1);
    delay(200);
  }

  all_off();
}

void example4() //Light up from outer to inner
{
  for (a = 5, b = 6; a >= 0, b <= 11; a--, b++)
  {
    digitalWrite(pin[a], 1);
    digitalWrite(pin[b], 1);
    delay(200);
  }

  all_off();
}

void example5()
{
  for (int a = 0; a <= 11; a += 2)
  {
    digitalWrite(pin[a], 1);
  }
  delay(300);
  all_off();

  for (int a = 1; a <= 11; a = a + 2)
  {
    digitalWrite(pin[a], 1);
  }
  delay(300);
  all_off();
}

void all_off() // Off all the LED
{
  for (b = 0; b <= 11; b++){
    digitalWrite(pin[b], 0);
  }
  delay(100);
}
