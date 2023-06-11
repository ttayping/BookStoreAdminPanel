package bookstore.admin.panel.client.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class Topics {
    @JsonAlias(value = "total_count")
    private Integer totalCount;
    private List<Items> items;
}
