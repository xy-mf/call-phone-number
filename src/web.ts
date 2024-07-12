import { WebPlugin } from '@capacitor/core';

import type { CallPhoneNumberPlugin } from './definitions';

export class CallPhoneNumberWeb
  extends WebPlugin
  implements CallPhoneNumberPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
