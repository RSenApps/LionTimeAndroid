package com.RSen.LionTime;

import android.content.Intent;

import com.google.android.apps.dashclock.api.DashClockExtension;
import com.google.android.apps.dashclock.api.ExtensionData;

public class MyDashClock extends DashClockExtension {
    protected void onUpdateData(int reason) {
    	String[] timeInfo = TimeTillCalculator.getTimeTill(this);
    	
		if (!timeInfo[0].equals("-1")) {
			String text;
			text = timeInfo[0] + " min until " + timeInfo[1];
			  publishUpdate(new ExtensionData()
              .visible(true)
              .icon(R.drawable.ic_dashclock)
              .status(text)
              .expandedTitle(text)
              .expandedBody("Click to view schedule...")
              .clickIntent( new Intent(this, ViewScheduleActivity.class)));
		} else {
			publishUpdate(null); //clears the extension
		}
      
    }
    @Override
    protected void onInitialize(boolean isReconnect) {
    	super.onInitialize(isReconnect);
    	setUpdateWhenScreenOn(true);
    }
}
