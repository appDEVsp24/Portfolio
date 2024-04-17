//  Patrick Mull
//  Programming Mobile Devices Spring 2024
//  CSCI 457-01W Final Project
//  Ping Pong Game App
//
//  SettingsViewController.swift
//  FinalProject

import Foundation
import UIKit

enum gameType {
    case easy
    case medium
    case hard
}

class SettingsViewController : UIViewController {
    var didSelectColorClosure: ((UIColor) -> Void)?
    
    //Game Mode:
    @IBAction func Easy(_ sender: Any) {
        moveToGame(game: .easy)
    }

    @IBAction func Medium(_ sender: Any) {
        moveToGame(game: .medium)
    }
    
    @IBAction func Hard(_ sender: Any) {
        moveToGame(game: .hard)
    }
    
    func moveToGame(game : gameType) {
        
        let gameVC = self.storyboard?.instantiateViewController(withIdentifier: "gameVC") as! GameViewController
        currentGameType = game
        self.navigationController?.pushViewController(gameVC, animated: true) 
    }

}
