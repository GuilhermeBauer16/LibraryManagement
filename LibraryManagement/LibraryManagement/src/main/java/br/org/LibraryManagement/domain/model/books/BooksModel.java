package br.org.LibraryManagement.domain.model.books;

import br.org.LibraryManagement.domain.model.users.UserModel;

import javax.persistence.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name="books")
public class BooksModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;

    private double quantity;

    private boolean available;



        @Enumerated(EnumType.STRING)
        @Column(name = "book_category")
    private BooksCategory booksCategory;

    @ManyToMany(mappedBy = "books")
    private List<UserModel> users =new ArrayList<>();


    public BooksModel() {
    }

    public BooksModel(String name, String description, Double price, double quantity, BooksCategory booksCategory, boolean available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.booksCategory = booksCategory;
        this.available = available;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BooksCategory getBooksCategory() {
        return booksCategory;
    }

    public void setBooksCategory(BooksCategory booksCategory) {
        this.booksCategory = booksCategory;
    }

//    public PaymentMethod getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(PaymentMethod paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }


    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return "Books" + "\n" +
                "name: '" + name + '\'' + "\n" +
                ", description: '" + description + '\'' + "\n" +
                ", price: " + numberFormat.format(price) + "\n" +
                ", booksCategory: " + booksCategory
                ;
    }
}
