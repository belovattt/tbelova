package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    /**
     * logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(SQLStorage.class);
    /**
     * connection.
     */
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
     * @throws FileNotFoundException FileNotFoundException
     * @throws SQLException SQLException
     */
    public Tracker() throws FileNotFoundException, SQLException {
        this.basePath = basePath;
        Properties props = new Properties();
        String url = "";
        ClassLoader classLoader = getClass().getClassLoader();
        try (Scanner scanner = new Scanner(new File(
                classLoader.getResource("start.txt").getFile()))) {
            url = scanner.nextLine();
            String userName = scanner.nextLine();
            String pass = scanner.nextLine();
            props.setProperty("user", userName);
            props.setProperty("password", pass);
            addQuery = Queries.ADDQUERY;
            updateQuery = Queries.UPDATEQUERY;
            findByIdQuery = Queries.FINDBYIDQUERY;
            findByNameQuery = Queries.FINDBYNAMEQUERY;
            deleteQuery = Queries.DELETEQUERY;
            getAllQuery = Queries.GETALLQUERY;
            conn = DriverManager.getConnection(url, props);
            try (Statement st = conn.createStatement()) {
                st.execute(Queries.CREATETABLE);
            }
        }
    }

    /**
     * метод добавляет заявку.
     *
     * @param item - добавляемая заявка
     * @return item
     * @throws SQLException SQLException
     */
    public final Item add(final Item item) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement(addQuery)) {
            st.setString(Queries.ONE, item.getName());
            st.setString(Queries.TWO, item.getDescription());
            st.setDate(Queries.THREE, item.getCreated());
            st.setString(Queries.FOUR, item.getComments());
            st.executeUpdate();
        }
        return item;
    }

    /**
     * метод обновляет содержимое заявки.
     *
     * @param item - добавляемая заявка
     * @throws SQLException SQLException
     */
    public final void update(final Item item) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement(updateQuery)) {
            st.setString(Queries.ONE, item.getName());
            st.setString(Queries.TWO, item.getDescription());
            st.setString(Queries.THREE, item.getComments());
            st.setInt(Queries.FOUR, item.getId());
            st.executeUpdate();
        }
    }

    /**
     * метод ищет заявку по ключу.
     *
     * @param id - ключ
     * @return item
     * @throws SQLException SQLException
     */
    public final Item findById(final int id) throws SQLException {
        Item item = null;
        try (PreparedStatement st = conn.prepareStatement(findByIdQuery)) {
            st.setInt(Queries.ONE, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    item = new Item();
                    item.setId(id);
                    item.setName(rs.getString(Queries.TWO));
                    item.setDescription(rs.getString(Queries.THREE));
                    item.setComments(rs.getString(Queries.FIVE));
                    item.setCreated(rs.getDate(Queries.FOUR));
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
     * @throws SQLException SQLException
     */
    public final ArrayList<Item> findByName(final String name)
            throws SQLException {
        ArrayList<Item> finder = new ArrayList<>();
       try (PreparedStatement st = conn.prepareStatement(findByNameQuery)) {
           st.setString(Queries.ONE, name);
           try (ResultSet rs = st.executeQuery()) {
               while (rs.next()) {
                   Item item = new Item();
                   item.setId(rs.getInt(Queries.ONE));
                   item.setName(rs.getString(Queries.TWO));
                   item.setDescription(rs.getString(Queries.THREE));
                   item.setComments(rs.getString(Queries.FIVE));
                   item.setCreated(rs.getDate(Queries.FOUR));
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
     * @throws SQLException SQLException
     */
    public final void delete(final int id) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement(deleteQuery)) {
            st.setInt(Queries.ONE, id);
            st.executeUpdate();
        }

    }

    /**
     * метод возвращает список все заявок.
     *
     * @return finder
     * @throws SQLException SQLException
     */
    public final ArrayList<Item> getAll() throws SQLException {
        ArrayList<Item> finder = new ArrayList<>();
        try (PreparedStatement st = conn.prepareStatement(getAllQuery)) {
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setId(rs.getInt(Queries.ONE));
                    item.setName(rs.getString(Queries.TWO));
                    item.setDescription(rs.getString(Queries.THREE));
                    item.setComments(rs.getString(Queries.FIVE));
                    item.setCreated(rs.getDate(Queries.FOUR));
                    finder.add(item);
                }
            }
        }

        return finder;
    }


    @Override
    public final void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
