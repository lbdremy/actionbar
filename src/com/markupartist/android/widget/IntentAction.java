package com.markupartist.android.widget;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.markupartist.android.widget.actionbar.R;

public class IntentAction implements Action {
    private Context mContext;
    private Intent mIntent;
    final private int mDrawable;

    public IntentAction(Context context, Intent intent, int drawable) {
        mDrawable = drawable;
        mContext = context;
        mIntent = intent;
    }
    
    @Override
    public int getDrawable() {
        return mDrawable;
    }
    
    @Override
    public void performAction() {
        try {
        	if(mIntent != null){
        		mContext.startActivity(mIntent);
        	}
        } catch (ActivityNotFoundException e) {
            Toast.makeText(mContext,
                    mContext.getText(R.string.actionbar_activity_not_found),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
