import { registerPlugin } from '@capacitor/core';

import type { CallPhoneNumberPlugin } from './definitions';

const CallPhoneNumber = registerPlugin<CallPhoneNumberPlugin>(
  'CapacitorCallPhoneNumber',
  {
    web: () => import('./web').then(m => new m.CallPhoneNumberWeb()),
  },
);

export * from './definitions';
export { CallPhoneNumber };
