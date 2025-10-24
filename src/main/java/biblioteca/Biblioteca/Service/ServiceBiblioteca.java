package biblioteca.Biblioteca.Service;

import biblioteca.Biblioteca.Model.Books;
import biblioteca.Biblioteca.Repository.RepositoryBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ServiceBiblioteca {

    @Autowired
    private RepositoryBiblioteca repositoryBbta;

    public Books createBooks(Books book) {
        return repositoryBbta.save(book);
    }

    public List<Books> listAllBooks(){
        return repositoryBbta.findAll();
    }

    public Optional<Books> findBooksId(Long id) {
        return repositoryBbta.findById(id);
    }

    public Books updateBooks(Long id, Books abooks) {
        Books books = repositoryBbta.findById(id).orElseThrow();
        abooks.setName(abooks.getName());
        abooks.setAuthor(abooks.getAuthor());
        abooks.setGender(abooks.getGender());

        return repositoryBbta.save(books);
    }

    public void deleteBooks (Long id) {
        repositoryBbta.deleteById(id);
    }
}
