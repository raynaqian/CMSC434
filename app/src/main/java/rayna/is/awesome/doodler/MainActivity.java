package rayna.is.awesome.doodler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private DoodleView doodleView;
    private ImageButton currPaintSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doodleView = (DoodleView)findViewById(R.id.drawing);
        LinearLayout paintButtonLayout = (LinearLayout) findViewById(R.id.paint_colors);
        currPaintSelection = (ImageButton)paintButtonLayout.getChildAt(0);

    }

    public void colorClicked(View v){
        ImageButton imgV = (ImageButton) v;
        String color = v.getTag().toString();
        doodleView.setColor(color);
    }
}
