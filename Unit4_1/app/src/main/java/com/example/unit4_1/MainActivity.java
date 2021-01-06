package com.example.unit4_1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String output;

    EditText string1Input;
    EditText string2Input;

    Button apply;
    Button display1;
    Button compare;
    Button vowels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        string1Input = (EditText) findViewById(R.id.string1);
        string2Input = (EditText) findViewById(R.id.string2);

        apply = (Button) findViewById(R.id.addstrings);
        display1 = (Button) findViewById(R.id.display);
        compare = (Button) findViewById(R.id.compare);
        vowels = (Button) findViewById(R.id.vowels);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output = string1Input.getText().toString() + " " + string2Input.getText().toString();
                TextView out = (TextView) findViewById(R.id.total);
                out.setText(output);
            }
        });

        display1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView out = (TextView) findViewById(R.id.total);
                out.setVisibility(v.VISIBLE);
            }
        });

        compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView out = (TextView) findViewById(R.id.total);
                if(string1Input.getText().toString().equals(string2Input.getText().toString())){
                    out.setText("Output: Matching");}
                else{
                    out.setText("Output: Not Matching");}
            }
        });

        vowels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output = string1Input.getText().toString() + " " + string2Input.getText().toString();
                TextView out = (TextView) findViewById(R.id.total);
                out.setText("Output: " + countVowels(output));

            }
        });
    }

    public static int countVowels(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u')
            {
                count++;
            }
        }
        return count;
    }
}