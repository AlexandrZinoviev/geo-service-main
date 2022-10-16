import org.junit.Assert;
import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class TestGeoServiceImpl {
    @Test
    //проверим, что по IP, метод находит верный адрес
    public void byIpMoscow() {
        GeoServiceImpl geo = new GeoServiceImpl();
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location actual = geo.byIp(GeoServiceImpl.MOSCOW_IP);
        Assert.assertEquals(expected, actual);
    }

    @Test
    //проверим, что по IP, метод находит верный адрес
    public void byIpUSA() {
        GeoServiceImpl geo = new GeoServiceImpl();
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);
        Location actual = geo.byIp(GeoServiceImpl.NEW_YORK_IP);
        Assert.assertEquals( expected, actual);

    }
}
