# 3rd Assignment Report

![](https://github.com/kianaghamsari/Second-Assignment/blob/develop/uni.png)

## Kiana Ghamsari - 400222079


# Introduction 

The purpose of the application is to manage a library using Java Object-Oriented Programming.

The application includes 5 classes:
* Book
* Librarian
* Library
* Main
* User

You can sign up or login if you already have an account as a ordinary user who can borrow a book, or as a librarian who manages the library.


# Structure

* The `Library` class is the most important , and also, class `Main` runs the program by calling the method called `runMenu()`.
* The methods `newUserSignUp()` and `newLibrarianSignUp()` are created in `Main` to let new users sign up as either an ordinary user or a librarian.
* Users can borrow and return books from the library by `rentBook()` and `returnBook()` methods, respectively, defined in `User` class.
* The add, update, search, remove operations on all books and users objects are accessed only by librarians. These methods are defined in `Library` class.
* A Librarian can also borrow or return books due to it’s inheritance of `User` class.
* Librarian can, also, add or remove another librarian. 

# Bonus
In my implementation:

* Usernames are unique
* A book cannot be borrowed twice
* The user cannot return the book that has not been borrowed
* All fields are private, and proper getters and setters are defined
* All functionalities are available from GUI

# Conclusion:
* By this project, I've used basic concepts of object-oriented programming in an example.
* I, also, experienced working with access modifiers, public and private methods.
* I broke my code into individual classes that helped me increasing the readability of my code
* I didn't provide a back and exit command