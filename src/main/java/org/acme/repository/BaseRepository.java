package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.Date;
import java.util.UUID;

public interface BaseRepository<T> extends PanacheRepository<T> {
  public default int softDelete(UUID uuid) {
    return update("deleted_at= ?1 where id = ?2", new Date(), uuid);
  }

  public default T findByUUID(UUID uuid) {
    return find("id = ?1 and deleted_at = null", uuid).firstResult();
  }
}
