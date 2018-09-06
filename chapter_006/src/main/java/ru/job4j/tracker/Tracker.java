package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 * Class Tracker.
 *
 * @author Tatyana Belova
 * @since 24.08.2018
 */
public class Tracker implements AutoCloseable {

    private static final Logger log = LoggerFactory.getLogger(SQLStorage.class);
    private Connection conn = null;
    /**
     * путь к папке с исходниками.
     */
    private String basePath;
    /**
     * запрос на добавление заявки.
     */
    private String addQuery;
    /**
     * запрос на изменение заявки.
     */
    private String updateQuery;
    /**
     * запрос на поиск заявки по id.
     */
    private String findByIdQuery;
    /**
     * запрос на поиск заявки по имени.
     */
    private String findByNameQuery;
    /**
     * запрос на удаление заявки.
     */
    private String deleteQuery;
    /**
     * запрос на вывод всех заявок.
     */
    private String getAllQuery;

    /**
     * конструктор.
     *
     * @throws FileNotFoundException
     * @throws SQLException
     */
    public Tracker() throws FileNotFoundException, SQLException {
        this.basePath = basePath;
        Properties props = new Properties();
        String url = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try (Scanner scanner = new Scanner(new File(classLoader.getResource("start.txt").getFile()))) {
            url = scanner.nextLine();
            String userName = scanner.nextLine();
            String pass = scanner.nextLine();
            props.setProperty("user", userName);
            props.setProperty("password", pass);
            addQuery = scanner.nextLine();
            updateQuery = scanner.nextLine();
            findByIdQuery = scanner.nextLine();
            findByNameQuery = scanner.nextLine();
            deleteQuery = scanner.nextLine();
            getAllQuery = scanner.nextLine();
            conn = DriverManager.getConnection(url, props);
            try (Statement st = conn.createStatement()) {

                st.execute("CREATE TABLE IF NOT EXISTS Items(id serial primary key, userName varchar(100), description varchar(100), created DATE, comments text)");
            }
        }
    }

    /**
     * метод добавляет заявку.
     *
     * @param item - добавляемая заявка
     * @return item
     */
    public Item add(Item item) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement(addQuery)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setDate(3, item.getCreated());
            st.setString(4, item.getComments());
            st.executeUpdate();
        }
        return item;
    }

    /**
     * метод обновляет содержимое заявки.
     *
     * @param item - добавляемая заявка
     */
    public void update(Item item) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement(updateQuery)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setString(3, item.getComments());
            st.setInt(4, item.getId());
            st.executeUpdate();
        }
    }

    /**
     * метод ищет заявку по ключу.
     *
     * @param id - ключ
     * @return item
     */
    public Item findById(int id) throws SQLException {
        Item item = null;
        try (PreparedStatement st = conn.prepareStatement(findByIdQuery)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    item = new Item();
                    item.setId(id);
                    item.setName(rs.getString(2));
                    item.setDescription(rs.getString(3));
                    item.setComments(rs.getString(5));
                    item.setCreated(rs.getDate(4));
                }
            }
        }
        return item;
    }

    /**
     * метод ищет заявку по имени.
     *
     * @param name - имя
     * @return finder
     */
    public ArrayList<Item> findByName(String name) throws SQLException {
        ArrayList<Item> finder = new ArrayList<>();
       try (PreparedStatement st = conn.prepareStatement(findByNameQuery)) {
           st.setString(1, name);
           try (ResultSet rs = st.executeQuery()) {
               while (rs.next()) {
                   Item item = new Item();
                   item.setId(rs.getInt(1));
                   item.setName(rs.getString(2));
                   item.setDescription(rs.getString(3));
                   item.setComments(rs.getString(5));
                   item.setCreated(rs.getDate(4));
                   finder.add(item);
               }
           }
       }
       return finder;
    }

    /**
     * метод удаляет заявку по ключу.
     *
     * @param id - ключ
     */
    public void delete(int id) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement(deleteQuery)) {
            st.setInt(1, id);
            st.executeUpdate();
        }

    }

    /**
     * метод возвращает список все заявок.
     *
     * @return finder
     */
    public ArrayList<Item> getAll() throws SQLException {
        ArrayList<Item> finder = new ArrayList<>();
        try (PreparedStatement st = conn.prepareStatement(getAllQuery)) {
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setId(rs.getInt(1));
                    item.setName(rs.getString(2));
                    item.setDescription(rs.getString(3));
                    item.setComments(rs.getString(5));
                    item.setCreated(rs.getDate(4));
                    finder.add(item);
                }
            }
        }

        return finder;
    }

    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * {@code try}-with-resources statement.
     * <p>
     * <p>While this interface method is declared to throw {@code
     * Exception}, implementers are <em>strongly</em> encouraged to
     * declare concrete implementations of the {@code close} method to
     * throw more specific exceptions, or to throw no exception at all
     * if the close operation cannot fail.
     * <p>
     * <p> Cases where the close operation may fail require careful
     * attention by implementers. It is strongly advised to relinquish
     * the underlying resources and to internally <em>mark</em> the
     * resource as closed, prior to throwing the exception. The {@code
     * close} method is unlikely to be invoked more than once and so
     * this ensures that the resources are released in a timely manner.
     * Furthermore it reduces problems that could arise when the resource
     * wraps, or is wrapped, by another resource.
     * <p>
     * <p><em>Implementers of this interface are also strongly advised
     * to not have the {@code close} method throw {@link
     * InterruptedException}.</em>
     * <p>
     * This exception interacts with a thread's interrupted status,
     * and runtime misbehavior is likely to occur if an {@code
     * InterruptedException} is {@linkplain Throwable#addSuppressed
     * suppressed}.
     * <p>
     * More generally, if it would cause problems for an
     * exception to be suppressed, the {@code AutoCloseable.close}
     * method should not throw it.
     * <p>
     * <p>Note that unlike the {@link Closeable#close close}
     * method of {@link Closeable}, this {@code close} method
     * is <em>not</em> required to be idempotent.  In other words,
     * calling this {@code close} method more than once may have some
     * visible side effect, unlike {@code Closeable.close} which is
     * required to have no effect if called more than once.
     * <p>
     * However, implementers of this interface are strongly encouraged
     * to make their {@code close} methods idempotent.
     *
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}