package com.yosss.yourappraiser.screens;



import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
        import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

    private static int SPLASH_TIMER = 5000;

     Button conected;
     EditText userName,password,phone,gender;
     SharedPreferences sharedPreferences;
     User globalUser;

Animation bottun,userName1,password1,phone1,gender1;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logine);
        init();



       userName1 = AnimationUtils.loadAnimation(this,R.anim.test6_anim);
        password1 = AnimationUtils.loadAnimation(this,R.anim.test7_anim);
        phone1 = AnimationUtils.loadAnimation(this,R.anim.test8_anim);
        gender1 = AnimationUtils.loadAnimation(this,R.anim.test9_anim);
        bottun = AnimationUtils.loadAnimation(this,R.anim.test11_anim);

        conected.setAnimation(bottun);
        userName.setAnimation(userName1);
        password.setAnimation(password1);
        phone.setAnimation(phone1);
        gender.setAnimation(gender1);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Login.this, "ברוך הבא", Toast.LENGTH_SHORT).show();

            }
        },SPLASH_TIMER);
    }


    private   void init() {

        sharedPreferences = getSharedPreferences(UtilsForLogin.SP_NAME, MODE_PRIVATE);

        userName = findViewById(R.id.email);
        password = findViewById(R.id.pass);

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
