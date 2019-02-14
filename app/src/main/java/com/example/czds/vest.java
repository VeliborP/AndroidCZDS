package com.example.czds;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.czds.Model.RSSObject;

import java.io.InputStream;
import java.net.URL;

public class vest extends AppCompatActivity implements  PopupMenu.OnMenuItemClickListener{

    public TextView
            tekstNaslova,
            tekstOpisa,
            txtLink,
            textContent,
            tekstSledeca1,
            tekstSledeca2;
    ImageView imgFb,imgYT,imgInsta,imgFbFooter,imgYtFooter, imgTwFooter;
    TextView fONama,fAnalize, fGostovanja, fEmisije, fTribine, fKontakt, fMilan, fNemanja,
            fOgnjen, fPetar, fSanja, fSrdjan, fPredrag, fObrad;

    RSSObject rssObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vest2);

        tekstNaslova = findViewById(R.id.tekstNaslova);
        tekstOpisa = findViewById(R.id.tekstOpisa);
        txtLink = findViewById(R.id.txtLink);
        textContent = findViewById(R.id.textContent);
        tekstSledeca1 = findViewById(R.id.tekstSledeca1);
        tekstSledeca2 = findViewById(R.id.tekstSeldeca2);

        //glavna vest
        SetContentInViews();
        bindClicks();
        bindFooterClicks();

    }

    private void SetContentInViews() {
        Intent myIntent = getIntent();
        String title = myIntent.getStringExtra("Title");
        String description= myIntent.getStringExtra("Description");
        String content = myIntent.getStringExtra("Content");

        String[] Content = content.split("</p>");

            for (String cont: Content) {
                Drawable img = getImgUrl(cont);
                RelativeLayout layout = findViewById(R.id.vestLayout);
            if(img != null){
                TextView txtView = new TextView(this);
                txtView.setText(Html.fromHtml(cont));
                ImageView imgView = new ImageView(this);
                imgView.setImageDrawable(img);
                layout.addView(imgView);
            }
            else{

                TextView txtView = new TextView(this);
                txtView.setText(Html.fromHtml(cont));
            }

        }

        String pubDate= myIntent.getStringExtra("PubDate");
        String autor= myIntent.getStringExtra("Autor");
        String link = myIntent.getStringExtra("Link");
        //sledeca vest
        String sledeca1= myIntent.getStringExtra("SledecaVest1");
        String sledeca1PubDate= myIntent.getStringExtra("SledecaVest1PubDate");
        String sledeca2= myIntent.getStringExtra("SledecaVest2");
        String sledeca2PubDate= myIntent.getStringExtra("SledecaVest2PubDate");

        tekstNaslova.setText(Html.fromHtml(title));
        tekstOpisa.setText(Html.fromHtml(description) + "\n" +autor+ "\n" + pubDate);
        textContent.setText(Html.fromHtml(content));
        txtLink.setText("Više na: "+link);
        tekstSledeca1.setText(sledeca1 + "\n" + sledeca1PubDate);
        tekstSledeca2.setText(sledeca2 + "\n" + sledeca2PubDate);
    }
    private static Drawable getImgUrl(String content){
        String imgUrl = content.substring(content.indexOf("src=")+5, content.indexOf("jpg")+3);
        try {
            InputStream is = (InputStream) new URL(imgUrl).getContent();
            Drawable d = Drawable.createFromStream(is, null);
            return d;
        } catch (Exception e) {
            return null;
        }
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
                //todo
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
