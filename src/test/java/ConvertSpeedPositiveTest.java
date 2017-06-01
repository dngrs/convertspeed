import com.convertspeed.SpeedUnit;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Igor Odokienko
 */
public class ConvertSpeedPositiveTest extends BaseTest {

   @Test
    public void checkMinSpeedValue(){
       double actualResult = convertSpeedsSoap.convertSpeed(0, SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.CENTIMETERS_PERSECOND);
       Assert.assertEquals(0, actualResult, 1e-15);
   }

    @Test
    public void checkMaxDoubleValue(){
        double actualResult = convertSpeedsSoap.convertSpeed(Double.MAX_VALUE, SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.KILOMETERS_PERHOUR);
        Assert.assertTrue(actualResult == Double.MAX_VALUE);
    }

    @Test
    public void checkResponseWhenSpeedIsGraterThenMaxDouble() {
        double actualResult = convertSpeedsSoap.convertSpeed(Double.MAX_VALUE, SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.CENTIMETERS_PERSECOND);
        Assert.assertTrue(Double.isInfinite(actualResult));
    }

    @Test
    public void checkResponseWhenInputSpeedIsNaN() {
        double actualResult = convertSpeedsSoap.convertSpeed(Double.NaN, SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.CENTIMETERS_PERSECOND);
        System.out.println(actualResult);
        Assert.assertTrue(Double.isNaN(actualResult));
    }

    @Test
    public void checkResponseWhenInputSpeedIsInfinity() {
        double actualResult = convertSpeedsSoap.convertSpeed(Double.POSITIVE_INFINITY, SpeedUnit.KILOMETERS_PERHOUR, SpeedUnit.CENTIMETERS_PERSECOND);
        Assert.assertTrue(Double.isInfinite(actualResult));
    }

}
