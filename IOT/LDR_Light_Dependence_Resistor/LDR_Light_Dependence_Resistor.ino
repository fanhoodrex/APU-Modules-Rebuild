const int ledPin1 = 8;
const int ledPin2 = 9;
const int ldrPin = A0;

void setup() {
  Serial.begin(9600);
  pinMode(ledPin1, OUTPUT);
  pinMode(ledPin2, OUTPUT);
  pinMode(ldrPin, INPUT);
}
void loop() {
  int ldrStatus = analogRead(ldrPin);
  if (ldrStatus <= 200){ // Less then 200 Two LED on
    digitalWrite(ledPin1, HIGH);
    digitalWrite(ledPin2, HIGH);
    Serial.print("Its DARK, Turn on both the LED : ");
    Serial.println(ldrStatus);
  } 
  else if (200 < ldrStatus && ldrStatus <= 800){ // Between 201 and 800 One LED on
    digitalWrite(ledPin1, HIGH);
    digitalWrite(ledPin2, LOW);
    Serial.print("Its BRIGHT, Turn off one LED : ");
    Serial.println(ldrStatus);
  }
  else{ // More than 801, Both LED off
    digitalWrite(ledPin1, LOW);
    digitalWrite(ledPin2, LOW);
    Serial.print("Its BRIGHT, Turn off both LED : ");
    Serial.println(ldrStatus);
  }
}
