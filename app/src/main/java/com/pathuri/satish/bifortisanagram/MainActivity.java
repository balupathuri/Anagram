package com.pathuri.satish.bifortisanagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private Button checkResults;
    private String str1,str2;
    private TextView resultstoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        checkResults=(Button)findViewById(R.id.button);

        checkResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1=editText1.getText().toString();
                str2=editText2.getText().toString();

                if (isAnagram(str1, str2)) {
                    Toast.makeText(getApplicationContext(),str2 + " is anagram of " + str1,Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "This two Strings are not anagrams", Toast.LENGTH_SHORT).show();

                }
            }

        });

    }


        private static boolean isAnagram(String str1, String str2) {
            // If length of strings are not same, the strings are not anagrams.
            if (str1 == null || str2 == null || str1.length() != str2.length()) {
                return false;
            }

            char[] str1Chars = str1.toLowerCase().toCharArray();
            StringBuilder builder = new StringBuilder(str2.toLowerCase());

            for (Character ch : str1Chars) {

                // Find the index of the current character in builder.
                int index = builder.indexOf(String.valueOf(ch));
                if (index == -1) {
                    return false;
                }
                // Remove the character from builder so that multiple occurrences of
                // a character in the first string will be matched with equal number
                // of occurrences of the character in the second string.
                builder.delete(index, index + 1);
            }
            return true;
        }
    }

