package br.org.LibraryManagement.service.book;

import br.org.LibraryManagement.domain.model.books.Books;
import br.org.LibraryManagement.domain.model.books.BooksCategory;
import br.org.LibraryManagement.domain.model.books.PaymentMethod;
import br.org.LibraryManagement.util.CreateParameter;

public class BookService {

    public static Books createBook(){
        System.out.println("New book");
        String name = CreateParameter.createString("Name: ");
        String description = CreateParameter.createString("Description: ");
        Double price = CreateParameter.createDouble("Price: ");
        listBookCategory();
        long category = CreateParameter.createLong("Type the number of the category: ");
        BooksCategory booksCategory = BooksCategory.getBooksCategoryByValueId(category);
         return new Books(name,description,price,booksCategory);


    }

    public static void listBookCategory(){
        int i = 1;
        for (BooksCategory category : BooksCategory.values()){

            System.out.println("(" + i + ") " +"Category: " + category.name());
            i++;

        }
    }
}
