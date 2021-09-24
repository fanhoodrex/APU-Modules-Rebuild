int buzzerPin = 9;
int echoPin = 12;
int trigPin = 13;
long duration = 0;
int distanceCM = 0;

void setup() {
  pinMode(echoPin, INPUT);
  pinMode(trigPin, OUTPUT);
  pinMode(buzzerPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  distanceCM = duration * 0.017175;
  Serial.print(distanceCM);
  Serial.println("cm");
  delay(1000);

  if (distanceCM < 150) {
    digitalWrite(9, 1);
    tone(buzzerPin, 500); // Send 1KHz sound signal...
  }
  else {
    digitalWrite(9, 0);
    noTone(buzzerPin); // Stop sound...
  }
}
