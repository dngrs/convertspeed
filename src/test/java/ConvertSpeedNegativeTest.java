import com.convertspeed.SpeedUnit;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.ws.soap.SOAPFaultException;

/**
 * Created by Igor Odokienko
 */
public class ConvertSpeedNegativeTest extends BaseTest {

    @Test(expected = SOAPFaultException.class)
    public void checkResponseWithoutSpeedParameter() {
        try {
            convertSpeedsSoap.convertSpeed(SpeedUnit.CENTIMETERS_PERSECOND, SpeedUnit.KILOMETERS_PERHOUR);
        } catch (SOAPFaultException e) {
            Assert.assertTrue(e.getMessage().contains("Speed parameter is missed in request"));
            throw e;
        }
    }

    @Test(expected = SOAPFaultException.class)
    public void checkResponseWithNegativeSpeed() {
        try {
            convertSpeedsSoap.convertSpeed(-10, SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.MILES_PERHOUR);
        } catch (SOAPFaultException e) {
            Assert.assertTrue(e.getMessage().contains("Speed cannot be negative"));
            throw e;
        }
    }

    @Test(expected = SOAPFaultException.class)
    public void checkResponseWithIncorrectFromUnitValue() {
        try {
            convertSpeedsSoap.convertSpeed(100, SpeedUnit.TEST, SpeedUnit.MILES_PERHOUR);
        } catch (SOAPFaultException e) {
            Assert.assertTrue(e.getMessage().contains("'Test' is not a valid value for SpeedUnit"));
            throw e;
        }
    }

    @Test(expected = SOAPFaultException.class)
    public void checkResponseWithIncorrectToUnitValue() {
        try {
            convertSpeedsSoap.convertSpeed(100, SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.TEST);
        } catch (SOAPFaultException e) {
            Assert.assertTrue(e.getMessage().contains("'Test' is not a valid value for SpeedUnit"));
            throw e;
        }
    }

    @Test(expected = SOAPFaultException.class)
    public void checkResponseWithoutFromUnitParameter() {
        try {
            convertSpeedsSoap.convertSpeed(100, null, SpeedUnit.KILOMETERS_PERHOUR);
        } catch (SOAPFaultException e) {
            Assert.assertTrue(e.getMessage().contains("FromUnit parameter is missed in request"));
            throw e;
        }
    }

    @Test(expected = SOAPFaultException.class)
    public void checkResponseWithoutToUnitParameter() {
        try {
            convertSpeedsSoap.convertSpeed(100, SpeedUnit.KILOMETERS_PERHOUR, null);
        } catch (SOAPFaultException e) {
            Assert.assertTrue(e.getMessage().contains("ToUnit parameter is missed in request"));
            throw e;
        }
    }

    @Test(expected = SOAPFaultException.class)
    public void checkInjectionOfSpeedParameterAsString() {
        try {
            convertSpeedsSoap.convertSpeed("100", SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.MILES_PERHOUR);
        } catch (SOAPFaultException e) {
            Assert.assertTrue(e.getMessage().contains("'qwe' is not a valid value for Speed parameter"));
            throw e;
        }
    }

}
