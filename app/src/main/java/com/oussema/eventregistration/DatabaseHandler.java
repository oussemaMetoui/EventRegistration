package com.oussema.eventregistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.oussema.eventregistration.model.Member;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "registrationDB";
    private static final String TABLE_MEMBERS = "members";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEMBERS_TABLE = "CREATE TABLE " + TABLE_MEMBERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")";
        db.execSQL(CREATE_MEMBERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBERS);
        onCreate(db);
    }

    public void addMember(Member member){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, member.getName()); // Member Name
        values.put(KEY_EMAIL, member.getEmail()); // member email

        // Inserting Row
        db.insert(TABLE_MEMBERS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public Member getMember(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MEMBERS, new String[] { KEY_ID,
                        KEY_NAME, KEY_EMAIL }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        return new Member(Integer.parseInt(cursor.getString(0)),cursor.getString(1)
        ,cursor.getString(2));
    }

    public List<Member> getAllMembers(){
        List<Member> members = new ArrayList<>();

        String query = "SELECT * FROM "+TABLE_MEMBERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Member member = new Member();
                member.setId(Integer.parseInt(cursor.getString(0)));
                member.setName(cursor.getString(1));
                member.setEmail(cursor.getString(2));
                // Adding contact to list
                members.add(member);
            } while (cursor.moveToNext());
        }

        return members;
    }
}
