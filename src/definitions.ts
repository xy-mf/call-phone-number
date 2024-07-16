export interface CallPhoneNumberPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
