// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CallPhoneNumber",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CallPhoneNumber",
            targets: ["CallPhoneNumberPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CallPhoneNumberPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CallPhoneNumberPlugin"),
        .testTarget(
            name: "CallPhoneNumberPluginTests",
            dependencies: ["CallPhoneNumberPlugin"],
            path: "ios/Tests/CallPhoneNumberPluginTests")
    ]
)