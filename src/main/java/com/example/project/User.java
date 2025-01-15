package com.example.project;

public class User
{
    private String name;
    private String Id;
    public Book[] book = new Book[5];

    public User(String name, String id)
    {
        this.name = name;
        Id = id;
    }
 
    public String getName() 
    {
        return name;
    }

    public void setName(String newName) 
    {
        name = newName;
    }

    public String getId() 
    {
        return Id;
    }

    public void setId(String newId) 
    {
        Id = newId;
    }

    public Book[] getBooks() 
    {
        return book;
    }

    public void setBooks(Book[] newBook) 
    {
        book = newBook;
    }

    public String bookListInfo()
    {
        String info = "";

        for (int i = 0; i < book.length; i++)
        {
            info += (book[i] == null) ? "empty\n" : 
            "Title: " + book[i].getTitle() + ", " + "Author: " + book[i].getAuthor() + ", " + "Year: " + book[i].getYearPublished()
            + ", " + "ISBN: " + book[i].getIsbn() + ", " + "Quantity: " + book[i].getQuantity() + "\n"; 
        }

        return info;
    } 
    //returns a booklist for the user detailing the books' author, title,
    //publication date, and serial number, if empty, output "empty"

    public String userInfo()
    {
        return  "Name: " + name + "\n" + "Id: " + IdGenerate.getCurrentId() + "\n" + "Books: \n" + bookListInfo();
    }
    // returns the user info and books they checked out 
}