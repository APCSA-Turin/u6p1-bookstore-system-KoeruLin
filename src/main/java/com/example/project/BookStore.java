package com.example.project;

public class BookStore
{
    private Book[] books = new Book[0];
    private User[] users = new User[10];

    public BookStore()
    {
    }

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 

    //requires 1 empty constructor

    public User[] getUsers()
    {
        return users;
    }

    public void setUsers(User[] newUsers)
    {
        users = newUsers;
    }

    public Book[] getBooks()
    {
        return books;
    }

    public void addUser(User user)
    {
        for(int i = 0; i < users.length; i++)
        {
            if(users[i] == null)
            {
                users[i] = user;
                break;
            }
        }
    } 

    public void removeUser(User user)
    {
        for(int i = 0; i < users.length; i++)
        {
            if(users[i] == user)
            {
                users[i] = null;
                break;
            }
        }
        
        consolidateUsers();

        Book[] newBook = new Book[books.length - 1];

        for(int i = 0; i < newBook.length; i++)
        {
            newBook[i] = books[i];
        }
        
        books = newBook;
    }
    // wrong, that user index need to be completely removed

    public void consolidateUsers()
    {
        User[] newUser = new User[users.length];
        int i = 0;

        for (User user : users) 
        {
            if (user != null) 
            {
                newUser[i] = user; 
                i++;
            }
        }

        users = newUser;  
    }

    public void addBook(Book book)
    {
        Book[] newBook = new Book[books.length + 1];
        for(int i = 0; i < books.length; i++)
        {
            newBook[i] = books[i];
        }

        if (books.length == 0)
        {
            newBook[0] = book;
        }
        else
        {
            newBook[newBook.length - 1] = book;
        }

        books = newBook;
    }

    public void insertBook(Book book, int index)
    {
        if(books[index] == null)
        {
            books[index] = book;
        }
        else
        {
            Book[] newBook = new Book[books.length + 1];

            for(int i = 0; i < index + 1; i++)
            {
                newBook[i] = books[i];
            }
            
            newBook[index] = book;

            for(int z = index + 1; z < books.length; z++)
            {
                newBook[z] = books[z - 1];
            }
            
            books = newBook;
        }
    }

    public void removeBook(Book book)
    {
        for(int i = 0; i < books.length; i++)
        {
            if(books[i] == book)
            {
                books[i] = null;
                break;
            }
        }
    }

    public String bookStoreUserInfo()
    {
        return "";
    } //you are not tested on this method but use it for debugging purposes
}