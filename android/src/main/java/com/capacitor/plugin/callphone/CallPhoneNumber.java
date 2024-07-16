package com.capacitor.plugin.callphone;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class CallPhoneNumber {

    private final Context context;

    public CallPhoneNumber(Context context) {
        this.context = context;
    }

    public Boolean dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        if (null != intent.resolveActivity(context.getPackageManager())) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }

    @SuppressWarnings("MissingPermission")
    public Boolean callPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        if (null != intent.resolveActivity(context.getPackageManager())) {
            context.startActivity(intent);
            return true;
        }
        return false;
    }
}
