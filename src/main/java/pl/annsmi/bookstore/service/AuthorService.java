package pl.annsmi.bookstore.service;

import org.springframework.stereotype.Service;
import pl.annsmi.bookstore.model.Author;
import pl.annsmi.bookstore.model.dto.ReadAuthorDTO;
import pl.annsmi.bookstore.model.dto.WriteAuthorDTO;
import pl.annsmi.bookstore.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    AuthorService(final AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public ReadAuthorDTO addAuthor(WriteAuthorDTO source){
        Author result = source.toAuthor();
        authorRepository.save(result);
        return new ReadAuthorDTO(result);
    }

    public List<ReadAuthorDTO> readAllAuthors(){
        return authorRepository.findAll().stream().map(ReadAuthorDTO::new).collect(Collectors.toList());
    }

    public ReadAuthorDTO updateAuthor(int id, WriteAuthorDTO model) throws IllegalArgumentException{
        Author source = model.toAuthor();
        Author toUpdate = authorRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Given author doesnt exist!"));
        toUpdate.setName(source.getName());
        toUpdate.setSurname(source.getSurname());
        authorRepository.save(toUpdate);
        return new ReadAuthorDTO(toUpdate);

    }






}
