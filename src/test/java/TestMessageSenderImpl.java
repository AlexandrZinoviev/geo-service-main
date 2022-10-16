import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.entity.Country.RUSSIA;
import static ru.netology.entity.Country.USA;

public class TestMessageSenderImpl {
    @Test
    //проверим, что метод отправляет русский текст
    public void testSendRussianText() {
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp(GeoServiceImpl.MOSCOW_IP))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoServiceImpl,localizationServiceImpl);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String actual = messageSenderImpl.send(headers);
        String expected = "Добро пожаловать";
        Assert.assertEquals(expected, actual);
    }

    @Test
    //проверим, что метод отправляет аглийский текст
    public void testSendEnglishText() {
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp(GeoServiceImpl.NEW_YORK_IP))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceImpl.locale(USA))
                .thenReturn("Welcome");

        MessageSenderImpl messageSenderImpl = new MessageSenderImpl(geoServiceImpl,localizationServiceImpl);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String actual = messageSenderImpl.send(headers);
        String expected = "Welcome";
        Assert.assertEquals(expected, actual);

    }
}
