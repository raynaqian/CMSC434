package rayna.is.awesome.doodler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Rayna on 11/3/2016.
 */

public class DoodleView extends View {

    private Paint mPaintDoodle = new Paint();
    private Path mPath = new Path();

    public DoodleView(Context context) {
        super(context);
        init(null, 0);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        mPaintDoodle.setColor(Color.RED);
        mPaintDoodle.setAntiAlias(true);
        mPaintDoodle.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaintDoodle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();
        switch(motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }
}
