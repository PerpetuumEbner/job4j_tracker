package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    static Connection connection;

    @BeforeClass
    public static void init() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Ignore
    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Ignore
    @Test
    public void createItem() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("name"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Ignore
    @Test
    public void whenReplace() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = new Item("name");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Name with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Name with description"));
    }

    @Ignore
    @Test
    public void whenFindAll() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("name");
        tracker.add(itemOne);
        Item itemTwo = new Item("id");
        tracker.add(itemTwo);
        List<Item> result = tracker.findAll();
        assertThat(result.size(), is(2));
    }

    @Ignore
    @Test
    public void whenFindByName() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("name");
        tracker.add(item);
        List<Item> expected = new ArrayList<>();
        expected.add(item);
        List<Item> result = tracker.findByName("name");
        assertThat(result, is(expected));
    }

    @Ignore
    @Test
    public void whenFindById() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("name");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Ignore
    @Test
    public void whenDelete() throws Exception {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = new Item("name");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}