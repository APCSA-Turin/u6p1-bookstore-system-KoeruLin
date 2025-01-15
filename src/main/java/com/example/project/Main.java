package com.example.project;
import java.util.Scanner;
import java.lang.Thread;

public class Main 
{
    public static void userInterface()
    {
        System.out.println("*************************************************");
        System.out.println("********** Welcome to the GFG Library! **********");
        System.out.println("*************************************************");
        System.out.println("Select From The Following Options:");
        System.out.println("-------------------------------------------------");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register User.");
        System.out.println("Press 6 to Show All Registered Users.");
        System.out.println("-------------------------------------------------");
    }
    // formats the user interface

    public static void main(String[] args)
    {
        boolean quit = false;
        BookStore bookstore = new BookStore();

        while(!quit)
        {
            Scanner scan = new Scanner(System.in);
            
            userInterface();
            
            System.out.println();
            int option = scan.nextInt();
            scan.nextLine();

            switch(option)
            {
                case 0:
                    quit = true;
                    scan.close();
                    break;
                case 1:
                    System.out.println("Enter Serial Number of Book: ");
                    String isbn = scan.nextLine();
                    
                    System.out.println("Enter name of Book: ");
                    String name = scan.nextLine();

                    System.out.println("Enter author name: ");
                    String author = scan.nextLine();

                    System.out.println("Enter publication year: ");
                    int year = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Enter quantity of Book: ");
                    int quantity = scan.nextInt();
                    scan.nextLine();

                    Book book = new Book(name, author, year, isbn, quantity);
                    bookstore.addBook(book);
                    break;
                // adds a book to bookstore
                
                case 2:
                    System.out.println("Enter name of Book to Upgrade Quantity: ");
                    String search = scan.nextLine();

                    for(int i = 0; i < bookstore.books.length; i++)
                    {
                        if(bookstore.books[i].getTitle().equals(search))
                        {
                            System.out.println("Upgrade Quantity by What Amount: ");
                            int amount = scan.nextInt();
                            scan.nextLine();

                            bookstore.books[i].setQuantity(bookstore.books[i].getQuantity() + amount);
                            break;
                        }
                    }
                    break;
                    // adds more copies of a book to the book 
         
                case 3:
                    System.out.println("Enter name of Book: ");
                    String find = scan.nextLine();

                    for(int i = 0; i < bookstore.books.length; i++)
                    {
                        if(bookstore.books[i].getTitle().equals(find))
                        {
                            System.out.println("Book Found");
                            System.out.println(bookstore.books[i].bookInfo());
                            break;
                        }
                    }
                    break;
                    // finds the book and reveals its details

                case 4:
                    for(int i = 0; i < bookstore.books.length; i++)
                    {
                        System.out.println(bookstore.books[i].bookInfo());
                    }
                    break;
                    // reveal the details of every book in bookstore
                    
                case 5:
                    System.out.println("User Name: ");
                    String userName = scan.nextLine();

                    IdGenerate.generateID();

                    User user = new User(userName, IdGenerate.getCurrentId());

                    bookstore.addUser(user);
                    bookstore.consolidateUsers();
                    
                    break;
                    // adds a new user to bookstore
                
                case 6:
                    for(int i = 0; i < bookstore.users.length; i++)
                    {
                        if(bookstore.users[i] == null)
                        {
                            break;
                        }
                        else
                        {
                            System.out.println(bookstore.users[i].userInfo());
                        }
                    }
                    break;
                   // reveals the details of every user in bookstore
                }
                
                try 
                {
                    Thread.sleep(2000); 
                } 
                catch (InterruptedException e) 
                {
                    System.out.println("Interrupted: " + e.getMessage());
                }
                // freezes the running program by 2 seconds
        }
    }
}
