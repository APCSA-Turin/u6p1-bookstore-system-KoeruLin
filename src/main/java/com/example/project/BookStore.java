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
                consolidateUsers();
                break;
            }
        }
    }

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

    public String bookStoreUserInfo()
    {
        String info = "";
        for(int i = 0; i < books.length; i++)
        {
            info += books[i].bookInfo() + "\n";
        }
        return info;
    } //you are not tested on this method but use it for debugging purposes

    public static void main(String[] args)
    {
        BookStore store = new BookStore(); 
        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        Book b2 = new Book("The Outliers", "Malcolm Gladwell",2008,"978-0316017930",1);
        Book b3 = new Book("1984", "George Orwell", 1949, "978-0451524935", 5);
        Book b4 = new Book("Brave New World", "Aldous Huxley", 1932, "978-0060850524", 3);
        Book b5 = new Book("Test","Author",1900, "1234", 1);
        store.addBook(b1);
        store.addBook(b4);
        store.insertBook(b2, 1);
        store.insertBook(b3,2);
        store.insertBook(b5,4);

        for(Book book : store.books)
        {
            System.out.println(book);
        }
    }
}