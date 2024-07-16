import { WebPlugin } from '@capacitor/core';

import type {
  CallPhoneNumberPlugin,
  CallPhoneOptions,
  CallPhoneResult,
  PermissionStatus,
} from './definitions';

export class CallPhoneNumberWeb
  extends WebPlugin
  implements CallPhoneNumberPlugin
{
  checkPermissions(): Promise<PermissionStatus> {
    throw this.unimplemented('Not implemented on web.');
  }

  requestPermissions(): Promise<PermissionStatus> {
    throw this.unimplemented('Not implemented on web.');
  }

  call({ phoneNumber }: CallPhoneOptions): Promise<CallPhoneResult> {
    window.location.href = `tel:${phoneNumber}`;
    return Promise.resolve({ success: true });
  }
}
