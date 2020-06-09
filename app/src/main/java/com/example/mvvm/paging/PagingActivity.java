package com.example.mvvm.paging;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityPagingBinding;

public class PagingActivity extends AppCompatActivity {

    ActivityPagingBinding        mBinding;
    StudentDao                   mDao;
    StudentDatabase              mDatabase;
    LiveData<PagedList<Student>> mLiveData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_paging);
        //        mBinding = ActivityPagingBinding.inflate(getLayoutInflater());
        RvAdapter adapter = new RvAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mBinding.dataRv.setLayoutManager(linearLayoutManager);
        mBinding.dataRv.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        mBinding.dataRv.setAdapter(adapter);
        mDatabase = StudentDatabase.getInstance(this);
        mDao = mDatabase.studentDao();
        mLiveData = new LivePagedListBuilder<>(mDao.getAllStudents(), 30).build();
        mLiveData.observe(this, new Observer<PagedList<Student>>() {
            @Override
            public void onChanged(PagedList<Student> students) {
                adapter.submitList(students);
                students.addWeakCallback(null, new PagedList.Callback() {
                    @Override
                    public void onChanged(int position, int count) {
                        Log.e("TAG", "changed position " + position
                                + "   count:" + count);
                    }

                    @Override
                    public void onInserted(int position, int count) {

                    }

                    @Override
                    public void onRemoved(int position, int count) {

                    }
                });
            }
        });

        mBinding.btnCreate.setOnClickListener(v -> {
            Student[] students = new Student[1000];
            for (int i = 0; i < 1000; i++) {
                Student student = new Student();
                student.setStudentNumber(i);
                students[i] = student;
            }
            new InsertAsync(mDao).execute(students);
        });

        mBinding.btnClear.setOnClickListener(v -> {
            new ClearAsync(mDao).execute();
        });

    }

    static class InsertAsync extends AsyncTask<Student, Void, Void> {

        StudentDao mStudentDao;

        public InsertAsync(StudentDao studentDao) {
            mStudentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            mStudentDao.insertStudents(students);
            return null;
        }
    }

    static class ClearAsync extends AsyncTask<Void, Void, Void> {

        StudentDao mStudentDao;

        public ClearAsync(StudentDao studentDao) {
            mStudentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mStudentDao.deletAllStudents();
            return null;
        }
    }
}