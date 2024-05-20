
import org.example.BookingManager;
import org.example.HotelDao;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingManagerTest {

    private HotelDao hotelDaoMock;
    private BookingManager bookingManager;

    @Before
    public void setup() throws SQLException {

        // Create a mock instance of the HotelDao class using Mockito.
        hotelDaoMock = mock(HotelDao.class);
        // Instantiate BookingManager with the mocked HotelDao.
        bookingManager = new BookingManager(hotelDaoMock);

        // Create a list of available room IDs for testing.
        List<String> availableRooms = Arrays.asList("A202", "A203", "A204");

        // Define the behavior of the mock: when fetchAvailableRooms is called on the mock,
        // it will return the predefined list of available rooms.
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);

    }

   @Test
    public void bookingManager_CheckAvailableRoomsTrue() throws SQLException {
        assertTrue(bookingManager.checkRoomAvailability("A204"));
    }

    @Test
    public void bookingManager_checkAvailableRoomsFalse() throws SQLException {
        assertFalse(bookingManager.checkRoomAvailability("A205"));
    }
}