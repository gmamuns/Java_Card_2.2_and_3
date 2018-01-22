

package extendedapplet1;

import java.io.IOException;
import java.io.PrintWriter;

import javacard.framework.*;
import javacardx.framework.JCSystem;
/**
 *
 * @author DELL
 */
public class JavaCardExtendedApplet extends Applet {
    private final static byte [] hello = {0x48,0x65,0x6c,0x6c,0x6f};

  
    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new JavaCardExtendedApplet().register();
    }

    protected JavaCardExtendedApplet() {
        register();
    }

  
    @Override
    public void process(APDU apdu) {
        byte[] buf = apdu.getBuffer();
        switch(ISO7816.OFFSET_INS){
            case 0x40:
                Util.arrayCopy(hello,(byte)0,buf,ISO7816.OFFSET_CDATA,(byte)5);
                apdu.setOutgoingAndSend(ISO7816.OFFSET_CDATA,(byte)5);
                break;
            default:
                ISOException.throwIt(ISO7816.SW_WRONG_DATA);
                
       
        }
    }
}
