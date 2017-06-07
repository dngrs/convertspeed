import com.convertspeed.ConvertSpeeds;
import com.convertspeed.ConvertSpeedsSoap;
import com.convertspeed.SpeedUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.HeaderHandler;
import utils.SoapClientHandlerLog;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor Odokienko
 */
public class ConvertSpeedSecurityTokenTest {

    ConvertSpeeds convertSpeeds;
    ConvertSpeedsSoap convertSpeedsSoap;

    @Before
    public void setUp(){

        convertSpeeds = new ConvertSpeeds();
        convertSpeeds.setHandlerResolver(new HandlerResolver() {
            @Override
            public List<Handler> getHandlerChain(PortInfo portInfo) {
                List<Handler> hchain = new ArrayList<>();
                hchain.add(new HeaderHandler());
                hchain.add(new SoapClientHandlerLog());
                return hchain;
            }
        });

        convertSpeedsSoap = convertSpeeds.getConvertSpeedsSoap();

    }

    @Test(expected = SOAPFaultException.class)
    public void checkResponseWhenUserTokenIsAdded(){
        try {
            convertSpeedsSoap.convertSpeed(100, SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.MILES_PERHOUR);
        } catch (SOAPFaultException e) {
            Assert.assertTrue(e.getMessage().contains("SOAP header Security was not understood"));
            throw e;
        }
    }

}
