package bookstore.admin.panel.service;


import bookstore.admin.panel.dao.entity.Publisher;
import bookstore.admin.panel.dao.repository.PublisherRepository;

import bookstore.admin.panel.mapper.PublisherMapper;

import bookstore.admin.panel.model.dto.PublisherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private static final PublisherMapper mapper = PublisherMapper.MAPPER_2;

    public void addPublisher(PublisherDto publisherDto) {

        publisherRepository.save(mapper.toPublisherEntity(publisherDto));
    }

    public void updatePublisher(Long id, PublisherDto publisherDto) {
        Optional<Publisher> foundedPublisher = publisherRepository.findById(id);
        Publisher publisher = mapper.toPublisherEntity(publisherDto);
        if (foundedPublisher.isPresent()) {
            foundedPublisher.get().setName(publisher.getName());
            publisherRepository.save(foundedPublisher.get());
        }
    }

    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }

    public List<PublisherDto> getAllPublishers() {
        return mapper.toPublisherDtoList(publisherRepository.findAll());
    }

    public PublisherDto getPublisherById (Long id){
        return mapper.toPublisherDto(publisherRepository.getById(id));
    }

}
