package com.example.joaquin.flashcards;

/**
 * The class holds the questions and its answers
 * to be used for the display of the flash card.
 */

public class FlashCard {

    private String question;
    private String answer;

    public FlashCard(String question, String answer) {

        this.question = question;
        this.answer = answer;

    }

    public String getQuestion() {

        return question;

    }

    public String getAnswer() {

        return answer;

    }

}
