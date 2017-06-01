import com.convertspeed.SpeedUnit;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Igor Odokienko
 */

@RunWith(JUnitParamsRunner.class)
public class ConvertSpeedDataDrivenTest extends BaseTest{

    @Test
    @FileParameters(value = "src/main/resources/checkSpeedConversion.csv", mapper = CsvWithHeaderMapper.class)
    public void checkSpeedConversion(double speed, String fromUnit, String toUnit, double expectedResult){
        double actualResult = convertSpeedsSoap.convertSpeed(speed, SpeedUnit.valueOf(fromUnit),SpeedUnit.valueOf(toUnit));
        Assert.assertEquals(expectedResult, actualResult, 0.00001);
    }

}
