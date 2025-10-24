package biblioteca.Biblioteca.Controller;

import biblioteca.Biblioteca.Model.Books;
import biblioteca.Biblioteca.Service.ServiceBiblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/livros")

public class BibliotecaController {

    @Autowired
    private ServiceBiblioteca servicebbta;

    @PostMapping
    public Books createBooks(@RequestBody Books book){
        return servicebbta.createBooks(book);
    }

    @GetMapping
    public List<Books> listBooks() {return servicebbta.listAllBooks();}

    @GetMapping("/{id}")
    public ResponseEntity<Books> findBooks(@PathVariable Long id) {
        return servicebbta.findBooksId(id)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBooks (@PathVariable Long id, @RequestBody Books abooks) {
        Books bookUpdated = servicebbta.updateBooks(id, abooks);
        return ResponseEntity.ok(bookUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooks (@PathVariable Long id) {
        servicebbta.deleteBooks(id);
        return ResponseEntity.noContent().build();
    }



}
