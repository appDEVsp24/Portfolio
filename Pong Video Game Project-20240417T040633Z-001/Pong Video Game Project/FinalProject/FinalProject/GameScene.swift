//  Patrick Mull
//  Programming Mobile Devices Spring 2024
//  CSCI 457-01W Final Project
//  Ping Pong Game App
//
//  GameScene.swift
//  FinalProject

import SpriteKit
import GameplayKit

class GameScene: SKScene {
    
    var ball = SKSpriteNode()
    var comp = SKSpriteNode()
    var user = SKSpriteNode()
    var score = [Int]()
    var tLabel = SKLabelNode()
    var bLabel = SKLabelNode()
    
    override func didMove(to view: SKView) {
        
        tLabel = self.childNode(withName: "tLabel") as! SKLabelNode
        bLabel = self.childNode(withName: "bLabel") as! SKLabelNode
        ball = self.childNode(withName: "ball") as! SKSpriteNode
        
        comp = self.childNode(withName: "comp") as! SKSpriteNode
        comp.position.y = (self.frame.height / 2) - 80
        
        user = self.childNode(withName: "user") as! SKSpriteNode
        user.position.y = (-self.frame.height / 2) + 80
        
        let border = SKPhysicsBody(edgeLoopFrom: self.frame)
        
        border.friction = 0
        border.restitution = 1
        
        self.physicsBody = border
        
        startGame()
    }
    
    func startGame() {
        
        score = [0,0]
        tLabel.text = "\(score[1])"
        bLabel.text = "\(score[0])"
        ball.physicsBody?.applyImpulse(CGVector(dx: 10, dy: 10))
    }
    

    
    func addScore(playerWhoWon: SKSpriteNode) {
        
        ball.position = CGPoint(x: 0, y: 0)
        ball.physicsBody?.velocity = CGVector(dx: 0, dy: 0)
        
        if playerWhoWon == user {
            score[0] += 1
            let scoreSound = SKAction.playSoundFileNamed("score", waitForCompletion: false)
            ball.physicsBody?.applyImpulse(CGVector(dx: 10, dy: 10))
            
        }
        else if playerWhoWon == comp {
            score[1] += 1
            let scoreSound = SKAction.playSoundFileNamed("score", waitForCompletion: false)
            ball.physicsBody?.applyImpulse(CGVector(dx: -10, dy: -10))
        }
        
        //print(score)
        tLabel.text = "\(score[1])"
        bLabel.text = "\(score[0])"
        
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        
        for touch in touches {
            let location = touch.location(in: self)
            user.run(SKAction.moveTo(x: location.x, duration: 0.2))
        }
        
    }
    
    override func touchesMoved(_ touches: Set<UITouch>, with event: UIEvent?) {
        
        for touch in touches {
            let location = touch.location(in: self)
            user.run(SKAction.moveTo(x: location.x, duration: 0.2))
        }
        
    }
    
    override func update(_ currentTime: TimeInterval) {
        // Called before each frame is rendered
        
        switch currentGameType {
        case .easy:
            comp.run(SKAction.moveTo(x: ball.position.x, duration: 1.3))
            ball.color = UIColor.red
            ball.colorBlendFactor = 1
            break
        case .medium:
            comp.run(SKAction.moveTo(x: ball.position.x, duration: 1.0))
            ball.color = UIColor.white
            ball.colorBlendFactor = 1
            comp.size = CGSize(width: 100, height: 15)
            user.size = CGSize(width: 60, height: 15)
            break
        case .hard:
            comp.run(SKAction.moveTo(x: ball.position.x, duration: 0.7))
            ball.color = UIColor.gray
            ball.colorBlendFactor = 1
            comp.size = CGSize(width: 100, height: 15)
            user.size = CGSize(width: 30, height: 15)
            break
        }
        
        if ball.position.y <= user.position.y - 30 {
            addScore(playerWhoWon: comp)
        }
        else if ball.position.y >= comp.position.y + 30 {
            addScore(playerWhoWon: user)
        }
        
        
        
    }
    
}
