package bookstore.admin.panel.dao.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Publisher extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "publishers")
    private List<Book> books;

}
