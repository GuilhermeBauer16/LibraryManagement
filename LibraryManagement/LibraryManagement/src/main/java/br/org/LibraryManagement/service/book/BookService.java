package br.org.LibraryManagement.service.book;

import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.domain.model.books.BooksCategory;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.util.CreateParameter;

import static br.org.LibraryManagement.DAO.BooksDAO.BooksDAO.findBookByName;

public class BookService {

    public static BooksModel createBook() {
        System.out.println("New book");
        String name = CreateParameter.createString("Name: ");
        String description = CreateParameter.createString("Description: ");
        double price = CreateParameter.createDouble("Price: ");
        double quantity = CreateParameter.createDouble("Quantity: ");
        listBookCategory();
        long category = CreateParameter.createLong("Type the number of the category: ");
        BooksCategory booksCategory = BooksCategory.getBooksCategoryByValueId(category);
        return new BooksModel(name, description, price, quantity, booksCategory);


    }

    public static void listBookCategory() {
        int i = 1;
        for (BooksCategory category : BooksCategory.values()) {

            System.out.println("(" + i + ") " + "Category: " + category.name());
            i++;

        }
    }

    public static BooksModel editBook(BooksModel booksModel) {
        System.out.println("If you don't want to change the field please type enter!");
        String name = CreateParameter.createString("Name: ");
        String description = CreateParameter.createString("Description: ");

        if (!name.isEmpty()) {
            booksModel.setName(name);
        }

        if (!description.isEmpty()) {
            booksModel.setDescription(description);
        }


        if(checkIfIsTrue("You would like to change the book price[y|n]: ") == true) {
            Double price = CreateParameter.createDouble("Price: ");
            booksModel.setPrice(price);

        }

        if (checkIfIsTrue("You would like to change the book category:[y|n]: ")){
            listBookCategory();
            long category = CreateParameter.createLong("Type the number of the category: ");
            BooksCategory booksCategory = BooksCategory.getBooksCategoryByValueId(category);
            booksModel.setBooksCategory(booksCategory);
        }

        if(checkIfIsTrue("You would like to change the book quantity:[y|n]: ")){
            Double quantity = CreateParameter.createDouble("Quantity: ");
            booksModel.setQuantity(quantity);
        }

        return booksModel;


    }

    public static boolean checkIfIsTrue(String message){

        String check = CreateParameter.createString(message).toUpperCase();
        char firstLetter = check.charAt(0);
        if (firstLetter == 'Y') {
            return true;
        }
        return  false;
    }

    public static UserModel buyTheBook(UserModel userModel) throws Exception {

        BooksModel booksModel = findBookByName();
        double accountBalance = userModel.getBank().getBalance();
        double bookPrice = booksModel.getPrice();
        if (accountBalance < bookPrice) {
            throw new RuntimeException("Sorry but you don't have money on your account for buy this book!");
        }

        double result = accountBalance - bookPrice;
        userModel.getBank().setBalance(result);
        userModel.addBook(booksModel);
        return userModel;


    }

}

