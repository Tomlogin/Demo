package zhuoxin.andriody.com.gitdroid.retrofit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zhuoxin.andriody.com.gitdroid.gitretrofit.Tudou;

/**
 * Created by Administrator on 9/29 0029.
 */
public class GitPresenter {
    private GitView gitView;
    public GitPresenter(GitView gitView){
        this.gitView=gitView;
    }
    String key="08b127d3d67bc05a617fe7aebf1d9670";
    public void getData(final Context context){
        gitView.showProgress();
       NetRetrofitclient.getNetRetrofitclient().getdata().enqueue(new Callback<Tudou>() {
           @Override
           public void onResponse(Call<Tudou> call, Response<Tudou> response) {
               Log.e("tag", "onResponse: "+response.body().toString() );
               gitView.setData(response.body().getResult().getData().get(0).getSteps());
               gitView.hideProgress();
               gitView.showMessage("请求成功");
           }

           @Override
           public void onFailure(Call<Tudou> call, Throwable t) {
               gitView.hideProgress();
               gitView.showMessage("请求失败");
           }
       });
//                if (response.isSuccessful()) {
//                    Tudou.ResultBean ResultBean = response.body();
//                    List<Tudou.ResultBean.DataBean> data = ResultBean.getData();
//                    if (data!=null) {
//                        gitView.setData(data);
//                        gitView.hideProgress();
//                        gitView.showMessage("请求成功");
//                    }
//                }
            }
         public void postdata(){
             gitView.showProgress();
             NetRetrofitclient.getNetRetrofitclient().userregister(key,"萝卜",10,1).enqueue(new Callback<ResponseBody>() {
                 @Override
                 public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                     Gson gson=new Gson();
                     try {
                         Tudou data=gson.fromJson(response.body().string(),Tudou.class);
                         gitView.setData(data.getResult().getData().get(0).getSteps());
                         gitView.hideProgress();
                         gitView.showMessage("请求成功");
                     } catch (IOException e) {
                         e.printStackTrace();
                     }

                 }

                 @Override
                 public void onFailure(Call<ResponseBody> call, Throwable t) {
                     gitView.hideProgress();
                     gitView.showMessage("请求失败");
                 }
             });


         }


}
