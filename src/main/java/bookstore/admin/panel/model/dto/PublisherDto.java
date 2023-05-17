package bookstore.admin.panel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDto {
    private String name;
    private String mail;
    private String phoneNumber;
    private List<Long> bookIdList;
}
