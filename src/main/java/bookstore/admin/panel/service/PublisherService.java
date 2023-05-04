package bookstore.admin.panel.service;


import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.dao.repository.PublisherRepository;

import bookstore.admin.panel.exception.BadRequestException;
import bookstore.admin.panel.exception.Error;
import bookstore.admin.panel.mapper.UniversalMapper;
import bookstore.admin.panel.model.dto.PublisherDto;
import bookstore.admin.panel.model.dto.PublisherRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private static final UniversalMapper mapper = UniversalMapper.MAPPER;

    public void addPublisher(PublisherDto publisherDto) {

        publisherRepository.save(mapper.toPublisherEntity(publisherDto));
    }

    public void updatePublisher(Long id, PublisherDto publisherDto) {
        Publisher foundedPublisher = publisherRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        Publisher publisher = mapper.toPublisherEntity(publisherDto);
        foundedPublisher.setName(publisher.getName());
        publisherRepository.save(foundedPublisher);
}

    public void deletePublisherById(Long id) {
        publisherRepository.findById(id).orElseThrow(()
                -> new BadRequestException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        publisherRepository.deleteById(id);
    }

    public List<PublisherRequestDto> getAllPublishers() {
        return mapper.toPublisherRequestDtoList(publisherRepository.findAll());
    }

    public PublisherRequestDto getPublisherById(Long id) {
        return mapper.toPublisherRequestDto(publisherRepository.findById(id).orElseThrow(
                () -> new BadRequestException(Error.BOOK_NOT_FOUND_ERROR_CODE,
                Error.BOOK_NOT_FOUND_ERROR_MESSAGE)));
    }
}
