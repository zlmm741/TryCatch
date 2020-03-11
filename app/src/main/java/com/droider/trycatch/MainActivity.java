package com.droider.trycatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tryCatch(100, "6");
    }

    private void tryCatch(int drumsticks, String people) {
        try {
            int i = Integer.parseInt(people);
            try {
                int m = drumsticks / i;
                int n = drumsticks - m * i;
                String str = String.format("共有 %d 只鸡腿，%d 个人平分，" +
                        "每人可分 %d 只，还剩 %d 只", drumsticks, i, m, n);
                Toast.makeText(this,
                        str,
                        Toast.LENGTH_SHORT).show();
            }
            catch (ArithmeticException e) {
                Toast.makeText(this,
                        "人数不能为 0",
                        Toast.LENGTH_SHORT).show();
            }
        }
        catch (NumberFormatException e) {
            Toast.makeText(this,
                    "无效的数值字符串",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
