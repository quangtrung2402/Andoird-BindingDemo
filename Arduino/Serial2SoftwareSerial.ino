#include <SoftwareSerial.h>

SoftwareSerial mySerial(3, 2); // RX, TX
char receiveData;
void setup() {
  // Open serial communications and wait for port to open:
  Serial.begin(9600);
  while (!Serial) {
    ; // wait for serial port to connect. Needed for native USB port only
  }

  // set the data rate for the SoftwareSerial port
  mySerial.begin(9600);
}

void loop() { // run over and over
  if (mySerial.available()) {
    receiveData = mySerial.read();
    Serial.write(receiveData);
  }
  if (Serial.available()) {
    mySerial.write(Serial.read());
  }
}
