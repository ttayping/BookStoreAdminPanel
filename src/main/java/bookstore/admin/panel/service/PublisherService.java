package bookstore.admin.panel.service;

import bookstore.admin.panel.dao.repository.PublisherRepository;
import bookstore.admin.panel.mapper.PublisherMapper;
import bookstore.admin.panel.model.dto.PublisherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private static final PublisherMapper mapper = PublisherMapper.MAPPER_2;

    public void addPublisher(PublisherDto publisherDto) {
        publisherRepository.save(mapper.toPublisher(publisherDto));
    }
}
