"""
Patrick Mull
"""

TITLE = 'Mario Mini-Game'
# Screen is 720 x 480
WIDTH = 720
HEIGHT = 480
# 4 types of food:
MAGIC_MUSHROOM = 0
ONEUP_MUSHROOM = 1
STARMAN = 2
POISON = 3

mario = Actor('mario.png')
mario.lives = 2
mario.super = False
mario.invincible = False
mario.invincibleTimer = 0 # 1 second = 60 frames
mario.dead = False
mario.x = 200
mario.y = 120
mario.selection = MAGIC_MUSHROOM # default selection

magicMushroom = Actor("mushroom1.png")
magicMushroom.pos = (288,120)
magicMushroom.name = "Magic Mushroom"
oneUp = Actor("1up.png")
oneUp.pos = (288,200)
oneUp.name = "1 UP"
starMan = Actor("star.png")
starMan.pos = (288,280)
starMan.name = "Starman"
poison = Actor("poison.png")
poison.pos = (288,360)
poison.name = "Poison Mushroom"

def eatFood(foodType):
    '''Assume that foodType will store the food that Mario chose to eat.
       For example, if Mario chose the Magic Mushroom then the value stored in food type will be 0 or MAGIC_MUSHROOM'''
    if foodType == POISON:   # Mario eats the Poison Mushroom
        receiveHit()
    elif foodType == MAGIC_MUSHROOM:
        mario.super = True
        mario.image = "sumario.png"
    elif foodType == ONEUP_MUSHROOM:
        mario.lives += 1
    elif foodType == STARMAN:
        mario.invincible = True
        mario.invincibleTimer = 300

def receiveHit():
    "Pleae write your code here. This function will be called when Mario eats the Poison Mushroom"
    if mario.invincible == True:
        mario.lives = mario.lives
    elif mario.super == True:
        mario.super = False
        mario.image = "mario.png"
    else:
        mario.lives -= 1

    if mario.lives == 0:
        mario.dead = True

def draw():
    screen.clear()
    if mario.dead:
        screen.draw.text("GAME OVER", topleft=(280, 200), fontsize=40)
    else:
        screen.draw.text("Pick up one item. Use UP and DOWN to select, SPACE to confirm.", topleft=(112, 440), fontsize=24)
        # Draw Mario:
        mario.draw()
        screen.draw.text("Lives: "+str(mario.lives), topleft=(20, 20), fontsize=32)
        screen.draw.text("Invincible timer: "+str(mario.invincibleTimer), topleft=(490, 20), fontsize=32)
        # Draw items:
        magicMushroom.draw()
        oneUp.draw()
        starMan.draw()
        poison.draw()
        screen.draw.text(magicMushroom.name, topleft=(magicMushroom.x + 48, magicMushroom.y), fontsize=32)
        screen.draw.text(oneUp.name, topleft=(oneUp.x + 48, oneUp.y), fontsize=32)
        screen.draw.text(starMan.name, topleft=(starMan.x + 48, starMan.y), fontsize=32)
        screen.draw.text(poison.name, topleft=(poison.x + 48, poison.y), fontsize=32)

def update():
    # Decrease invincible timer by 1/60 second
    if mario.invincibleTimer > 0:
        mario.invincibleTimer = mario.invincibleTimer - 1
    else:
        mario.invincible = False

def on_key_down(key):
    if key == keys.UP:
        mario.selection = mario.selection - 1
        if mario.selection < MAGIC_MUSHROOM:
            mario.selection = POISON
        mario.y = mario.y - 80
        if mario.y < magicMushroom.y:
            mario.y = poison.y
    elif key == keys.DOWN:
        mario.selection = mario.selection + 1
        if mario.selection > POISON:
            mario.selection = MAGIC_MUSHROOM
        mario.y = mario.y + 80
        if mario.y > poison.y:
            mario.y = magicMushroom.y
    elif key == keys.SPACE:
        eatFood(mario.selection) # Mario eats the item.
