# Library Management System

## Overview

The Library Management System is a Java-based application designed to manage books, librarians, and book issuance within a library. The project utilizes a MySQL database to store information about books and librarians, providing functionalities such as adding books, issuing books to students, managing librarians, and more.

## Project Structure

The project consists of two main DAO (Data Access Object) classes:

1. **BookDao:**
   - Manages operations related to books, including adding new books, viewing all books, deleting books, checking book availability, issuing books, and returning books.

2. **LibrarianDao:**
   - Handles operations related to librarians, such as adding new librarians, updating librarian details, deleting librarians, validating login credentials, viewing the list of librarians, and updating passwords.

## Usage

### BookDao
- `addBook(Books b):` Adds a new book to the library.
- `viewBooks():` Retrieves and displays a list of all books in the library.
- `deleteBook(String bid):` Deletes a book from the library based on the book ID.
- `getIssuedBooks(String bid):` Retrieves the count of issued books for a given book ID.
- `checkIssued(String bid):` Checks if a book with a given ID is available for issuance.
- `issueBook(IssueBook issueBook):` Issues a book to a student.
- `returnBook(String bid, String studentid):` Updates the return status of a book and adjusts the issued count.

### LibrarianDao
- `addLibrarian(Librarian librarian):` Adds a new librarian to the system.
- `updateLibrarian(Librarian librarian):` Updates the details of an existing librarian.
- `deleteLibrarian(int id):` Deletes a librarian based on the librarian ID.
- `validateLogin(String name, String password):` Validates login credentials for a librarian.
- `viewLibrarians():` Retrieves and displays a list of all librarians.
- `updatePassword(String name, String password):` Updates the password of a librarian.

## Setup

1. **Database Configuration:**
   - Ensure that the MySQL database is set up.
   - Update the database connection details in the `DataBase` class.

2. **Librarian Credentials:**
   - Modify the `validateLogin` method in `LibrarianDao` to include the initial login credentials.

3. **Run the Application:**
   - Execute the main application file after setting up the database and librarian credentials.
