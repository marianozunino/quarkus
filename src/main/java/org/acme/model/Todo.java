package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "todo")
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
