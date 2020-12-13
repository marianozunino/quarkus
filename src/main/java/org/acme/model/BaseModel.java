package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.Date;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@MappedSuperclass
public abstract class BaseModel extends PanacheEntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = "pg-uuid")
  private UUID id;

  @Column(name = "deleted_at", nullable = true)
  public Date deletedAt;
}
