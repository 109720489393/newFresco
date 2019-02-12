package com.example.windows_zxy.newfresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.but_one)
    Button butOne;
    @BindView(R.id.but_two)
    Button butTwo;
    @BindView(R.id.but_three)
    Button butThree;
    @BindView(R.id.but_four)
    Button butFour;
    @BindView(R.id.but_five)
    Button butFive;
    @BindView(R.id.but_six)
    Button butSix;
    @BindView(R.id.but_seven)
    Button butSeven;
    @BindView(R.id.but_eight)
    Button butEight;
    @BindView(R.id.image_fresco)
    SimpleDraweeView imageFresco;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        uri = Uri.parse("http://pic1.win4000.com/mobile/2018-11-15/5bed347fc089f.jpg");
        imageFresco.setImageURI(uri);
    }

    @OnClick({R.id.but_one, R.id.but_two, R.id.but_three, R.id.but_four, R.id.but_five, R.id.but_six, R.id.but_seven, R.id.but_eight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_one:
                RoundingParams rp = new RoundingParams();
                rp.setRoundAsCircle(true);
                GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(getResources())
                        //设置圆形圆角参数
                        .setRoundingParams(rp)
                        .setRoundingParams(RoundingParams.fromCornersRadii(20, 25, 30, 35))
                        .build();
                imageFresco.setHierarchy(hierarchy);
                AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setTapToRetryEnabled(true)
                        .build();
                imageFresco.setController(build);
                break;
            case R.id.but_two:
                GenericDraweeHierarchy hierarchy1 = GenericDraweeHierarchyBuilder.newInstance(getResources())
                        .setRoundingParams(RoundingParams.asCircle())
                        .build();
                imageFresco.setHierarchy(hierarchy1);
                AbstractDraweeController build1 = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        .setTapToRetryEnabled(true)
                        .build();
                imageFresco.setController(build1);
                break;
            case R.id.but_three:
                imageFresco.setAspectRatio(1.2f);
                break;
            case R.id.but_four:
                ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(uri)
                        //设置支持渐进式加载
                        .setProgressiveRenderingEnabled(true)
                        .build();
                AbstractDraweeController build2 = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        //如果支持重置,必须在controller进行控制
                        .setTapToRetryEnabled(true)
                        //setImageRequest,支持渐进式加载
                        .setImageRequest(imageRequest)
                        //设置GIF自动播放
                        .setAutoPlayAnimations(true)
                        .build();
                imageFresco.setController(build2);

                break;
            case R.id.but_five:
                break;
            case R.id.but_six:
                uri = Uri.parse("http://img02.sogoucdn.com/app/a/100520021/506d836d1e3b115e259f33788d89fcfa");
                AbstractDraweeController build3 = Fresco.newDraweeControllerBuilder()
                        .setUri(uri)
                        //如果支持重置,必须在controller进行控制
                        .setTapToRetryEnabled(true)
                        //设置GIF自动播放
                        .setAutoPlayAnimations(true)
                        .build();
                imageFresco.setController(build3);
                break;
            case R.id.but_seven:
                break;
            case R.id.but_eight:
                break;
        }
    }
}
