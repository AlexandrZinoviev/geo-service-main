import org.junit.Assert;
import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class TestLocalizationService {
    @Test
    //провеим, что сообщение выдается на русском
    public void testLocaleRussia() {
        LocalizationServiceImpl loc = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        String result = loc.locale(Country.RUSSIA);
        Assert.assertEquals(expected,result);
    }

    @Test
    //провеим, что сообщение выдается на английском
    public void testLocaleAnotherCountry() {
        LocalizationServiceImpl loc = new LocalizationServiceImpl();
        String expected = "Welcome";
        String result = loc.locale(Country.USA);
        Assert.assertEquals(expected,result);
    }

}
