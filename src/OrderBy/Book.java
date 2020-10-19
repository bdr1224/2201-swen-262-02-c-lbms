package OrderBy;

import java.util.Date;

public class Book {

    private String title;
    private String isbn;
    private int pages;
    private int copies;
    private int checkedOut;
    private Date date;

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPages() {
        return pages;
    }

    public int getCheckedOut() {
        return checkedOut;
    }

    public int getCopies() {
        return copies;
    }

    public boolean isInStock() {
        return copies - checkedOut > 0;
    }

    public Date getDate() {
        return date;
    }

}
