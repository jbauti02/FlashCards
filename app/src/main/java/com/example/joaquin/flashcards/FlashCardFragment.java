package com.example.joaquin.flashcards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * This class is used to display the flash card. It implements
 * the FlashCard and the FlashCardSet classes to cycle through the
 * questions and answers that are being accessed by the user.
 */

public class FlashCardFragment extends Fragment {

    private static final String KEY_CARD_NUM = "card_num";
    private View view;
    private int cardNum = 0;
    FlashCard flashCard;
    FlashCardSet flashCardSet;
    ArrayList<FlashCard> flashCards;

    /*
        This is the main method to create the flash card. It uses the extra strings
        to access the specific category and difficulty based on the user's selection.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String subject = getActivity().getIntent().getStringExtra(Integer.toString(R.string.key));
        String diff = getActivity().getIntent().getStringExtra(Integer.toString(R.string.diff_key));
        flashCardSet = new FlashCardSet(subject, diff);
        flashCards = flashCardSet.getFlashCards();

    }

    /*
        Display the contents of the card of the app to be answered.
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_flash_card, container, false);
        initFlashCard();
        clickPrev();
        clickNext();

        return view;

    }

    /*
        Create the contents for the flash card so they can access the FlashCard and the
        FlashCardSet classes for the questions and answers to be displayed.
     */

    public void initFlashCard() {

        flashCard = FlashCardSet.getSet().getFlashCard(cardNum);

        final TextView question = (TextView)view.findViewById(R.id.question_text_view);
        question.setText(flashCard.getQuestion());

        question.setOnClickListener(new View.OnClickListener() {

            boolean switched = true;

            @Override
            public void onClick(View v) {

                if(switched) {
                    question.setText(flashCard.getAnswer());
                    switched = false;

                } else {
                    question.setText(flashCard.getQuestion());
                    switched = true;
                }

            }

        });

    }

    /*
        This method cycles through the flash cards of the specific category based on the
        difficulty previously.
     */

    public void clickPrev() {

        Button button = (Button)view.findViewById(R.id.prev_button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                int size = flashCards.size();
                cardNum = (cardNum + (size - 1)) % flashCards.size();
                initFlashCard();

            }
        });

    }

    /*
        This method cycles through the flash cards of the specific category based on the
        difficulty forward.
     */

    public void clickNext() {

        Button button = (Button)view.findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                cardNum = (cardNum + 1) % flashCards.size();
                initFlashCard();

            }

        });

    }

}
