package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.entity.Book;
import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.dao.repository.BookRepository;
import bookstore.admin.panel.dao.repository.PublisherRepository;
import bookstore.admin.panel.exception.BadRequestException;
import bookstore.admin.panel.exception.Error;
import bookstore.admin.panel.mapper.Mapper;
import bookstore.admin.panel.mapper.PublisherRequestMapper;
import bookstore.admin.panel.mapper.PublisherResponseMapper;
import bookstore.admin.panel.model.dto.PublisherRequestDto;
import bookstore.admin.panel.model.dto.PublisherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final BookRepository bookRepository;
    private static final Mapper mapper = Mapper.MAPPER;
    private static final PublisherRequestMapper publisherRequestMapper = PublisherRequestMapper.PUBLISHER_REQUEST_MAPPER;
    private static final PublisherResponseMapper publisherResponseMapper = PublisherResponseMapper.PUBLISHER_RESPONSE_MAPPER;

    public void addPublisher(PublisherRequestDto publisherDto) {
        if (Objects.isNull(publisherDto)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Publisher publisher = publisherRequestMapper.toEntity(publisherDto);
        List<Book> books = bookRepository.findAllByIdIn(publisherDto.getBookIdList());
        if (Objects.nonNull(books)) {
            publisher.setBooks(books);
        }
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Long id, PublisherRequestDto publisherDto) {
        if (Objects.isNull(id) || Objects.isNull(publisherDto)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        Publisher foundedPublisher = publisherRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        List<Book> books = bookRepository.findAllByIdIn(publisherDto.getBookIdList());
        foundedPublisher = mapper.toPublisherEntity(books, publisherDto, foundedPublisher);
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

    public List<PublisherResponseDto> getAllPublishers() {
        return publisherResponseMapper.toDto(publisherRepository.findAll());
    }

    public PublisherResponseDto getPublisherById(Long id) {
        if (Objects.isNull(id)) {
            throw new BadRequestException(Error.BAD_REQUEST_ERROR_CODE, Error.BAD_REQUEST_ERROR_MESSAGE);
        }
        return publisherResponseMapper.toDto(publisherRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE)));
    }
}
