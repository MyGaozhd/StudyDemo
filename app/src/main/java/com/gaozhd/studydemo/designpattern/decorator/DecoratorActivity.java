package com.gaozhd.studydemo.designpattern.decorator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.gaozhd.studydemo.R;
import com.gaozhd.studydemo.activity.BaseActivity;

/**
 * @author Gao ZhiDong <gaozhidong@tiantanhehe.com>
 * @ClassName: ${type_name}
 * @Description: ${todo}
 * @date ${date} ${time}
 * <p/>
 * ${tags}
 */
public class DecoratorActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorator);

        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    private void init() {

        StudentInterface student = new Student(new Study());
        student.study();
        Log.d("gaozhd", "/*********************************/");
        StudentInterface student1 = new Student1(student);
        student1.study();
        Log.d("gaozhd", "/*********************************/");
        StudentInterface student2 = new Student2(student1);
        student2.study();

    }
}
