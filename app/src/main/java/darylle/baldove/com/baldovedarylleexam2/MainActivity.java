package darylle.baldove.com.baldovedarylleexam2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText eFname,eLname, eExam1,eExam2, eAverage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eFname = findViewById(R.id.etFname);
        eLname = findViewById(R.id.etLname);
        eExam1 = findViewById(R.id.etExam1);
        eExam2 = findViewById(R.id.etExam2);
        eAverage = findViewById(R.id.etAverage);
    }

    public void saveExternal(View v)
    {
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(folder, "External.txt");
        String FName = eFname.getText().toString();
        String LName = eLname.getText().toString();
        int Exam1 = Integer.parseInt(eExam1.getText().toString());
        int Exam2 = Integer.parseInt(eExam2.getText().toString());
        int Ave = (Exam1 + Exam2)/2;
        String persist = FName + LName + Ave;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(persist.getBytes());
            Toast.makeText(this, "SAVED IN SD CARD!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.d("Error", "Error writing to file");
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        eAverage.setText(Integer.toString(Ave));
        Toast.makeText(this, "Success, saved in" + getExternalFilesDir("Data3.txt"), Toast.LENGTH_SHORT).show();

    }

}
