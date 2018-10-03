package ru.job4j.tracker;


import java.sql.Date;


/**
 *Class Item.
 *@author Tatyana Belova
 *@since 24.08.2018
*/
public class Item {
    /**
     * key.
     */
    private int id;
    /**
     * наименование.
     */
    private String name;
    /**
     * описание.
     */
    private String description;
    /**
     * дата создания.
     */
    private Date created;
    /**
     * комментарии.
     */
    private String comments;
    /**
     * метод возвращает ключ.
     * @return id
     */
    public final int getId() {
        return this.id;
    }
    /**
     * метод возвращает имя.
     * @return name
     */
    public final String getName() {
        return this.name;
    }
    /**
     * метод возвращает описание.
     * @return description
     */
    public final String getDescription() {
        return this.description;
    }
    /**
     * метод возвращает дату создания.
     * @return created
     */
    public final Date getCreated() {
        return this.created;
    }
    /**
     * метод возвращает комментарии.
     * @return comments
     */
    public final String getComments() {
        return this.comments;
    }
    /**
     * метод устанавливает ключ.
     * @param id - id
     */
    public final void setId(final int id) {
        this.id = id;
    }
    /**
     * метод устанавливает имя.
     * @param name - name
     */
    public final void setName(final String name) {
        this.name = name;
    }
    /**
     * метод устанавливает описание.
     * @param description - description
     */
    public final void setDescription(final String description) {
        this.description = description;
    }
    /**
     * метод устанавливает дату создания.
     * @param date - date
     */
    public final void setCreated(final Date date) {
        this.created = date;
    }
    /**
     * метод устанавливает комментарии.
     * @param comments - comments
     */
    public final void setComments(final String comments) {
        this.comments = comments;
    }
}
