Neighborhood Library

Screenshots:
*Home:(https://github.com/user-attachments/assets/c5fb17e9-edd8-4072-ad7f-ce6c53bf0ff2)
*Show Available Books: (https://github.com/user-attachments/assets/2289be68-b881-47a1-b47c-3b12f33aad12)
*Show Checked Out books: (https://github.com/user-attachments/assets/f93d2b4d-d05c-450c-b955-b4fdec39df45)
*Error: (https://github.com/user-attachments/assets/e1608189-5f3c-4e67-8ab1-f9a6fad9de9e)

Interesting Piece of Code:

for (Book book : books) {
    if (!book.isCheckedOut()) {
        System.out.printf("ID: %d | ISBN: %s | Title: %s\n", 
            book.getId(), book.getIsbn(), book.getTitle());


I have used this code to display checked out books. It helped me to check if a book has checked and if yes shows details with format. I learned that this code is called enhanced for-loops (also called “for-each” loops).
