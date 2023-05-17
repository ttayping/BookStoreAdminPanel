package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.dao.repository.BookRepository;
import bookstore.admin.panel.dao.repository.PublisherRepository;
import bookstore.admin.panel.exception.BadRequestException;
import bookstore.admin.panel.exception.Error;
import bookstore.admin.panel.mapper.PublisherMapper;
import bookstore.admin.panel.model.dto.PublisherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;
    private static final PublisherMapper publisherMapper = PublisherMapper.PUBLISHER_MAPPER;

    public void addPublisher(PublisherDto publisherDto) {
        if (Objects.isNull(publisherDto)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Publisher publisher = publisherMapper.toEntity(publisherDto);
        List<Book> books = bookRepository.findAllByIdIn(publisherDto.getBookIdList());
        if (Objects.nonNull(books)) {
            publisher.setBooks(books);
        }
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Long id, PublisherDto publisherDto) {
        if (Objects.isNull(id) || Objects.isNull(publisherDto)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Publisher foundedPublisher = publisherRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        Publisher publisher = publisherMapper.toEntity(publisherDto);
        foundedPublisher.setName(publisher.getName());
        if (Objects.nonNull(publisherDto.getBookIdList())) {
            foundedPublisher.setBooks(bookRepository.findAllByIdIn(publisherDto.getBookIdList()));
        }
        publisherRepository.save(foundedPublisher);
    }

    public void deletePublisherById(Long id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        publisherRepository.findById(id).orElseThrow(()
                -> new BadRequestException(Error.NOT_FOUND_ERROR_CODE,
                Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        publisherRepository.deleteById(id);
    }

    public List<PublisherDto> getAllPublishers() {
        return publisherMapper.toDto(publisherRepository.findAll());
    }

    public PublisherDto getPublisherById(Long id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        return publisherMapper.toDto(publisherRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE)));
    }
}
