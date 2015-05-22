package com.example.joaquin.flashcards;

import android.support.v4.app.Fragment;

/**
 * This class is the base of the FlashCardFragment class, this class
 * has to be called in the Intent in order to access the flash card,
 * which is the FlashCardFragment class.
 */

public class FlashCardActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new FlashCardFragment();
    }
}
