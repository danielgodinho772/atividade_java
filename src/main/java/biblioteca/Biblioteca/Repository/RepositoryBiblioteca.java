package biblioteca.Biblioteca.Repository;

import biblioteca.Biblioteca.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBiblioteca extends JpaRepository<Books, Long> {
}
