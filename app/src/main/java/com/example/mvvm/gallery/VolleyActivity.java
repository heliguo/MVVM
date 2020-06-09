package com.example.mvvm.gallery;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.LruCache;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.mvvm.R;
import com.example.mvvm.databinding.ActivityVolleyBinding;

public class VolleyActivity extends AppCompatActivity {

    ActivityVolleyBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_volley);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_volley);
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(
                StringRequest.Method.GET,
                "http://www.baidu.com",
                response -> {

                },
                error -> {

                }
        );
        queue.add(request);

        ImageLoader imageLoader = new ImageLoader(queue, new ImageLoader.ImageCache() {

            private LruCache<String, Bitmap> mCache = new LruCache<>(20);

            @Override
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
        });

        imageLoader.get("", new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                Glide.with(VolleyActivity.this)
                        .load("")
                        .placeholder(R.drawable.ic_launcher_background)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        })
                        .into(mBinding.volleyimge);
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mBinding.volleynetimge.setImageUrl("", imageLoader);

        mBinding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });


    }
}