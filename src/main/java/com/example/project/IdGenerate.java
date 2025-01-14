package com.example.project;

public class IdGenerate
{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    private static String currentId = "99";

    public IdGenerate()
    {
    }
    
    //requires 1 private attribute String currentId. You must initialize it to 99

    //requires one empty constructor
    public static String getCurrentId()
    {
        return currentId;
    }

    public static void reset()
    {
        currentId = "99";
    } 
    //must reset the currentId back to 99

    public static String generateID()
    {
        Integer incrementedCurrent = (Integer.parseInt(currentId) + 1);
        currentId = incrementedCurrent.toString();

        return currentId;
    } 
    //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
}