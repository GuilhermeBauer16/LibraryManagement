package br.org.LibraryManagement.service.book;

import br.org.LibraryManagement.DAO.BooksDAO.BooksDAO;
import br.org.LibraryManagement.domain.model.books.BooksModel;
import br.org.LibraryManagement.domain.model.books.BooksCategory;
import br.org.LibraryManagement.domain.model.users.UserModel;
import br.org.LibraryManagement.exception.BookNotAvailable;
import br.org.LibraryManagement.exception.BookNotFound;
import br.org.LibraryManagement.util.CheckIfDataIsEmpty;
import br.org.LibraryManagement.util.CreateParameter;
import br.org.LibraryManagement.util.EncryptPassword;

import java.util.List;

public class BookService {

    public static BooksModel createBook() throws BookNotAvailable {
        System.out.println("=/".repeat(30));
        System.out.println("New book");
        System.out.println("=/".repeat(30));
        String name = CreateParameter.createString("Name: ");
        CheckIfDataIsEmpty.checkIfIsEmpty(name);
        String description = CreateParameter.createString("Description: ");
        CheckIfDataIsEmpty.checkIfIsEmpty(description);
        double price = CreateParameter.createDouble("Price: ");
        double quantity = CreateParameter.createDouble("Quantity: ");
        listBookCategory();
        long category = CreateParameter.createLong("Type the number of the category: ");
        BooksCategory booksCategory = BooksCategory.getBooksCategoryByValueId(category);
        System.out.println("=/".repeat(30));
        boolean available = false;
        if (quantity > 0) {
            available = true;
        }

        return new BooksModel(name, description, price, quantity, booksCategory, available);


    }

    public static String showBookByName(BooksModel booksModel) {
        return booksModel.toString();
    }

    public static void listBookCategory() {
        int i = 1;
        for (BooksCategory category : BooksCategory.values()) {

            System.out.println("(" + i + ") " + "Category: " + category.name());
            i++;

        }
    }

    public static void listBooksAvailable() throws BookNotFound {

        List<BooksModel> availableBooks = BooksDAO.findBooksByAvailability(true);
        System.out.println("=/".repeat(30));
        for (BooksModel booksModel : availableBooks) {
            System.out.println(booksModel.toString());
            System.out.println("=/".repeat(30));
        }
    }

    public static void listBookNoAvailable() throws BookNotFound {
        List<BooksModel> noAvailableBooks = BooksDAO.findBooksByAvailability(false);
        System.out.println("=/".repeat(30));
        for (BooksModel booksModel : noAvailableBooks) {
            System.out.println(booksModel.toString());
            System.out.println("=/".repeat(30));

        }
    }

    public static BooksModel editBook(BooksModel booksModel) throws BookNotAvailable {

        System.out.println("If you don't want to change the field please type enter!");
        System.out.println("=/".repeat(30));
        System.out.println("Edit book");
        System.out.println("=/".repeat(30));
        String name = CreateParameter.createString("Name: ");
        String description = CreateParameter.createString("Description: ");

        if (!name.isEmpty()) {
            booksModel.setName(name);
        }

        if (!description.isEmpty()) {
            booksModel.setDescription(description);
        }


        if (checkIfIsTrue("You would like to change the book price[y|n]: ") == true) {
            Double price = CreateParameter.createDouble("Price: ");
            booksModel.setPrice(price);

        }

        if (checkIfIsTrue("You would like to change the book category:[y|n]: ")) {
            listBookCategory();
            long category = CreateParameter.createLong("Type the number of the category: ");
            BooksCategory booksCategory = BooksCategory.getBooksCategoryByValueId(category);
            booksModel.setBooksCategory(booksCategory);
        }

        if (checkIfIsTrue("You would like to change the book quantity:[y|n]: ")) {
            Double quantity = CreateParameter.createDouble("Quantity: ");
            booksModel.setQuantity(quantity);
            checkingIfIsAvailable(booksModel);
        }

        System.out.println("=/".repeat(30));
        return booksModel;

    }

    public static boolean checkIfIsTrue(String message) {

        String check = CreateParameter.createString(message).toUpperCase();
        char firstLetter = check.charAt(0);
        if (firstLetter == 'Y') {
            return true;
        }
        return false;
    }

    public static UserModel buyTheBook(UserModel userModel) throws Exception {

        EncryptPassword encryptPassword = new EncryptPassword();
        BooksModel booksModel = BooksDAO.findBookByName();
        if (booksModel.isAvailable() == false) {
            throw new BookNotAvailable("This book is not available", "");
        }
        double accountBalance = userModel.getBank().getBalance();
        double bookPrice = booksModel.getPrice();
        if (accountBalance < bookPrice) {
            throw new RuntimeException("Sorry but you don't have money on your account for buy this book!");
        }
        System.out.println("For continue please type your password");
        encryptPassword.checkingIfThePasswordsAreEquals(userModel.getPassword());
        double result = accountBalance - bookPrice;
        userModel.getBank().setBalance(result);
        userModel.addBook(booksModel);
        return userModel;


    }

    public static void checkingIfIsAvailable(BooksModel booksModel) throws BookNotAvailable {

        if (booksModel.getQuantity() < 0) {
            throw new BookNotAvailable("This book is not available",
                    "Probably don't had more books available");
        }

        booksModel.setAvailable(true);
    }

}

