package zhuoxin.andriody.com.gitdroid.git;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 11/7 0007.
 */
public class madapter extends PagerAdapter {
    private List<ImageView> list ;
    private Context context;

    public madapter(List<ImageView> list,Context con) {
        this.list = list;
        context=con;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View ret = null;

        //对ViewPager页号求摸取出View列表中要显示的项
        position %= list.size();
        Log.d("Adapter", "instantiateItem: position: " + position);
        ret = list.get(position);
        //如果View已经在之前添加到了一个父组件，则必须先remove，否则会抛出IllegalStateException。
        ViewParent viewParent = ret.getParent();
        if (viewParent != null) {
            ViewGroup parent = (ViewGroup) viewParent;
            parent.removeView(ret);
        }
        container.addView(ret);

        return ret;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }


}
