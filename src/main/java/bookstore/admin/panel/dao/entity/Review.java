package bookstore.admin.panel.dao.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter
public class Review extends BaseEntity {

    @Column(name = "reviewer_name", nullable = false)
    private String reviewer;

    @Column(name = "note", nullable = false)
    private String note;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

}
