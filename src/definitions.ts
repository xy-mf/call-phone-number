import type { PermissionState } from '@capacitor/core';

export interface CallPhoneOptions {
  /**
   * The phone number to be called
   */
  phoneNumber: string;

  /**
   * The type of call, optional, can be either 'call' or 'dial'.
   * Only supports Android
   */
  type?: 'call' | 'dial';
}

export interface CallPhoneResult {
  success: boolean;
}

export interface PermissionStatus {
  /**
   * Permission state for callPhone alias.
   */
  callPhone: PermissionState;
}

export type CallPhoneNumberPermissionType = 'callPhone';

export interface CallPhoneNumberPluginPermissions {
  permissions: CallPhoneNumberPermissionType[];
}

export interface CallPhoneNumberPlugin {
  call(options: CallPhoneOptions): Promise<CallPhoneResult>;
  checkPermissions(): Promise<PermissionStatus>;
  requestPermissions(
    permissions?: CallPhoneNumberPluginPermissions,
  ): Promise<PermissionStatus>;
}
