package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.acme.model.Todo;

@ApplicationScoped
@Transactional
public class TodoRepository implements PanacheRepository<Todo> {

  public Todo findByTitle(String title) {
    return find("title", title).firstResult();
  }

  public List<Todo> search(String word, Page page) {
    return find("title like ?1 and completed = ?2", word, false).page(page).list();
  }

  public void deleteCompleted() {
    delete("completed", true);
  }
}
