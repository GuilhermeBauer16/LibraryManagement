package br.org.LibraryManagement.domain.model.books;

public enum BooksCategory {
    ROMANCE(1),
    MYSTERY(2),
    SCIENCE_FICTION(3),
    BIOGRAPHY(4),
    SELF_HELP(5),
    CHILDREN(6),
    SPIRITUALITY(7),
    OTHER(8);

    private long valueId;

    BooksCategory(long valueId) {
        this.valueId = valueId;
    }

    public static void listBookCategory() {
        for (BooksCategory category : BooksCategory.values()) {
            System.out.println("Category: " + category.name());

        }
    }

    public static BooksCategory getBooksCategoryByValueId(long valueCategory) {
        for (BooksCategory category : values()) {

            if (category.valueId == valueCategory) {
                return category;

            }


        }
        throw new IllegalArgumentException("Please type a valid category! ");
    }

    public long getValueId() {
        return valueId;
    }
}
