import Capacitor
import Foundation

/// Please read the Capacitor iOS Plugin Development Guide
/// here: https://capacitorjs.com/docs/plugins/ios
@objc(CallPhoneNumberPlugin)
public class CallPhoneNumberPlugin: CAPPlugin, CAPBridgedPlugin {
  public let identifier = "CallPhoneNumberPlugin"
  public let jsName = "CallPhoneNumber"
  public let pluginMethods: [CAPPluginMethod] = [
    CAPPluginMethod(name: "call", returnType: CAPPluginReturnPromise),
    CAPPluginMethod(name: "checkPermissions", returnType: CAPPluginReturnPromise),
    CAPPluginMethod(name: "requestPermissions", returnType: CAPPluginReturnPromise),
  ]

  @objc override public func checkPermissions(_ call: CAPPluginCall) {
    call.unimplemented("Not implemented on iOS.")
  }

  @objc override public func requestPermissions(_ call: CAPPluginCall) {
    call.unimplemented("Not implemented on iOS.")
  }

  @objc func call(_ call: CAPPluginCall) {
    let phoneNumber = call.getString("phoneNumber") ?? ""
    let result = callPhoneNumber(phoneNumber)

    call.resolve([
      "success": result
    ])
  }

  @objc func callPhoneNumber(_ phoneNumber: String) -> Bool {
    guard let phoneURLStr = URL(string: "tel://" + phoneNumber) else {
      return false
    }

    if UIApplication.shared.canOpenURL(phoneURLStr) {
      if #available(iOS 10.0, *) {
        DispatchQueue.main.async {
          UIApplication.shared.open(phoneURLStr, options: [:], completionHandler: nil)
        }
      } else {
        DispatchQueue.main.async {
          UIApplication.shared.openURL(phoneURLStr)
        }
      }

      return true
    } else {
      return false
    }
  }
}
