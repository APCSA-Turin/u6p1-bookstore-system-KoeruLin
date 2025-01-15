package com.example.project;

public class BookStore
{
    private Book[] books = new Book[0];
    private User[] users = new User[10];

    public BookStore()
    {
    }

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
    // sets the earliest null value in users array to user

    public void removeUser(User user)
    {
        for(int i = 0; i < users.length; i++)
        {
            if(users[i] == user)
            {
                users[i] = null;
                consolidateUsers();
                break;
            }
        }
    }
    // removes user from user array by setting it to null and consolidates it in the process

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
    //brings all null values to the end of the array for users array

    public void consolidateBooks()
    {
        User[] newBook = new User[books.length];
        int i = 0;

        for (Book book : books) 
        {
            if (book != null) 
            {
                books[i] = book; 
                i++;
            }
        }

        users = newBook;  
    }
    //brings all null values to the end for books array

    public void addBook(Book book)
    {
        Book[] newBook = new Book[books.length + 1];
        
        for(int i = 0; i < books.length; i++)
        {
            newBook[i] = books[i];
        }
            
        newBook[newBook.length - 1] = book;

        books = newBook;
    }
    //adds a book to books array, increases array size

    public void insertBook(Book book, int index)
    {
        Book[] newBook = new Book[books.length + 1];

        if(index == newBook.length - 1)
        {
            for(int i = 0; i < books.length; i++)
            {
                newBook[i] = books[i];
            }

            newBook[index] = book;
        }
        else
        {
            for(int i = 0; i < index; i++)
            {
                newBook[i] = books[i];
            }
                    
            newBook[index] = book;
    
            for(int z = index; z < books.length; z++)
            {                
                newBook[z + 1] = books[z];
            }
        }
                
        books = newBook;  
    }
    //inserts book in books array at a specific index, increases array size

    public void removeBook(Book book)
    {
        boolean removed = false;

        for(int i = 0; i < books.length; i++)
        {
            if(books[i] == book)
            {
                if(books[i].getQuantity() - 1 == 0)
                {
                    books[i] = null;
                    removed = true;
                }
                else
                {
                    books[i].setQuantity(books[i].getQuantity() - 1);
                }
            }
        }

        if(removed)
        {
            Book[] newBook = new Book[books.length - 1];

            consolidateBooks();

            for(int i = 0; i < newBook.length; i++)
            {
                newBook[i] = books[i];
            }

            books = newBook;
        }
        else
        {
            consolidateBooks();
        }
    }
    //reduces the book's quantity by one, if quantity is zero then book is removed from books array
    //decreases array size
}