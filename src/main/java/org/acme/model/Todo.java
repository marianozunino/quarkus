package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity()
public class Todo extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(unique = true)
    public String title;

    public String url;

    public boolean completed;

    @Column(name = "ordering")
    public int order;
}
