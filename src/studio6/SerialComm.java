package studio6;

import jssc.*;

public class SerialComm {

	static SerialPort port;

	private static boolean debug;  // Indicator of "debugging mode"
	static boolean a;
	static byte[] c;


	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	


	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
				SerialPort.DATABITS_8,
				SerialPort.STOPBITS_1,
				SerialPort.PARITY_NONE);

		debug = false; // Default is to NOT be in debug mode
	}



	// TODO: Add writeByte() method from Studio 5
	public static boolean writeByte(byte b){
		while(debug == true){
			try {
				a = port.writeByte(b);
			} catch (SerialPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(a);
			return a;
		}
		return a;

	}


	// TODO: Add available() method
	public static boolean available(byte b){
		while(debug == true){
			try{
				if(port.getInputBufferBytesCount() > 0){
					a = true;
				}
			}
			catch(SerialPortException e){
				e.printStackTrace();
			}
		}
		return a;
	}



	// TODO: Add readByte() method	
	public static byte[] readbyte(byte b){
		while(debug == true){
			try{
				c = port.readBytes();
			}
			catch(SerialPortException e){
				e.printStackTrace();
			}
		}
		return c;
	}



	// TODO: Add a main() method
	static void main(){
		SerialComm port;
		while(true){
			SerialComm.available(b);
		}
	}

}
