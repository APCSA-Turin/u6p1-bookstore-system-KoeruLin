package com.example.project;

public class IdGenerate
{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    private static String currentId = "99";

    public IdGenerate()
    {
    }

    //requires one empty constructor
    public static String getCurrentId()
    {
        return currentId;
    }

    public static void reset()
    {
        currentId = "99";
    } 
    //reset the currentId back to 99

    public static void generateID()
    {
        int incrementedCurrent = (Integer.parseInt(currentId) + 1);
        currentId = Integer.toString(incrementedCurrent);
    } 
    //generates a new id, when called it will increment the currentId by 1
    // converts currentId to a int so it can be incremented before turning back into a string

}