// Sample Java Card 2.2 Applet to show Counting Basics


package extendedapplet1;

import java.io.IOException;
import java.io.PrintWriter;

import javacard.framework.*;
import javacardx.framework.JCSystem;

public class Counter extends Applet {

   
    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new Counter();
    }

    protected Counter() {
        register();
    }

  
    @Override
    public void process(APDU apdu) {
        	
		byte[] buf = apdu.getBuffer();
		
		if(buf[ISO7816.OFFSET_CLA] != 0xAA)
			ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
		
		switch (buf[ISO7816.OFFSET_INS])
		{
		case (byte)0x01:
			break;
		case (byte)0x02:
			break;
		case (byte)0x03:
			break;
		default:
			ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
		}
    }
}
