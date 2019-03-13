package com.centar.zds;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.onesignal.OneSignal;

public class WebViewActivity extends AppCompatActivity  {
    WebView webView;
    String naslovnaHtml;
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
            OneSignal.startInit(this)
                    .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                    .unsubscribeWhenNotificationsAreDisabled(true)
                    .init();
                WebView.setWebContentsDebuggingEnabled(false);
            webView = findViewById(R.id.webView123);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // Here put your code
                if(url.equals("https://czds.rs/"))
                {
                    view.loadData(naslovnaHtml, "text/html; charset=UTF-8", "utf-8");
                }
                else{
                view.loadUrl(url);
                }
                // return true; //Indicates WebView to NOT load the url;
                return false; //Allow WebView to load url
            }
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView.loadUrl("file:///android_asset/noInternet.html");
            }
        });
        final WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        Ion.with(getApplicationContext())
                    .load("https://czds.rs")
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {
                            naslovnaHtml = customHtml(result);
                            webView.loadData(naslovnaHtml, "text/html; charset=UTF-8", "utf-8");
                        }
                    });

    }


    private String customHtml(String html)
    {

        String replacedArchive = html.replace("\"widget widget_archive\"","\"widget widget_archive d-none\"");
        String replacedMain = replacedArchive.replace("site-main", "site-main d-flex flex-wrap");
        String replacedNews = replacedMain.replace("post-prev sh1-box","post-prev sh1-box p-1 \" style=\"width:49%; margin:1px;\"");
        String replacedText = replacedNews.replace("post-prev__body","post-prev__body d-none");
        String replaceSaznajVise = replacedText.replace("post-prev__read-more", "post-prev__read-more d-none");
        String arhivaObjavaRemoved = replaceSaznajVise.replace("btn btn-home-slider__read-more", "btn btn-home-slider__read-more d-none");
        String videoFullWith = arhivaObjavaRemoved.replace("<iframe width=\"350\"", "<iframe width=\"98%\"");
        String burgerMenu = videoFullWith.replace("<i class=\"fas fa-bars\"></i>", "<img src=\"https://i.ibb.co/QQnfgFq/burger-slim.png\" alt=\"\" width=\"70\" height=\"40\">");
        String fbIcon = burgerMenu.replace("<i class=\"fab fa-facebook-f\"></i>","<img src=\"https://i.ibb.co/SV79F4J/fb.png\" alt=\"\" width=\"36\" height=\"36\">");
        String ytIcon = fbIcon.replace("<i class=\"fab fa-youtube\"></i>","<img src=\"https://i.ibb.co/p3YcHwV/YT.png\" alt=\"\" width=\"36\" height=\"36\">");
        String twImg = ytIcon.replace("<i class=\"fab fa-twitter\"></i>","<img src=\"https://i.ibb.co/ZG0s2Gb/tw.png\" alt=\"\" width=\"36\" height=\"36\">");
        String pin = twImg.replace("<i class=\"fas fa-tags\"></i>","<img src=\"https://i.ibb.co/Jdt3JJc/pin.png\" alt=\"\" width=\"25\" height=\"20\" style=\"display:inline-block!important\">");
        String paperPlane = pin.replace("<i class=\"fas fa-paper-plane footer-newsletter__btn-icon\"></i>","<img src=\"https://i.ibb.co/dggtB53/paper-plane.png\" alt=\"\" width=\"30\" height=\"30\">");
        String navBarBUtton = paperPlane.replace("data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\"","data-toggle=\"collapse\" data-target=\"#navbarNavDropdown\" style=\"outline: none;\"");
        return navBarBUtton;
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }



}
