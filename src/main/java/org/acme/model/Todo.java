package org.acme.model;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo extends BaseModel {

  @Column(unique = true)
  public String title;

  public String url;

  public boolean completed;

  @Column(name = "ordering")
  public int order;
}
