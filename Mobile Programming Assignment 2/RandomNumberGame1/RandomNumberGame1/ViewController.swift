//
//  ViewController.swift
//  RandomNumberGame1
//
//  Created by user247975 on 2/12/24.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var messageLabel: UILabel!
    
    @IBOutlet weak var userNumTextField: UITextField!
    
    @IBOutlet weak var time: UILabel!
    
    var timerA = Timer()

    var counterA: Int = 30;
    
   
    
    var secretNum = Int.random(in: 0...100)
    
    var guesses = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }
    
    @objc func countDownA() {
        counterA -= 1
        time.text = String(counterA)
        if counterA == 0  {
            timerA.invalidate()
            endGame()
        }
    }
    
    func endGame() {
        messageLabel.text = "Time's up! Sorry, it was \(secretNum)"
    }
    
    
    @IBAction func guessButtonClicked(_ sender: UIButton) {
        
        timerA.invalidate()
        
        timerA = Timer.scheduledTimer(timeInterval: 1, target: self, selector:#selector(countDownA) , userInfo: nil, repeats: true)
        
        countDownA()

        self.guesses += 1
        
        let userNum =
        Int(userNumTextField.text!)
        
        if guesses <= 5 {
            
            if userNum == secretNum {
                //messageLabel.text = "You win! Guess a new number."
                messageLabel.text = "Yes, it is \(secretNum)"
                
                secretNum = Int.random(in: 0...100)
            } else if userNum! > secretNum {
                messageLabel.text = "Too big, guess a smaller number"
            } else {
                messageLabel.text = "Too small, guess a bigger number"
            }
        } else {
            messageLabel.text = "Sorry, it was \(secretNum)"        }
                    
    }
    
    @IBAction func reset(_ sender: UIButton) {
        counterA = 30
        timerA.invalidate()
        time.text = String(counterA)
        self.guesses = 0
        messageLabel.text = "Please enter a number"
        userNumTextField.text = "0"
        
    }
    
    
    
    
}



