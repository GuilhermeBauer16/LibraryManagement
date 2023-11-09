package br.org.LibraryManagement.domain.model.books;

public class Books {

    private String name;
    private String description;
    private Double price;

    private BooksCategory booksCategory;

    private PaymentMethod paymentMethod;

    public Books(String name, String description, Double price, BooksCategory booksCategory, PaymentMethod paymentMethod) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.booksCategory = booksCategory;
        this.paymentMethod = paymentMethod;
    }

    public Books(String name, String description, Double price, BooksCategory booksCategory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.booksCategory = booksCategory;
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

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Books" +
                "name: '" + name + '\'' +
                ", description: '" + description + '\'' +
                ", price: " + price +
                ", booksCategory: " + booksCategory
                ;
    }
}
