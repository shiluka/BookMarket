package bookrating.algorithm.hashmap;

import bookrating.book.Book;

//Hash Map for Book
public class HashMap {

      private final static int TABLE_SIZE = 1500;
      private HashEntry[] table;

      public HashMap() {
            table = new HashEntry[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++)
                  table[i] = null;
      }

      public Book get(String key) {    	  
            int hash = (Math.abs(key.hashCode()) % (TABLE_SIZE));
            //System.out.println("**" + hash+" "+table[hash].getKey()+ " **"+ key);
            while (table[hash] != null && !(table[hash].getKey().equals(key))){
                  hash = (hash + 1) % (TABLE_SIZE);
            }
            if (table[hash] == null)
                  return null;
            else
                  return table[hash].getValue();
      }

 

      public void put(String key, Book value) {

            int hash = (Math.abs(key.hashCode()) % (TABLE_SIZE));

            while (table[hash] != null && !(table[hash].getKey().equals(key)))
                  hash = (hash + 1) % (TABLE_SIZE);

            table[hash] = new HashEntry(key, value);
      }
      
      public void print(){
    	  
    	  for(int i=0;i<TABLE_SIZE;i++){
    		  if(table[i]==null) i++;
    		  else
    		  System.out.println(table[i].getValue().getName() + " " + table[i].getKey()+"*");
    	  }
      }

}