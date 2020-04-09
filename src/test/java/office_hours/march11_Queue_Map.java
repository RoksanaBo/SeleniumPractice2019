package office_hours;

import java.util.*;

public class march11_Queue_Map {

    public static void main(String[] args) {


    /*

    dequeue - double sided.
    we can add and retrieve elements from dequeue from
    both sides (head, end)

     */

        Deque<Integer> numbers = new ArrayDeque<>();

        numbers.addFirst(20);
        numbers.addFirst(30);
        numbers.addFirst(50);

        System.out.println(numbers); // [50, 30, 20]

        numbers.addLast(90);
        System.out.println(numbers); // [50, 30, 20, 90]

        numbers.add(33);
        System.out.println(numbers); // [50, 30, 20, 90, 33]


        Integer num = numbers.pollFirst(); // it will return and delete first element
        System.out.println(num); // 50

        System.out.println(numbers); // [30, 20, 90, 33]   , 50 was removed

        System.out.println(numbers.getLast() + " peek: " + numbers.peekLast());// 33 peek: 33, because 33 is
                                                                               // the last element

        // peek() --> returns the value (similar to get() )
        // poll() --> returns the value and remove it from the Queue
        System.out.println("dequeue after peek: " + numbers); // dequeue after peek: [30, 20, 90, 33]

//==============================================================================================
        // What collections you are using in your project?
        // describe all different collections ( List, Queue, Set )
        // explain the difference between all of them
        // pick on and explain:

        // List --> I use ArrayList most of the times, because I usually
        // just need to store some values.
        // I would use LinkedList, if I know I will need to manipulate my data
        // consistently add, remove, etc..)



        // From the Set --> I use for unique value .
        // TreeSet --> I use for unique sorted values.
        // Queue --> I use if I need to check FIFO (First in - First out) logic in my project.

//===================================================================================================
/*
        MAP Interface: does not accept any duplicate keys

       - HashMap --> key/value, can accept null
       - HashTable --> synchronized / no null values
       - LinkedHashMap --> extends the HashMap, slower than HashMap, linked (before-after-next)
       - TreeMap --> sorted, no nulls here.

 */

        HashMap <String, String> user1 = new HashMap<>();
        user1.put("First Name", null);
        user1.put("Last Name", "Smith");
        user1.put("Account Number", "A6345165");
        user1.put("DOB", "02.20.1980");

        System.out.println(user1);// {Account Number=A6345165, DOB=02.20.1980, First Name=null, Last Name=Smith}

//====================USER 2 ====================================================================================

        LinkedHashMap <String, String> user2 = new LinkedHashMap<>();
        user2.put("First Name", "John");
        user2.put("Last Name", null);
        user2.put("Last Name", "White");
        user2.put("Last Name", "Green");
        user2.put("Account Number", "A17365");
        user2.put("DOB", "12.02.1964");

        System.out.println(user2); // {First Name=John, Last Name=Green, Account Number=A6345165, DOB=02.20.1980}

//============================USER 3 ==============================================

        HashMap <String, String> user3 = new HashMap<>(user1);
        user3.put("Account Number", "A50564431");
        user3.put("DOB", "12.08.1990");

//===========================Users all together====================================

        //List <Map<String, String>> users = new ArrayList<>();
        // or we can use :
        List <HashMap<String, String>> users = new ArrayList<>();
        // LinkedHashMap extends HashMap
        users.add(user1);
        users.add(user2);
        users.add(user3);



        // print account number for all users  along with last name:
        System.out.println("===LIST=== \n" + users);

        // [{Account Number=A6345165, DOB=02.20.1980, First Name=null, Last Name=Smith},
        //  {First Name=John, Last Name=Green, Account Number=A17365, DOB=12.02.1964},
        //  {First Name=null, Account Number=A50564431, Last Name=Smith, DOB=12.08.1990}]




        for(HashMap<String,String> user : users){
            System.out.println("Account number: " + user.get("Account Number") + " | Last Name: " +user.get("Last Name"));
        }


//=====================print key + value for each user ==================================

        int i = 1;

        for(HashMap <String, String> user : users){
            System.out.println("User " + i);
            Iterator <String > keys = user.keySet().iterator();

            while (keys.hasNext()){
                String key = keys.next();
                System.out.println(key + ":" + user.get(key));
            }
            i++;
        }
        // User 1
        // Account Number:A6345165
        // DOB:02.20.1980
        // First Name:null
        // Last Name:Smith

        // User 2
        // First Name:John
        // Last Name:Green
        // Account Number:A17365
        // DOB:12.02.1964

        // User 3
        // First Name:null
        // Account Number:A50564431
        // Last Name:Smith
        // DOB:12.08.1990






    }
}
