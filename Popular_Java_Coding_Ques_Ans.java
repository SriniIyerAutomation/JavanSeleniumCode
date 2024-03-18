// Online Java Compiler
// Use this editor to write, compile and run your Java code online

//a.	Find out count(occurrences) of duplicate words in a string along with count.

import java.util.*;

class DuplicateWords {
    
    //Data structures: List, Set, Queue,Stacks, Arrays,Strings,Maps(Key and Value)
    public void findDuplicateWords(String str)
    {
        //1st step: split the string into multiple words
        //2nd: we need to iterate over the array of words and then form a logic to identify if any of the words are duplicate
        //3rd: If any of them is duplicate store into a data structure along with repeated count.
        String[] listStrings=str.split(" ");//1st
        String word="";
        HashMap<String,Integer> allWords = new HashMap<String,Integer>();
        
        //2nd
        for(int i=0;i<listStrings.length;i++)
        {
            //3rd-logic to store duplicates
            word=listStrings[i];
            if(allWords.containsKey(word))//if word is present increment existing occurrence counter by 1
            {
                allWords.put(word,allWords.get(word)+1);
            }
            else //if word is not present inside hashmap
            {
                allWords.put(word,1);
            }
        }
        printDuplicateWords(allWords);
    }
    
    public void printDuplicateWords(HashMap<String,Integer> allWords)
    {
        //storage of all different entries(each entry in Java, key->value pairs)
        Set<Map.Entry<String,Integer>> setEntries = allWords.entrySet();
        Iterator<Map.Entry<String,Integer>> itrEntries=setEntries.iterator();
        while(itrEntries.hasNext())
        {
            Map.Entry<String,Integer> entry = itrEntries.next();
            if(entry.getValue() > 1)
              System.out.println(entry.getKey()+"--->"+entry.getValue());
        }
        
    }
    
    public static void main(String[] args) {
        String str="Python Java are great programming languages. Java is a very old programming language. Python has evolved over last few years and Python language will overtake Java.";
        DuplicateWords obj = new DuplicateWords();
        obj.findDuplicateWords(str);
    }
}