package org.example;

import java.util.*;

public class TestingK {
    private int id;
    public TestingK(int id){
        this.id=id;
    }
    public int getId(){
        return  id;
    }

    @Override
    public int hashCode(){
        return id;
    }
    @Override
    public boolean equals(Object anything){
        if(this == anything){
            return true;
        }
        if(this.getClass()!=anything.getClass()|| anything==null){
            return false;
        }
        TestingK key=(TestingK) anything;
        return id==key.getId();
    }


    public static void main(String[] args) {
        MyHashTable<TestingK, Student> table = new MyHashTable<>();
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            TestingK key = new TestingK(random.nextInt(1000));
            Student value = new Student("Student " + i);
            table.put(key, value);
        }

        MyHashTable.HashNode<TestingK, Student>[] chainArray = table.getChainArray();
        for (int i = 0; i < chainArray.length; i++) {
            int count = 0;
            MyHashTable.HashNode<TestingK, Student> current = chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
        BST<Integer, String> bst = new BST<>();

        for (int i = 0; i < 10000; i++) {
            int key = random.nextInt(1000);
            String value = "Value " + i;
            bst.put(key, value);
        }

        System.out.println("Size of BST: " + bst.size());

        for (Integer key : bst.iterator()) {
            System.out.println("Key is " + key + " and value is " + bst.get(key));
        }
    }



    static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }
    }
}

