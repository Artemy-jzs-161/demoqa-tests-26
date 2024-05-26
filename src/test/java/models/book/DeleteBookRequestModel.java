package models.book;

import lombok.Data;

@Data
public class DeleteBookRequestModel {
    private String isbn;
    private String userId;

    public DeleteBookRequestModel(String isbn, String userId) {
        this.isbn = isbn;
        this.userId = userId;
    }
}
