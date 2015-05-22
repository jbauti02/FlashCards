package com.example.joaquin.flashcards;

import java.util.*;

/**
 * This class is used for the specific list of questions and answers
 * to be displayed for the user to interact with.
 */

public class FlashCardSet {

    private ArrayList<FlashCard> flashCards = new ArrayList<FlashCard>();
    private static String subject, diff;
    private static FlashCardSet flashCardSet;

    /*
        The flash card questions based the difficulty the user chooses will be displayed for them
        to answer, so a switch statement is created based on the user's actions.
     */

    public FlashCardSet(String subject, String diff) {

        this.subject = subject;
        this.diff = diff;

        switch (subject) {

            case "animals":
                    if(diff.equals("medium")) {
                        flashCards.add(new FlashCard("What sound does a owl make?", "Whoo"));
                        flashCards.add(new FlashCard("What sound does a bird make?", "Chirp"));
                        flashCards.add(new FlashCard("What sound does a goat make?", "Bahah"));
                    } else if(diff.equals("hard")){
                        flashCards.add(new FlashCard("What sound does a mouse make?", "Squeak"));
                        flashCards.add(new FlashCard("What sound does a horse make?", "Neigh"));
                        flashCards.add(new FlashCard("What sound does a deer make?", "Bleat"));
                    } else {
                        flashCards.add(new FlashCard("What sound does a dog make?", "Woof"));
                        flashCards.add(new FlashCard("What sound does a cat make?", "Meow"));
                        flashCards.add(new FlashCard("What sound does a cow make?", "Moo"));
                    }
                    break;

            case "humans":

                if(diff.equals("medium")) {
                    flashCards.add(new FlashCard("True or false? Your ears are important when it comes to staying balanced.", "True"));
                    flashCards.add(new FlashCard("The bones that make up your spine are called what?", "Vertebrae"));
                    flashCards.add(new FlashCard(" True or false? The two chambers at the bottom of your heart are called ventricles.", "True"));
                } else if(diff.equals("hard")){
                    flashCards.add(new FlashCard("Another name for your voice box is the?", "Larynx"));
                    flashCards.add(new FlashCard("What is the human body’s biggest organ?", "The skin"));
                    flashCards.add(new FlashCard("What substance are nails made of?", "Keratin"));
                } else {
                    flashCards.add(new FlashCard("How many lungs does the human body have??", "2"));
                    flashCards.add(new FlashCard("The two holes in your nose are called?", "Nostrils"));
                    flashCards.add(new FlashCard("The bones around your chest that protect organs such as the heart are called what?", "Ribs"));
                }
                break;

            case "cars":

                if(diff.equals("medium")) {
                    flashCards.add(new FlashCard("What make is a Sentra?", "Nissan"));
                    flashCards.add(new FlashCard("What make is an Accent?", "Hyundai"));
                    flashCards.add(new FlashCard("What make is an a Aura?", "Saturn"));
                } else if(diff.equals("hard")){
                    flashCards.add(new FlashCard("What make is a BRZ?", "Subaru"));
                    flashCards.add(new FlashCard("What make is a Gran Turismo?", "BMW"));
                    flashCards.add(new FlashCard("What make is a 500 Sport?", "Fiat"));
                } else {
                    flashCards.add(new FlashCard("What make is a Civic?", "Honda"));
                    flashCards.add(new FlashCard("What make is a Camry?", "Toyota"));
                    flashCards.add(new FlashCard("What make is a Geo Metro?", "Ford"));
                }
                break;

            case "math":

                if(diff.equals("medium")) {
                    flashCards.add(new FlashCard("What is 4 - 5 + 1?", "0"));
                    flashCards.add(new FlashCard("What is 2 * 9 / 3?", "6"));
                    flashCards.add(new FlashCard("What is 35 / 7 + 6", "11"));
                } else if(diff.equals("hard")){
                    flashCards.add(new FlashCard("What is (3 + 2) / 5 - 49?", "-48"));
                    flashCards.add(new FlashCard("What is 56 / (28 - 22 + 1)?", "8"));
                    flashCards.add(new FlashCard("What is (6 * 2 * 2) - (7 - 23 + 40)?", "0"));
                } else {
                    flashCards.add(new FlashCard("What is 1 + 1?", "2"));
                    flashCards.add(new FlashCard("What is 5 - 2?", "3"));
                    flashCards.add(new FlashCard("What is 8 * 4?", "32"));
                }
                break;
                default:

                }

            }

    /*
        This is accessed by the FlashCardFragment class when the user starts up
        the "Flash Cards!" app. This returns the FlashCardSet for the flash card
        fragment class.
     */

    public static FlashCardSet getSet() {

        flashCardSet = new FlashCardSet(subject, diff);
        return flashCardSet;

    }

    /*
        Accesses the list of the flash cards to be
        used for the flash card.
     */

    public ArrayList<FlashCard> getFlashCards(){

        return flashCards;

    }

    /*
        Accesses and retrieves the specific flash card
        for the user to answer.
     */

    public FlashCard getFlashCard(int id){

        return flashCards.get(id);

    }

}
