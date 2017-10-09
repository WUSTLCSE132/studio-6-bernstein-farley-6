const int buttonPin = 2;
unsigned int count = 0;

//debounce variables
int buttonState;             // the current reading from the input pin
int lastButtonState = LOW;   // the previous reading from the input pin
unsigned long lastDebounceTime = 0;  // the last time the output pin was toggled
unsigned long debounceDelay = 50;    // the debounce time; increase if the output flickers


void buttonPressed() {
  int reading = digitalRead(buttonPin);
  if(reading != lastButtonState){
    lastDebounceTime = millis();  
  }
  if((millis() - lastDebounceTime) > debounceDelay){
    if(buttonState == LOW){
       Serial.println("Interrupt");
       count += 1;
       Serial.print("Button has been pressed ");
       Serial.print(count);
       Serial.println(" time(s)");
    }
  }
  lastButtonState = reading;
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  // Interrupts can happen on "edges" of signals.  
  // Three edge types are supported: CHANGE, RISING, and FALLING 
  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, FALLING);
  Serial.begin(9600);
}

void loop() {
  for(int i=0;i<100;i++) {
    Serial.println(i);
    delay(1000);
  }
}
