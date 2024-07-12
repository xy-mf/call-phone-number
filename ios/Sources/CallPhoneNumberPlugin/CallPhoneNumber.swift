import Foundation

@objc public class CallPhoneNumber: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
