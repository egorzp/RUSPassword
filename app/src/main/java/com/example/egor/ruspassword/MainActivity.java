package com.example.egor.ruspassword;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    EditText engPasEditText, rusPasEditText;
    char[] rus = {'й', 'ц', 'у', 'к', 'е', 'н', 'г', 'ш', 'щ',

            'з', 'х', 'ъ', 'ф', 'ы', 'в', 'а', 'п', 'р',

            'о', 'л', 'д', 'ж', 'э', 'я', 'ч', 'с', 'м',

            'и', 'т', 'ь', 'б', 'ю', 'ё',

            'Й', 'Ц', 'У', 'К', 'Е', 'Н', 'Г', 'Ш', 'Щ',

            'З', 'Х', 'Ъ', 'Ф', 'Ы', 'В', 'А', 'П', 'Р',

            'О', 'Л', 'Д', 'Ж', 'Э', 'Я', 'Ч', 'С', 'М',

            'И', 'Т', 'Ь', 'Б', 'Ю', 'Ё'};
    char[] eng = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o',

            'p', '[', ']', 'a', 's', 'd', 'f', 'g', 'h',

            'j', 'k', 'l', ';', '"', 'z', 'x', 'c', 'v',

            'b', 'n', 'm', ',', '.', '`',

            'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',

            'P', '{', '}', 'A', 'S', 'D', 'F', 'G', 'H',

            'J', 'K', 'L', ':', '"', 'Z', 'X', 'C', 'V',

            'B', 'N', 'M', '<', '>', '~'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        engPasEditText = (EditText)findViewById(R.id.engPasEditText);
        rusPasEditText = (EditText)findViewById(R.id.rusPasEditText);

    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonConvert:    String result="";
        char[] array = rusPasEditText.getText().toString().toCharArray();
        for (int i = 0; i < array.length; i++){
            int count = 0;
            for (int j = 0; j < rus.length; j++){
                if(array[i]==rus[j]){
                    result+=eng[j];
                    count++;
                    continue;
                }
            }
            if(count ==0){result+=array[i];}
        }
        engPasEditText.setText(result);
        break;
            case R.id.buttonCoppy:
                ClipboardManager ClipMan = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipMan.setText(engPasEditText.getText());
                break;
            default:break;
    }

    }
}
