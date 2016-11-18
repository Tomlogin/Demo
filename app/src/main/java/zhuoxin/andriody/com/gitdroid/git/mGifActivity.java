package zhuoxin.andriody.com.gitdroid.git;

import android.animation.StateListAnimator;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import butterknife.Bind;
import butterknife.ButterKnife;
import zhuoxin.andriody.com.gitdroid.R;

public class mGifActivity extends AppCompatActivity {

    @Bind(R.id.flipper)
    ViewFlipper flipper;
    private int imgs[]={R.drawable.lead_1,R.drawable.lead_2,R.drawable.lead_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_gif);
        ButterKnife.bind(this);
        for (int i = 0; i <imgs.length ; i++) {
            flipper.addView(getimgdata(imgs[i]));
        }

        flipper.setInAnimation(this,R.anim.left_in);
        flipper.setOutAnimation(this,R.anim.left_out);
        flipper.setFlipInterval(3000);
        flipper.startFlipping();
        



    }
    private ImageView getimgdata(int id){
        ImageView img=new ImageView(this);
        img.setBackgroundResource(id);
        return img;
    }
}
