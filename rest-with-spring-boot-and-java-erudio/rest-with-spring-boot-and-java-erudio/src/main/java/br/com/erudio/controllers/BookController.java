package br.com.erudio.controllers;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.services.BookService;
import br.com.erudio.util.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books/v1")
public class BookController {

    @Autowired
    private BookService service;
    @PostMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML, MediaType.APPLICATION_XML},
                 consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<BookVO> createBook(@RequestBody BookVO bookVO) {
        BookVO bookVOCreated = service.create(bookVO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookVOCreated);
    }

    @GetMapping(value = "/{id}",
                produces = {MediaType.APPLICATION_YML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public BookVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML, MediaType.APPLICATION_XML})
    public List<BookVO> findAll(){
        return service.findAll();
    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_YML, MediaType.APPLICATION_XML})
    public BookVO update(@RequestBody BookVO bookVO) {
        return service.update(bookVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
