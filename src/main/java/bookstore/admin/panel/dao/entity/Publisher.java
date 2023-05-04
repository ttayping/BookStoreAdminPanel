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

    @Column(name = "mail")
    private String mail;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToMany(mappedBy = "publishers")
    private List<Book> books;

}
