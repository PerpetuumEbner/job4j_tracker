package ru.job4j.tracker;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode (of = "id")
@Entity
@Table(name = "items")
public class Item implements Comparable<Item> {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String description;

    private Timestamp time;

    private LocalDateTime created = LocalDateTime.now();

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    public Item(String name) {
        this.name = name;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String name, String description, Timestamp time) {
        this.name = name;
        this.description = description;
        this.time = time;
    }

    @Override
    public String toString() {
        return created.format(FORMATTER) + System.lineSeparator() + id + " " + name;
    }

    @Override
    public int compareTo(Item anotherItem) {
        return name.compareTo(anotherItem.getName());
    }
}