package zhuoxin.andriody.com.gitdroid.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zhuoxin.andriody.com.gitdroid.R;
import zhuoxin.andriody.com.gitdroid.gitretrofit.Tudou;

public class RetrofitActivity extends AppCompatActivity {

    @Bind(R.id.btn_retrofit)
    Button btnRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_retrofit)
    public void onClick() {
        NetRetrofitclient.getNetRetrofitclient().getdata().enqueue(new Callback<Tudou>() {
            @Override
            public void onResponse(Call<Tudou> call, Response<Tudou> response) {
                Toast.makeText(RetrofitActivity.this, "响应成功", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Tudou> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "响应失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
