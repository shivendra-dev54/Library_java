package Library_java;

class Book {
    private String title;
    private String author;
    private String borrower;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrower = "";
    }

    public Book(String title, String author, String borrower) {
        this.title = title;
        this.author = author;
        this.borrower = borrower;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + (borrower.isEmpty() ? "" : ", Borrowed by: " + borrower);
    }
}
