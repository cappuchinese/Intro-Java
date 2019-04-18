package snippets.apis;

import snippets.syntax.Duck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        //typed collection
//        ArrayList<String> words = new ArrayList<>();

        //better
//        List<String> words = new ArrayList<>();
        List<String> words = new LinkedList<>();


        words.add("Game");
        words.add("of");
        words.add("Thrones");
//        words.add(new Duck());

        for (String word : words) {
            System.out.println("word = " + word);
        }
        //type is inferred from collection
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            System.out.println("word = " + i + ": " + word);
        }

        words.contains("Thrones"); //true
        words.size(); //3
        words.isEmpty(); //false
        //same as
        boolean empty = words.size() == 0;

        words.remove("of"); //deletes word
        words.remove(1); //second element
        words.clear(); //empty list


        //"raw" type collection: everything is Object
        ArrayList wordsNonGeneric = new ArrayList();
        wordsNonGeneric.add("House");
        wordsNonGeneric.add("of");
        wordsNonGeneric.add("Cards");
        //danger!
        wordsNonGeneric.add(new Duck());

        //iterate over Object type
        for (int i = 0; i < wordsNonGeneric.size(); i++) {
            //need to cast to actual type
            //this will give a ClassCastException exception on the Duck, which is of course not a String!
            Object element = wordsNonGeneric.get(i);
            if (element instanceof String) {
                String word = (String) element;
                System.out.println("word = " + i + ": " + word);
            } else {
                System.out.println("skipped non-String element of type " + element.getClass().getSimpleName());
            }
        }
    }
}
