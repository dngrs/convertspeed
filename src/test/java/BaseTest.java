import com.convertspeed.ConvertSpeeds;
import com.convertspeed.ConvertSpeedsSoap;
import org.junit.Before;
import utils.JaxWsHandlerResolver;

/**
 * Created by Igor Odokienko
 */
public class BaseTest {

    ConvertSpeeds convertSpeeds;
    ConvertSpeedsSoap convertSpeedsSoap;

    @Before
    public void setUp(){
        convertSpeeds = new ConvertSpeeds();
        convertSpeeds.setHandlerResolver(new JaxWsHandlerResolver());
        convertSpeedsSoap = convertSpeeds.getConvertSpeedsSoap();
    }

}
