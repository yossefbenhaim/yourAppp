package com.yosss.yourappraiser.screens;



import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.firebase.firestore.FirebaseFirestore;
        import com.google.firebase.firestore.QuerySnapshot;
        import com.yosss.yourappraiser.R;
        import com.yosss.yourappraiser.login.UtilsForLogin;
        import com.yosss.yourappraiser.objects_for_chat.User;
        import com.yosss.yourappraiser.objects_for_chat.Utils;

import java.util.ArrayList;

public class Login extends AppCompatActivity {


    private Button conected,chak;
    private EditText userName,password,phone,gender;
    private SharedPreferences sharedPreferences;
    private User globalUser;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logine);
        init();
    }


    private   void init() {

        sharedPreferences = getSharedPreferences(UtilsForLogin.SP_NAME, MODE_PRIVATE);

        userName = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        chak = findViewById(R.id.contenu);
        phone = findViewById(R.id.mobil_num);
        gender = findViewById(R.id.address);
        conected = findViewById(R.id.contenu);
        conected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                globalUser = new User(userName.getText().toString(),
                        password.getText().toString(), phone.getText().toString(), gender.getText().toString());
                if (globalUser.getName().length() >= 3 && globalUser.getPassword().length() >= 6) {
                    db.collection("users").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            ArrayList<User> users = (ArrayList<User>) queryDocumentSnapshots.toObjects(User.class);
                            if (users.contains(globalUser)) {
                                moveToChatsActivity();
                            } else {
                                boolean exist = false;
                                for (User user : users) {
                                    exist = user.getName().contains(globalUser.getName());
                                    if (exist) {
                                        break;
                                    }
                                }
                                if (exist) {
                                    Toast.makeText(Login.this, "יש לוודא שהפרטים שהוזנו תקינים", Toast.LENGTH_SHORT).show();
                                } else {
                                    db.
                                            collection("users").
                                            document(globalUser.getName()).
                                            set(globalUser).
                                            addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {

                                                    moveToChatsActivity();
                                                }
                                            });
                                }

                            }
                        }
                    });
                } else if (userName.getText().toString().length() < 3) {
                    userName.setError("יש להזין שם משתמש עם שלושה תווים ומעלה");
                } else {
                    password.setError("יש למלא סיסמה בעלת שישה תווים ומעלה");
                }
            }
        });
    }
    private void moveToChatsActivity() {
        Utils.user=globalUser;
        sharedPreferences.edit().putBoolean(Utils.IS_CONNECTED,true).apply();
        sharedPreferences.edit().putString(Utils.USER_NAME,globalUser.getName()).apply();
        startActivity(new Intent(Login.this, MainActivity.class));
    }

}
