package com.example.alan.lahacks;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class EventProfile extends AppCompatActivity {

    //Initialize all of my Objects to be declared within onCreate method.
    TextView descriptionText;
    String descriptionTextString = "";
    int likeCount, saveCount, toGoCount;
    int clickCounter1, clickCounter2, clickCounter3;
    EventData e[] = new EventData[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_profile);
        clickCounter1 = 0;
        //Link to creator's profile !!(CAUTION: Now just link to own profile)
        ImageButton profileButton = (ImageButton) findViewById(R.id.imageButton);
        profileButton.setImageResource(R.drawable.profilepic);
        //profileButton.setBackgroundResource(R.drawable.);
        profileButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startNewActivity = new Intent(EventProfile.this, PersonalProfile.class);
                startActivity(startNewActivity);

            }
        });

        int eventInteger;
        eventInteger = grabInteger();
        e[eventInteger] = new EventData("a","Set up your professional profile, learn the basics, and " +
                " effectively harness the power of LinkedIn to connect with " +
                " employers, gather career information, and find jobs.","c",0,0);
        descriptionTextString += e[0].getDetails();

        //Add actions to Like, save, and toGo buttons.
        final ImageButton likeButton = (ImageButton) findViewById(R.id.imageButton3) ;
        likeButton.setImageResource(R.drawable.like_image);
        likeButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        likeButton.setBackgroundResource(R.color.cardview_light_background);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickCounter1 == 0){
                    //Filled image as you have just added one to the likes
                    likeButton.setImageResource(R.drawable.change);
                    ColorFilter filter = new LightingColorFilter( Color.BLACK, Color.RED);
                    likeButton.setColorFilter(filter);
                    likeCount += 1;
                    clickCounter1 +=1;
                }
                else if(clickCounter1 == 1) {
                    //Empty button since you will be subtracting one
                    likeButton.setImageResource(R.drawable.like_image);
                    ColorFilter filter = new LightingColorFilter( Color.BLACK, Color.BLACK);
                    likeButton.setColorFilter(filter);
                    likeCount -= 1;
                    clickCounter1 -= 1;
                }

            }
        });



        final ImageButton saveButton = (ImageButton) findViewById(R.id.imageButton6) ;
        saveButton.setImageResource(R.drawable.save_button);
        saveButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        saveButton.setBackgroundResource(R.color.cardview_light_background);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickCounter2 == 0){
                    //Filled image as you have just added one to the likes
                    saveButton.setImageResource(R.drawable.save_button);
                    ColorFilter filter = new LightingColorFilter( Color.BLACK, Color.YELLOW);
                    saveButton.setColorFilter(filter);
                    saveCount += 1;
                    clickCounter2 +=1;
                }
                else if(clickCounter2 == 1) {
                    //Empty button since you will be subtracting one
                    saveButton.setImageResource(R.drawable.save_button);
                    ColorFilter filter = new LightingColorFilter( Color.BLACK, Color.BLACK);
                    saveButton.setColorFilter(filter);
                    saveCount -= 1;
                    clickCounter2 -= 1;
                }
            }
        });
        //likeButton.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View view) {
         //       likeButton.setBackgroundResource(R.drawable.);
        //    }
       // });


        final ImageButton toGoButton = (ImageButton) findViewById(R.id.imageButton7) ;
        toGoButton.setImageResource(R.drawable.to_go_button);
        toGoButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        toGoButton.setBackgroundResource(R.color.cardview_light_background);
        toGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickCounter3 == 0){
                    //Filled image as you have just added one to the likes
                    toGoButton.setImageResource(R.drawable.to_go_button);
                    ColorFilter filter = new LightingColorFilter( Color.BLACK, Color.RED);
                    toGoButton.setColorFilter(filter);
                    toGoCount += 1;
                    clickCounter3 +=1;
                }
                else if(clickCounter3 == 1) {
                    //Empty button since you will be subtracting one
                    toGoButton.setImageResource(R.drawable.to_go_button);
                    ColorFilter filter = new LightingColorFilter( Color.BLACK, Color.BLACK);
                    toGoButton.setColorFilter(filter);
                    toGoCount -= 1;
                    clickCounter3 -= 1;
                }

            }
        });




        //Setup event picture
        ImageView eventPicture =(ImageView) findViewById(R.id.eventImage) ;
        eventPicture.setBackgroundResource(R.drawable.career);

        //Link all of my objects to the ones created in my XML.
        descriptionText = (TextView)findViewById(R.id.descriptionText);
        descriptionText.setText(descriptionTextString);


    }

    public int grabInteger()
    {
        Intent mIntent;
        mIntent = getIntent();

        int intValue = mIntent.getIntExtra("eventInteger", 0);

        return intValue;
    }

    public void toCommentPage(View view) {
        Intent startNewActivity = new Intent(this, CampusEvent.class);
        startActivity(startNewActivity);
    }

    /**
     * toEventProfile method. Takes user to GEvent Profile screen when button is clicked.
     * @param view View
     */
    public void toEventProfile(View view) {
        Intent startNewActivity = new Intent(this, EventProfile.class);
        startActivity(startNewActivity);
    }

    /**
     * toPersonalProfile method. Takes user to Personal Profile screen when button is clicked.
     * @param view View
     */
    public void toPersonalProfile(View view) {
        Intent startNewActivity = new Intent(this, PersonalProfile.class);
        startActivity(startNewActivity);
    }

    /**
     * toMapView method. Takes user to the maps view when clicked.
     * @param view View
     */
    public void toMapView(View view) {
        Intent startNewActivity = new Intent(this, MapsActivity.class);
        startActivity(startNewActivity);
    }
}
