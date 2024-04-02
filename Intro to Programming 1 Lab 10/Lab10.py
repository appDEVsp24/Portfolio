import random

TITLE = 'COSC 1436 FPS'
BLOCK_SIZE = 87
WORLD_SIZE = 8
WIDTH = WORLD_SIZE*BLOCK_SIZE
HEIGHT = WORLD_SIZE*BLOCK_SIZE
fps = Actor('crosshair.png')
fps.x = 4*BLOCK_SIZE
fps.y = 4*BLOCK_SIZE
fps.score = 0
fps.ammo = 5
fps.name = 'CS'
fps.dx = 0
fps.dy = 0
fps.fired = False
target = Actor('missile2.png')
target.x = 2*BLOCK_SIZE
target.y = 0*BLOCK_SIZE
target.value = 10
target.visible = True
gun = Actor('lasergun.png')
gun.visible = False

def draw():
    screen.blit('city', (0,0))
    if target.visible:
        target.draw()
    fps.draw()
    screen.draw.text("Score: " + str(fps.score), topleft=(8, 4), fontsize=40)
    screen.draw.text("Ammo: " + str(fps.ammo), topleft=(WIDTH - 2*BLOCK_SIZE, 4), fontsize=40)
    if gun.visible:
        gun.draw()

def on_key_down(key):
    if key == keys.LEFT:
        fps.dx = -2
    elif key == keys.RIGHT:
        fps.dx = 2
    elif key == keys.UP:
        fps.dy = -2
    elif key == keys.DOWN:
        fps.dy = 2
    elif key == keys.V:
        gun.visible = not gun.visible
    elif key == keys.SPACE:
        fps.fired = True
    elif key == keys.R:
        fps.ammo = 5

def on_key_up(key):
    fps.dx = 0
    fps.dy = 0

def update():
    moveCrosshair()
    if fps.fired:
        gunFired()
    moveTarget()


def moveTarget():
    target.y +=2
    if target.y == HEIGHT - 2*BLOCK_SIZE:
        target.image = 'explosion3.png'
        clock.schedule(hideTarget, 0.2)
        fps.score -= target.value
        clock.schedule(newTarget, 0.3)

def newTarget():
    choice = random.randint(1,2)
    if choice == 1:
        target.image = 'missile2.png'
        target.y = 0*BLOCK_SIZE
        target.value = 10
        target.visible = True
    else:
        target.image = 'missile1.png'
        target.y = 0*BLOCK_SIZE
        target.value = 5
        target.visible = True
    target.x = random.randint(1,7)*BLOCK_SIZE

def hideTarget():
    target.visible = False

def moveCrosshair():
    fps.x = fps.x + fps.dx
    fps.y = fps.y + fps.dy

def gunFired():
    fps.fired = False
    if fps.ammo > 0:
        fps.ammo -= 1
        choice = random.randint(1, 7)
        if choice == 1:
            fps.image = 'explosion2.png'
        else:
            fps.image = 'explosion.png'
        if fps.colliderect(target) and target.visible:
            target.visible = False
            clock.schedule(newTarget, 0.3)
            fps.score += target.value
        clock.schedule(resetImage, 0.2)

def resetImage():
    fps.image = 'crosshair.png'