package com.dnl.resizable;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

import java.util.Locale;

public class AppWidget extends AppWidgetProvider {

    @Override
       public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for (int appWidgetId : appWidgetIds) {
            Bundle options=appWidgetManager.getAppWidgetOptions(appWidgetId);

            onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, options);

            RemoteViews updateViews = new RemoteViews(context.getPackageName(), R.layout.widget4x4);
            Intent intent = new Intent(context, PopActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            PendingIntent pendingIntent =  PendingIntent.getActivity(context, 0, intent, 0);
            updateViews.setOnClickPendingIntent(R.id.help, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetIds, updateViews);
        }



    }

    @Override
    public void onAppWidgetOptionsChanged(Context ctxt, AppWidgetManager mgr, int appWidgetId, Bundle newOptions) {

        RemoteViews updateViews = null;
        //RemoteViews updateViews=
         //       new RemoteViews(ctxt.getPackageName(), R.layout.widget4x4);

        String msg =
                String.format(Locale.getDefault(),
                        "[%d-%d] x [%d-%d]",
                        newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH),
                        newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH),
                        newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT),
                        newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT));

        int minWidth = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH);
        int maxWidth = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH);
        int minHeight = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT);
        int maxHeight = newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT);

        //updateViews.setTextViewText(R.id.size, msg);

        //1x1 widget
        if(minWidth == 64 && maxWidth == 90 && minHeight == 58 && maxHeight == 84){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget1x1);
        }
        //1x2 widget
        if(minWidth == 144 && maxWidth == 196 && minHeight == 58 && maxHeight == 84){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget1x2);
        }
        //1x3 widget
        if(minWidth == 224 && maxWidth == 302 && minHeight == 58 && maxHeight == 84){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget1x3);
        }
        //1x5 widget
        if(minWidth == 304 && maxWidth == 408 && minHeight == 58 && maxHeight == 84){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget1x5);
        }

        //2x1 widget
        if(minWidth == 64 && maxWidth == 90 && minHeight == 132 && maxHeight == 184){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget2x1);
        }
        //2x2 widget
        if(minWidth == 144 && maxWidth == 196 && minHeight == 132 && maxHeight == 184){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget2x2);
        }
        if(minWidth == 224 && maxWidth == 302 && minHeight == 132 && maxHeight == 184){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget2x2);
        }
        //2x4 widget
        if(minWidth == 304 && maxWidth == 408 && minHeight == 132 && maxHeight == 184){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget2x4);
        }

        //3x1 widget
        if(minWidth == 64 && maxWidth == 90 && minHeight == 206 && maxHeight == 284){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget3x1);
        }
        //3x2 widget
        if(minWidth == 144 && maxWidth == 196 && minHeight == 206 && maxHeight == 284){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget3x2);
        }
        if(minWidth == 224 && maxWidth == 302 && minHeight == 206 && maxHeight == 284){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget3x2);
        }
        //3x4 widget
        if(minWidth == 304 && maxWidth == 408 && minHeight == 206 && maxHeight == 284){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget3x4);
        }

        //5x1 widget
        if(minWidth == 64 && maxWidth == 90 && minHeight == 280 && maxHeight == 384){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget5x1);
        }
        //4x2 widget
        if(minWidth == 144 && maxWidth == 196 && minHeight == 280 && maxHeight == 384){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget4x2);
        }
        if(minWidth == 224 && maxWidth == 302 && minHeight == 280 && maxHeight == 384){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget4x2);
        }
        //4x4 widget
        if(minWidth == 304 && maxWidth == 408 && minHeight == 280 && maxHeight == 384){
            updateViews = new RemoteViews(ctxt.getPackageName(), R.layout.widget4x4);
        }

        Intent intent = new Intent(ctxt, PopActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent =  PendingIntent.getActivity(ctxt, 0, intent, 0);
        updateViews.setOnClickPendingIntent(R.id.help, pendingIntent);
        mgr.updateAppWidget(appWidgetId, updateViews);
    }


}
