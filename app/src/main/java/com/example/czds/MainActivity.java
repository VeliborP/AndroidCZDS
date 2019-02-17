package com.example.czds;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.czds.Adapter.FeedAdapter;
import com.example.czds.Common.HTTPDataHandler;
import com.example.czds.Model.RSSObject;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    RecyclerView recyclerView;
    RSSObject rssObject;
    ImageView imgFb,imgYT,imgInsta,imgFbFooter,imgYtFooter, imgTwFooter;
    TextView fONama,fAnalize, fGostovanja, fEmisije, fTribine, fKontakt, fMilan, fNemanja,
    fOgnjen, fPetar, fSanja, fSrdjan, fPredrag, fObrad;
    WebView videoView;
    //RSS link
    private final String RSS_link="https://czds.rs/feed/";
    private final String RSS_to_Json_API = " https://api.rss2json.com/v1/api.json?rss_url=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.videoViewHome);

        bindClicks();
        bindFooterClicks();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
        loadRSS();
        SetVideoView();
    }

    private void SetVideoView(){
        videoView.loadData("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ovy6k5PPMsI\" frameborder=\"0\" allowfullscreen></iframe>", "text/html" , "utf-8");
        WebSettings webSettings = videoView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    private void bindClicks(){
        imgFb = findViewById(R.id.imgFb);
        imgYT = findViewById(R.id.imgYt);
        imgInsta = findViewById(R.id.imgInsta);

        imgFbFooter = findViewById(R.id.imgFbFooter);
        imgYtFooter = findViewById(R.id.imgYtFooter);
        imgTwFooter = findViewById(R.id.imgTwFooter);

        imgFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.facebook.com/centarzadrustvenustabilnost/"));
                startActivity(browserIntent);

            }
        });
        imgInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://twitter.com/centarzds"));
                startActivity(browserIntent);

            }
        });
        imgYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.youtube.com/channel/UC_U9TPc4Gf5JVkutEyjAbhQ"));

                startActivity(browserIntent);

            }
        });
        imgFbFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.facebook.com/centarzadrustvenustabilnost/"));
                startActivity(browserIntent);

            }
        });
        imgTwFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://twitter.com/centarzds"));
                startActivity(browserIntent);

            }
        });
        imgYtFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://www.youtube.com/channel/UC_U9TPc4Gf5JVkutEyjAbhQ"));

                startActivity(browserIntent);

            }
        });
    }

    private void bindFooterClicks(){
        fONama = findViewById(R.id.fONama);
        fAnalize = findViewById(R.id.fAnalize);
        fGostovanja = findViewById(R.id.fGostovanja);
        fEmisije = findViewById(R.id.fEmisije);
        fTribine = findViewById(R.id.fTribine);
        fNemanja = findViewById(R.id.fNemanja);
        fMilan = findViewById(R.id.fMilan);
        fKontakt = findViewById(R.id.fKontakt);
        fOgnjen = findViewById(R.id.fOgnjen);
        fPetar = findViewById(R.id.fPetar);
        fSanja = findViewById(R.id.fSanja);
        fSrdjan = findViewById(R.id.fSrdjan);
        fPredrag = findViewById(R.id.fPredrag);
        fObrad = findViewById(R.id.fObrad);

        fONama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/o-nama/"));

                startActivity(browserIntent);

            }
        });
        fAnalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/kat/analize/"));

                startActivity(browserIntent);

            }
        });
        fGostovanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/kat/gostovanja/"));

                startActivity(browserIntent);

            }
        });
        fEmisije.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/kat/emisije/"));

                startActivity(browserIntent);

            }
        });
        fTribine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/kat/tribine/"));

                startActivity(browserIntent);

            }
        });
        fNemanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/author/nemanja/"));

                startActivity(browserIntent);

            }
        });
        fMilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/author/milan/"));

                startActivity(browserIntent);

            }
        });
        fKontakt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/kontakt/"));

                startActivity(browserIntent);

            }
        });
        fOgnjen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/author/ognjen/"));

                startActivity(browserIntent);

            }
        });fPetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/author/petar/"));

                startActivity(browserIntent);

            }
        });
        fPredrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/author/predrag/"));

                startActivity(browserIntent);

            }
        });fSanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/author/sanja/"));

                startActivity(browserIntent);

            }
        });
        fSrdjan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/author/srdjan/"));

                startActivity(browserIntent);

            }
        });
        fObrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://czds.rs/author/obrad/"));

                startActivity(browserIntent);

            }
        });


    }

    private void loadRSS() {
        AsyncTask<String,String,String> loadRSSAsync = new AsyncTask<String, String, String>() {

            ProgressDialog mDialog = new ProgressDialog(MainActivity.this);

            @Override
            protected void onPreExecute() {
                mDialog.setMessage("Molimo sačekajte...");
                mDialog.show();
            }

            @Override
            protected String doInBackground(String... params) {
                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.GetHTTPData(params[0]);
                return  result;
            }
            @Override
            protected void onPostExecute(String s) {
                mDialog.dismiss();
                rssObject = new Gson().fromJson(s,RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(rssObject,getBaseContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };

        StringBuilder url_get_data = new StringBuilder(RSS_to_Json_API);
        url_get_data.append(RSS_link);
        loadRSSAsync.execute(url_get_data.toString());
    }

    public void showMenu(View v){
        PopupMenu popup = new PopupMenu(this,v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.main_menu);
        popup.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);

        switch (item.getItemId()){
        case R.id.btnKontakt:
            Intent intent = new Intent(this,Kontakt.class);
            this.startActivity(intent);
        return true;
        case R.id.btnAnalize:
            browserIntent.setData(Uri.parse("https://czds.rs/kat/analize/"));
            startActivity(browserIntent);
            return true;
            case R.id.btnAutori:
                browserIntent.setData(Uri.parse("https://czds.rs/autori/"));
                startActivity(browserIntent);
                return true;
                case R.id.btnOnama:
                browserIntent.setData(Uri.parse("https://czds.rs/o-nama/"));
                startActivity(browserIntent);
                return true;
            case R.id.btnMultimedija:
                browserIntent.setData(Uri.parse("https://czds.rs/kat/emisije/"));
                startActivity(browserIntent);
                return true;
        default:
            return false;
        }
    }
}