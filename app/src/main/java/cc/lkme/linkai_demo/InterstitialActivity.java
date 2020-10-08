package cc.lkme.linkai_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.baidu.mobads.InterstitialAd;
import com.baidu.mobads.InterstitialAdListener;

import cc.lkme.common.referral.CommonError;
import cc.lkme.common.util.LMLogger;
import cc.lkme.linkai.adapter.callback.AiInteractionListener;
import cc.lkme.linkai.adapter.referral.AiAdInfo;
import cc.lkme.linkai.core.view.AiInterstitial;

public class InterstitialActivity extends AppCompatActivity {

    private Button load, show;
    private AiInterstitial aiInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);
        load = findViewById(R.id.load);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aiInterstitial.load();
//                bindInteractionView("7235551", 0, 0);
            }
        });
        show = findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aiInterstitial.show();
            }
        });
        aiInterstitial = new AiInterstitial(this, "100013");
        aiInterstitial.setOnAiInteractionListener(new AiInteractionListener() {

            @Override
            public void onLoad(AiAdInfo aiAdInfo) {
                Toast.makeText(InterstitialActivity.this, "有广告可展示", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(CommonError error) {
                Toast.makeText(InterstitialActivity.this, "无广告展示", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReady() {
                Toast.makeText(InterstitialActivity.this, "渲染成功，可以展示", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShow(AiAdInfo aiAdInfo) {
                Toast.makeText(InterstitialActivity.this, "广告展示", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onClick(AiAdInfo aiAdInfo) {
                Toast.makeText(InterstitialActivity.this, "广告点击", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClose(AiAdInfo aiAdInfo) {
                Toast.makeText(InterstitialActivity.this, "广告关闭", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //在合适的时机，释放广告的资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (aiInterstitial != null) {
            //调用destroy()方法释放
            aiInterstitial.destroy();
        }
    }

    private InterstitialAd mInterAd;

    /**
     * 创建横幅广告的View，并添加至接界面布局中 注意：只有将AdView添加到布局中后，才会有广告返回
     */
    private void bindInteractionView(String adPlaceId, int scaleWidth, int scaleHeight) {
        mInterAd = new InterstitialAd(InterstitialActivity.this, adPlaceId);
        // 设置监听器
        mInterAd.setListener(new InterstitialAdListener() {

            @Override
            public void onAdReady() {
                LMLogger.debugStackTrace();
                // 资源已经缓存完毕，还没有渲染出来
                mInterAd.showAd(InterstitialActivity.this);
            }

            @Override
            public void onAdPresent() {
                LMLogger.debugStackTrace();
                // 广告已经渲染出来
            }

            @Override
            public void onAdClick(InterstitialAd interstitialAd) {
                LMLogger.debugStackTrace();
            }

            @Override
            public void onAdDismissed() {
                LMLogger.debugStackTrace();
            }

            @Override
            public void onAdFailed(String reason) {
                LMLogger.debugStackTrace();
            }

        });
        mInterAd.loadAd();
    }
}
