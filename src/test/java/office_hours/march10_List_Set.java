package office_hours;

import java.util.*;

public class march10_List_Set {

    public static void main(String[] args) {


/*
     In my work most of the time I use ArrayList to store anything
      into the structure as a List. I never used Queue, but I know some
      examples where it can be used. Sometimes I use HashSet to store some
      unique values if I need.
      Most of the time I use the HashMap.


-------------------------------------------------------------------------------------------
     LIST:
       Under List Interface we have:

     - ArrayList (indexes, faster to read, slower when we
       do manipulations(remove or add elements)

     - Vector (same as ArrayList, but thread safe)

     - Stack (Last in - First out (like a stack of paper))

     - LinkedList (node (each element reference to previous
       and next element in the list))
       (performance- sensitive чувствительный к производительности,
       memory allocation  выделение памяти)


      [2, 5, 3] --> if we remove 5 --> [2, 3]
      [2] [5] [3]

---------------------------------------------------------------------------------------------------

    SET:
      Set Interface: set is structure that does not contain duplicates. It contains only unique values
      -HashSet --> no indexes - faster, because it's use hashing крошить,
                   it does not keep an order, allows 1 null

      -TreeSet : sorted set, no nulls
      -LinkedHashSet : keeps the order

---------------------------------------------------------------------------------------------------

 */
        HashSet <String> hashSet = new HashSet<>();
        TreeSet <String> treeSet = new TreeSet<>();
        LinkedHashSet <String> linkedHashSet = new LinkedHashSet<>();

        for(String each : Arrays.asList("Value5", "Value1", "Value3")){
            hashSet.add(each);
            treeSet.add(each);
            linkedHashSet.add(each);
        }
        System.out.println("hashSet: " + hashSet); //  [Value3, Value1, Value5]
        System.out.println("treeSet: " + treeSet); //  [Value1, Value3, Value5]
        System.out.println("linkedHashSet: " + linkedHashSet); // [Value5, Value1, Value3]


        // loop through the Set, use iterator:
        Iterator <String> iteratorSet = hashSet.iterator();
        while ((iteratorSet.hasNext())){
            System.out.println(iteratorSet.next()); // go through one by one
            // Value3
            // Value1
            // Value5
        }

//======================================================================================================

        ArrayList <Integer> dropdown = new ArrayList<>();
        dropdown.add(1);
        dropdown.add(2);
        dropdown.add(3);
        dropdown.add(4);
        dropdown.add(5);
        dropdown.add(1);
        // [ 1, 2, 3, 4, 5, 1 ]
        System.out.println("list: " + dropdown);

        HashSet <Integer> optionsSet = new HashSet<>(dropdown);
        System.out.println("optionSet: " + optionsSet);

        if(optionsSet.size() == dropdown.size()){
            System.out.println("expected is the same as actual");

        }else {
            System.out.println("options contains duplicates");
        }

//================================================================================================
/*    QUEUE:

      PriorityQueue --> First in- first out --> can accept duplicates, but it does not have indexes.

      ArrayDequeue --> special in adding and removing
 */

     PriorityQueue <String> priorityQueue = new PriorityQueue<>();
     priorityQueue.add("John");
     priorityQueue.add("Kate");
     priorityQueue.add("Tom");

        System.out.println("Queue: " + priorityQueue);  //  [John, Kate, Tom]

        System.out.println("peek: " + priorityQueue.peek());
        System.out.println("queue after peek: " + priorityQueue);
        // peek --> peeking -> it will check and return the first element in a queue

        System.out.println("poll: " + priorityQueue.poll());
        System.out.println("queue after poll: " + priorityQueue);
        // poll -> polling will return the first value in queue and remove it
        //         опрос вернет первое значение в очереди и удалит его


        //====================================================================================







    }
}
