//
//  AppDelegate.swift
//  iosApp
//
//  Created by Michal Gáborík on 01/10/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication, supportedInterfaceOrientationsFor window: UIWindow?) -> UIInterfaceOrientationMask {
        // Lock orientation to portrait
        return .portrait
    }
}
