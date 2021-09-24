int E = 13;
int D = 12;
int C = 11;
int DP = 10;
int B = 9;
int A = 8;
int F = 7;
int G = 6;

void s0()
{
  digitalWrite(E, LOW);
  digitalWrite(D, LOW);
  digitalWrite(C, LOW);
  digitalWrite(DP, HIGH);
  digitalWrite(B, LOW);
  digitalWrite(A, LOW);
  digitalWrite(F, LOW);
  digitalWrite(G, HIGH);
}

void s1()
{
  digitalWrite(E, HIGH);
  digitalWrite(D, HIGH);
  digitalWrite(C, LOW);
  digitalWrite(DP, HIGH);
  digitalWrite(B, LOW);
  digitalWrite(A, HIGH);
  digitalWrite(F, HIGH);
  digitalWrite(G, HIGH);
}

void s2()
{
  digitalWrite(E, LOW);
  digitalWrite(D, LOW);
  digitalWrite(C, HIGH);
  digitalWrite(DP, HIGH);
  digitalWrite(B, LOW);
  digitalWrite(A, LOW);
  digitalWrite(F, HIGH);
  digitalWrite(G, LOW);
}

void s3()
{
  digitalWrite(E, HIGH);
  digitalWrite(D, LOW);
  digitalWrite(C, LOW);
  digitalWrite(DP, HIGH);
  digitalWrite(B, LOW);
  digitalWrite(A, LOW);
  digitalWrite(F, HIGH);
  digitalWrite(G, LOW);
}

void s4()
{
  digitalWrite(E, HIGH);
  digitalWrite(D, HIGH);
  digitalWrite(C, LOW);
  digitalWrite(DP, HIGH);
  digitalWrite(B, LOW);
  digitalWrite(A, HIGH);
  digitalWrite(F, LOW);
  digitalWrite(G, LOW);
}

void s5()
{
  digitalWrite(E, HIGH);
  digitalWrite(D, LOW);
  digitalWrite(C, LOW);
  digitalWrite(DP, HIGH);
  digitalWrite(B, HIGH);
  digitalWrite(A, LOW);
  digitalWrite(F, LOW);
  digitalWrite(G, LOW);
}

void s6()
{
  digitalWrite(E, LOW);
  digitalWrite(D, LOW);
  digitalWrite(C, LOW);
  digitalWrite(DP, HIGH);
  digitalWrite(B, HIGH);
  digitalWrite(A, LOW);
  digitalWrite(F, LOW);
  digitalWrite(G, LOW);
}

void s7()
{
  digitalWrite(E, HIGH);
  digitalWrite(D, HIGH);
  digitalWrite(C, LOW);
  digitalWrite(DP, HIGH);
  digitalWrite(B, LOW);
  digitalWrite(A, LOW);
  digitalWrite(F, HIGH);
  digitalWrite(G, HIGH);
}

void s8()
{
  digitalWrite(E, LOW);
  digitalWrite(D, LOW);
  digitalWrite(C, LOW);
  digitalWrite(DP, HIGH);
  digitalWrite(B, LOW);
  digitalWrite(A, LOW);
  digitalWrite(F, LOW);
  digitalWrite(G, LOW);
}

void s9()
{
  digitalWrite(E, HIGH);
  digitalWrite(D, LOW);
  digitalWrite(C, LOW);
  digitalWrite(DP, HIGH);
  digitalWrite(B, LOW);
  digitalWrite(A, LOW);
  digitalWrite(F, LOW);
  digitalWrite(G, LOW);
}

void s10()
{
  digitalWrite(E, LOW);
  digitalWrite(D, HIGH);
  digitalWrite(C, HIGH);
  digitalWrite(DP, LOW);
  digitalWrite(B, HIGH);
  digitalWrite(A, HIGH);
  digitalWrite(F, LOW);
  digitalWrite(G, HIGH);
}

void setup()
{
  pinMode(E, OUTPUT);
  pinMode(D, OUTPUT);
  pinMode(C, OUTPUT);
  pinMode(DP, OUTPUT);
  pinMode(B, OUTPUT);
  pinMode(A, OUTPUT);
  pinMode(F, OUTPUT);
  pinMode(G, OUTPUT);
}

void loop()
{

  int SensorValue = analogRead(A0) / 100;
  switch (SensorValue)
  {
    case 0: s0(); break;
    case 1: s1(); break;
    case 2: s2(); break;
    case 3: s3(); break;
    case 4: s4(); break;
    case 5: s5(); break;
    case 6: s6(); break;
    case 7: s7(); break;
    case 8: s8(); break;
    case 9: s9(); break;
    case 10: s10(); break;
    default: break;
  }
  delay(500);
}
