package cc.lkme.linkai_demo;

import android.app.Application;

import cc.lkme.linkai.adapter.AiAdConfig;
import cc.lkme.linkai.core.LinkAi;

public class CustomApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AiAdConfig aiAdConfig = new AiAdConfig.Builder()
                .setOpenAdAppId("5101295")
                .setGdtAppId("1110911996")
                .setBaiduAppId("cf690f12")
                .setCacheAdPositionInfo(true)
                .setUseTextureView(false)
                .build();
        LinkAi.getInstance(this, "9f3265281569e995f65bde2949bf9e5c", aiAdConfig);
        LinkAi.getInstance().setDebug();
    }
}
