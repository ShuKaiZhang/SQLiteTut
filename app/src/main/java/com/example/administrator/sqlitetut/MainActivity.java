package com.example.administrator.sqlitetut;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected DBManager dbManager;
    protected TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager = new DBManager(this);
        textView = (TextView) this.findViewById(R.id.textView);

        getUserName("2");
    }

    public void insertData() {
        try {
            dbManager.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbManager.insertUser("11", "John", "12/10/1991");
        dbManager.insertUser("2", "Mary", "23/11/1990");
        dbManager.insertUser("13", "Helen", "13/08/1992");
        textView.setText(readData());
        dbManager.close();
    }

    public String readData() {
        Cursor c = dbManager.getAllUsers();
        String s = "";
        if (c.moveToFirst()) {
            do {
                s += "id: " + c.getString(0) + "\t" + "Name: " + c.getString(1) + "\t" + "DOB: " + c.getString(2) + "\n";
            } while (c.moveToNext());
        }
        return s;
    }

    public void deleteData(String id) {
        try {
            dbManager.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbManager.deleteUser(id);
        textView.setText(readData());
        dbManager.close();
    }

    public void updateUserName(String id, String name) {
        try {
            dbManager.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dbManager.updateUser(id, name);
        textView.setText(readData());
        dbManager.close();
    }
    public void getUserName(String id) {
        try {
            dbManager.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Cursor c =dbManager.getUser(id);
        String s = "";
        if (c.moveToFirst()) {
            do {
                s += "id: " + c.getString(0) + "\t" + "Name: " + c.getString(1) + "\t" + "DOB: " + c.getString(2) + "\n";
            } while (c.moveToNext());
        }
        textView.setText(s);
        dbManager.close();
    }

}
