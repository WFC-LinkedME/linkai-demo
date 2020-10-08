package cc.lkme.linkai_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;

import cc.lkme.common.referral.CommonError;
import cc.lkme.linkai.adapter.callback.AiNativeUnifiedListener;
import cc.lkme.linkai.adapter.referral.AiAdInfo;
import cc.lkme.linkai.core.view.AiNativeUnifiedAd;

public class NativeUnifiedActivity extends AppCompatActivity {

    private Button load;
    private AiNativeUnifiedAd aiNativeUnifiedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_unified);
        load = findViewById(R.id.load);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        aiNativeUnifiedAd = new AiNativeUnifiedAd(this, "123");
        aiNativeUnifiedAd.setOnAiNativeUnifiedListener(new AiNativeUnifiedListener() {
            @Override
            public void onLoad(AiAdInfo aiAdInfo, List<Object> ads) {
                System.out.println(ads);
            }

            @Override
            public void onFail(CommonError aiAdError) {

            }

            @Override
            public void onClose(AiAdInfo aiAdInfo) {

            }
        });
        aiNativeUnifiedAd.load();
    }
}
