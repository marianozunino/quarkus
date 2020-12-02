package org.acme.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity()
@Table(name = "todo")
public class Todo {
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
