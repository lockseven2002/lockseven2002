package com.example.lockseven2002.readphptest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnReadAll;
    Button btnNew;
    TextView largeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClickEvent btnClickListener = new ClickEvent();

        btnNew = (Button) findViewById(R.id.btnCreate);
        btnReadAll = (Button) findViewById(R.id.btnAllRead);
        largeText = (TextView) findViewById(R.id.tvShow);

        btnReadAll.setOnClickListener(new ClickEvent());
        btnNew.setOnClickListener(new ClickEvent());
    }

    public class ClickEvent implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAllRead:
                    new Async().execute("http://10.0.3.2:8080/readAll20160510.php");
                    break;
                default:
                    break;
            }
        }
    }

    public class Async extends AsyncTask<String, String, String> {

        protected String doInBackground(String... params) {
            String strEndSplit = "";
            Http_Connect httpConn = new Http_Connect(params[0]);
            strEndSplit = httpConn.http_Conn();
            return strEndSplit;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            largeText.setText(s);
        }
    }

}


