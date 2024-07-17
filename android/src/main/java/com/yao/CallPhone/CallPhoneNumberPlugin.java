package com.yao.CallPhone;

import android.Manifest;

import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(
        name = "CallPhoneNumber",
        permissions = {@Permission(strings = {Manifest.permission.CALL_PHONE}, alias = CallPhoneNumberPlugin.CALL_PHONE)}
)
public class CallPhoneNumberPlugin extends Plugin {

    static final String CALL_PHONE = "callPhone";

    private CallPhoneNumber implementation;

    @Override
    public void load() {
        implementation = new CallPhoneNumber(getContext());
    }

    @Override
    @PluginMethod
    public void checkPermissions(PluginCall call) {
        super.checkPermissions(call);
    }

    @Override
    @PluginMethod
    public void requestPermissions(PluginCall call) {
        super.requestPermissions(call);
    }

    @PluginMethod
    public void call(PluginCall call) {
        String type = call.getString("type");
        if ("dial".equals(type)) {
            this.startDialPhoneNumber(call);
            return;
        }
        this.startCallPhoneNumber(call);
    }

    private void startDialPhoneNumber(PluginCall call) {
        String phoneNumber = call.getString("phoneNumber");

        Boolean success = implementation.dialPhoneNumber(phoneNumber);
        JSObject result = new JSObject();

        result.put("success", success);

        call.resolve(result);
    }

    private void startCallPhoneNumber(PluginCall call) {
        if (getPermissionState(CallPhoneNumberPlugin.CALL_PHONE) != PermissionState.GRANTED) {
            requestPermissionForAlias(CallPhoneNumberPlugin.CALL_PHONE, call, "callPhonePermsCallback");
        } else {
            this._callPhoneNumber(call);
        }
    }

    @PermissionCallback
    private void callPhonePermsCallback(PluginCall call) {
        if (getPermissionState(CallPhoneNumberPlugin.CALL_PHONE) == PermissionState.GRANTED) {
            this._callPhoneNumber(call);
        } else {
            call.reject("Call phone permission was denied");
        }
    }

    private void _callPhoneNumber(PluginCall call) {
        String phoneNumber = call.getString("phoneNumber");

        Boolean success = implementation.callPhoneNumber(phoneNumber);
        JSObject result = new JSObject();

        result.put("success", success);

        call.resolve(result);
    }
}
