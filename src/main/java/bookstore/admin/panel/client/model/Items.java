package bookstore.admin.panel.client.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class Items {
    private String name;
    @JsonAlias("display_name")
    private String displayName;
    private String released;
    private Double score;
    @JsonAlias("short_description")
    private String shortDescription;
}
