package com.codeasteroid.simpleclockalarm;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class AlarmService extends IntentService {
    private static final String TAG = AlarmService.class.getSimpleName();

    public AlarmService() {
        super(AlarmService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        sendNotification();
    }

    private void sendNotification() {
        Log.d(TAG, "sendNotification: \"Preparing to send notification...:\"" + "Wake Up! Wake Up!");
        NotificationManager alarmNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, AlarmActivity.class), 0);
        NotificationCompat.Builder alarmNotificationBuilder = new NotificationCompat.Builder(this, "ch_1")
                .setContentTitle("Alarm").setSmallIcon(R.drawable.ic_launcher_foreground)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Wake Up! Wake Up!"))
                .setContentText("Wake Up! Wake Up!");
        alarmNotificationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1, alarmNotificationBuilder.build());
        Log.d(TAG, "sendNotification: \"Notification sent.\"");
    }
}
