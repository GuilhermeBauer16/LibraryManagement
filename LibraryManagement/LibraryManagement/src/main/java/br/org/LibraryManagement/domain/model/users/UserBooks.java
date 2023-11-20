package br.org.LibraryManagement.domain.model.users;

import br.org.LibraryManagement.domain.model.books.BooksModel;

import javax.persistence.*;

@Entity
@Table(name="user_books")
public class UserBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
     private UserModel userId;

    @ManyToOne
    @JoinColumn(name = "book_id")
     private BooksModel bookId;


}
