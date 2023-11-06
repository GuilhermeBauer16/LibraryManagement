package br.org.LibraryManagement.domain.model.books;

public enum PaymentMethod {

    DEBIT{
        @Override
        public double calculateDiscount(Double price) {
            double discount = price * 0.10;
            return price - discount;
        }
    },
    CREDIT{
        @Override
        public double calculateDiscount(Double price) {
            double discount = price * 0.05;
            return price - discount;
        }
    },
    CASH{
        @Override
        public double calculateDiscount(Double price) {
            double discount = price * 0.15;
            return price - discount;
        }
    },
    PIX{
        @Override
        public double calculateDiscount(Double price) {
            double discount = price * 0.15;
            return price - discount;
        }
    };

    public abstract double calculateDiscount(Double price) ;

}


